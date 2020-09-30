package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class DomesticTadaDaoImpl implements DomesticTadaDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	/*Constructor for autowire jdbc and datasource*/
	@Autowired
	public DomesticTadaDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public int saveDomesticTadaAdv(DomesticTada domTada) {
		int indTourId = jdbcOperations.queryForObject("SELECT emp_reimb.ecgc_hrd_int_seq_no_tbl_func('tada_ind_dtl_trn')", Integer.class);
		
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("indTourId", indTourId);
		namedParameters.put("advSetFlg", domTada.getAdvSettleFlg());
		namedParameters.put("empNo", domTada.getEmpNo());
		namedParameters.put("purpose", domTada.getPurpose());
		namedParameters.put("tourType", domTada.getTourType());
		namedParameters.put("depdt", domTada.getDepDt());
		namedParameters.put("depTrvlMode", domTada.getDepTrvlMode());
		namedParameters.put("depTrainType", domTada.getDepTrainType());
		namedParameters.put("depTrvlClss", domTada.getDepTrvlClss());
		namedParameters.put("arrDt", domTada.getArrDt());
		namedParameters.put("arrTrvlMode", domTada.getRetDepTrvlMode());
		namedParameters.put("arrTrainType", domTada.getRetDepTrainType());
		namedParameters.put("arrTrvlClss", domTada.getRetDepTrvlClss());
		namedParameters.put("depfare", domTada.getDepFare());
		namedParameters.put("totalExp", domTada.getTotal());
		namedParameters.put("amtClaimed", domTada.getAmtClaimed());
		namedParameters.put("arrFare", domTada.getRetDepFare());
		namedParameters.put("daysPeriod", domTada.getDaysPeriod());
		namedParameters.put("actWrkDays", domTada.getActualWorkingDays());
		namedParameters.put("city", domTada.getCity());
		namedParameters.put("applicationDt", domTada.getApplicationDt());
		namedParameters.put("othExp", domTada.getOtherExpenses());
		namedParameters.put("totalDa", domTada.getTotDa());
		namedParameters.put("eligibleDa", domTada.getEligibleDa());
		namedParameters.put("conveyanceExp", domTada.getConveyanceExp());
		namedParameters.put("hotelExp", domTada.getHotelExp());
		namedParameters.put("hotelTax", domTada.getHotelTax());
		namedParameters.put("cityClss", domTada.getCityClassDa());
		namedParameters.put("cityCatgId", domTada.getCityClassHotel());
		namedParameters.put("actDepTime", domTada.getDepTime());
		namedParameters.put("depdtTm", domTada.getDepTmDate());
		namedParameters.put("depTmTime", domTada.getDepTmTime());
		namedParameters.put("arrTmTime", domTada.getArrTmTime());
		namedParameters.put("arrTmDt", domTada.getArrTmDate());
		namedParameters.put("officeAccomo", domTada.isOfficeAccommodation());
		namedParameters.put("boardingLodging", domTada.getBoardingLodging());
		namedParameters.put("retDepTmTime", domTada.getRetDepTmTime());
		namedParameters.put("retDepTmDate", domTada.getRetDepTmDate());
		namedParameters.put("retArrTmTime", domTada.getRetArrTmTime());
		namedParameters.put("retArrTmDate", domTada.getRetArrTmDate());
		namedParameters.put("arrTime", domTada.getArrTime());
		
		return namedParameterJdbcOperations.update(TadaQueries.INSERT_DOMESTIC_TADA_DTL, namedParameters);
	}

	@Override
	public List<DomesticTada> domesticAdvListForSet(int empNo) {
		
		return jdbcOperations.query(TadaQueries.SELECT_DOMESTIC_ADV_FOR_SET, 
				 new Object [] {empNo}, new RowMapper<DomesticTada>() {
			@Override
			public DomesticTada mapRow(ResultSet rs, int rowNum) throws SQLException {
				DomesticTada domAdv = new DomesticTada(); 
				domAdv.setIndTourId(rs.getInt("ind_tour_id"));
				domAdv.setEmpNo(rs.getInt("emp_no")); 
				domAdv.setPurpose(rs.getString("purpose"));
				domAdv.setTourType(rs.getString("tour_type"));
				domAdv.setTotal(rs.getDouble("total_expenses"));  
				domAdv.setAmtClaimed(rs.getDouble("amt_claimed"));  
				domAdv.setApplicationDt(rs.getDate("application_date"));
				domAdv.setTotalAppr(rs.getDouble("total_appr"));
				
				return domAdv;
			}
		});
	}

	@Override
	public DomesticTada domesticAdvForSet(int indTourId) {
		
		return jdbcOperations.queryForObject(TadaQueries.SELECT_DOMESTIC_ADV_BY_TOUR_ID, 
				 new Object [] {indTourId}, new RowMapper<DomesticTada>() {
			@Override
			public DomesticTada mapRow(ResultSet rs, int rowNum) throws SQLException {
				DomesticTada domAdv = new DomesticTada(); 
				domAdv.setIndTourId(rs.getInt("ind_tour_id"));
				domAdv.setEmpNo(rs.getInt("emp_no")); 
				domAdv.setPurpose(rs.getString("purpose"));
				domAdv.setTourType(rs.getString("tour_type"));
				domAdv.setDepDt(rs.getDate("dep_dt"));
				domAdv.setDepTrvlMode(rs.getString("dep_travel_mode")); 
				domAdv.setDepTrainType(rs.getString("dep_train_type")); 
				domAdv.setDepTrvlClss(rs.getString("dep_travel_class"));  
				domAdv.setArrDt(rs.getDate("arr_dt")); 
				domAdv.setRetDepTrvlMode(rs.getString("arr_travel_mode"));  
				domAdv.setRetDepTrainType(rs.getString("arr_train_type")); 
				domAdv.setRetDepTrvlClss(rs.getString("arr_travel_class")); 
				domAdv.setDepFare(rs.getDouble("dep_fare")); 
				domAdv.setTotal(rs.getDouble("total_expenses"));  
				domAdv.setAmtClaimed(rs.getDouble("amt_claimed"));  
				domAdv.setRetDepFare(rs.getDouble("arr_fare")); 
				domAdv.setDaysPeriod(rs.getInt("days_period")); 
				domAdv.setActualWorkingDays(rs.getInt("act_work_days"));  
				domAdv.setCity(rs.getString("city_name")); 
				domAdv.setApplicationDt(rs.getDate("application_date"));
				domAdv.setOtherExpenses(rs.getDouble("oth_exp"));  
				domAdv.setTotDa(rs.getDouble("total_da"));
				domAdv.setEligibleDa(rs.getDouble("eligible_da"));
				domAdv.setConveyanceExp(rs.getDouble("conveyance_exp")); 
				domAdv.setHotelExp(rs.getDouble("hotel_exp")); 
				domAdv.setHotelTax(rs.getDouble("hotel_tax")); 
				domAdv.setCityClassDa(rs.getString("city_class"));
				domAdv.setCityClassHotel(rs.getString("city_category_id"));
				domAdv.setDepTime(rs.getString("act_dep_to_time"));
				domAdv.setDepTmDate(rs.getDate("dep_dt_tm"));
				domAdv.setDepTmTime(rs.getString("dep_from_tm_time")); 
				domAdv.setArrTmTime(rs.getString("arrival_tm_time")); 
				domAdv.setArrTmDate(rs.getDate("arr_tm_dt"));
				domAdv.setOfficeAccommodation(rs.getBoolean("office_accommodation")); 
				domAdv.setBoardingLodging(rs.getString("boarding_lodging"));
				domAdv.setRetDepTmTime(rs.getString("ret_dep_tm_time")); 
				domAdv.setRetDepTmDate(rs.getDate("ret_dep_tm_dt"));
				domAdv.setRetArrTmTime(rs.getString("ret_arr_tm_time")); 
				domAdv.setRetArrTmDate(rs.getDate("ret_arr_tm_dt")); 
				domAdv.setArrTime(rs.getString("arr_time"));
				
				return domAdv;
			}
		});
	}

	@Override
	public int saveDomesticTadaSet(DomesticTada domTada) {
		int indTourId = jdbcOperations.queryForObject("SELECT emp_reimb.ecgc_hrd_int_seq_no_tbl_func('tada_ind_dtl_trn')", Integer.class);
		
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("indTourId", indTourId);
		namedParameters.put("advSetFlg", domTada.getAdvSettleFlg());
		namedParameters.put("empNo", domTada.getEmpNo());
		namedParameters.put("purpose", domTada.getPurpose());
		namedParameters.put("tourType", domTada.getTourType());
		namedParameters.put("depdt", domTada.getDepDt());
		namedParameters.put("depTrvlMode", domTada.getDepTrvlMode());
		namedParameters.put("depTrainType", domTada.getDepTrainType());
		namedParameters.put("depTrvlClss", domTada.getDepTrvlClss());
		namedParameters.put("arrDt", domTada.getArrDt());
		namedParameters.put("arrTrvlMode", domTada.getRetDepTrvlMode());
		namedParameters.put("arrTrainType", domTada.getRetDepTrainType());
		namedParameters.put("arrTrvlClss", domTada.getRetDepTrvlClss());
		namedParameters.put("depfare", domTada.getDepFare());
		namedParameters.put("totalExp", domTada.getTotal());
		namedParameters.put("amtClaimed", domTada.getAmtClaimed());
		namedParameters.put("arrFare", domTada.getRetDepFare());
		namedParameters.put("daysPeriod", domTada.getDaysPeriod());
		namedParameters.put("actWrkDays", domTada.getActualWorkingDays());
		namedParameters.put("city", domTada.getCity());
		namedParameters.put("applicationDt", domTada.getApplicationDt());
		namedParameters.put("othExp", domTada.getOtherExpenses());
		namedParameters.put("totalDa", domTada.getTotDa());
		namedParameters.put("eligibleDa", domTada.getEligibleDa());
		namedParameters.put("conveyanceExp", domTada.getConveyanceExp());
		namedParameters.put("hotelExp", domTada.getHotelExp());
		namedParameters.put("hotelTax", domTada.getHotelTax());
		namedParameters.put("cityClss", domTada.getCityClassDa());
		namedParameters.put("cityCatgId", domTada.getCityClassHotel());
		namedParameters.put("actDepTime", domTada.getDepTime());
		namedParameters.put("depdtTm", domTada.getDepTmDate());
		namedParameters.put("depTmTime", domTada.getDepTmTime());
		namedParameters.put("arrTmTime", domTada.getArrTmTime());
		namedParameters.put("arrTmDt", domTada.getArrTmDate());
		namedParameters.put("officeAccomo", domTada.isOfficeAccommodation());
		namedParameters.put("boardingLodging", domTada.getBoardingLodging());
		namedParameters.put("retDepTmTime", domTada.getRetDepTmTime());
		namedParameters.put("retDepTmDate", domTada.getRetDepTmDate());
		namedParameters.put("retArrTmTime", domTada.getRetArrTmTime());
		namedParameters.put("retArrTmDate", domTada.getRetArrTmDate());
		namedParameters.put("arrTime", domTada.getArrTime());
		
		namedParameterJdbcOperations.update(TadaQueries.INSERT_DOMESTIC_TADA_DTL, namedParameters);
		int result = 0;
		if(domTada.getIndTourId() != null) {
			int advSetId = jdbcOperations.queryForObject("SELECT emp_reimb.ecgc_hrd_int_seq_no_tbl_func('ltc_tada_adv_set_map')", Integer.class);
			namedParameters.put("advSetId", advSetId);
			namedParameters.put("process", "Domestic");
			namedParameters.put("setId", indTourId);
			namedParameters.put("advId", domTada.getIndTourId());
			result = namedParameterJdbcOperations.update(TadaQueries.INSERT_ADV_SET_MAPPING, namedParameters);
		}
		return result; 
	}

}
