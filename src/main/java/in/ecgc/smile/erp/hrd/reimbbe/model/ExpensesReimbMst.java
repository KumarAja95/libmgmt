package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.math.BigDecimal;


public class ExpensesReimbMst {
	
	int expEligId;
	
	int rankCd;
	
	String processCd;
	
	String financialYear;
	
	BigDecimal eligiAmt;
	
	String status;
	
	int createdBy;
	
	String createdDt;
	
	int lastUpdateBy;
	
	String lastUpdateDt;
	
	String metaRemark;

	public int getExpEligId() {
		return expEligId;
	}

	public void setExpEligId(int expEligId) {
		this.expEligId = expEligId;
	}

	public int getRankCd() {
		return rankCd;
	}

	public void setRankCd(int rankCd) {
		this.rankCd = rankCd;
	}

	public String getProcessCd() {
		return processCd;
	}

	public void setProcessCd(String processCd) {
		this.processCd = processCd;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getEligiAmt() {
		return eligiAmt;
	}

	public void setEligiAmt(BigDecimal eligiAmt) {
		this.eligiAmt = eligiAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public int getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(int lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdateDt() {
		return lastUpdateDt;
	}

	public void setLastUpdateDt(String lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public String getMetaRemark() {
		return metaRemark;
	}

	public void setMetaRemark(String metaRemark) {
		this.metaRemark = metaRemark;
	}
	

}
