package in.ecgc.smile.erp.hrd.reimbbe.model;

public class TravelModeMst {

String trvlModId;
	
	String trvlMod;
	
	String status;
	
	String createdBy;
	
	String createdDt;
	
	String lastUpdatedBy;
	
	String lastUpdatedDt;
	
	String remark;

	public String getTrvlModId() {
		return trvlModId;
	}

	public void setTrvlModId(String trvlModId) {
		this.trvlModId = trvlModId;
	}

	public String getTrvlMod() {
		return trvlMod;
	}

	public void setTrvlMod(String trvlMod) {
		this.trvlMod = trvlMod;
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

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(String lastUpdatedDt) {
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
		return "TravelModeMst [trvlModId=" + trvlModId + ", trvlMod=" + trvlMod + ", status=" + status + ", createdBy="
				+ createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt="
				+ lastUpdatedDt + ", remark=" + remark + "]";
	}
	
	
}
