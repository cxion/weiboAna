package edu.cst.yuke.beans;

import java.util.Date;

/**
 * 鍘熷寰崥瀵硅薄
 * 鐩墠鎸夋椂淇濈暀id鍜宼ext涓や釜涓昏鍐呭
 * @author xion_
 *
 */
public class Weibo {
	//寰崥mid
	String mid;
	//寰崥鍐呭
	String text;
	//uid 銆� 
	String uid;
	Date date;
	public Weibo(){
		
	}
	public Weibo(String uid,String id, String text,Date date) {
		this.uid = uid;
		this.mid = id;
		this.text = text;
		this.date = date;
	}
	public String getId() {
		return mid;
	}
	public void setId(String id) {
		this.mid = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUid(){
		return this.uid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public Date getDate(){
		return this.date;
	}
	public void setDate(Date date){
		this.date = date;
	}
}
