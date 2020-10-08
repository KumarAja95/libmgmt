package in.ecgc.smile.erp.hrd.reimbbe.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;
import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;
import in.ecgc.smile.erp.hrd.reimbbe.service.DomesticTadaService;
import in.ecgc.smile.erp.hrd.reimbbe.service.IndForDaMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.IndLodgBordingMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.TravelModeMstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("hrd-tada")
@Api(value = "TADA Reimbursement Command BE Controller")//Swagger annotation
public class TadaReimbCommandRestController {

	/* Service */
	@Autowired
	private IndForDaMstService indForDaMstService;
	
	@Autowired
	private TravelModeMstService trvlModMstService;
	
	@Autowired
	private IndLodgBordingMstService lodgBoardingMstService;
	
	@Autowired
	private DomesticTadaService domTadaService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(TadaReimbCommandRestController.class);
	
	/* Save Domestic/Foreign da data Return boolean value (true/false) */
	@ApiOperation(value = "Save domestic/foreign da")						//Swagger Annotation 
	@PostMapping("/ind-for-da-mst")
	public ResponseEntity<Boolean> saveIndForDa(@RequestBody IndForDaMst indForDaMst,Locale locale, Model model) {

		LOGGER.info("--Inside save domestic/foreign da data--");
		boolean result = indForDaMstService.addIndForDa(indForDaMst);
	    return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	/* Update Domestic/Foreign da data Return boolean value (true/false) */
	@ApiOperation(value = "Update domestic/foreign da")						//Swagger Annotation 
	@PutMapping("/ind-for-da-mst")
	public ResponseEntity<Boolean> updateIndForDa(@RequestBody IndForDaMst indForDaMst,Locale locale, Model model) {

		LOGGER.info("--Inside Update domestic/foreign da data--");
		boolean result = indForDaMstService.modifyIndForDa(indForDaMst);
	    return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	/* Save travel mode data Return boolean value (true/false) */
	@ApiOperation(value = "Save travel mode")						//Swagger Annotation 
	@PostMapping("/trvl-mod-mst")
	public ResponseEntity<Boolean> saveTrvlMod(@RequestBody TravelModeMst trvlModMst,Locale locale, Model model) {

		LOGGER.info("--Inside save travel mode data--");
		boolean result = trvlModMstService.addTrvlMode(trvlModMst);
	    return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	/* Update travel mode data Return boolean value (true/false) */
	@ApiOperation(value = "Update travel mode")						//Swagger Annotation 
	@PutMapping("/trvl-mod-mst")
	public ResponseEntity<Boolean> updateTrvlMod(@RequestBody TravelModeMst trvlModMst,Locale locale, Model model) {

		LOGGER.info("--Inside update travel mode data--");
		boolean result = trvlModMstService.modifyTrvlMode(trvlModMst);
	    return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	/* Save lodging/boarding da data Return boolean value (true/false) */
	@ApiOperation(value = "Save lodging/boarding DA")						//Swagger Annotation 
	@PostMapping("/lodg-bord-da-mst")
	public ResponseEntity<Boolean> saveLodgBoardingDa(@RequestBody IndLodgBordingMst lodgBoardingMst,Locale locale, Model model) {

		LOGGER.info("--Inside save lodging/boarding data--");
		boolean result = lodgBoardingMstService.addLodgBoardingDa(lodgBoardingMst);
	    return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update lodging/boarding DA")						//Swagger Annotation
	@PutMapping("/lodg-bord-da-mst")
	public ResponseEntity<Boolean> updateLodgBoardingDa(@RequestBody IndLodgBordingMst lodgBoardingMst) {
		LOGGER.info("--Inside update lodging/boarding data--");
		boolean result = lodgBoardingMstService.modifyLodgBoardingDa(lodgBoardingMst);
	    return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	/* Save domestic tada advance data Return boolean value (true/false) */
	@ApiOperation(value = "Save Domestic tada advance")	
	@PostMapping("/domestic")
	public ResponseEntity<Boolean> saveDomesticTadaAdv(@RequestBody DomesticTada domTada, Locale locale, Model model) {
		LOGGER.info("--Inside save lodging/boarding data--");
		boolean result = domTadaService.addDomesticTadaAdv(domTada);
	    return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	/* Save domestic tada advance data Return boolean value (true/false) */
	@ApiOperation(value = "Save Domestic tada settlement")	
	@PostMapping("/domestic-set")
	public ResponseEntity<Boolean> saveDomesticTadaSet(@RequestBody DomesticTada domTada, Locale locale, Model model) {
		LOGGER.info("--Inside save domestic tada settlement--");
		boolean result = domTadaService.saveDomesticTadaSet(domTada);
	    return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
