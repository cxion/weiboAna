package edu.cst.yuke.dao;


import java.util.ArrayList;
import java.util.Date;

import edu.cst.yuke.beans.*;

interface WeiboDao {
	/**
	 * 淇濆瓨processedWeibo鍒版暟鎹簱
	 * 浠eiboID涓哄閿紝涓嶄繚瀛榳eibo瀵硅薄
	 * 鍙繚瀛� id锛宼hem锛宔motion,topicdone,emtiondone
	 * @param processedWeibo
	 */
	public void save(Weibo weibo);
	/**
	 * 鎸夌収鐨勬椂鍊欐寜鐓d鍒犻櫎
	 * @param processedWeibo
	 */
	public void delete(Weibo weibo);
	/**
	 * 鑾峰彇鏌愪釜uid鐨勬墍鏈夊井鍗�
	 * @return 鎵惧埌鐨勮褰�
	 */
	public Weibo findbyId(String id);
	/**
	 * 鑾峰彇鎸囧畾鏃堕棿娈靛唴鐨勬煇uid寰崥
	 * @param fromtime
	 * @param endtime
	 * @param uid
	 * @return
	 */
	public ArrayList<Weibo> find(Date fromtime,Date endtime,String uid);
	/**
	 * 鑾峰彇鏌愭椂闂存鍐呯殑寰崥
	 * @param fromtime
	 * @param endtime
	 * @return
	 */
	public ArrayList<Weibo> find(Date fromtime,Date endtime);
	/**
	 * 鑾峰彇鎵�鏈夎褰�
	 * @return
	 */
	public ArrayList<Weibo> findAll();
}
