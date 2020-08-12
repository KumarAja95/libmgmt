package in.ecgc.smile.erp.hrd.reimbbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(value = "TADA Reimbursement Query BE Controller")//Swagger annotation
public class TadaReimbQueryRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TadaReimbQueryRestController.class);
}
