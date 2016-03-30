package edu.cst.yuke.topic.evaluation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import edu.cst.yuke.topic.TopicProcessosImp;
import edu.cst.yuke.topic.TopicProcessosImpFace;

/**
 * 用于评价算法准确度的类
 * @author xion_
 *
 */
public class Evaluater {
	/**
	 * 文件按照 话题目录-文本的结构组织
	 *      文件夹
	 *      / | \
	 *   话题1 话题2 话题3
	 *   | |
	 * 文本    |
	 *    文本
	 */
	static int[][] confusionMatrix = new int[7][7];
	
	static List<String> topicsStr=new ArrayList();
	static{
		topicsStr.add("财经");
		topicsStr.add("健康");
		topicsStr.add("教育");
		topicsStr.add("旅游");
		topicsStr.add("人文艺术");
		topicsStr.add("体育");
		topicsStr.add("IT");
	}	
	static int right,notright;
		
	static String testFilePath;
	public static void main(String[] args) {
		/*testFilePath="knnData/weiboCorpus/";
		verification();
		printMatrix();*/
		splitFile(new File("C:\\Users\\xion_\\Desktop\\testData\\财经.txt"));
		
	}
	
	private static void printMatrix(){
		System.out.print("\t");
		for(String topic :topicsStr){
			System.out.print(topic+"\t");
		}
		System.out.println();
		for(int i = 0;i<7;i++){
			System.out.print(topicsStr.get(i)+"\t");
			for(int j = 0;j<7;j++){
				System.out.print(confusionMatrix[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	private static void verification(){
		File[] topicFolders = new File(testFilePath).listFiles();
		int i=0,j=0;
		for(File topicFolder:topicFolders){
			i=topicsStr.indexOf(topicFolder.getName());
			File[] weiboFiles = topicFolder.listFiles();
			for(File weibofile:weiboFiles){
				String classifyResult = classify(weibofile);
			j=topicsStr.indexOf(classifyResult);
			if(i==-1 || j==-1){
				System.err.println("不是你的文件夹名字有问题，就是你的分类的结果名字有问题");
				i=0;
				j=0;
				continue;
			}
			System.out.print(topicFolder.getName()+":"+classifyResult);
			if (topicFolder.getName().equals(classifyResult)) {
				right++;
			}else {
				notright++;
			}
			System.out.print(topicFolder.getName().equals(classifyResult)?" |":"   |");
			System.out.println("\t"+(right*1.0)/(right+notright)+"%");
			confusionMatrix[i][j]++;
			}
		}
	}
	private static String classify(File file){
		
		String topic = TopicProcessosImp.getInstance().getTopic(readFile(file));
		return topic;
	}
	
	private static String readFile(File file){
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), "GBK"));
			String temp;
			while((temp=reader.readLine())!=null){
				sb.append(temp);
			}
			reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("不支持的编码格式");
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件不存在");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读写错误");
			return null;
		}
		
		return sb.toString();
	}
	
	private static void splitFile(File file) {
		try {
			String path = file.getParent()+"\\"+file.getName().substring(0, file.getName().indexOf("."));
			File makepaht= new File(path);
			makepaht.mkdirs();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK" ));
			String readerStr;
			int i = 0;
			BufferedWriter writer;
			StringBuffer sb = new StringBuffer();
			while((readerStr=reader.readLine())!=null){
				if (!readerStr.trim().equals("")) {
					sb.append(readerStr);
				}else {
					i++;
					writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+"\\"+i+".txt")),"utf-8"));
					writer.write(sb.toString());
					writer.flush();
					System.out.println(path+"\\"+i+".txt");
				}
				
			}
			i++;
			writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+"/"+i)),"utf-8"));
			writer.write(sb.toString());
			writer.flush();
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
