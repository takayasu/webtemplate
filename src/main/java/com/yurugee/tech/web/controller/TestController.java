package com.yurugee.tech.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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


		Employee emp = empDao.selectById("1");


		return "test-index";

	}

	@RequestMapping("list")
	public ModelAndView list(){



		List<Employee> list = empDao.allList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("test-list");

		return mv;

	}

	@RequestMapping(path="add")
	public ModelAndView add(@RequestParam Map<String, String> params) throws UnsupportedEncodingException{

		Employee emp = new Employee();
		emp.id = params.get("id");
		emp.name = params.get("name");

		empDao.insert(emp);


		List<Employee> list = empDao.allList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("test-list");

		return mv;

	}


	@RequestMapping(path="add2" ,produces="text/plain;charset=UTF-8")
	public ModelAndView requestAdd(HttpServletRequest request) throws UnsupportedEncodingException{

		Employee emp = new Employee();
		emp.id = request.getParameter("id");
		emp.name = request.getParameter("name");

		empDao.insert(emp);


		List<Employee> list = empDao.allList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("test-list");

		return mv;

	}


}
