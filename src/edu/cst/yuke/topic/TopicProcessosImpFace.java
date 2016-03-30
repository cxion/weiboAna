package edu.cst.yuke.topic;

import edu.cst.yuke.beans.ProcessedWeibo;
import edu.cst.yuke.beans.Weibo;
/**
 * 外观类，屏蔽细节
 * @author xion_
 *
 */
public class TopicProcessosImpFace implements TopicProcessor {

	@Override
	public ProcessedWeibo Processor(Weibo weibo) {
		// TODO Auto-generated method stub
		
		ProcessedWeibo processedWeibo = new ProcessedWeibo(weibo);
		processedWeibo.setTheme(TopicProcessosImp.getInstance().getTopic(weibo.getText()));
		processedWeibo.setTopicDone(true);
		
		return processedWeibo;
	}

}
