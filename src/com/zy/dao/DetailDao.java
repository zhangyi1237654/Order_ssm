package com.zy.dao;

import java.util.List;

import com.zy.vo.Detail;

public interface DetailDao {

	public List<Detail> listByOrderId(int id);
	public int delete(int id);
}
