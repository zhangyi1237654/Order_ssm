package com.zy.dao;

import java.util.List;

import com.zy.vo.Order;

public interface OrderDao {

	public List<Order> list();
	public int update(Order order);
	public Order getById(int id);
}
