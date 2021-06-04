package in.ecgc.smile.erp.hrd.reimbbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import org.slf4j.Logger;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 *Employee Controller class
 *
 *@Author Ajay Kumar **/
@RestController
@RequestMapping("/")
@Api(value = "Employee Controller")//Swagger annotation
public class EmployeeController {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;
	
	
	@ApiOperation(value = "View employee based on id")
	@GetMapping("/employees/{empNo}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empNo") Integer empNo){
		
		LOGGER.info("--Fetching Employee by Id--");
		//Employee employee = empService.viewEmployeeById(empNo);
		//return new ResponseEntity<>(employee, HttpStatus.OK);
		Employee emp = new Employee();
		emp.setEmpAlias("Ajay Kumar");
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
}
	