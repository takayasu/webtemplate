package com.yurugee.tech.web.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name="emp")
public class Employee {

	public String id;
	public String name;

}
