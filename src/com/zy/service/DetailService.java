package com.zy.service;

import java.util.List;

import com.zy.vo.Detail;

public interface DetailService {

	public List<Detail> listByOrderId(int id);
	public int delete(int orderId,int detailId);
}
