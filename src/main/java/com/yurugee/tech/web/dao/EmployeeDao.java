package com.yurugee.tech.web.dao;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yurugee.tech.web.model.Employee;

@Dao
@AnnotateWith(annotations = {
		@Annotation(target=AnnotationTarget.CLASS,type=Component.class),
		@Annotation(target=AnnotationTarget.CONSTRUCTOR,type=Autowired.class)
})
public interface EmployeeDao {
	@Select
	public Employee selectById(String id);

}
