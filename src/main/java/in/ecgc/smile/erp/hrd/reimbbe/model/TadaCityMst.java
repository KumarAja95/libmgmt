package in.ecgc.smile.erp.hrd.reimbbe.model;

public class TadaCityMst {

	Integer cityId;
	
	String rankId;
	
	String cityClsDa;
	
	String cityClsHotel;
	
	Integer daAmt;
	
	Integer hotelAmt;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getRankId() {
		return rankId;
	}

	public void setRankId(String rankId) {
		this.rankId = rankId;
	}

	public String getCityClsDa() {
		return cityClsDa;
	}

	public void setCityClsDa(String cityClsDa) {
		this.cityClsDa = cityClsDa;
	}

	public String getCityClsHotel() {
		return cityClsHotel;
	}

	public void setCityClsHotel(String cityClsHotel) {
		this.cityClsHotel = cityClsHotel;
	}

	public Integer getDaAmt() {
		return daAmt;
	}

	public void setDaAmt(Integer daAmt) {
		this.daAmt = daAmt;
	}

	public Integer getHotelAmt() {
		return hotelAmt;
	}

	public void setHotelAmt(Integer hotelAmt) {
		this.hotelAmt = hotelAmt;
	}

	@Override
	public String toString() {
		return "TadaCityMst [cityId=" + cityId + ", rankId=" + rankId + ", cityClsDa=" + cityClsDa + ", cityClsHotel="
				+ cityClsHotel + ", daAmt=" + daAmt + ", hotelAmt=" + hotelAmt + "]";
	}
	
	
}
