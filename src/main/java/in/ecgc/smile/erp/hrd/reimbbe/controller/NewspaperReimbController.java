package in.ecgc.smile.erp.hrd.reimbbe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import in.ecgc.smile.erp.hrd.reimbbe.model.ExpensesReimbMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.NewspaperReimb;
import in.ecgc.smile.erp.hrd.reimbbe.service.NewspaperReimbQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(value = "Newspaper Reimbursement BE Controller")//
public class NewspaperReimbController {
	
private static final Logger LOGGER=LoggerFactory.getLogger(NewspaperReimbController.class);

	
	
	@Autowired
	private NewspaperReimbQueryService newspaperReimbQueryService;
	

	@ApiOperation(value = "GET EXPENSES REIMB ELIGIBLTY LIST")						//Swagger Annotation 
	@GetMapping("/expenses_mst/{rankId}/{processCd}")
	public ResponseEntity<ExpensesReimbMst> getExpensesMstList(@PathVariable("rankId") Integer rankId, @PathVariable("processCd") String processCd){
		LOGGER.info("--Inside Expenses reimb Eligiblty List --");
		LOGGER.error("--List Expenses reimb Eligiblty --",rankId);
		System.out.println(rankId);
		ExpensesReimbMst expensesReimbMst=newspaperReimbQueryService.getExpensesMstList(rankId,processCd);
		System.out.println(expensesReimbMst);
		return new ResponseEntity<>(expensesReimbMst,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET EXPENSES REIMB ELIGIBLTY LIST")						//Swagger Annotation 
	@GetMapping("/expenses_mst/list")
	public ResponseEntity<List<ExpensesReimbMst>> getExpensesMstList(){
		LOGGER.info("--Inside get Expenses reimb Eligiblty List --");
		List<ExpensesReimbMst> list=newspaperReimbQueryService.getExpensesMstList();
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "ADD Expenses Reimb Eligiblty Data")						//Swagger Annotation 
	@PostMapping("/expenses_mst")
	public ResponseEntity<Boolean> saveExpensesMstData(@RequestBody ExpensesReimbMst expensesReimbMst){
		LOGGER.info("--Add GET Expenses Reimb Eligiblty Data--");
		LOGGER.error("--Ltc Data--",expensesReimbMst);
		boolean result=newspaperReimbQueryService.addExpensesMstdata(expensesReimbMst);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	/*
	
	@ApiOperation(value = "GET Expenses Reimb Eligiblty")						//Swagger Annotation 
	@GetMapping("/LtcEligibltyData")
	public ResponseEntity<ExpensesReimbMst> getLtcEligibltyData(@RequestParam int ltcNo){
		LOGGER.info("--Inside get Expenses Reimb Eligiblty data by ltcNO --");
		LOGGER.error("--List of Expenses Reimb Eligiblty --",ltcNo);
		System.out.println(ltcNo);
		ExpensesReimbMst expensesReimbMst=newspaperReimbQueryService.
		System.out.println(expensesReimbMst);
		return new ResponseEntity<>(expensesReimbMst,HttpStatus.OK);
	}
	*/
	
	
	
	@ApiOperation(value = "Update Expenses Reimb Eligiblty Data")						//Swagger Annotation 
	@PutMapping("/expenses_mst")
	public ResponseEntity<Boolean> updateExpensesMstData(@RequestBody ExpensesReimbMst expensesReimbMst){
		LOGGER.info("--Add GET Expenses Reimb Eligiblty Data--");
		LOGGER.error("--Ltc Data--",expensesReimbMst);
		boolean result=newspaperReimbQueryService.updateExpensesMst(expensesReimbMst);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "DELETE Expenses Reimb Eligiblty Data")						//Swagger Annotation 
	@DeleteMapping("/expenses_mst/{expEligId}")
	public ResponseEntity<Boolean> deleteExpensesMstData(@PathVariable("expEligId") Integer expEligId){
		LOGGER.info("--Add GET Expenses Reimb Eligiblty Data--");
		LOGGER.error("--Ltc Data--",expEligId);
		boolean result=newspaperReimbQueryService.deleteLtcExpensesMst(expEligId);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "ADD Newspaper Reimb Data")						//Swagger Annotation 
	@PostMapping("/newspaper_reimb")
	public ResponseEntity<Boolean> saveNewspaperReimbData(@RequestBody NewspaperReimb newspaperReimb){
		LOGGER.info("--Add Newspaper Reimb Data--");
		LOGGER.error("--NewsPaper Reimb  Data--",newspaperReimb);
		boolean result=newspaperReimbQueryService.addNewspaperReimbdata(newspaperReimb);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "Update Newspaper Reimb Data")						//Swagger Annotation 
	@PutMapping("/newspaper_reimb")
	public ResponseEntity<Boolean> updateNewspaperReimbData(@RequestBody NewspaperReimb newspaperReimb){
		LOGGER.info("--update Newspaper Reimb  Data--");
		LOGGER.error("--NewsPaper Reimb  Data--",newspaperReimb);
		boolean result=newspaperReimbQueryService.updateNewspaperReimbdata(newspaperReimb);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "GET Newspaper REIMB  LIST")						//Swagger Annotation 
	@GetMapping("/newspaper_reimb/list/{processCd}")
	public ResponseEntity<List<NewspaperReimb>> getNewspaperReimbList(@PathVariable("processCd") String processCd){
		LOGGER.info("--Inside Newspaper reimb  List --");
		LOGGER.error("--List Newspaper reimb  --",processCd);
		System.out.println(processCd);
		List<NewspaperReimb> list=newspaperReimbQueryService.getNewspaperReimbList(processCd);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET Newspaper REIMB  BY AppNO")						//Swagger Annotation 
	@GetMapping("/newspaper_reimb/{appNo}")
	public ResponseEntity<NewspaperReimb> getNewspaperReimbByAppNo(@PathVariable("appNo") Integer appNo){
		LOGGER.info("--Inside Newspaper reimb  Get BY AppNo --");
		LOGGER.error("-- Newspaper reimb BY AppNo --",appNo);
		System.out.println(appNo);
		NewspaperReimb news=newspaperReimbQueryService.getNewspaperReimbByAppNo(appNo);
		System.out.println(news);
		return new ResponseEntity<>(news,HttpStatus.OK);
	}

}
