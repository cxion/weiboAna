package edu.cst.yuke.beans;
/**
 * ԭʼ΢������
 * Ŀǰ��ʱ����id��text������Ҫ����
 * @author xion_
 *
 */
public class Weibo {
	//΢��id
	int id;
	//΢������
	String text;
	//uid �� 
	
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
