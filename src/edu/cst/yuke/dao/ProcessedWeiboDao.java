package edu.cst.yuke.dao;

import java.util.ArrayList;
import java.util.Date;

import edu.cst.yuke.beans.*;

interface ProcessedWeiboDao {
	/**
	 * 淇濆瓨processedWeibo鍒版暟鎹簱
	 * 浠eiboID涓哄閿紝涓嶄繚瀛榳eibo瀵硅薄
	 * 鍙繚瀛� id锛宼hem锛宔motion,topicdone,emtiondone
	 * @param processedWeibo
	 */
	public void save(ProcessedWeibo processedWeibo);
	/**
	 * 鎸夌収鐨勬椂鍊欐寜鐓d鍒犻櫎
	 * @param processedWeibo
	 */
	public void delete(ProcessedWeibo processedWeibo);
	/**
	 * 閫氳繃id鏌ユ壘璁板綍
	 * @return 鎵惧埌鐨勮褰�
	 */
	public ProcessedWeibo findbyId(String uid);
	/**
	 * 鑾峰彇鎸囧畾鏃堕棿娈靛唴鐨勬煇uid寰崥鍒嗘瀽缁撴灉
	 * @param fromtime
	 * @param endtime
	 * @param uid
	 * @return
	 */
	public ArrayList<ProcessedWeibo> find(Date fromtime,Date endtime,String uid);
	/**
	 * 鑾峰彇鎸囧畾鏃堕棿娈靛唴鐨勬墍鏈塽id寰崥鍒嗘瀽缁撴灉
	 * @param fromtime
	 * @param endtime
	 * @return
	 */
	public ArrayList<ProcessedWeibo> find(Date fromtime,Date endtime);
	/**
	 * 鑾峰彇鎵�鏈夎褰�
	 * @return
	 */
	public ArrayList<ProcessedWeibo> findAll();
	
}
