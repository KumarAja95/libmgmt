package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TadaTypeMst {

Integer tadaTypeId;
	
	String type;
	
	String subType;
	
	String status;
	
	String createdBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date createdDt;
	
	String lastUpdatedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date lastUpdatedDt;
}
