package in.ecgc.smile.erp.hrd.reimbbe.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;
import in.ecgc.smile.erp.hrd.reimbbe.service.LtcCommandService;
import in.ecgc.smile.erp.hrd.reimbbe.service.LtcQueryService;
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
@Api(value = "Ltc Reimbursement BE Controller")//Swagger annotation
public class LtcReimbController {
	private static final Logger LOGGER=LoggerFactory.getLogger(LtcReimbController.class);
	
	
	@Autowired
	private LtcCommandService ltcCommandService;
	
	@Autowired
	private LtcQueryService ltcQueryService;
	
	@ApiOperation(value = "Add LTC Advance data")						//Swagger Annotation 
	@PostMapping("/ltcTxn-adv")
	public ResponseEntity<Integer> saveLtcAdvDtls(@RequestBody  LtcTxn ltcData,Locale locale, Model model) {

		LOGGER.info("--Inside save Ltc data--");
		LOGGER.error("--Creating LtcTxn with this data--",ltcData);
		int result=ltcCommandService.addLtcAdvData(ltcData);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}

	@ApiOperation(value = "GET LTC LIST")						//Swagger Annotation 
	@GetMapping("/LtcAdvApproveList")
	public ResponseEntity<List<LtcTxn>> getAdavanceApprovalList(@PathVariable("empNo") Integer empNo){
		LOGGER.info("--Inside get Advance Approval List --");
		LOGGER.error("--List of empID--",empNo);
		List<LtcTxn> list=ltcQueryService.getAdvanceApprovalList(empNo);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "GET LTC Data By LtcTxnId")						//Swagger Annotation 
	@GetMapping("/ltctxn/{ltcTxnId}")
	public ResponseEntity<LtcTxn> getLtcDataByLtcTxnId(@PathVariable("ltcTxnId") Integer ltcTxnId){
		LOGGER.info("--Inside GET LTC Data By LtcTxnId --");
		LOGGER.error("--Ltc Data--",ltcTxnId);
		LtcTxn ltcTxn=ltcQueryService.getLtcDataByLtcTxnId(ltcTxnId);
		System.out.println(ltcTxn);
		return new ResponseEntity<>(ltcTxn,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "ADD LTC Advance Settlement")						//Swagger Annotation 
	@PostMapping("/ltcTxn-set")
	public ResponseEntity<Integer> saveLtcSetDtls(@RequestBody LtcTxn ltcData){
		LOGGER.info("--Inside Add LTC Settlement Data  --");
		LOGGER.error("--Ltc Data--",ltcData);
		int result=ltcCommandService.addLtcAdvSettlement(ltcData);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "ADD LTC Direct Settlement")						//Swagger Annotation 
	@PostMapping("/ltcTxn-dir")
	public ResponseEntity<Integer> saveLtcDirSetDtls(@RequestBody LtcTxn ltcData){
		LOGGER.info("--Inside ADD LTC Direct Settlement --");
		LOGGER.error("--Ltc Data--",ltcData);
		int result=ltcCommandService.addLtcDirSettlement(ltcData);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "GET LTC LIST")						//Swagger Annotation 
	@GetMapping("/list/ltctxn/{empNo}/{advSetFlg}")
	public ResponseEntity<List<LtcTxn>> getAdvSetList(@PathVariable("empNo") Integer empNo ,@PathVariable ("advSetFlg") String advSetFlg){
		LOGGER.info("--Inside get Ltc List --");
		LOGGER.error("--List of ltc--",empNo);
		List<LtcTxn> list=ltcQueryService.getLtcList(empNo, advSetFlg);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "GET LTC ELIGIBLTY LIST")						//Swagger Annotation 
	@GetMapping("/list/ltc-eligiblity/{rankId}")
	public ResponseEntity<List<LtcEligiblty>> getLtcEligibltyList(@PathVariable("rankId") String rankId){
		LOGGER.info("--Inside get Ltc Eligiblty List --");
		LOGGER.error("--List of Ltc Eligiblty --",rankId);
		System.out.println(rankId);
		List<LtcEligiblty> list=ltcQueryService.getLtcEligibltyList(rankId);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET LTC ELIGIBLTY LIST")						//Swagger Annotation 
	@GetMapping("/list/ltc-eligiblity")
	public ResponseEntity<List<LtcEligiblty>> getLtcEligibltyMstList(){
		LOGGER.info("--Inside get Ltc Eligiblty List --");
		
		List<LtcEligiblty> list=ltcQueryService.getLtcEligibltyMstList();
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "ADD LTC Eligiblty Data")						//Swagger Annotation 
	@PostMapping("/ltc-eligiblity")
	public ResponseEntity<Boolean> addLtcEligiblty(@RequestBody LtcEligiblty ltcEligiblty){
		LOGGER.info("--Add GET LTC Eligiblty Data--");
		LOGGER.error("--ADD Ltc Eligiblty--",ltcEligiblty);
		boolean result=ltcCommandService.addLtcEligibltydata(ltcEligiblty);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "GET LTC ELIGIBLTY DATA BY LTC_NO")						//Swagger Annotation 
	@GetMapping("/ltc-eligiblity/{ltcNo}")
	public ResponseEntity<LtcEligiblty> getLtcEligibltyData(@PathVariable("ltcNo") Integer ltcNo){
		LOGGER.info("--Inside get Ltc Eligiblty data by ltcNO --");
		LOGGER.error("-- Ltc Eligiblty --",ltcNo);
		System.out.println(ltcNo);
		LtcEligiblty ltcELigiblty=ltcQueryService.getLtcEliDtlByLtcNo(ltcNo);
		System.out.println(ltcELigiblty);
		return new ResponseEntity<>(ltcELigiblty,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update LTC Eligiblty Data")						//Swagger Annotation 
	@PutMapping("/ltc-eligiblity")
	public ResponseEntity<Boolean> updateLtcEligiblty(@RequestBody LtcEligiblty ltcEligiblty){
		LOGGER.info("--Update LTC Eligiblty Data--");
		LOGGER.error("--Ltc Data--",ltcEligiblty);
		boolean result=ltcCommandService.updateLtcEligiblty(ltcEligiblty);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "DELETE LTC Eligiblty Data")						//Swagger Annotation 
	@DeleteMapping("/ltc-eligiblity/{ltcNo}")
	public ResponseEntity<Boolean> deleteLtcEligibltyData(@PathVariable("ltcNo") Integer ltcNo){
		LOGGER.info("--Delete LTC Eligiblty Data--");
		LOGGER.error("--Ltc Data--",ltcNo);
		boolean result=ltcCommandService.deleteLtcEligibltyData(ltcNo);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "Update LTC Approval Data")						//Swagger Annotation 
	@PutMapping("/ltcTxn/approve")
	public ResponseEntity<Boolean> updateLtcApproveData(@RequestBody LtcTxn ltcTxn){
		LOGGER.info("--Update LTC Approve Data--");
		LOGGER.error("--Ltc Data--",ltcTxn);
		boolean result=ltcCommandService.updateApproveAdvSet(ltcTxn);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	

	
	
	
	@ApiOperation(value = "GET LTC Employee Dependent Travel LIST")						//Swagger Annotation 
	@GetMapping("/LtcDepTravList/{ltcTxnId}")
	public ResponseEntity<List<LtcEmpDepTrv>> getLtcDepTravList(@PathVariable("ltcTxnId") Integer ltcTxnId){
		LOGGER.info("--LTC Employee Dependent Travel LIST --");
		LOGGER.error("--LTC Employee Dependent Travel LIST --",ltcTxnId);
		System.out.println(ltcTxnId);
		List<LtcEmpDepTrv> list=ltcQueryService.getLtcDepTravList(ltcTxnId);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "GET LTC Employee Travel  Data")						//Swagger Annotation 
	@GetMapping("/LtcEmpTravData/{ltcTxnId}")
	public ResponseEntity<LtcEmpTrv> getLtcEmpTrvData(@PathVariable("ltcTxnId") Integer ltcTxnId){
		LOGGER.info("--Inside get LTC Employee Travel  Data --");
		LOGGER.error("--List of LTC Employee Travel  Data --",ltcTxnId);
		System.out.println(ltcTxnId);
		LtcEmpTrv ltcEmpTrv=ltcQueryService.getEmpTravData(ltcTxnId);
		System.out.println(ltcEmpTrv);
		return new ResponseEntity<>(ltcEmpTrv,HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "Update LTC Application Data")						//Swagger Annotation 
	@PutMapping("/ltcTxn")
	public ResponseEntity<Boolean> updateLtcApp(@RequestBody LtcTxn ltcData){
		
		LOGGER.error("--Ltc Data--",ltcData);
		boolean result=ltcCommandService.updateLtcAppForCheck(ltcData);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "Add LTC Extension Data")						//Swagger Annotation 
	@PostMapping("/ltc-extension")
	public ResponseEntity<Boolean> addLtcExtensionData(@RequestBody LtcExtention ltcExt){
		
		LOGGER.error("--Ltc Data--",ltcExt);
		boolean result=ltcCommandService.addLtcExtentionData(ltcExt);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	
	@ApiOperation(value = "Update LTC Extension Data")						//Swagger Annotation 
	@PutMapping("/ltc-extension")
	public ResponseEntity<Boolean> updateLtcExtApproval(@RequestBody LtcExtention ltcExt){
		
		LOGGER.error("--Ltc Data--",ltcExt);
		boolean result=ltcCommandService.updateLtcExtApp(ltcExt);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	@ApiOperation(value = "GET LTC EXTENTION LIST")						//Swagger Annotation 
	@GetMapping("/list/ltc-extension/{empNo}")
	public ResponseEntity<List<LtcExtention>> getLtcExtentionList(@PathVariable("empNo") Integer empNo ){
		LOGGER.info("--Inside get Ltc Extention List --");
		LOGGER.error("--List of Ltc Extention --",empNo);
		System.out.println(empNo);
		List<LtcExtention> list=ltcQueryService.getLtcExtentionList(empNo);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "GET LTC Extention   Data")						//Swagger Annotation 
	@GetMapping("/ltc-extension/{ltcExtId}")
	public ResponseEntity<LtcExtention> getLtcExtentionData(@PathVariable("ltcExtId") Integer ltcExtId){
		LOGGER.info("--Inside get Ltc Extention data --");
		LOGGER.error("--Ltc Extention data --",ltcExtId);
		System.out.println(ltcExtId);
		LtcExtention ltcExt=ltcQueryService.getLtcExtentionData(ltcExtId);
		System.out.println(ltcExt);
		return new ResponseEntity<>(ltcExt,HttpStatus.OK);
	}
	
	

	@ApiOperation(value = "GET LTC Block Year List")						//Swagger Annotation 
	@GetMapping("/list/ltc-blockYear")
	public ResponseEntity<List<String>> getLtcBlockYearList(){
		LOGGER.info("--Inside GET LTC Block Year List --");
		
		List<String> list=ltcQueryService.getBlockYearList();
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET Travel List")						//Swagger Annotation 
	@GetMapping("/list/LtcTravelList/{flag}")
	public ResponseEntity<List<String>> getTravelList(@PathVariable("flag") Integer flag){
		LOGGER.info("--Inside get Travel List --");
		
		List<String> list=ltcQueryService.getTravelList( flag);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET Travel Mode List")						//Swagger Annotation 
	@GetMapping("/list/travel-mode")
	public ResponseEntity<List<String>> get_list_travel_mode(){
		LOGGER.info("--Inside get Travel Mode List --");
		
		List<String> list=ltcQueryService.getTravelModeList();
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET Travel  class List")						//Swagger Annotation 
	@GetMapping("/list/travel-class/{travelMode}")
	public ResponseEntity<List<String>> get_list_travel_class(@PathVariable("travelMode") String travelMode){
		LOGGER.info("--Inside get Travel Class List --");
		
		List<String> list=ltcQueryService.getTravelClassList(travelMode);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET Train type List")						//Swagger Annotation 
	@GetMapping("/list/train-type/{travelMode}")
	public ResponseEntity<List<String>> get_list_train_type(@PathVariable("travelMode") String travelMode){
		LOGGER.info("--Inside get Train Type  List --");
		
		List<String> list=ltcQueryService.getTrainTypeList(travelMode);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
