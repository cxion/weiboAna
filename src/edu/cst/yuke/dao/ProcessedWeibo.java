package edu.cst.yuke.dao;

import java.util.Date;

interface ProcessedWeibo {
	/**
	 * 保存processedWeibo到数据库
	 * 以weiboID为外键，不保存weibo对象
	 * 只保存 id，them，emotion,topicdone,emtiondone
	 * @param processedWeibo
	 */
	public void save(ProcessedWeibo processedWeibo);
	/**
	 * 按照的时候按照id删除
	 * @param processedWeibo
	 */
	public void delete(ProcessedWeibo processedWeibo);
	/**
	 * 通过id查找记录
	 * @return 找到的记录
	 */
	public ProcessedWeibo findbyId();
	
	public ProcessedWeibo find(Date fromtime,Date endtime,int uid);
	/**
	 * 获取所有记录
	 * @return
	 */
	public ProcessedWeibo findAll();
	
}
