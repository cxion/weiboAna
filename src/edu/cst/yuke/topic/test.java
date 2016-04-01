package edu.cst.yuke.topic;

public class test {
	public static void main(String[] args) {
		String topic  = TopicProcessosImp.getInstance().getTopic("【中国快递垃圾惊人：年耗170亿米胶带99亿个纸箱】快递包装材料繁多，但是大多数的快递公司或电商都没有回收计划。快递用的胶带和填充泡沫等，往往连收废品的人都不要，只得直接扔掉。对于快递公司来说，回收二手纸箱利润很薄，通常也不会花人力和物力去回收");
		System.out.println(topic);
	}
}
