package edu.cst.yuke.beans;
/**
 * 处理以后的微博对象
 * 
 * @author xion_
 *
 */
public class ProcessedWeibo {
	//原始微博对象
	Weibo weibo;
	//主题
	String theme;
	//情感维度得分
	double[] emotions;

	//是否进行了话题的分类
	boolean topicDone=false;
	//是否进行了情感的分类
	boolean emtionDone=false;
	
	public ProcessedWeibo(Weibo weibo) {
		
		this.weibo = weibo;
	
		
	}
	public Weibo getWeibo() {
		return weibo;
	}
	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public double[] getEmotions() {
		return emotions;
	}
	public void setEmotions(double[] emotions) {
		this.emotions = emotions;
	}
	public boolean isTopicDone() {
		return topicDone;
	}
	public void setTopicDone(boolean topicDone) {
		this.topicDone = topicDone;
	}
	public boolean isEmtionDone() {
		return emtionDone;
	}
	public void setEmtionDone(boolean emtionDone) {
		this.emtionDone = emtionDone;
	}
	
	
}
