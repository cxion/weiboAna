package edu.cst.yuke.topic.knn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KdTree {
	int dimension;
	int nowWhichXi=0;
	List<Vector> points = new ArrayList<>();
	Node root = null;
	public void fromFileLoadPoint(){
		
	}
	
	public void addPoint(Vector p){
		//this is not a safe copy do not change p after you add it in to this 
		this.points.add(p);
	}
	
	public void initialMode(){
		this.dimension=points.get(0).demension;
		this.root=makeKdTree(points, 0);
	}
	
	public Node makeKdTree(List<Vector> orglist,int usingDimension){
		this.setUsingIndex(usingDimension);
		Collections.sort(orglist);
		Node node = new Node();
		int mid = orglist.size()/2;
		if (orglist.size()==0) {
			return null;
		}if (orglist.size()==1) {
			Node node2= new Node();
			node2.X=orglist.get(0);
			return node2;
		}
		node.X=orglist.get(mid);
		List<Vector> llist = orglist.subList(0, mid);
		List<Vector> rlist = orglist.subList(mid+1, orglist.size());
		
			node.lchid=makeKdTree(llist, (usingDimension+1)%dimension);
			node.lchid.father = node;
			node.rchid=makeKdTree(rlist, (usingDimension+1)%dimension);
			node.rchid.father = node;
		
		
		return node;
	}
	
	public void printTree(Node node){
		System.out.print(node.X.toString()+",");
		if (node.lchid!=null) {
			printTree(node.lchid);
		}
		if (node.rchid!=null) {
			printTree(node.rchid);
		}
	}
	
	public void setUsingIndex(int index){
		for(Vector p :points){
			p.whichIndexUsing= index;
		}
	}
	
	public Vector[] getNearestPoit(Vector p,int n){
		Vector[] KNPs = new Vector[n];
		return null;
		
	}
	
	
	class Node{
		Vector X;
		Node father = null;
		Node lchid = null;
		Node rchid = null;
	public String toString(){
		return X.toString();
	}
	}
}
