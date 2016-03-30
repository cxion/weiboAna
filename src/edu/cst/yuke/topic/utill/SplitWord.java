package edu.cst.yuke.topic.utill;

/**
 * �ִʹ��� ���õ���ģʽ 
 * �̲߳���ȫ
 * @author xion
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.sun.jna.Library;
import com.sun.jna.Native;

//import code.NlpirTest.CLibrary;

public class SplitWord {
	static SplitWord spliter;
	// ����ӿ�CLibrary���̳���com.sun.jna.Library
		public interface CLibrary extends Library {
			// ���岢��ʼ���ӿڵľ�̬����
			CLibrary Instance = (CLibrary) Native.loadLibrary(
					"NLPIR", CLibrary.class);

			// printf��������
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
			// ����printf��ӡ��Ϣ
			int init_flag = CLibrary.Instance.NLPIR_Init(argu
					.getBytes(system_charset), charset_type, "0"
					.getBytes(system_charset));

			if (0 == init_flag) {
				System.err.println("��ʼ��ʧ�ܣ�");
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
					System.out.println("�ִʹ����ļ���ȡʧ��");
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
