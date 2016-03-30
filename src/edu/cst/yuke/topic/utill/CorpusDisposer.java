package edu.cst.yuke.topic.utill;

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
import java.util.StringTokenizer;



public class CorpusDisposer {
	
	static int count;
	static SplitWord sw ;
	public static void main(String[] args) throws IOException {
		visitFiles(new File("C:\\Users\\xion_\\Downloads\\dataset_617249 (1)\\617249"));
		System.out.println(count);
		
	}
	
	public static void visitFiles(File path){
		
			if (path.isDirectory()) {
				File[] files = path.listFiles();
				for(File file :files){
					visitFiles(file);
				}
			}else {
				dosomething_to_doc(path);
				
			}
			
		
	}
	
	public static void dosomething_to_doc(File file){
		//System.out.println(file.getAbsolutePath());
		
		String decFileName= "ldaData/corpus2/"+file.getParentFile().getName()+"_"+file.getName();
		System.out.println(count++);
		System.out.println(file.getAbsolutePath()+"\t-->\t"+decFileName);
		if (!new File(decFileName).exists()) {
			doc_split(file, new File(decFileName));	
		}else {
			
			System.err.println("exist");
		}
	}
	
	public static void doc_split(File orgFile, File desFile){
		try {
			if(sw==null){
				sw = SplitWord.getInstance();
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(orgFile), "GBK"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile)));
			String temp;
			while((temp=br.readLine())!=null){

				String templine =sw.splitWord(temp);

				StringTokenizer tokenizer = new StringTokenizer(templine, " ");
				while(tokenizer.hasMoreTokens()){
					String word = tokenizer.nextToken();
					//System.err.println("hello");
					String Nword ="";
					try {
						Nword = word.trim().substring(0, word.indexOf("/"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
						
					}
				
					bw.write(Nword+" ");
					
					
				}
				bw.write("\n");;
				
				System.gc();
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
