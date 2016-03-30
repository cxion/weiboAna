package edu.cst.yuke.topic.utill;

public final class Constant {
	//常量
	public final static String WEIBO_ORG_PATH="F:/weibo/weibo.txt";
	public final static String WEIBO_100000_PATH="F:/weibo/weibo_TM";
	public final static String WEIBO_TM_OUT_PATH="F:/weibo/weibo_TM";
	
	public final static String LDAPARAMETERFILE="ldaData/LdaParameter/LdaParameters.txt";
	//大语料
    public final static String ldaDocsPath = "ldaData/corpus_splited/";
    public final static String LdaResultsPath = "ldaData/LdaResults/";
    
    public final static String STOP_WORD_PATH = "ldaData/stopword/stopword";
    //lda结果
    /**
     * the topic - word matrix file 
     */
    public final static String LDA_RESULT_WORDS_FILE = LdaResultsPath+"lda_150.twords";
    
    public final static String WEIBO_CROPUS_PATH = "knnData/weiboCorpus";
    
    public final static String TRAIN_FILE ="knnData/train.dat";
    public final static String TEST_FILE ="knnData/test.dat";
    
    public final static String KNN_PRESIST_FILE = "knnData/presit.obj";
    //配置
    /**
     * the number of topics
     */
    public static int topicNums=50;
    public static int topicWors=200;
    
    public static int KNN_k = 10;
    
    
    
}
