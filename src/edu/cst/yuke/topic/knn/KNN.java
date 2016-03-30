package edu.cst.yuke.topic.knn;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class KNN {
	List<KNNNode> nodes;
	
	public KNN(){
		nodes = new ArrayList<>();
	}
	
	public void readDataFromFile(File file){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new 
				BufferedInputStream(new FileInputStream(file))));){
			
			String lineString="";
			boolean init = false;
			int length;
			while((lineString=br.readLine())!=null){
				String[] lineStrings = lineString.split(",");
				nodes.add(new KNNNode(lineStrings));
				nodes.get(nodes.size()-1).index=nodes.size()-1;
				
				
			}
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void caculateDistance(Vector v){
		for(int i = 0;i<nodes.size();i++){
			Vector another = nodes.get(i).vector;
			//这是默认使用的欧式距离，p=2如果要使用其他距离可以自定义
			try {
				nodes.get(i).distance = v.distance(another);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public KNNNode[] getResulet(Vector v,int k){
		caculateDistance(v);
		Collections.sort(nodes);
		
		return nodes.subList(0, k).toArray(new KNNNode[k]);
	}
	
	public String classify(Vector v,int k){
		KNNNode[] nodes = getResulet(v, k);
		Map<String, Integer> stringMap = new HashMap<>();
		
		for(KNNNode n:nodes){
			String lableName = n.lable;
			if (stringMap.containsKey(lableName)) {
				stringMap.put(lableName, stringMap.get(lableName)+1);
			}else  {
				stringMap.put(lableName, 1);
			}
		}
		String finallClass="";
		int max = 0;
		for(String key:stringMap.keySet()){
			int temp = stringMap.get(key);
			if (temp>max) {
				max=temp;
				finallClass=key;
			}
		}
		return finallClass;
	}
	
	class KNNNode implements Comparable<KNNNode>{
		Vector vector;
		int index;
		double distance;
		String lable;
		/**
		 * 使用字符初始化
		 * @param lineStrings 包含了数值特征和lable的向量
		 */
		public KNNNode(String[] lineStrings){
			int n = lineStrings.length;
			String[] sonString = new String[n-1];
			System.arraycopy(lineStrings, 0, sonString, 0, n-1);
			this.vector = new Vector(sonString);
			this.lable = lineStrings[n-1];
			this.distance = 0;
			this.index = -1;
		}

		/**
		 * 
		 */
		@Override
		public int compareTo(KNNNode o) {
			// TODO Auto-generated method stub
			return Double.compare(this.distance, o.distance);
		}
		
		
			
		}
	}

