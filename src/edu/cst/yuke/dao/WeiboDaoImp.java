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
		weibos.add(new Weibo("1", "1", "今天我们国家是个帅气的国家，真的是太厉害了", new Date(2015, 5, 5)));
		weibos.add(new Weibo("1", "2", "今天我们国家是个帅气的国家，真的是太厉害了哈哈哈", new Date(2015, 5, 8)));
		weibos.add(new Weibo("1", "3", "今天我们国家是个帅气的国家，真的是太厉害了哈哈哈，这是第三条测试的微博，中国足球有点", new Date(2015, 5, 9)));
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
