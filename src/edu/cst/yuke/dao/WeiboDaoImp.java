package edu.cst.yuke.dao;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import edu.cst.yuke.beans.Weibo;

public class WeiboDaoImp implements WeiboDao{

	@Override
	public void save(Weibo weibo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Weibo weibo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Weibo findbyId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Weibo> find(Date fromtime, Date endtime, String uid) {
		// TODO Auto-generated method stub
		List<Weibo> weibos =new ArrayList<Weibo>();
		weibos.add(new Weibo("1", "1", "�������ǹ����Ǹ�˧���Ĺ��ң������̫������", new Date(2015, 5, 5)));
		weibos.add(new Weibo("1", "2", "�������ǹ����Ǹ�˧���Ĺ��ң������̫�����˹�����", new Date(2015, 5, 8)));
		weibos.add(new Weibo("1", "3", "�������ǹ����Ǹ�˧���Ĺ��ң������̫�����˹����������ǵ��������Ե�΢�����й������е�", new Date(2015, 5, 9)));
		return (ArrayList<Weibo>) weibos;
	}

	@Override
	public ArrayList<Weibo> find(Date fromtime, Date endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Weibo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
