package edu.cst.yuke.beans;
/**
 * 原始微博对象
 * 目前按时保留id和text两个主要内容
 * @author xion_
 *
 */
public class Weibo {
	//微博id
	int id;
	//微博内容
	String text;
	//uid 、 
	
	public Weibo(int id, String text) {
		
		this.id = id;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
