package com.zy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zy.dao.OrderDao;
import com.zy.vo.Order;
@Repository("orderDao")
public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<Order> list() {
		return getSqlSession().selectList("com.zy.vo.order.mapper.list");
	}

	@Override
	public int update(Order order) {
		return getSqlSession().update("com.zy.vo.order.mapper.update",order);
	}
	@Override
	public Order getById(int id) {
		
		return getSqlSession().selectOne("com.zy.vo.order.mapper.getById",id);
	}

}
