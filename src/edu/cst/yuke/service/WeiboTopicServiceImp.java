package edu.cst.yuke.service;

import java.awt.event.MouseWheelEvent;
import java.net.StandardSocketOptions;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.cst.yuke.beans.ProcessedWeibo;
import edu.cst.yuke.beans.Weibo;
import edu.cst.yuke.dao.ProcessedWeiboDaoImp;
import edu.cst.yuke.dao.WeiboDaoImp;
import edu.cst.yuke.topic.TopicProcessosImpFace;

public class WeiboTopicServiceImp implements WeiboTopicService{

	@Override
	public ProcessedWeibo[] getWeiboWithTopicByUid(String Uid ) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return this.getWeiboWithTopicByUidAndTime(Uid,format.parse("0000-01-00"),format.parse("9999-01-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("this is no possible for logic of code");
			return null;
		}
	}

	@Override
	public ProcessedWeibo[] getWeiboWithTopicByUidAndTime(String Uid, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<Weibo> weibos = new ArrayList<>();
		List<ProcessedWeibo> processedWeibos = new ArrayList<>();
		// TODO Auto-generated method stub
		//1\get from database as a arr
		weibos=new WeiboDaoImp().find(fromDate, toDate, Uid);
		for(Weibo weibo:weibos){
			ProcessedWeibo processedWeibo = new ProcessedWeiboDaoImp().findbyId(weibo.getId());
			if (processedWeibo == null) {
				processedWeibo =new TopicProcessosImpFace().Processor(weibo);
			}
			processedWeibos.add(processedWeibo);
		}
		
		return processedWeibos.toArray(new ProcessedWeibo[processedWeibos.size()]);
		
	}

	@Override
	public String phareToJSONByTopic(ProcessedWeibo[] processedWeibos) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		Map<String, Integer> coutMap = new HashMap<>();
		for(ProcessedWeibo processedWeibo:processedWeibos){
			if(coutMap.containsKey(processedWeibo.getTheme())){
				coutMap.put(processedWeibo.getTheme(), coutMap.get(processedWeibo.getTheme())+1);
			}else {
				coutMap.put(processedWeibo.getTheme(), 1);
			}
		}
		for(String key :coutMap.keySet()){
			
			sb.append("{value:"
					+ coutMap.get(key)
					+ ",name:\'"
					+ key
					+ "\'},");
		}
		String temp = sb.toString();
		return temp.substring(0,temp.length()-1);
	}

	@Override
	public String[] phareToJSONByTime(ProcessedWeibo[] processedWeibos) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> topicList = new ArrayList<>();
		topicList.add("财经");
		topicList.add("健康");
		topicList.add("教育");
		topicList.add("旅游");
		topicList.add("体育");
		topicList.add("IT");
		topicList.add("人文艺术");
		topicList.add("其它");
		Map<Long, Integer>[] coutMaps = new HashMap[topicList.size()];
		/*for(Map m:coutMaps){
			m = new HashMap<>();
		}*/
		for(int i = 0;i<topicList.size();i++){
			coutMaps[i]= new HashMap<>();
		}
		//get starttiem and to time
		Date fromdate=new Date();
		Date todate=new Date();
		boolean start=false;
		long days;
		
		
		for(ProcessedWeibo processedWeibo:processedWeibos){
		//find the fist and last day	
			if (!start) {
				fromdate=getThisDay(processedWeibo.getWeibo().getDate());
				todate = getThisDay(processedWeibo.getWeibo().getDate());
				start=true;
			}
			Date now = getThisDay(processedWeibo.getWeibo().getDate());
			if (fromdate.after(now)) {
				fromdate=(Date) now.clone();
				
			}
			if (todate.before(now)) {
				todate= (Date) now.clone();
			}
			Map<Long, Integer> nowUseMap = coutMaps[topicList.indexOf(processedWeibo.getTheme())];
			
			if ((nowUseMap.get(now.getTime()))!=null){
				nowUseMap.put(now.getTime(),nowUseMap.get(now.getTime())+1);
			}else {
				nowUseMap.put(now.getTime(), 1);
			}
			
			
		}
		long fromdateLong = fromdate.getTime();
		long todateLong = todate.getTime();
		long dayTime = 24*60*60*1000;
		fromdate = new Date(fromdateLong-(fromdateLong%dayTime) );
		todate = new Date(todateLong-(todateLong%dayTime));
		days= (todate.getTime()-fromdate.getTime())/dayTime+1;
		Date[] dates = new Date[(int)days];
		
		for(int i = 0;i<(int)days;i++){
			dates[i]=new Date(fromdateLong+i*dayTime);
		}
		int[][] counts = new int[topicList.size()][dates.length];
		for(int i = 0;i<topicList.size();i++){
			Map<Long, Integer> nowUseMap = coutMaps[i];
			for(Long now:nowUseMap.keySet()){
				int indexOfDate = (int)((now-fromdateLong)/dayTime);
				//System.out.println("i:"+i+"\tindexOfDate:"+indexOfDate);
				counts[i][indexOfDate] = nowUseMap.get(now);
			}
		}
		String[] resultStrs = new String[9];
		resultStrs[0] = phareDates(dates);
		for(int i = 0;i<8;i++){
			resultStrs[i+1] = phareCounts(coutMaps[i], dates.length, fromdateLong);
		}
		return resultStrs;
	}
	
	
	private Date getThisDay(java.util.Date date){
		long dayTime = 24*60*60*1000;
		long oldDateTime = date.getTime();
		Date newDate = new Date(oldDateTime-(oldDateTime%dayTime));
		return newDate;
	}
	
	
	private String phareDates(Date[] dates) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		for(Date date :dates){
			String dateStr = format.format(date);
			sb.append(dateStr+",");
		}
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
	private String phareCounts(Map<Long, Integer> map,int howManyDays,Long fromDateLong) {
		StringBuffer sb = new StringBuffer();
		Integer[] countArr = new Integer[howManyDays];
		for(int i = 0;i<countArr.length;i++)
			countArr[i]=new Integer(0);
		long dayTime = 24*60*60*1000;
		for(Long now:map.keySet()){
			int index = (int) ((now-fromDateLong)/dayTime);
			countArr[index] = map.get(now);
		}
		
		return join(countArr, ",");
	}
	
	private  <T> String join(T[] objs,String spliter) {
		StringBuffer sb = new StringBuffer();
		for(T s:objs){
			sb.append(s.toString()+spliter);
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
}
