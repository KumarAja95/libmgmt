package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LtcEmpTrv {

	int ltcEmpTrvId;
	
	int ltcTxnId;
	
	int empNo;
	
	String depTravMode;
	
	String depTrainType;
	
	String depTravClass;
	
	BigDecimal depFareClaimed;
	
	BigDecimal depFareApprov;
	
     String arrTravMode;
	
	String arrTrainType;
	
	String arrTravClass;
	
	BigDecimal arrFareClaimed;
	
	BigDecimal arrFareApprov;
	
	String status;
	
	 int createdBy;
		
	String createdDate;
		
	int lastUpdateBy;
		
	String lastUpdateDate;
		
	String metaRemark;
	
}
