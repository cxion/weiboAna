package edu.cst.yuke.service;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		String[] strs = {"a","b","c","d","e","f","g","h"};
		Date date = new Date();
		
		for(int i =0; i<100000;i++)
		join1(strs,"_");
		recordTime(date);
		for(int i =0; i<100000;i++)
		join2(strs,"_");
		
		recordTime(date);
		
		for(int i =0; i<100000;i++)
		join3(strs,"_");
		recordTime(date);
	}
	
	private static void recordTime(Date date) {
		
		System.out.println(new Date().getTime()-date.getTime());
		date = new Date();
	}
	private static String join1(String[] strs,String splitter) {
		StringBuffer sb = new StringBuffer();
		for(String s:strs){
			sb.append(s+splitter);
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	
	private static String join2(String[] strs,String splitter) {
		StringBuffer sb = new StringBuffer();
		for(String s:strs){
			sb.append(s+splitter);
		}
		String s = sb.toString();
		return s.substring(0, s.length()-1);
	}
	
	private static String join3(String[] strs,String splitter) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<strs.length;i++){
			if (i!=strs.length-1) {
				sb.append(strs[i]+splitter);
			}else {
				sb.append(strs[i]);
			}
		}
		
		return sb.toString();
	}
}
