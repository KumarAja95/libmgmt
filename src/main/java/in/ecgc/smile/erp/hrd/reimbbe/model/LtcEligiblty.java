package in.ecgc.smile.erp.hrd.reimbbe.model;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LtcEligiblty {

	int ltcNo;
	
	String description;
	
	String rankId;
	
	String travelMode;
	
	String travelClass;
	
	String trainType;
	
	@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date effectiveDt;
	
	char status;
	
	 int createdBy;
		
	String createdDate;
		
	int lastUpdateBy;
		
	String lastUpdateDate;
		
	String metaRemark;
}
