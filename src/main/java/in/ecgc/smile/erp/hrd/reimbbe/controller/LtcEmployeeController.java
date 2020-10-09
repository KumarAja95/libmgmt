package in.ecgc.smile.erp.hrd.reimbbe.controller;

import java.util.List;


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
import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;
import in.ecgc.smile.erp.hrd.reimbbe.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 *Employee Controller class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@RestController
@RequestMapping("/")
@Api(value = "Ltc Employee  BE Controller")//Swagger annotation
public class LtcEmployeeController {

	private static final Logger LOGGER=LoggerFactory.getLogger(LtcEmployeeController.class);

	@Autowired
	private EmployeeService empService;
	
	
	@ApiOperation(value = "View employee based on id")
	@GetMapping("/employees/{empNo}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empNo") Integer empNo){
		
		LOGGER.info("--Fetching Employee by Id--");
		Employee employee = empService.viewEmployeeById(empNo);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	
	
	
	
	@ApiOperation(value = "View dependent based on dependent id")
	@GetMapping("/employee-dependent/{dependentId}")
	public ResponseEntity<EmployeeDependent> getDependentByDependentId(@PathVariable("dependentId") Integer dependentId){
		
		LOGGER.info("--Fetching dependent based on dependent id--");
		EmployeeDependent empDepn = empService.viewDependentByDependentId(dependentId);
		return new ResponseEntity<>(empDepn,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "View dependent based on employee id and Process")
	@GetMapping("/employee/dependent/{empNo}/{processName}")
	public ResponseEntity<List<EmployeeDependent>> getDependentByEmpId(@PathVariable("empNo") Integer empNo,
			@PathVariable("processName") String processName){
		
		LOGGER.info("--Fetching dependent based on employee id--");
		List<EmployeeDependent> empDepn = empService.viewDependdentById(empNo, processName);
		return new ResponseEntity<>(empDepn,HttpStatus.OK);
	}
	
}
	