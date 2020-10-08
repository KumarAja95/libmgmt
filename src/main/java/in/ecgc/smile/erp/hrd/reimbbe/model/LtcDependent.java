package in.ecgc.smile.erp.hrd.reimbbe.model;


import java.math.BigDecimal;
import java.util.List;

import lombok.Data;


@Data
public class LtcDependent {
	
	List<Integer> dependentId;
	
    List<String> nameOfDependent;
	
	List<String> relation;
	
	List<String> depTravMode;
	
	List<String> depTrainType;
	
	List<String> depTravClass;
	
	List<BigDecimal> depFareClaimed;
	
	List<BigDecimal> depFareApprov;
	
     List<String> arrTravMode;
	
	List<String> arrTrainType;
	
	List<String> arrTravClass;
	
	List<BigDecimal> arrFareClaimed;
	
	List<BigDecimal> arrFareApprov;
	


}
