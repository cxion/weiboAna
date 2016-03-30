package edu.cst.yuke.topic;

import edu.cst.yuke.beans.ProcessedWeibo;
import edu.cst.yuke.beans.Weibo;

public interface TopicProcessor {
	public ProcessedWeibo Processor(Weibo weibo);
}
