package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IndLodgBordingMst {

Integer lodBordId;
	
	String description;
	
	Integer rateOfDa;
	
	String status;
	
	String createdBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date createdDt;
	
	String lastUpdatedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date lastUpdatedDt;
	
	String remark;

	public Integer getLodBordId() {
		return lodBordId;
	}

	public void setLodBordId(Integer lodBordId) {
		this.lodBordId = lodBordId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRateOfDa() {
		return rateOfDa;
	}

	public void setRateOfDa(Integer rateOfDa) {
		this.rateOfDa = rateOfDa;
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
		return "IndLodgBordingMst [lodBordId=" + lodBordId + ", description=" + description + ", rateOfDa=" + rateOfDa
				+ ", status=" + status + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + ", remark=" + remark + "]";
	}
	
	
}
