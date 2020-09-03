package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IndForDaMst {

	Integer indForDaId;
	
	Integer minHour;
	
	Integer maxHour;
	
	Integer rateOfDa;
	
	String type;
	
	String status;
	
	String createdBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date createdDt;
	
	String lastUpdatedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date lastUpdatedDt;
	
	String remark;

	public Integer getIndForDaId() {
		return indForDaId;
	}

	public void setIndForDaId(Integer indForDaId) {
		this.indForDaId = indForDaId;
	}

	public Integer getMinHour() {
		return minHour;
	}

	public void setMinHour(Integer minHour) {
		this.minHour = minHour;
	}

	public Integer getMaxHour() {
		return maxHour;
	}

	public void setMaxHour(Integer maxHour) {
		this.maxHour = maxHour;
	}

	public Integer getRateOfDa() {
		return rateOfDa;
	}

	public void setRateOfDa(Integer rateOfDa) {
		this.rateOfDa = rateOfDa;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "IndForDaMst [indForDaId=" + indForDaId + ", minHour=" + minHour + ", maxHour=" + maxHour + ", rateOfDa="
				+ rateOfDa + ", type=" + type + ", status=" + status + ", createdBy=" + createdBy + ", createdDt="
				+ createdDt + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + ", remark="
				+ remark + "]";
	}
	
	
}
