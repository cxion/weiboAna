package edu.cst.yuke.topic.Fex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import edu.cst.yuke.topic.utill.Constant;
import edu.cst.yuke.topic.utill.SplitWord;

public class WordToTopic {
	static final int TOPIC_NUM=Constant.topicNums;
	static final String TOPIC_FILE=Constant.LDA_RESULT_WORDS_FILE;
	
	static WordToTopic wordToTopic;
	Map<String, String> topicMap;
	boolean loaded=false;
	private WordToTopic(){
		topicMap  = new HashMap<>();
		this.loadTopic(TOPIC_FILE);
	}
	/**
	 * singleInstance mode
	 * @return a object which can change D-W to a D-T vector 
	 */
	static public WordToTopic getInstance(){
		if (wordToTopic == null){
			wordToTopic= new WordToTopic();
		}
		return wordToTopic;
	}
	
	public void printMap(){
		int count = 0;
		for(String s : this.topicMap.keySet()){
			System.out.println("词："+s+" 词频和话题"+topicMap.get(s));
			count++;
		}
		System.out.println(count);
	}
	/**
	 * 
	 * @param text the weibo text
	 * @return return a double list ,the number element in it stands for the
	 * extent of different topic
	 * @throws IOException
	 */
	public double[] DWToDT(String text)  {
		double[] DTVector = new double[TOPIC_NUM];
		SplitWord spliter = SplitWord.getInstance();
		String result = spliter.splitWord(text);
		String[] words= result.split(" ");
		for(String word :words){
			String needWord = word.split("/")[0];
			String topicProbilitiesAll =topicMap.get(needWord);
			if (topicProbilitiesAll==null) {
				continue;
			}

			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//System.out.println(needWord);
			String[] topicProbilities = topicProbilitiesAll.split(";");
			for(String topicProbility:topicProbilities){
				String[] tokens=topicProbility.split(" ");
				DTVector[Integer.parseInt(tokens[2])]+=Double.parseDouble(tokens[0]);
			}
		}
		//System.out.println(new edu.zju.cst.knn.Vector(DTVector));
		return DTVector;
	}
	
	private void loadTopic(String filePath){
		BufferedReader br;
		try {
			 br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),"GBK"));
			 String line;
			 while((line = br.readLine())!=null){
				 String[] cuts = line.split("\t");
				 String topic = cuts[0];
				 for(int i = 2;i<cuts.length;i++){
					 String[] temp= cuts[i].split(" ");
					 if (topicMap.get(temp[0])!=null) {
						topicMap.put(temp[0],topicMap.get(temp[0])+";"+temp[1]+" "+topic);
						 //System.err.println(temp[0]+topicMap.get(temp[0])+" "+temp[1]+topic);
					}
					 topicMap.put(temp[0], temp[1]+" "+topic);
				 }
			 }
			 loaded = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.err.println("数组越界");
		}
		
		
		
	}
}
