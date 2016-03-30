package edu.cst.yuke.topic.knn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws IOException{
		
		
		/*KdTree kdTree = new KdTree();
		kdTree.addPoint(new Vector(new double[]{2,3}));
		kdTree.addPoint(new Vector(new double[]{5,4}));
		kdTree.addPoint(new Vector(new double[]{9,6}));
		kdTree.addPoint(new Vector(new double[]{4,7}));
		kdTree.addPoint(new Vector(new double[]{8,1}));
		kdTree.addPoint(new Vector(new double[]{7,2}));
		
		kdTree.initialMode();
		kdTree.printTree(kdTree.root);
		System.out.println("");*/
		
		//produceTestDate();
		KNN model = new KNN();
		model.readDataFromFile(new File("train.dat"));
		//String result = model.classify(new Vector("0.1,0.1"), 5);
		//System.out.println(result);
		//String result2 = model.classify(new Vector("0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,8.942778804339468E-4,0.0,0.0,0.0,0.0,0.0,0.0,0.0012492225505411625,0.0,0.0,0.0,0.0,0.0,0.0,0.014363807626068592,0.0,0.0,0.0,0.0,0.0080713527277112,0.0,0.0,0.0,0.0,0.0,0.0,0.0025810018414631486,0.004004373215138912,0.0,0.0,0.0,0.009613704576622695,0.002519549336284399,0.0,0.0,0.0"
		//		), 10);
		BufferedReader bw = new BufferedReader(new InputStreamReader(new FileInputStream("test.dat")));
		String temp;
		while((temp=bw.readLine())!=null){
			System.out.println(model.classify(new Vector(temp), 20));
		}
		//System.out.println(result2);
	}
	
	
	public static void produceTestDate(){
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("test"),"utf-8"));
			double x1=0;
			double x2=0;
			for(int i = 0;i<100;i++){
				x1=new Random().nextDouble()-0.5;
				x2=new Random().nextDouble()-0.5;
				bw.write(x1+","+x2+","+"0\n");
			}
			for(int i = 0;i<100;i++){
				x1=new Random().nextDouble()+0.5;
				x2=new Random().nextDouble()+0.5;
				bw.write(x1+","+x2+","+"1\n");
			}
			bw.flush();
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
}
