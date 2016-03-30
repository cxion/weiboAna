package edu.cst.yuke.topic.knn;

import javax.security.auth.Subject;

public class Vector implements Comparable<Vector>{
	double[] X;
	int demension;
	int whichIndexUsing = 0;
	//构造方法
	public Vector(double[] X){
		this.X = X;
		this.demension = X.length;	
	}
	//使用字符串构造
	public Vector(String[] line){
		this.demension = line.length;
		X = new double[line.length];
		for(int i = 0;i<this.demension;i++){
		
			this.X[i] = Double.parseDouble(line[i]);
		}
		
	}
	
	public Vector(String line){
		this(line.split(","));
	}
	
	
	
	public Vector add(Vector other){
		double[] result = new double[demension];
		for(int i =0;i<demension;i++){
			result[i] = this.X[i]+other.X[i];
		}
		return new Vector(result);
	}
	
	public Vector sub(Vector other){
		double[] result = new double[demension];
		for(int i =0;i<demension;i++){
			
				result[i] = this.X[i]-other.X[i];
			
		}
		return new Vector(result);
	}
	
	public double dot(Vector other){
		double result = 0;
		for(int i =0;i<demension;i++){
			result+=this.X[i]*other.X[i];
		}
		return result;
	}
	
	public double power(int p){
		double result = 0;
		for(int i =0;i<demension;i++){
			result+=Math.pow(this.X[i], p);
		}
		return result;
	}
	
	public double distance(Vector other,int p){
		double temp;
		temp = (this.sub(other)).power(p);
		return Math.pow(temp, 1/(double)p);
	}
	
	public double distance(Vector other){
		return distance(other, 2);
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(double d:this.X){
			sb.append(d+"，" );
		}
		
		return "["+sb.substring(0, sb.length()-1)+"]";
	}




	@Override
	public int compareTo(Vector o) {
		
		
		return Double.compare(this.X[whichIndexUsing],o.X[whichIndexUsing]);
	}
}


