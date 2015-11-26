package com.yurugee.tech.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yurugee.tech.web.BeanConfig;
import com.yurugee.tech.web.dao.EmployeeDao;
import com.yurugee.tech.web.model.Employee;



@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	private BeanConfig config;

	@Autowired
	private EmployeeDao empDao;


	@RequestMapping("index")
	public String index(){

		System.out.println(config.dataSource().toString());

		Employee emp = empDao.selectById("1");


		return "test-index";

	}

}
