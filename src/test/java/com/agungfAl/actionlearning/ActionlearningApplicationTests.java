package com.agungfAl.actionlearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agungfAl.actionlearning.entity.Employee;
import com.agungfAl.actionlearning.entity.PenyerapanDanaDesa;
import com.agungfAl.actionlearning.service.EmployeeService;
import com.agungfAl.actionlearning.service.PenyerapanService;

@SpringBootTest
class ActionlearningApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired 
	PenyerapanService serapService;

	@Autowired
	EmployeeService empService;

	// @Test 
	// void testPenyerapanService(){

	// }
	@Test
	void testUpdateEmp(){
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("SUPERAGUNG");
		emp.setRole("ADMIN");
		emp.setActive(true);

		Employee dataUpdate = new Employee();
		dataUpdate.setId(1L);
		dataUpdate.setName("SUPERADMIN");
		dataUpdate.setRole("ADMIN");
		dataUpdate.setActive(true);

		Employee emp3 = empService.update(dataUpdate, 1L);
		Assertions.assertEquals(dataUpdate, emp3);
		// Employee emp4 = empService.update(emp2, 1L);
		// Assertions.assertEquals(emp, emp3);
	}
	
	@Test
	void testUpdateSerap(){		
		PenyerapanDanaDesa serap = new PenyerapanDanaDesa();
		// serap.setId(14L);
		serap.setkdUraianOutput("12345");
		serap.setsatuanOutput("Test5");
		serap.setVolume("5");

		
		PenyerapanDanaDesa updateSerap = new PenyerapanDanaDesa();
		// updateSerap.setId(14L);
		updateSerap.setkdUraianOutput("123456");
		updateSerap.setsatuanOutput("Test6");
		updateSerap.setVolume("6");
	
		
		PenyerapanDanaDesa serap2 = serapService.update(updateSerap, 14L);
		Assertions.assertEquals(updateSerap, serap2);		
	}



}
