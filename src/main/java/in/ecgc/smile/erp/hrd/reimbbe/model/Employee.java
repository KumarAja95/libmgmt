package in.ecgc.smile.erp.hrd.reimbbe.model;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


/**
 *Employee Model class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
public class Employee {


	
	/* Employee Id which is used for Employee reference */
	Integer empNo;
	
	String prefix;
	
	/* Employee First Name*/
	@Pattern(regexp="^[A-Za-z]+$", message="Enter Valid First Name")  
	String firstName;
	
	/* Employee Middle Name*/
	String midName;
	
	/* Employee Last Name*/
	@Pattern(regexp="^[A-Za-z]+$", message="Enter Valid Last Name")
	String lastName;
	
	String empAlias;
	
	String gender;
	
	String birthPlace;
	
	String nationality;
	
	/* Employee DOB*/
	//@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date dob;
	
	/* Employee Confirmation date */
	//@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date confDate;
	
	/* Employee Date of joining*/
	//@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date doj;
	
	/* Employee Type*/
	String empType;
	
	/* Employee designation*/
	/* String designation; */

	/* Employee Location */
	@NotBlank(message="Please provide Location")
	String logicalLocCd;
	
	/* Employee office branch code */
	@NotBlank(message="Please Select Employee Branch Code")
	String branchCode;
	
	/* Employee office region code */
	@NotBlank(message="Please Select Employee Region Code")
	String regionCode;
	
	/* Employee rank */
	@NotBlank(message="Please Select Employee Rank")
	String rankId;
	
	/* Employee Designation */
	//@NotBlank(message="Please Select Employee Designation")
	String desigId;
	
	/* Employee category */
	@NotBlank(message="Please Select Employee Categoty")
	String categoryCd;
	
	/* Employee religion */
	String religion;
	
	/* Employee handicap flag */
	@NotBlank(message="Please Select Employee Handicap Field  ")
	String handicapFlg;
	
	/* Employee disability percentage */
	long disabilityPerc;
	
	/* Employee handicap description */
	String handicapDesc;
	
	
	/* Employee Status */
	String statusCd;
	
	String divCd;
	
	String deptCd;
	
	String sectorCd;
	
	Integer reportingTo;
	
	/* Salary Details */
	Double prsntBasicSal;
	
	String salPayMode;
	
	Double fixedDa;
	
	Double persAllowance;
	
	String createdBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date createdDt;
	
	String lastUpdatedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date lastUpdatedDt;

	

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpAlias() {
		return empAlias;
	}

	public void setEmpAlias(String empAlias) {
		this.empAlias = empAlias;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getConfDate() {
		return confDate;
	}

	public void setConfDate(Date confDate) {
		this.confDate = confDate;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getLogicalLocCd() {
		return logicalLocCd;
	}

	public void setLogicalLocCd(String logicalLocCd) {
		this.logicalLocCd = logicalLocCd;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRankId() {
		return rankId;
	}

	public void setRankId(String rankId) {
		this.rankId = rankId;
	}

	public String getDesigId() {
		return desigId;
	}

	public void setDesigId(String desigId) {
		this.desigId = desigId;
	}

	public String getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(String categoryCd) {
		this.categoryCd = categoryCd;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getHandicapFlg() {
		return handicapFlg;
	}

	public void setHandicapFlg(String handicapFlg) {
		this.handicapFlg = handicapFlg;
	}

	public long getDisabilityPerc() {
		return disabilityPerc;
	}

	public void setDisabilityPerc(long disabilityPerc) {
		this.disabilityPerc = disabilityPerc;
	}

	public String getHandicapDesc() {
		return handicapDesc;
	}

	public void setHandicapDesc(String handicapDesc) {
		this.handicapDesc = handicapDesc;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getDivCd() {
		return divCd;
	}

	public void setDivCd(String divCd) {
		this.divCd = divCd;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getSectorCd() {
		return sectorCd;
	}

	public void setSectorCd(String sectorCd) {
		this.sectorCd = sectorCd;
	}

	public Integer getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(Integer reportingTo) {
		this.reportingTo = reportingTo;
	}

	public Double getPrsntBasicSal() {
		return prsntBasicSal;
	}

	public void setPrsntBasicSal(Double prsntBasicSal) {
		this.prsntBasicSal = prsntBasicSal;
	}

	public String getSalPayMode() {
		return salPayMode;
	}

	public void setSalPayMode(String salPayMode) {
		this.salPayMode = salPayMode;
	}

	public Double getFixedDa() {
		return fixedDa;
	}

	public void setFixedDa(Double fixedDa) {
		this.fixedDa = fixedDa;
	}

	public Double getPersAllowance() {
		return persAllowance;
	}

	public void setPersAllowance(Double persAllowance) {
		this.persAllowance = persAllowance;
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
		return "Employee [ empNo=" + empNo + ", prefix=" + prefix + ", firstName="
				+ firstName + ", midName=" + midName + ", lastName=" + lastName + ", empAlias=" + empAlias + ", gender="
				+ gender + ", birthPlace=" + birthPlace + ", nationality=" + nationality + ", dob=" + dob
				+ ", confDate=" + confDate + ", doj=" + doj + ", empType=" + empType + ", logicalLocCd=" + logicalLocCd
				+ ", branchCode=" + branchCode + ", regionCode=" + regionCode + ", rankId=" + rankId + ", desigId="
				+ desigId + ", categoryCd=" + categoryCd + ", religion=" + religion + ", handicapFlg=" + handicapFlg
				+ ", disabilityPerc=" + disabilityPerc + ", handicapDesc=" + handicapDesc + ", statusCd=" + statusCd
				+ ", divCd=" + divCd + ", deptCd=" + deptCd + ", sectorCd=" + sectorCd + ", reportingTo=" + reportingTo
				+ ", prsntBasicSal=" + prsntBasicSal + ", salPayMode=" + salPayMode + ", fixedDa=" + fixedDa
				+ ", persAllowance=" + persAllowance + ", createdBy=" + createdBy + ", createdDt=" + createdDt
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + "]";
	}

}
