package edu.cst.yuke.beans;
/**
 * �����Ժ��΢������
 * 
 * @author xion_
 *
 */
public class ProcessedWeibo {
	//ԭʼ΢������
	Weibo weibo;
	//����
	String theme;
	//���ά�ȵ÷�
	double[] emotions;

	//�Ƿ�����˻���ķ���
	boolean topicDone=false;
	//�Ƿ��������еķ���
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
