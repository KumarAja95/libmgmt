package in.erp.lib.mgmtbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import org.slf4j.Logger;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.erp.lib.mgmtbe.model.Customer;
import in.erp.lib.mgmtbe.model.Order;
import in.erp.lib.mgmtbe.service.CustomerService;
import in.erp.lib.mgmtbe.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 *Controller class
 *
 *@Author Ajay Kumar **/
@RestController
@RequestMapping("/")
@Api(value = "Customer Controller")//Swagger annotation
public class CustomerController {

	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private OrderService orderService;
	
	
	@ApiOperation(value = " Return Book")
	@PostMapping("/customer/book")
	public ResponseEntity<Boolean> retunBook(@RequestBody Order order){
		
		LOGGER.info("--Return Book--"+ order);
		boolean result = orderService.returnBook(order);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
}
	