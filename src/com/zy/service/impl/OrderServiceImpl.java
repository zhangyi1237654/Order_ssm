package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.OrderDao;
import com.zy.service.OrderService;
import com.zy.vo.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> list() {
		return orderDao.list();
	}

}
