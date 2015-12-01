package com.yurugee.tech.web.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import com.yurugee.tech.web.model.Employee;


@Dao
@DomaRepository
public interface EmployeeDao {

	@Select
	public Employee selectById(String id);

	@Select
	public Employee selectByName(String name);

	@Select
	public List<Employee> allList();

	@Insert
	public int insert(Employee emp);
}
