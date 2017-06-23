package com.zy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zy.dao.DetailDao;
import com.zy.vo.Detail;
@Repository("detailDao")
public class DetailDaoImpl extends SqlSessionDaoSupport implements DetailDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<Detail> listByOrderId(int id) {
		
		return getSqlSession().selectList("com.zy.vo.detail.mapper.listByOrderId",id);
	}

	@Override
	public int delete(int id) {
		
		return getSqlSession().delete("com.zy.vo.detail.mapper.remove",id);
	}

}
