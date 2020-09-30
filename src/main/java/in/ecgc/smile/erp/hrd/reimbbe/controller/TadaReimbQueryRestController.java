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

import in.ecgc.smile.erp.hrd.reimbbe.model.CityClassMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;
import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.TadaCityMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;
import in.ecgc.smile.erp.hrd.reimbbe.service.CityClassMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.DomesticTadaService;
import in.ecgc.smile.erp.hrd.reimbbe.service.IndForDaMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.IndLodgBordingMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.TadaCityMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.TadaTypeMstService;
import in.ecgc.smile.erp.hrd.reimbbe.service.TravelModeMstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("hrd-tada")
@Api(value = "TADA Reimbursement Query BE Controller")//Swagger annotation
public class TadaReimbQueryRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TadaReimbQueryRestController.class);
	
	@Autowired
	private TadaTypeMstService tadaTypeMstService;
	
	@Autowired
	private IndForDaMstService indForDaMstService;
	
	@Autowired
	private TravelModeMstService trvlModMstService;
	
	@Autowired
	private CityClassMstService cityClsMstService;
	
	@Autowired 
	private TadaCityMstService tadaCityMstService;
	
	@Autowired
	private IndLodgBordingMstService indLodBordMstService;
	
	@Autowired
	private DomesticTadaService domTadaService;
	
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
	
	@ApiOperation(value = "View a list of all domestic/foreign da", response = List.class)
	@GetMapping("/ind-for-da-mst")
	public ResponseEntity<List<IndForDaMst>> getAllIndForDa(){
		LOGGER.info("Fetching all domestic/foreign da from master");
		List<IndForDaMst> indForDaList = indForDaMstService.viewAllIndForDa();
		return new ResponseEntity<>(indForDaList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of all travel mode from master", response = List.class)
	@GetMapping("/trvl-mod-mst")
	public ResponseEntity<List<TravelModeMst>> getAllTrvlMode(){
		LOGGER.info("Fetching all travel mode from master");
		List<TravelModeMst> trvlModList = trvlModMstService.viewAllTrvlMode();
		return new ResponseEntity<>(trvlModList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of active travel mode from master", response = List.class)
	@GetMapping("/active/trvl-mod-mst")
	public ResponseEntity<List<TravelModeMst>> getActiveTrvlMode(){
		LOGGER.info("Fetching active travel mode from master");
		List<TravelModeMst> trvlModList = trvlModMstService.viewActiveTrvlMode();
		return new ResponseEntity<>(trvlModList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of city class from master", response = List.class)
	@GetMapping("/city-class-mst")
	public ResponseEntity<List<CityClassMst>> getAllCityAndClass(){
		LOGGER.info("Fetching city class from master");
		List<CityClassMst> cityClassList = cityClsMstService.viewAllCityAndClass();
		return new ResponseEntity<>(cityClassList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a tada city da hotel amount from master", response = List.class)
	@GetMapping("/city-da-hotel-mst/{rankId}/{cityClsDa}/{cityClsHotel}")
	public ResponseEntity<TadaCityMst> getTadaCityDaHotelAmt(@PathVariable("rankId") String rankId, 
			@PathVariable("cityClsDa") String cityClsDa, @PathVariable("cityClsHotel") String cityClsHotel){
		LOGGER.info("Fetching tada city da hotel amount from master");
		TadaCityMst tadaCity = tadaCityMstService.viewTadaCityDaHotelAmt(rankId, cityClsDa, cityClsHotel);
		return new ResponseEntity<>(tadaCity, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of domestic/foreign da based on type", response = List.class)
	@GetMapping("/ind-for-da-mst/{type}")
	public ResponseEntity<List<IndForDaMst>> getIndForDa(@PathVariable("type") String type){
		LOGGER.info("Fetching domestic/foreign da based on type from master");
		List<IndForDaMst> indForDaList = indForDaMstService.viewIndForDa(type);
		return new ResponseEntity<>(indForDaList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of all lodging/boarding da from master", response = List.class)
	@GetMapping("/lodg-bord-da-mst")
	public ResponseEntity<List<IndLodgBordingMst>> getAllLodgBordingDa(){
		LOGGER.info("Fetching all lodging/boarding da from master");
		List<IndLodgBordingMst> lodgBordDaList = indLodBordMstService.viewAllLodgBordingDa();
		return new ResponseEntity<>(lodgBordDaList, HttpStatus.OK);
	}
	
	@GetMapping("/active/lodg-bord-da-mst")
	public ResponseEntity<List<IndLodgBordingMst>> getActiveLodgBordingDa() {
		LOGGER.info("Fetching active lodging/boarding da from master");
		List<IndLodgBordingMst> lodgBordDaList = indLodBordMstService.viewActiveLodgBordingDa();
		return new ResponseEntity<>(lodgBordDaList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View pending domestic advance")
	@GetMapping("/domestic-adv/{empNo}")
	public ResponseEntity<List<DomesticTada>> getDomesticAdvListForSet(@PathVariable("empNo") int empNo){
		LOGGER.info("Fetching pending domestic advance application");
		List<DomesticTada> domAdvList = domTadaService.domesticAdvListForSet(empNo);
		return new ResponseEntity<>(domAdvList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View pending domestic advance by indTourId")
	@GetMapping("/domestic-advid/{indTourId}")
	public ResponseEntity<DomesticTada> getDomesticAdvForSet(@PathVariable("indTourId") int indTourId) {
		LOGGER.info("Fetching pending domestic advance application");
		DomesticTada domAdvList = domTadaService.domesticAdvForSet(indTourId);
		return new ResponseEntity<>(domAdvList, HttpStatus.OK);
	}
}
