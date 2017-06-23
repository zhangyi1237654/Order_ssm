package com.zy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.dao.DetailDao;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DetailDao detailDao = (DetailDao) ac.getBean("detailDao");
		System.out.println(detailDao.listByOrderId(1).size());
	}

}
