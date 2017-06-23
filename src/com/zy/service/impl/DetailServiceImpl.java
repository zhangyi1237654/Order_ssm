package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.DetailDao;
import com.zy.dao.OrderDao;
import com.zy.error.DeleteException;
import com.zy.service.DetailService;
import com.zy.vo.Detail;
import com.zy.vo.Order;
@Service("detailService")
public class DetailServiceImpl implements DetailService{

	@Autowired
	private DetailDao detailDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Detail> listByOrderId(int id) {
		return detailDao.listByOrderId(id);
	}
//
	@Override
	public int delete(int orderId, int detailId) {
		if(detailDao.delete(detailId) > 0){
			Order order = orderDao.getById(orderId);
			List<Detail> detail  = detailDao.listByOrderId(orderId);
			order.setTotalPrice(calcuPrice(detail));
			if(orderDao.update(order) > 0){
				return 1;
			}
		}
		try {
			throw new DeleteException("±§Ç¸,²Ù×÷ÓÐÎó!");
		} catch (DeleteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private double calcuPrice(List<Detail> list){
		
		double sum = 0;
		for(Detail d:list){
			sum+=d.getMenu().getPrice() * d.getNum();
		}
		return sum;
	}
}
