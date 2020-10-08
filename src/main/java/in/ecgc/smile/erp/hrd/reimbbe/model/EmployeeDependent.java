package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeDependent {

	Integer empNo;
	
	Integer dependentId;
	
	String processName;
	
	String dependentName;
	
	String relation;
	
	Integer dependentAge;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date dob;
	
	String maritalStatus;
	
	String address;
	
	String address1;
	
	String address2;
	
	String address3;
	
	String address4;
	
	String city;
	
	String state;
	
	String country;
	
	Long pinCode;
	
	Long mobNo;
	
	Boolean studentFlag;
	
	String nameOfInstitute;
	
	Boolean employedFlg;
	
	String employerName;
	
	String employerAddress;
	
	String employerType;
	
	String sourceOfIncome;
	
	Boolean propertyFlg;
	
	String typeOfProperty;
	
	Double valueOfProperty;
	
	Boolean pensionHolderFlg;
	
	Double amountOfPension;
	
	String dependentTypeId;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getDependentId() {
		return dependentId;
	}

	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public Integer getDependentAge() {
		return dependentAge;
	}

	public void setDependentAge(Integer dependentAge) {
		this.dependentAge = dependentAge;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}

	public Boolean getStudentFlag() {
		return studentFlag;
	}

	public void setStudentFlag(Boolean studentFlag) {
		this.studentFlag = studentFlag;
	}

	public String getNameOfInstitute() {
		return nameOfInstitute;
	}

	public void setNameOfInstitute(String nameOfInstitute) {
		this.nameOfInstitute = nameOfInstitute;
	}

	public Boolean getEmployedFlg() {
		return employedFlg;
	}

	public void setEmployedFlg(Boolean employedFlg) {
		this.employedFlg = employedFlg;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}

	public String getEmployerType() {
		return employerType;
	}

	public void setEmployerType(String employerType) {
		this.employerType = employerType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public Boolean getPropertyFlg() {
		return propertyFlg;
	}

	public void setPropertyFlg(Boolean propertyFlg) {
		this.propertyFlg = propertyFlg;
	}

	public String getTypeOfProperty() {
		return typeOfProperty;
	}

	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

	public Double getValueOfProperty() {
		return valueOfProperty;
	}

	public void setValueOfProperty(Double valueOfProperty) {
		this.valueOfProperty = valueOfProperty;
	}

	public Boolean getPensionHolderFlg() {
		return pensionHolderFlg;
	}

	public void setPensionHolderFlg(Boolean pensionHolderFlg) {
		this.pensionHolderFlg = pensionHolderFlg;
	}

	public Double getAmountOfPension() {
		return amountOfPension;
	}

	public void setAmountOfPension(Double amountOfPension) {
		this.amountOfPension = amountOfPension;
	}

	public String getDependentTypeId() {
		return dependentTypeId;
	}

	public void setDependentTypeId(String dependentTypeId) {
		this.dependentTypeId = dependentTypeId;
	}

	@Override
	public String toString() {
		return "EmployeeDependent [empNo=" + empNo + ", dependentId=" + dependentId + ", processName=" + processName
				+ ", dependentName=" + dependentName + ", relation=" + relation + ", dob=" + dob + ", maritalStatus="
				+ maritalStatus + ", address=" + address + ", address1=" + address1 + ", address2=" + address2
				+ ", address3=" + address3 + ", address4=" + address4 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pinCode=" + pinCode + ", mobNo=" + mobNo + ", studentFlag=" + studentFlag
				+ ", nameOfInstitute=" + nameOfInstitute + ", employedFlg=" + employedFlg + ", employerName="
				+ employerName + ", employerAddress=" + employerAddress + ", employerType=" + employerType
				+ ", sourceOfIncome=" + sourceOfIncome + ", propertyFlg=" + propertyFlg + ", typeOfProperty="
				+ typeOfProperty + ", valueOfProperty=" + valueOfProperty + ", pensionHolderFlg=" + pensionHolderFlg
				+ ", amountOfPension=" + amountOfPension + ", dependentTypeId=" + dependentTypeId + "]";
	}
	
}

