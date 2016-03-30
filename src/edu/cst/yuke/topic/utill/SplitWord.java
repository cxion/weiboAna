package edu.cst.yuke.topic.utill;

/**
 * 分词工具 采用单例模式 
 * 线程不安全
 * @author xion
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.sun.jna.Library;
import com.sun.jna.Native;

//import code.NlpirTest.CLibrary;

public class SplitWord {
	static SplitWord spliter;
	// 定义接口CLibrary，继承自com.sun.jna.Library
		public interface CLibrary extends Library {
			// 定义并初始化接口的静态变量
			CLibrary Instance = (CLibrary) Native.loadLibrary(
					"NLPIR", CLibrary.class);

			// printf函数声明
			public int NLPIR_Init(byte[] sDataPath, int encoding,
					byte[] sLicenceCode);

			public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);

			public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,
					boolean bWeightOut);

			public void NLPIR_Exit();
		}

		public static String transString(String aidString, String ori_encoding,
				String new_encoding) {
			try {
				return new String(aidString.getBytes(ori_encoding), new_encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		private SplitWord() throws IOException{
			String argu = "";
			String system_charset = "GBK";
			int charset_type = 1;
			// 调用printf打印信息
			int init_flag = CLibrary.Instance.NLPIR_Init(argu
					.getBytes(system_charset), charset_type, "0"
					.getBytes(system_charset));

			if (0 == init_flag) {
				System.err.println("初始化失败！");
				return;
			}
		}
		public static SplitWord getInstance(){
			if (spliter==null) {
				try {
					spliter = new SplitWord();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("分词工具文件读取失败");
					return null;
				}
			}
			return spliter;
		}
		
		public String splitWord(String sInput){
			String nativeBytes = null;
			try {
				nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 3);	
				return nativeBytes;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
}
