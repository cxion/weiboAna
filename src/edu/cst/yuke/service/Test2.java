package edu.cst.yuke.service;

import java.util.Date;
import java.util.List;

import edu.cst.yuke.beans.ProcessedWeibo;
import edu.cst.yuke.dao.WeiboDaoImp;

public class Test2 {
	public static void main(String[] args) {
		new WeiboDaoImp().find(new Date(), new Date(), "5");
		WeiboTopicServiceImp topicSer = new WeiboTopicServiceImp();
		ProcessedWeibo[] processedWeibos = topicSer.getWeiboWithTopicByUidAndTime("s", new Date(), new Date());
		String jsonStr = topicSer.phareToJSONByTopic(processedWeibos);
		System.out.println(jsonStr);
		String[] strs = topicSer.phareToJSONByTime(processedWeibos);
		for(String s :strs){
			System.out.println(s);
		}
		System.out.println();
	}
}
