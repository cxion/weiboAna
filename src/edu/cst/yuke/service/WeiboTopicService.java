package edu.cst.yuke.service;

import java.io.ObjectInputStream.GetField;
import java.util.Date;

import edu.cst.yuke.beans.ProcessedWeibo;

interface WeiboTopicService {
	//按照uid获取微博
	public ProcessedWeibo[] getWeiboWithTopicByUid(String Uid);
	//按照Uid和时间获取处理后的微博
	public ProcessedWeibo[] getWeiboWithTopicByUidAndTime(String Uid,Date fromDate,Date toDate);
	/**
	 * 转化为JSON
	 * 形如
	 * "{value:124,name:'topic1'},{value:4564,name:'topic2'}"
	 * @param processedWeibos
	 * @return
	 */
	public String phareToJSONByTopic(ProcessedWeibo[] processedWeibos);
	/**
	 * 转化为JSON
	 * 形如
	 * String[0]:
	 * 	data:['date1','date2']
	 * String[1]
	 *  {
	 *  name:'topic1'
	 *  data:[date1value,date2value]
	 *  }
	 * String[2]
	 *  {
	 *  name:'topic2'
	 *  data:[date1value,date2value]
	 *  }
	 * @param processedWeibos
	 * @return
	 */
	public String[] phareToJSONByTime(ProcessedWeibo[] processedWeibos);
	
	
}
