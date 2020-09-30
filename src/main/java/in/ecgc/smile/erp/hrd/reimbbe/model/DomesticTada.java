package in.ecgc.smile.erp.hrd.reimbbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DomesticTada {

	/* primary key */ 
	Integer indTourId;
	
	/* Advance settlement flag */
	String advSettleFlg;
	
	Integer empNo;
	
	/* Purpose of tour */
	String purpose;
	
	/* Tour Type */
	String tourType;
	
	/* Departure date from office/home */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date depDt;
	
	/* Departure travel mode */
	String depTrvlMode;
	
	/* Departure train type */
	String depTrainType;
	
	/* Departure travel Class */
	String depTrvlClss;
	
	/* Arrival date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date arrDt;
	
	/* Return departure travel mode (arrival travel mode) */
	String retDepTrvlMode;
	
	/* Return departure train type (arrival train type) */
	String retDepTrainType;
	
	/* Return departure travel class (arrival travel class) */
	String retDepTrvlClss;
	
	/* Departure fare */
	double depFare;
	
	/* total=dep_fare+arr_fare+tot_da+conveyance_exp+hotel_exp+hotel_tax+other_exp 
	 * insert this total amount into total_expenses*/
	double total;
	
	/* Claimed Amount */
	double amtClaimed;
	
	/* Approved Amount */
	double amtApproved;
	
	/* Return fare (store data in arr_fare) */
	double retDepFare;
	
	/* This is only for UI purpose */
	double totFare;
	
	/* this is for UI Only not insert this data into table*/
	double totExpenses;
	
	/* Working days (total days) */
	Integer daysPeriod;
	
	/* Actual working days */
	Integer actualWorkingDays;
	
	/* City Name */
	String city;
	
	/* Adjusted Amount */
	double amtAdjusted;
	
	/* Debit credit */
	String debitCredit;
	
	/* Application Date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date applicationDt;
	
	/* Other Expenses */
	double otherExpenses;
	
	/* Advice Flag */
	String adviceFlg;
	
	/* Total Da */
	double totDa;
	
	/* EligibleDa Amount (At the time of advance 80% of total da) */
	double eligibleDa;
	
	/* Conveyance Expenses */
	double conveyanceExp;
	
	/* Hotel Expenses */
	double hotelExp;
	
	/* Hotel Tax */
	double hotelTax;
	
	/* City class for DA */
	String cityClassDa;
	
	/* City category for hotel amt */
	String cityClassHotel;
	
	/* Departure fare approved */
	double depFareAppr;
	
	/* Return fare (store data in arr_fare_appr) */
	double retDepFareAppr;
	
	/* Other Expenses approved */
	double  othExpAppr;
	
	/* Conveyance Expenses approved */
	double conveyanceExpAppr;
	
	/* Total DA Approved */
	double totDaAppr;
	
	/* Hotel expenses approved */
	double hotelExpAppr;
	
	/* Hotel tax approved */
	double hotelTaxAppr;
	
	/* Total other expenses approved (othExpAppr+totDaAppr+conveyanceExpAppr+hotelExpAppr+hotelTaxAppr) */
	double totOthExpAppr;
	
	/* Total approved amount (totOtherExpAppr+depFareAppr+retDepFareAppr) */
	double totalAppr;
	
	/* Actual departure time from office/Home(act_dep_to_time) */
	String depTime;
	
	/* Departure from terminal Date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date depTmDate;
	
	/* Departure from terminal time */
	String depTmTime;
	
	/* Arrival terminal time */
	String arrTmTime;
	
	/* Arrival At terminal Date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date arrTmDate;
	
	/* Arrival time */
	String arrTime;
	
	/* office Accommodation (true/false) */
	boolean officeAccommodation;
	
	/* Boarding and lodging both */
	String boardingLodging;
	
	/* Only boarding */
	String boarding;
	
	/* Only lodging */
	String lodging;
	
	/* Return departure terminal time */
	String retDepTmTime;
	
	/* Return departure terminal date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date retDepTmDate;
	
	/* Return Arrival at terminal time */
	String retArrTmTime;
	
	/* Return arrival at terminal date */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date retArrTmDate;

	public Integer getIndTourId() {
		return indTourId;
	}

	public void setIndTourId(Integer indTourId) {
		this.indTourId = indTourId;
	}

	public String getAdvSettleFlg() {
		return advSettleFlg;
	}

	public void setAdvSettleFlg(String advSettleFlg) {
		this.advSettleFlg = advSettleFlg;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public Date getDepDt() {
		return depDt;
	}

	public void setDepDt(Date depDt) {
		this.depDt = depDt;
	}

	public String getDepTrvlMode() {
		return depTrvlMode;
	}

	public void setDepTrvlMode(String depTrvlMode) {
		this.depTrvlMode = depTrvlMode;
	}

	public String getDepTrainType() {
		return depTrainType;
	}

	public void setDepTrainType(String depTrainType) {
		this.depTrainType = depTrainType;
	}

	public String getDepTrvlClss() {
		return depTrvlClss;
	}

	public void setDepTrvlClss(String depTrvlClss) {
		this.depTrvlClss = depTrvlClss;
	}

	public Date getArrDt() {
		return arrDt;
	}

	public void setArrDt(Date arrDt) {
		this.arrDt = arrDt;
	}

	public String getRetDepTrvlMode() {
		return retDepTrvlMode;
	}

	public void setRetDepTrvlMode(String retDepTrvlMode) {
		this.retDepTrvlMode = retDepTrvlMode;
	}

	public String getRetDepTrainType() {
		return retDepTrainType;
	}

	public void setRetDepTrainType(String retDepTrainType) {
		this.retDepTrainType = retDepTrainType;
	}

	public String getRetDepTrvlClss() {
		return retDepTrvlClss;
	}

	public void setRetDepTrvlClss(String retDepTrvlClss) {
		this.retDepTrvlClss = retDepTrvlClss;
	}

	public double getDepFare() {
		return depFare;
	}

	public void setDepFare(double depFare) {
		this.depFare = depFare;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getAmtClaimed() {
		return amtClaimed;
	}

	public void setAmtClaimed(double amtClaimed) {
		this.amtClaimed = amtClaimed;
	}

	public double getAmtApproved() {
		return amtApproved;
	}

	public void setAmtApproved(double amtApproved) {
		this.amtApproved = amtApproved;
	}

	public double getRetDepFare() {
		return retDepFare;
	}

	public void setRetDepFare(double retDepFare) {
		this.retDepFare = retDepFare;
	}

	public double getTotFare() {
		return totFare;
	}

	public void setTotFare(double totFare) {
		this.totFare = totFare;
	}

	public double getTotExpenses() {
		return totExpenses;
	}

	public void setTotExpenses(double totExpenses) {
		this.totExpenses = totExpenses;
	}

	public Integer getDaysPeriod() {
		return daysPeriod;
	}

	public void setDaysPeriod(Integer daysPeriod) {
		this.daysPeriod = daysPeriod;
	}

	public Integer getActualWorkingDays() {
		return actualWorkingDays;
	}

	public void setActualWorkingDays(Integer actualWorkingDays) {
		this.actualWorkingDays = actualWorkingDays;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAmtAdjusted() {
		return amtAdjusted;
	}

	public void setAmtAdjusted(double amtAdjusted) {
		this.amtAdjusted = amtAdjusted;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public Date getApplicationDt() {
		return applicationDt;
	}

	public void setApplicationDt(Date applicationDt) {
		this.applicationDt = applicationDt;
	}

	public double getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(double otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public String getAdviceFlg() {
		return adviceFlg;
	}

	public void setAdviceFlg(String adviceFlg) {
		this.adviceFlg = adviceFlg;
	}

	public double getTotDa() {
		return totDa;
	}

	public void setTotDa(double totDa) {
		this.totDa = totDa;
	}

	public double getEligibleDa() {
		return eligibleDa;
	}

	public void setEligibleDa(double eligibleDa) {
		this.eligibleDa = eligibleDa;
	}

	public double getConveyanceExp() {
		return conveyanceExp;
	}

	public void setConveyanceExp(double conveyanceExp) {
		this.conveyanceExp = conveyanceExp;
	}

	public double getHotelExp() {
		return hotelExp;
	}

	public void setHotelExp(double hotelExp) {
		this.hotelExp = hotelExp;
	}

	public double getHotelTax() {
		return hotelTax;
	}

	public void setHotelTax(double hotelTax) {
		this.hotelTax = hotelTax;
	}

	public String getCityClassDa() {
		return cityClassDa;
	}

	public void setCityClassDa(String cityClassDa) {
		this.cityClassDa = cityClassDa;
	}

	public String getCityClassHotel() {
		return cityClassHotel;
	}

	public void setCityClassHotel(String cityClassHotel) {
		this.cityClassHotel = cityClassHotel;
	}

	public double getDepFareAppr() {
		return depFareAppr;
	}

	public void setDepFareAppr(double depFareAppr) {
		this.depFareAppr = depFareAppr;
	}

	public double getRetDepFareAppr() {
		return retDepFareAppr;
	}

	public void setRetDepFareAppr(double retDepFareAppr) {
		this.retDepFareAppr = retDepFareAppr;
	}

	public double getOthExpAppr() {
		return othExpAppr;
	}

	public void setOthExpAppr(double othExpAppr) {
		this.othExpAppr = othExpAppr;
	}

	public double getConveyanceExpAppr() {
		return conveyanceExpAppr;
	}

	public void setConveyanceExpAppr(double conveyanceExpAppr) {
		this.conveyanceExpAppr = conveyanceExpAppr;
	}

	public double getTotDaAppr() {
		return totDaAppr;
	}

	public void setTotDaAppr(double totDaAppr) {
		this.totDaAppr = totDaAppr;
	}

	public double getHotelExpAppr() {
		return hotelExpAppr;
	}

	public void setHotelExpAppr(double hotelExpAppr) {
		this.hotelExpAppr = hotelExpAppr;
	}

	public double getHotelTaxAppr() {
		return hotelTaxAppr;
	}

	public void setHotelTaxAppr(double hotelTaxAppr) {
		this.hotelTaxAppr = hotelTaxAppr;
	}

	public double getTotOthExpAppr() {
		return totOthExpAppr;
	}

	public void setTotOthExpAppr(double totOthExpAppr) {
		this.totOthExpAppr = totOthExpAppr;
	}

	public double getTotalAppr() {
		return totalAppr;
	}

	public void setTotalAppr(double totalAppr) {
		this.totalAppr = totalAppr;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public Date getDepTmDate() {
		return depTmDate;
	}

	public void setDepTmDate(Date depTmDate) {
		this.depTmDate = depTmDate;
	}

	public String getDepTmTime() {
		return depTmTime;
	}

	public void setDepTmTime(String depTmTime) {
		this.depTmTime = depTmTime;
	}

	public String getArrTmTime() {
		return arrTmTime;
	}

	public void setArrTmTime(String arrTmTime) {
		this.arrTmTime = arrTmTime;
	}

	public Date getArrTmDate() {
		return arrTmDate;
	}

	public void setArrTmDate(Date arrTmDate) {
		this.arrTmDate = arrTmDate;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public boolean isOfficeAccommodation() {
		return officeAccommodation;
	}

	public void setOfficeAccommodation(boolean officeAccommodation) {
		this.officeAccommodation = officeAccommodation;
	}

	public String getBoardingLodging() {
		return boardingLodging;
	}

	public void setBoardingLodging(String boardingLodging) {
		this.boardingLodging = boardingLodging;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getLodging() {
		return lodging;
	}

	public void setLodging(String lodging) {
		this.lodging = lodging;
	}

	public String getRetDepTmTime() {
		return retDepTmTime;
	}

	public void setRetDepTmTime(String retDepTmTime) {
		this.retDepTmTime = retDepTmTime;
	}

	public Date getRetDepTmDate() {
		return retDepTmDate;
	}

	public void setRetDepTmDate(Date retDepTmDate) {
		this.retDepTmDate = retDepTmDate;
	}

	public String getRetArrTmTime() {
		return retArrTmTime;
	}

	public void setRetArrTmTime(String retArrTmTime) {
		this.retArrTmTime = retArrTmTime;
	}

	public Date getRetArrTmDate() {
		return retArrTmDate;
	}

	public void setRetArrTmDate(Date retArrTmDate) {
		this.retArrTmDate = retArrTmDate;
	}

	@Override
	public String toString() {
		return "DomesticTada [indTourId=" + indTourId + ", advSettleFlg=" + advSettleFlg + ", empNo=" + empNo
				+ ", purpose=" + purpose + ", tourType=" + tourType + ", depDt=" + depDt + ", depTrvlMode="
				+ depTrvlMode + ", depTrainType=" + depTrainType + ", depTrvlClss=" + depTrvlClss + ", arrDt=" + arrDt
				+ ", retDepTrvlMode=" + retDepTrvlMode + ", retDepTrainType=" + retDepTrainType + ", retDepTrvlClss="
				+ retDepTrvlClss + ", depFare=" + depFare + ", total=" + total + ", amtClaimed=" + amtClaimed
				+ ", amtApproved=" + amtApproved + ", retDepFare=" + retDepFare + ", totFare=" + totFare
				+ ", totExpenses=" + totExpenses + ", daysPeriod=" + daysPeriod + ", actualWorkingDays="
				+ actualWorkingDays + ", city=" + city + ", amtAdjusted=" + amtAdjusted + ", debitCredit=" + debitCredit
				+ ", applicationDt=" + applicationDt + ", otherExpenses=" + otherExpenses + ", adviceFlg=" + adviceFlg
				+ ", totDa=" + totDa + ", eligibleDa=" + eligibleDa + ", conveyanceExp=" + conveyanceExp + ", hotelExp="
				+ hotelExp + ", hotelTax=" + hotelTax + ", cityClassDa=" + cityClassDa + ", cityClassHotel="
				+ cityClassHotel + ", depFareAppr=" + depFareAppr + ", retDepFareAppr=" + retDepFareAppr
				+ ", othExpAppr=" + othExpAppr + ", conveyanceExpAppr=" + conveyanceExpAppr + ", totDaAppr=" + totDaAppr
				+ ", hotelExpAppr=" + hotelExpAppr + ", hotelTaxAppr=" + hotelTaxAppr + ", totOthExpAppr="
				+ totOthExpAppr + ", totalAppr=" + totalAppr + ", depTime=" + depTime + ", depTmDate=" + depTmDate
				+ ", depTmTime=" + depTmTime + ", arrTmTime=" + arrTmTime + ", arrTmDate=" + arrTmDate + ", arrTime="
				+ arrTime + ", officeAccommodation=" + officeAccommodation + ", boardingLodging=" + boardingLodging
				+ ", boarding=" + boarding + ", lodging=" + lodging + ", retDepTmTime=" + retDepTmTime
				+ ", retDepTmDate=" + retDepTmDate + ", retArrTmTime=" + retArrTmTime + ", retArrTmDate=" + retArrTmDate
				+ "]";
	}
	
	
}
