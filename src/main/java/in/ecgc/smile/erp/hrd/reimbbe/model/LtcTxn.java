package in.ecgc.smile.erp.hrd.reimbbe.model;


import java.math.BigDecimal;
import java.util.List;


import lombok.Data;

@Data
public class LtcTxn {

	int ltcTxnId;
	
	int ltcNo;
	
	String ltcFlag;
	
	String status;
	
	int empNo;
	
	String applicationDt;
	
	String blockYear;
	
	String leaveApplied;
	
	String advSettleFlag;
	
	String placeOfTravel;
	
	String ltcType;
	
	String onwardDtOfJourney;
	
	BigDecimal onwardFare;
	
	String returnDtOfJourney;
	
	BigDecimal returnFare;
	
	BigDecimal totalFare;
	
	BigDecimal amountClamied;
	
	BigDecimal amountApproved;
	
	String approvalStatus;
	
    int approvedBy;
    
    String approvedDt;
    
    BigDecimal billAmt;
    
    BigDecimal settlementAmt;
    
    BigDecimal adjustedAmt;
    
    String description;
    
    String journeyFrm;
    
    String journeyTo;
    
    String adviceFlag;
    
    String travelDetail;
    
    String approvRemarks;
    
    int yearOfTravel;
    
    int createdBy;
	
	String createdDate;
	
	int lastUpdateBy;
	
	String lastUpdateDate;
	
	String metaRemark;
	
     LtcDependent depList;
     
     LtcEmpTrv empTrvData;

     
     List<LtcEmpDepTrv> ltcDepList;
}
