package in.ecgc.smile.erp.hrd.reimbbe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;
import in.ecgc.smile.erp.hrd.reimbbe.service.TadaTypeMstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hrd-tada/api")
@Api(value = "TADA Reimbursement Query BE Controller")//Swagger annotation
public class TadaReimbQueryRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TadaReimbQueryRestController.class);
	
	@Autowired
	private TadaTypeMstService tadaTypeMstService;
	
	@ApiOperation(value = "View a list of active tada type", response = List.class)
	@GetMapping("/active/tada-type")
	public ResponseEntity<List<TadaTypeMst>> getActiveTadaType(){
		LOGGER.info("Fetching active tada type");
		List<TadaTypeMst> tadaTypeList = tadaTypeMstService.viewActiveTadaType();
		return new ResponseEntity<>(tadaTypeList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of active tada sub type", response = List.class)
	@GetMapping("/active/tada-subtype/{type}")
	public ResponseEntity<List<TadaTypeMst>> getActiveTadaSubType(@PathVariable("type") String type){
		LOGGER.info("Fetching active tada sub-type");
		List<TadaTypeMst> tadaSubTypeList = tadaTypeMstService.viewActiveTadaSubType(type);
		return new ResponseEntity<>(tadaSubTypeList, HttpStatus.OK);
	}
}
