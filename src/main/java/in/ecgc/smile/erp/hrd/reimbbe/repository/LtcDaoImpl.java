package in.ecgc.smile.erp.hrd.reimbbe.repository;
import java.sql.Date;
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

import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;
import in.ecgc.smile.erp.hrd.reimbbe.util.LtcQueries;







@Repository
public class LtcDaoImpl implements LtcDao{
	
private JdbcOperations jdbcOperations;
	
	/* For parameterized query */
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	
	@Autowired
	public LtcDaoImpl(DataSource dataSource) {
		
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
		jdbcOperations = new JdbcTemplate(dataSource);
	}

	@Override
	public int addLtcAdvData(LtcTxn ltcData) {
		
		System.out.println(ltcData);
		 Date appliDate=Date.valueOf(ltcData.getApplicationDt());
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  
		   namedParameters.put("ltcFlag", ltcData.getLtcFlag());
	       namedParameters.put("empNo", ltcData.getEmpNo());
		   namedParameters.put("appDate", appliDate);
		   namedParameters.put("blockYear", ltcData.getBlockYear());
		   namedParameters.put("leaveApplied", ltcData.getLeaveApplied());
		   namedParameters.put("advSettleFlg", ltcData.getAdvSettleFlag() );
		   
		   namedParameters.put("placeOfTravel", ltcData.getPlaceOfTravel());
	       namedParameters.put("ltcType", ltcData.getLtcType());
		   namedParameters.put("totalFare", ltcData.getTotalFare());
		   namedParameters.put("amtClaimed", ltcData.getAmountClamied());
		 namedParameters.put("travelDetail", ltcData.getTravelDetail() );
		    namedParameters.put("leaveApplied", ltcData.getLeaveApplied());
	       namedParameters.put("yearOfTravel", ltcData.getYearOfTravel() );
     	 
			try {
				  int result =namedParameterJdbcOperations.queryForObject(LtcQueries.INSERT_LTC_ADV_RECORD,namedParameters,Integer.class); 
				  System.out.println(result);
				 
				  return result; 
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}
	
	

	@Override
	public List<LtcTxn> getAdvanceApproveList(int empId) {
		List<LtcTxn> list=jdbcOperations.query(LtcQueries.GET_LTC_ADVANCE_APPROVAL_LIST,new Object[] { empId },new RowMapper<LtcTxn>() {

			@Override
			public LtcTxn mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcTxn ltcTxn=new LtcTxn(); 
				ltcTxn.setLtcTxnId(rs.getInt("ltc_txn_id"));
				ltcTxn.setLtcNo(rs.getInt("ltc_no"));
				ltcTxn.setApprovalStatus(rs.getString("approval_status"));
				ltcTxn.setApplicationDt(rs.getString("application_dt"));
				ltcTxn.setBlockYear(rs.getString("block_year"));
				
				
				return ltcTxn;
			}
		});
		return list;
	}

	@Override
	public LtcTxn getLtcDataByLtcTxnId(int ltcTxnId) {
		LtcTxn ltcTxn=(LtcTxn)jdbcOperations.queryForObject(LtcQueries.GET_LTC_DATA_BY_LTCTXNID,new Object[] { ltcTxnId },new RowMapper<LtcTxn>() {

			@Override
			public LtcTxn mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcTxn ltcTxn=new LtcTxn(); 
				ltcTxn.setLtcTxnId(rs.getInt("ltc_txn_id"));
				ltcTxn.setLtcNo(rs.getInt("ltc_no"));
				ltcTxn.setEmpNo(rs.getInt("emp_no"));
				ltcTxn.setAdvSettleFlag(rs.getString("adv_settle_flg"));
				ltcTxn.setApprovalStatus(rs.getString("approval_status"));
				ltcTxn.setApplicationDt(rs.getString("application_dt"));
				ltcTxn.setBlockYear(rs.getString("block_year"));
				ltcTxn.setLtcType(rs.getString("ltc_type"));
				ltcTxn.setPlaceOfTravel(rs.getString("place_of_travel"));
				ltcTxn.setAmountClamied(rs.getBigDecimal("amount_claimed"));
				ltcTxn.setSettlementAmt(rs.getBigDecimal("settlement_amt"));
				ltcTxn.setTotalFare(rs.getBigDecimal("total_fare"));
				ltcTxn.setApprovedDt(rs.getString("approved_dt"));
				ltcTxn.setAmountApproved(rs.getBigDecimal("amount_approved"));
				ltcTxn.setTravelDetail(rs.getString("travel_detail"));
				ltcTxn.setYearOfTravel(rs.getInt("year_of_travel"));
				ltcTxn.setJourneyFrm(rs.getString("journey_frm"));
				ltcTxn.setJourneyTo(rs.getString("journey_to"));
				ltcTxn.setOnwardDtOfJourney(rs.getString("onward_dt_of_journey"));
				ltcTxn.setReturnDtOfJourney(rs.getString("return_dt_of_journey"));
				ltcTxn.setOnwardFare(rs.getBigDecimal("onward_fare"));
				ltcTxn.setReturnFare(rs.getBigDecimal("return_fare"));
				return ltcTxn;
			}
		});
		return ltcTxn;
	}

	@Override
	public int addLtcAdvSettlement(LtcTxn ltcData) {
		
		
		 System.out.println(ltcData);
		 Date appliDate=Date.valueOf(ltcData.getApplicationDt());
		 Date onwardDate=Date.valueOf (ltcData.getOnwardDtOfJourney());
		 Date returnDate=Date.valueOf (ltcData.getReturnDtOfJourney());
	//	 Date approvDate=Date.valueOf(ltcData.getApprovedDt());
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcNo", ltcData.getLtcTxnId());
		   namedParameters.put("ltcFlag", ltcData.getLtcFlag());
	       namedParameters.put("empNo", ltcData.getEmpNo());
		   namedParameters.put("appDate", appliDate);
		   namedParameters.put("blockYear", ltcData.getBlockYear());
		// namedParameters.put("leaveApplied", ltcData.getLeaveApplied());
		   namedParameters.put("advSettleFlg", ltcData.getAdvSettleFlag() );
		   namedParameters.put("placeOfTravel", ltcData.getPlaceOfTravel());
		   namedParameters.put("ltcType", ltcData.getLtcType());
		   namedParameters.put("journeyFrm", ltcData.getJourneyFrm());
		   namedParameters.put("journeyTo", ltcData.getJourneyTo());
		   namedParameters.put("onwardDtOfJourney", onwardDate);
		   namedParameters.put("onwardFare", ltcData.getOnwardFare());
		   namedParameters.put("returnDtOfJourney", returnDate);
		   namedParameters.put("returnFare", ltcData.getReturnFare());
		   namedParameters.put("totalFare", ltcData.getTotalFare());
		   namedParameters.put("amtClaimed", ltcData.getAmountClamied());
		
		    namedParameters.put("settlementAmt", ltcData.getSettlementAmt());
		    namedParameters.put("adjustedAmt", ltcData.getAdjustedAmt());
		   namedParameters.put("journeyFrm", ltcData.getJourneyFrm() );
	        namedParameters.put("journeyTo", ltcData.getJourneyTo());
	
		    namedParameters.put("travelDetail", ltcData.getTravelDetail() );

		    namedParameters.put("yearOfTravel", ltcData.getYearOfTravel() );
	
			try {
				  int result =namedParameterJdbcOperations.queryForObject(LtcQueries.INSERT_LTC_ADV_SET_RECORD,namedParameters,Integer.class); 
				  System.out.println(result);
				 addMappingData(ltcData.getLtcTxnId(),result);
				  return result; 
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}
	

	@Override
	public int addMappingData(int advLtcTxnId, int setLtcTxnId) {
		try {
			  int result =jdbcOperations.update(LtcQueries.ADD_LTC_MAPPING, advLtcTxnId,setLtcTxnId); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		 
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}
	
	
	

	@Override
	public int addLtcDirSettlement(LtcTxn ltcData) {
		
		System.out.println(ltcData);
		System.out.println(ltcData.getAdvSettleFlag());
		 Date appliDate=Date.valueOf(ltcData.getApplicationDt());
		 Date onwardDate=Date.valueOf (ltcData.getOnwardDtOfJourney());
		 Date returnDate=Date.valueOf (ltcData.getReturnDtOfJourney());
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcNo", ltcData.getLtcNo());
		   namedParameters.put("ltcFlag", ltcData.getLtcFlag());
	       namedParameters.put("empNo", ltcData.getEmpNo());
		   namedParameters.put("appDate", appliDate);
		   namedParameters.put("blockYear", ltcData.getBlockYear());
		   namedParameters.put("leaveApplied", ltcData.getLeaveApplied());
		   namedParameters.put("advSettleFlg", ltcData.getAdvSettleFlag() );
		   namedParameters.put("placeOfTravel", ltcData.getPlaceOfTravel());
		   namedParameters.put("ltcType", ltcData.getLtcType());
		   namedParameters.put("journeyFrm", ltcData.getJourneyFrm());
		   namedParameters.put("journeyTo", ltcData.getJourneyTo());
		   namedParameters.put("onwardDtOfJourney", onwardDate);
		   namedParameters.put("onwardDtOfJourney", onwardDate);
		   namedParameters.put("onwardFare", ltcData.getOnwardFare());
		   namedParameters.put("returnDtOfJourney", returnDate);
		   namedParameters.put("returnFare", ltcData.getReturnFare());
		   namedParameters.put("totalFare", ltcData.getTotalFare());
		   namedParameters.put("amtClaimed", ltcData.getAmountClamied());
	   
		    namedParameters.put("travelDetail", ltcData.getTravelDetail() );
	  
		    namedParameters.put("yearOfTravel", ltcData.getYearOfTravel() );
	  
		 
			try {
				  int result =namedParameterJdbcOperations.queryForObject(LtcQueries.INSERT_LTC_DIR_SET_RECORD,namedParameters,Integer.class); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}
	
	@Override
	public List<LtcTxn> getAdvSetList(int empId ,String advSetStatus) {
		System.out.println("advSetFlg"+advSetStatus);
		List<LtcTxn> list;
		try {
		    list=jdbcOperations.query(LtcQueries.GET_LTC_APPLICATION_LIST,new Object[] { empId,advSetStatus },new RowMapper<LtcTxn>() {

			@Override
			public LtcTxn mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcTxn ltcTxn=new LtcTxn(); 
				ltcTxn.setLtcTxnId(rs.getInt("ltc_txn_id"));
				ltcTxn.setEmpNo(rs.getInt("emp_no"));
				ltcTxn.setApprovalStatus(rs.getString("approval_status"));
				ltcTxn.setApplicationDt(rs.getString("application_dt"));
				ltcTxn.setBlockYear(rs.getString("block_year"));
				 
				
				return ltcTxn;
			}
		});
		}catch(Exception e)
		{
			list=null;
		}
		return list;
	}

	@Override
	public int addLtcDepTrvData(LtcEmpDepTrv ltcEmpDepTrv) {
		System.out.println(ltcEmpDepTrv);
		 
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcTxnId", ltcEmpDepTrv.getLtcTxnId());
		   
	       namedParameters.put("empNo", ltcEmpDepTrv.getEmpNo());
	       namedParameters.put("dependentId", ltcEmpDepTrv.getDependentId());
		   namedParameters.put("dependentName", ltcEmpDepTrv.getNameOfDependent());
		   namedParameters.put("relation", ltcEmpDepTrv.getRelation());
		   namedParameters.put("arrTrvMode", ltcEmpDepTrv.getArrTravMode() );
		   namedParameters.put("arrTrainType", ltcEmpDepTrv.getArrTrainType());
	       namedParameters.put("arrTrvClass", ltcEmpDepTrv.getArrTravClass());
		   namedParameters.put("arrFareClaim", ltcEmpDepTrv.getArrFareClaimed());
		   namedParameters.put("arrFareAppr", ltcEmpDepTrv.getArrFareApprov());
		   namedParameters.put("depTrvMode", ltcEmpDepTrv.getDepTravMode() );
		   namedParameters.put("depTrainType", ltcEmpDepTrv.getDepTrainType());
	       namedParameters.put("depTrvClass", ltcEmpDepTrv.getDepTravClass());
		   namedParameters.put("depFareClaim", ltcEmpDepTrv.getDepFareClaimed());
		   namedParameters.put("depFareAppr", ltcEmpDepTrv.getDepFareApprov());
		 //  namedParameters.put("status", ltcEmpDepTrv.getStatus() );
		   try {
				  int result =namedParameterJdbcOperations.update(LtcQueries.INSERT_LTC_EMP_DEP_TRV_DATA,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}
	
	

	@Override
	public int addLtcEmpTrvData(LtcEmpTrv ltcEmpTrv) {
		System.out.println(ltcEmpTrv);
		 
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcTxnId", ltcEmpTrv.getLtcTxnId());
		   
	       namedParameters.put("empNo", ltcEmpTrv.getEmpNo());
		   namedParameters.put("arrTrvMode", ltcEmpTrv.getArrTravMode() );
		   namedParameters.put("arrTrainType", ltcEmpTrv.getArrTrainType());
	       namedParameters.put("arrTrvClass", ltcEmpTrv.getArrTravClass());
		   namedParameters.put("arrFareClaim", ltcEmpTrv.getArrFareClaimed());
		   namedParameters.put("arrFareAppr", ltcEmpTrv.getArrFareApprov());
		   namedParameters.put("depTrvMode", ltcEmpTrv.getDepTravMode() );
		   namedParameters.put("depTrainType", ltcEmpTrv.getDepTrainType());
	       namedParameters.put("depTrvClass", ltcEmpTrv.getDepTravClass());
		  namedParameters.put("depFareClaim", ltcEmpTrv.getDepFareClaimed());
		   namedParameters.put("depFareAppr", ltcEmpTrv.getDepFareApprov());
		 //  namedParameters.put("status", ltcEmpTrv.getStatus() );
		   try {
				  int result =namedParameterJdbcOperations.update(LtcQueries.INSERT_LTC_EMP_TRV_DATA,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}

	@Override
	public List<LtcEligiblty> getLtcEligibltyList(String rankId) {
		
		List<LtcEligiblty> list;
		try {
		  list =jdbcOperations.query(LtcQueries.GET_LTC_ELIGIBLTY_LIST,new Object[] { rankId },new RowMapper<LtcEligiblty>() {

			@Override
			public LtcEligiblty mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcEligiblty ltcEligiblty=new LtcEligiblty();
				ltcEligiblty.setLtcNo(rs.getInt("ltc_no"));
				ltcEligiblty.setRankId(rs.getString("rank_id"));
				ltcEligiblty.setTravelMode(rs.getString("travel_mode"));
				ltcEligiblty.setTravelClass(rs.getString("travel_class"));
				ltcEligiblty.setTrainType(rs.getString("train_type"));
				ltcEligiblty.setEffectiveDt(rs.getDate("eff_date"));
				return ltcEligiblty;
			}
		});
		}catch(Exception e) {
		
			list=null;
		}
		return list;
	}

	@Override
	public int addLtcEligibltydata(LtcEligiblty ltcEligiblty) {

		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  
	       namedParameters.put("description", ltcEligiblty.getDescription());
		   namedParameters.put("rankId", ltcEligiblty.getRankId() );
		   namedParameters.put("travelMode", ltcEligiblty.getTravelMode());
	       namedParameters.put("travelClass", ltcEligiblty.getTravelClass());
		   namedParameters.put("trainType", ltcEligiblty.getTrainType());
		   namedParameters.put("effDate", ltcEligiblty.getEffectiveDt());
		   namedParameters.put("status", ltcEligiblty.getStatus() );
		   try {
				  int result =namedParameterJdbcOperations.update(LtcQueries.INSERT_LTC_ELIGIBLTY_RECORD,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}
	

	@Override
	public int updateLtcEligiblty(LtcEligiblty ltcEligiblty) {
		 
		 
		
		try {
			  int result =jdbcOperations.update(LtcQueries.UPDATE_ELIGIBLTY_DATA, ltcEligiblty.getRankId() , ltcEligiblty.getDescription(), ltcEligiblty.getTravelMode(),ltcEligiblty.getTravelClass(), ltcEligiblty.getTrainType(), ltcEligiblty.getEffectiveDt(), ltcEligiblty.getLtcNo()); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public LtcEligiblty getLtcEligiblityData(int ltcNo) {
		LtcEligiblty ltcEligiblty;
		try {
		 ltcEligiblty=(LtcEligiblty)jdbcOperations.queryForObject(LtcQueries.GET_LTC_ELIGIBLTY_BY_LTCNO,new Object[] { ltcNo },new RowMapper<LtcEligiblty>() {

			@Override
			public LtcEligiblty mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcEligiblty ltcEligiblty=new LtcEligiblty();
				ltcEligiblty.setLtcNo(rs.getInt("ltc_no"));
				ltcEligiblty.setRankId(rs.getString("rank_id"));
				ltcEligiblty.setTravelMode(rs.getString("travel_mode"));
				ltcEligiblty.setTravelClass(rs.getString("travel_class"));
				ltcEligiblty.setTrainType(rs.getString("train_type"));
				ltcEligiblty.setEffectiveDt(rs.getDate("eff_date"));
				return ltcEligiblty;
			}
		});
		}catch(Exception e)
		{
			ltcEligiblty =null;
		}
		return ltcEligiblty;
	}
	
	@Override
	public int deleteLtcEligibltyData(int ltcNo) {
	 	
		try {
			  int result =jdbcOperations.update(LtcQueries.DELETE__LTC__ELIGIBLITY_DATA, ltcNo); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public int updateApproveAdvSet(LtcTxn ltcTxn) {
		Date approveDt=Date.valueOf(ltcTxn.getApprovedDt());
		try {
			  int result =jdbcOperations.update(LtcQueries.UPDATE_APPROVE_ADVANCE_SETTLEMENT, ltcTxn.getAmountApproved(),ltcTxn.getApprovalStatus(),ltcTxn.getApprovedBy(),approveDt,ltcTxn.getApprovRemarks(),ltcTxn.getLtcTxnId()); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}
	


	@Override
	public List<LtcEmpDepTrv> getLtcDependentList(int ltcTxnId) {
		System.out.println(ltcTxnId);
		List<LtcEmpDepTrv> list;
		try {
		 list=jdbcOperations.query(LtcQueries.GET_LTC_EMP_DEP_TRV_LIST,new Object[] { ltcTxnId },new RowMapper<LtcEmpDepTrv>() {

			@Override
			public LtcEmpDepTrv mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcEmpDepTrv ltcDep=new LtcEmpDepTrv(); 
				ltcDep.setLtcEmpDepTrvId(rs.getInt("ltc_emp_dep_trv_id"));
				ltcDep.setEmpNo(rs.getInt("emp_no"));
				ltcDep.setDependentId(rs.getInt("dependent_id"));
				ltcDep.setNameOfDependent(rs.getString("name_of_dependent"));
				ltcDep.setRelation(rs.getString("relation"));
				ltcDep.setDepTravMode(rs.getString("dep_travel_mode"));
				ltcDep. setDepTrainType(rs.getString("dep_train_type"));
				ltcDep.setDepTravClass(rs.getString("dep_travel_class"));
				ltcDep.setArrTravMode(rs.getString("arr_travel_mode"));
				ltcDep. setArrTrainType(rs.getString("arr_train_type"));
				ltcDep.setArrTravClass(rs.getString("arr_travel_class"));
				ltcDep.setArrFareClaimed(rs.getBigDecimal("arr_fare_claimed"));
				ltcDep.setDepFareClaimed(rs.getBigDecimal("dep_fare_claimed"));
				ltcDep.setArrFareApprov(rs.getBigDecimal("arr_fare_apprved"));
				ltcDep.setDepFareApprov(rs.getBigDecimal("dep_fare_apprved"));
				return ltcDep;
			}
		});
		}catch(Exception e) {
			list=null;
		}
		return list;
	
	}

	@Override
	public LtcEmpTrv getLtcEmpTravData(int ltcTxnId) {
		
		System.out.println(ltcTxnId);
		LtcEmpTrv ltcEmp;
		try {
		     ltcEmp=(LtcEmpTrv)jdbcOperations.queryForObject(LtcQueries.GET_LTC_EMP_TRV_DATA,new Object[] { ltcTxnId },new RowMapper<LtcEmpTrv>() {

			@Override
			public LtcEmpTrv mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcEmpTrv ltcEmp=new LtcEmpTrv(); 
				ltcEmp.setEmpNo(rs.getInt("emp_no"));
				ltcEmp.setLtcEmpTrvId(rs.getInt("ltc_emp_trv_id"));
				ltcEmp.setDepTravMode(rs.getString("dep_travel_mode"));
				ltcEmp. setDepTrainType(rs.getString("dep_train_type"));
				ltcEmp.setDepTravClass(rs.getString("dep_travel_class"));
				ltcEmp.setArrTravMode(rs.getString("arr_travel_mode"));
				ltcEmp. setArrTrainType(rs.getString("arr_train_type"));
				ltcEmp.setArrTravClass(rs.getString("arr_travel_class"));
				ltcEmp.setArrFareClaimed(rs.getBigDecimal("arr_fare_claimed"));
				ltcEmp.setDepFareClaimed(rs.getBigDecimal("dep_fare_claimed"));
				ltcEmp.setArrFareApprov(rs.getBigDecimal("arr_fare_apprved"));
				ltcEmp.setDepFareApprov(rs.getBigDecimal("dep_fare_apprved"));
				return ltcEmp;
			}
		});
		}catch(Exception e) {
			ltcEmp=null;
		}
		return ltcEmp;
	
	}

	@Override
	public int updateLtcEmpDepTrvDtl(LtcEmpDepTrv ltcEmpDepTrv) {
		System.out.println(ltcEmpDepTrv);
		try {
			  int result =jdbcOperations.update(LtcQueries.UPDATE_LTC_EMP_DEP_TRV_DATA, ltcEmpDepTrv.getDepFareApprov() , ltcEmpDepTrv.getArrFareApprov(), ltcEmpDepTrv.getLtcEmpDepTrvId()); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public int updateLtcEmpTrvDtl(LtcEmpTrv ltcEmpTrv) {
		System.out.println(ltcEmpTrv);
		try {
			  int result =jdbcOperations.update(LtcQueries.UPDATE_LTC_EMP_TRV_DATA, ltcEmpTrv.getDepFareApprov() , ltcEmpTrv.getArrFareApprov(), ltcEmpTrv.getLtcEmpTrvId()); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public int updateLtcAppForCheck(LtcTxn ltcData) {
		 System.out.println(ltcData);
		 System.out.println(ltcData.getSettlementAmt());
		 Date appliDate=Date.valueOf(ltcData.getApplicationDt());
	
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcTxnId", ltcData.getLtcTxnId());
		    namedParameters.put("appDate", appliDate);
		   namedParameters.put("blockYear", ltcData.getBlockYear());
		 namedParameters.put("advSettleFlg", ltcData.getAdvSettleFlag() );
		   namedParameters.put("placeOfTravel", ltcData.getPlaceOfTravel());
		   namedParameters.put("ltcType", ltcData.getLtcType());
		   namedParameters.put("journeyFrm", ltcData.getJourneyFrm());
		   namedParameters.put("journeyTo", ltcData.getJourneyTo());
	       namedParameters.put("onwardFare", ltcData.getOnwardFare());
	
		   namedParameters.put("returnFare", ltcData.getReturnFare());
		   namedParameters.put("totalFare", ltcData.getTotalFare());
		   namedParameters.put("amtClaimed", ltcData.getAmountClamied());
	        namedParameters.put("settlementAmt", ltcData.getSettlementAmt());
		    namedParameters.put("adjustedAmt", ltcData.getAdjustedAmt());
		    namedParameters.put("journeyFrm", ltcData.getJourneyFrm() );
	        namedParameters.put("journeyTo", ltcData.getJourneyTo());
            namedParameters.put("travelDetail", ltcData.getTravelDetail() );
	        namedParameters.put("yearOfTravel", ltcData.getYearOfTravel() );

		 
			try {
				  int result =namedParameterJdbcOperations.update(LtcQueries.UPDATE_LTC_APP_FOR_CHECK,namedParameters); 
				  System.out.println(result);
				
				  return result; 
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
			return 0;
	}

	@Override
	public int addLtcExtentionData(LtcExtention ltcExt) {
		
		Date appliDate=Date.valueOf(ltcExt.getApplicationDate());
		 Map<String, Object> namedParameters = new HashMap<String, Object>();
		 
		   namedParameters.put("empNo", ltcExt.getEmpNo());
		   namedParameters.put("blockYear", ltcExt.getBlockYear());
	       namedParameters.put("extentionYear", ltcExt.getExtYear() );
		   namedParameters.put("reasonOfExtention", ltcExt.getExtReason());
		   namedParameters.put("extentionStatus", ltcExt.getExtStatus());
		   namedParameters.put("status", ltcExt.getStatus());
		   namedParameters.put("appliDate", appliDate);
		  
		  
		
			try {
				  int result =namedParameterJdbcOperations.update(LtcQueries.INSERT_LTC_EXTENTION_DATA,namedParameters); 
				  System.out.println(result);
				
				  return result; 
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
			return 0;
	}

	@Override
	public int updateLtcExtApp(LtcExtention ltcExt) {
		try {
			  int result =jdbcOperations.update(LtcQueries.UPDATE_LTC_EXTENTION_APPROVAL, ltcExt.getAppStatus(),ltcExt.getLtcExtId());
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public LtcExtention getLtcExtentionData(int ltcExtId) {
		LtcExtention ltcExt;
		try {
			ltcExt=(LtcExtention)jdbcOperations.queryForObject(LtcQueries.GET_LTC_EXTENTION_DATA,new Object[] { ltcExtId },new RowMapper<LtcExtention>() {

			@Override
			public LtcExtention mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcExtention ltcExt=new LtcExtention(); 
				ltcExt.setLtcExtId(rs.getInt("ltc_extention_id"));
				ltcExt.setEmpNo(rs.getInt("emp_no"));
				ltcExt.setBlockYear(rs.getString("block_year"));
				ltcExt.setExtYear(rs.getString("extention_year"));
				ltcExt.setExtStatus(rs.getString("extention_status"));
				ltcExt.setExtReason(rs.getString("reason_of_extension"));
				ltcExt.setAppStatus(rs.getString("approval_status"));
				ltcExt.setApplicationDate(rs.getString("application_dt"));
				
				
				return ltcExt;
			}
		});
		}catch(Exception e)
		{
			ltcExt =null;
		}
		return ltcExt;
	}
	

	@Override
	public List<LtcExtention> getLtcExtentionList(int empNo) {
		System.out.println("extention"+empNo);
		List<LtcExtention> list=jdbcOperations.query(LtcQueries.GET_LTC_EXTENTION_LIST,new Object[] { empNo },new RowMapper<LtcExtention>() {

			@Override
			public LtcExtention mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcExtention ltcExt=new LtcExtention(); 
				ltcExt.setLtcExtId(rs.getInt("ltc_extention_id"));
				ltcExt.setEmpNo(rs.getInt("emp_no"));
				ltcExt.setBlockYear(rs.getString("block_year"));
				ltcExt.setExtYear(rs.getString("extention_year"));
				ltcExt.setExtStatus(rs.getString("extention_status"));
				ltcExt.setExtReason(rs.getString("reason_of_extension"));
				ltcExt.setAppStatus(rs.getString("approval_status"));
				ltcExt.setApplicationDate(rs.getString("application_dt"));
				
				
				return ltcExt;
			}
		});
		return list;
	}

	@Override
	public List<String> getBlockYearList() {
		List<String> list;
		try {
			list=jdbcOperations.queryForList(LtcQueries.GET_LTC_BLOCK_YEAR_LIST, String.class);
			return list;
		}catch(Exception e) {
           System.out.println(e);
		    
		    e.printStackTrace(); 
		}
		return null;
	}

	@Override
	public List<String> getTravelModeList() {
		List<String> list;
		try {
			list=jdbcOperations.queryForList(LtcQueries.GET_LTC_ELIGI_TRAVEL_MODE, String.class );
			return list;
		}catch(Exception e) {
           System.out.println(e);
		    
		    e.printStackTrace(); 
		}
		return null;
	}
	

	@Override
	public List<String> getTravelClassList(String travelMode) {
		List<String> list;
		try {
			list=jdbcOperations.queryForList(LtcQueries.GET_LTC_ELIGI_TRAVEL_CLASS1, String.class, new Object[] { travelMode });
			return list;
		}catch(Exception e) {
           System.out.println(e);
		    
		    e.printStackTrace(); 
		}
		return null;
	}
	
	@Override
	public List<String> getTravelClassList() {
		List<String> list;
		try {
			list=jdbcOperations.queryForList(LtcQueries.GET_LTC_ELIGI_TRAVEL_CLASS, String.class);
			return list;
		}catch(Exception e) {
           System.out.println(e);
		    
		    e.printStackTrace(); 
		}
		return null;
	}

	@Override
	public List<String> getTrainTypeList(String travelMode) {
		List<String> list;
		try {
			list=jdbcOperations.queryForList(LtcQueries.GET_LTC_ELIGI_TRAIN_TYPE, String.class, new Object[] { travelMode });
			return list;
		}catch(Exception e) {
           System.out.println(e);
		    
		    e.printStackTrace(); 
		}
		return null;
	}

	@Override
	public int updateLtcEmpTrvDataForCheck(LtcEmpTrv ltcEmpTrv) {
		
		
		System.out.println(ltcEmpTrv);
		 
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcEmpTrvId", ltcEmpTrv.getLtcEmpTrvId());
		   namedParameters.put("arrTravMode", ltcEmpTrv.getArrTravMode() );
		   namedParameters.put("arrTrainType", ltcEmpTrv.getArrTrainType());
	       namedParameters.put("arrTravClass", ltcEmpTrv.getArrTravClass());
		   namedParameters.put("arrFareClaim", ltcEmpTrv.getArrFareClaimed());
		 namedParameters.put("depTravMode", ltcEmpTrv.getDepTravMode() );
		   namedParameters.put("depTrainType", ltcEmpTrv.getDepTrainType());
	       namedParameters.put("depTravClass", ltcEmpTrv.getDepTravClass());
		  namedParameters.put("depFareClaim", ltcEmpTrv.getDepFareClaimed());
		
		try {
			  int result =namedParameterJdbcOperations.update(LtcQueries.UPDATE_LTC_EMP_TRV_DATA_FOR_CHECK,namedParameters); 
			  System.out.println(result);
			
			  return result; 
	  }catch(Exception e) { 
		  System.out.println(e);
		 
		  e.printStackTrace(); 
	  }
		return 0;
}

	@Override
	public int updateLtcEmpDepTrvDataCheck(LtcEmpDepTrv ltcEmpDepTrv) {
		
		
		System.out.println(ltcEmpDepTrv);
		 
		
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		   namedParameters.put("ltcEmpDepTrvId", ltcEmpDepTrv.getLtcEmpDepTrvId());
		   
	     
		   namedParameters.put("arrTravMode", ltcEmpDepTrv.getArrTravMode() );
		   namedParameters.put("arrTrainType", ltcEmpDepTrv.getArrTrainType());
	       namedParameters.put("arrTravClass", ltcEmpDepTrv.getArrTravClass());
		   namedParameters.put("arrFareClaim", ltcEmpDepTrv.getArrFareClaimed());
		   namedParameters.put("depTravMode", ltcEmpDepTrv.getDepTravMode() );
		   namedParameters.put("depTrainType", ltcEmpDepTrv.getDepTrainType());
	       namedParameters.put("depTravClass", ltcEmpDepTrv.getDepTravClass());
		   namedParameters.put("depFareClaim", ltcEmpDepTrv.getDepFareClaimed());
		 
		try {
			  int result =namedParameterJdbcOperations.update(LtcQueries.UPDATE_LTC_EMP_DEP_TRV_DATA_FOR_CHECK,namedParameters); 
			  System.out.println(result);
			
			  return result; 
	  }catch(Exception e) { 
		  System.out.println(e);
		 
		  e.printStackTrace(); 
	  }
		return 0;
}

	@Override
	public List<LtcEligiblty> getLtcEligibltyMstList() {
		List<LtcEligiblty> list;
		try {
		  list =jdbcOperations.query(LtcQueries.GET_LTC_ELIGIBLTY,new RowMapper<LtcEligiblty>() {

			@Override
			public LtcEligiblty mapRow(ResultSet rs, int rowNum) throws SQLException {
				LtcEligiblty ltcEligiblty=new LtcEligiblty();
				ltcEligiblty.setLtcNo(rs.getInt("ltc_no"));
				ltcEligiblty.setRankId(rs.getString("rank_id"));
				ltcEligiblty.setTravelMode(rs.getString("travel_mode"));
				ltcEligiblty.setTravelClass(rs.getString("travel_class"));
				ltcEligiblty.setTrainType(rs.getString("train_type"));
				ltcEligiblty.setEffectiveDt(rs.getDate("eff_date"));
				return ltcEligiblty;
			}
		});
		}catch(Exception e) {
		
			list=null;
		}
		return list;
	}
	
	
	
}
