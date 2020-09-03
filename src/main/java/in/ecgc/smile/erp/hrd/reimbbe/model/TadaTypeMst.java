package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

	public Integer getTadaTypeId() {
		return tadaTypeId;
	}

	public void setTadaTypeId(Integer tadaTypeId) {
		this.tadaTypeId = tadaTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	@Override
	public String toString() {
		return "TadaTypeMst [tadaTypeId=" + tadaTypeId + ", type=" + type + ", subType=" + subType + ", status="
				+ status + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdatedDt=" + lastUpdatedDt + "]";
	}
	
	
}
