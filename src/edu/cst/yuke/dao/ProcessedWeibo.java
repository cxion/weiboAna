package edu.cst.yuke.dao;

import java.util.Date;

interface ProcessedWeibo {
	/**
	 * ����processedWeibo�����ݿ�
	 * ��weiboIDΪ�����������weibo����
	 * ֻ���� id��them��emotion,topicdone,emtiondone
	 * @param processedWeibo
	 */
	public void save(ProcessedWeibo processedWeibo);
	/**
	 * ���յ�ʱ����idɾ��
	 * @param processedWeibo
	 */
	public void delete(ProcessedWeibo processedWeibo);
	/**
	 * ͨ��id���Ҽ�¼
	 * @return �ҵ��ļ�¼
	 */
	public ProcessedWeibo findbyId();
	
	public ProcessedWeibo find(Date fromtime,Date endtime,int uid);
	/**
	 * ��ȡ���м�¼
	 * @return
	 */
	public ProcessedWeibo findAll();
	
}
