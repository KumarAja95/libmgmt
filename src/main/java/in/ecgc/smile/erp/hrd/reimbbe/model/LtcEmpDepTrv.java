package in.ecgc.smile.erp.hrd.reimbbe.model;


import java.math.BigDecimal;

import lombok.Data;

@Data
public class LtcEmpDepTrv {

     int ltcEmpDepTrvId;
	
	int ltcTxnId;
	
	int empNo;
	
	int dependentId;
	
	String nameOfDependent;
	
	String relation;
	
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
	
	char status;
	
	 int createdBy;
		
	String createdDate;
		
	int lastUpdateBy;
		
	String lastUpdateDate;
		
	String metaRemark;
}
