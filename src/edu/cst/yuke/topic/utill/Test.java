package edu.cst.yuke.topic.utill;

import java.io.IOException;
import java.lang.reflect.Field;

import edu.cst.yuke.topic.utill.Constant;
public class Test {
	public static void main(String[] args)  {
		testConstant();
		
	}
	
	public static void testSpliter(){
		System.out.println(SplitWord.getInstance().splitWord("这是一首简单的小情歌"));
	}
	
	public static void testConstant(){
		
			Class c = Constant.class;
			Field[] fs = c.getDeclaredFields();
			for(Field f :fs){
				try {
					System.out.println(f.getName()+f.get(new Constant()));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
}
