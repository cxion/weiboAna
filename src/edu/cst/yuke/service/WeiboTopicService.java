package edu.cst.yuke.service;

import java.io.ObjectInputStream.GetField;
import java.util.Date;

import edu.cst.yuke.beans.ProcessedWeibo;

interface WeiboTopicService {
	//����uid��ȡ΢��
	public ProcessedWeibo[] getWeiboWithTopicByUid(String Uid);
	//����Uid��ʱ���ȡ������΢��
	public ProcessedWeibo[] getWeiboWithTopicByUidAndTime(String Uid,Date fromDate,Date toDate);
	/**
	 * ת��ΪJSON
	 * ����
	 * "{value:124,name:'topic1'},{value:4564,name:'topic2'}"
	 * @param processedWeibos
	 * @return
	 */
	public String phareToJSONByTopic(ProcessedWeibo[] processedWeibos);
	/**
	 * ת��ΪJSON
	 * ����
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
