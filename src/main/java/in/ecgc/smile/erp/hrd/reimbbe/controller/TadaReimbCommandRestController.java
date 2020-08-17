package in.ecgc.smile.erp.hrd.reimbbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(value = "TADA Reimbursement Command BE Controller")//Swagger annotation
public class TadaReimbCommandRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TadaReimbCommandRestController.class);
	//test
	
	@GetMapping("/")
	public ResponseEntity<String> getActive(){
		LOGGER.info("Fetching active tada type");
		
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
}
