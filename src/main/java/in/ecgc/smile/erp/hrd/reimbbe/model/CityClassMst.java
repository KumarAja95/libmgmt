package in.ecgc.smile.erp.hrd.reimbbe.model;

public class CityClassMst {

	String cityCd;
	
	String city;
	
	String catCdDa;
	
	String catCdHotel;

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCatCdDa() {
		return catCdDa;
	}

	public void setCatCdDa(String catCdDa) {
		this.catCdDa = catCdDa;
	}

	public String getCatCdHotel() {
		return catCdHotel;
	}

	public void setCatCdHotel(String catCdHotel) {
		this.catCdHotel = catCdHotel;
	}

	@Override
	public String toString() {
		return "CityClassMst [cityCd=" + cityCd + ", city=" + city + ", catCdDa=" + catCdDa + ", catCdHotel="
				+ catCdHotel + "]";
	}
	
	
}
