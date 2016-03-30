package edu.cst.yuke.topic;

public class test {
	public static void main(String[] args) {
		String topic  = TopicProcessosImp.getInstance().getTopic("国足有了自信2:0取胜把不可能变成可能，股市自信有了4000点！");
		System.out.println(topic);
	}
}
