package edu.cst.yuke.topic;

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
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import edu.cst.yuke.topic.Fex.WordToTopic;
import edu.cst.yuke.topic.knn.KNN;
import edu.cst.yuke.topic.knn.Vector;
import edu.cst.yuke.topic.utill.Constant;

/**
 * singleInstance mode，实现类
 * @author xion_
 *
 */
public class TopicProcessosImp {
	static TopicProcessosImp instance;
	KNN knnmodel ;
	public static TopicProcessosImp getInstance(){
		if (instance==null){
			instance = new TopicProcessosImp();
		}
		return instance;
	}
	
	private TopicProcessosImp(){
		knnmodel = new KNN();
		if (!new File(Constant.TRAIN_FILE).exists()) {
			produceTrainDataFromFiles(Constant.WEIBO_CROPUS_PATH);
		}
		
		
		knnmodel.readDataFromFile(new File(Constant.TRAIN_FILE));
		//1 初始化knn
		//1.1文件存在，从文件读
		//1.2文件不存在，生成
	}
	
	/*public String getTopic(String text){
		return "经济";
	}*/
	private  void produceTrainDataFromFiles(String path) {
	    File parent = new File(path);
	    
	    BufferedWriter writer;
	    try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(Constant.TRAIN_FILE))));
		
	    File[] topicDirs = parent.listFiles();
	    for(File topicDir:topicDirs){
	    	File[] weibos = topicDir.listFiles();
	    	String topic = topicDir.getName();
	    	for(File file: weibos){
					double[] vector = WordToTopic.getInstance().DWToDT(this.readFile(file));
				   	for(double d:vector){
				   		writer.write(d+",");
				   	}
				   	writer.write(topic+"\n");
	    	}
	    	
	    }
	    writer.flush();
    	writer.close();
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("io错误");
			return;
		}
	}
	

	
	private String readFile(File file){
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), "gbk"));
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
	
	public String getTopic(String text){
		String topic;
		
		Vector v = new Vector(WordToTopic.getInstance().DWToDT(text));
		if (v.power(2)==0) {
			return "其它";
		}
		topic = knnmodel.classify(v, Constant.KNN_k);
		return topic;
	}
}
