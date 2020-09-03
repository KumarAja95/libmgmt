package in.ecgc.smile.erp.hrd.reimbbe.util;

public interface TadaQueries {

	String GET_ACTIVE_TADA_TYPE = "SELECT DISTINCT type "
			+ "FROM emp_reimb.\"ecgc_hrd_tada_type_mst\" "
			+ "where status = true";
	
	String GET_ACTIVE_TADA_SUBTYPE = "SELECT sub_type "
			+ "FROM emp_reimb.\"ecgc_hrd_tada_type_mst\" "
			+ "where status = true and type=?";
	
	String GET_ALL_IND_FOR_DA_MST = "SELECT ind_for_da_id, min_hour, max_hour, rate_of_da, type, status "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_for_da_mst";
	
	String GET_IND_FOR_DA_MST = "SELECT min_hour, max_hour, rate_of_da "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_for_da_mst "
			+ "WHERE type=? AND status='A' ";
	
	String INSERT_IND_FOR_DA_MST = "INSERT INTO emp_reimb.ecgc_hrd_tada_ind_for_da_mst "
			+ "(ind_for_da_id, min_hour, max_hour, rate_of_da, type, status, meta_remarks) "
			+ "VALUES(:indForDaId, :minHour, :maxHour, :rateOfDa, :type, :status, :remark)";
	
	String UPDATE_IND_FOR_DA_MST = "UPDATE emp_reimb.ecgc_hrd_tada_ind_for_da_mst "
			+ "SET min_hour=:minHour, max_hour=:maxHour, rate_of_da=:rateOfDa, type=:type, status=:status, meta_remarks=:remark "
			+ "WHERE ind_for_da_id=:indForDaId ";
	
	String GET_ALL_TRVL_MOD_MST = "SELECT trvl_mod_id, trvl_mod, status, meta_remarks "
			+ "FROM emp_reimb.ecgc_hrd_tada_trvl_mod_mst";
	
	String INSERT_TRVL_MODE_MST = "INSERT INTO emp_reimb.ecgc_hrd_tada_trvl_mod_mst "
			+ "(trvl_mod_id, trvl_mod, status, created_by, created_dt, meta_remarks) "
			+ "VALUES(:trvlModId, :trvlMod, :status, :createdBy, :createdDt, :remark) ";
	
	String UPDATE_TRVL_MODE_MST = "UPDATE emp_reimb.ecgc_hrd_tada_trvl_mod_mst "
			+ "SET trvl_mod=:trvlMod, status=:status, last_updated_by=:lastUpdatedBy, last_updated_dt=:lastUpdatedDt, "
			+ "meta_remarks=:remark "
			+ "WHERE trvl_mod_id=:trvlModId ";
	
	String GET_ACTIVE_TRVL_MOD_MST = "SELECT trvl_mod_id, trvl_mod "
			+ "FROM emp_reimb.ecgc_hrd_tada_trvl_mod_mst where status='A' ";
	
	String GET_ALL_CITY_CLASS_MST = "SELECT city_cd, city, cat_cd_da, cat_cd_hotel "
			+ "FROM emp_reimb.ecgc_hrd_tada_city_class_mst ";
	
	String GET_CITY_DA_AMT_MST = "SELECT da_amt "
			+ "FROM emp_reimb.ecgc_hrd_tada_city_mst "
			+ "where rank_id=? AND city_class_da=?";
	
	String GET_CITY_HOTEL_AMT_MST = "SELECT hotel_amt "
			+ "FROM emp_reimb.ecgc_hrd_tada_city_mst "
			+ "where rank_id=? AND city_class_hotel=?";
	
	String GET_ALL_LODG_BORD_DA_MST = "SELECT tada_ind_lod_brd_id, description, rate_of_da, status, meta_remarks "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_lodging_boarding_mst";
	
	String INSERT_LODG_BORD_DA_MST = "INSERT INTO emp_reimb.ecgc_hrd_tada_ind_lodging_boarding_mst "
			+ "(tada_ind_lod_brd_id, description, rate_of_da, status, meta_remarks) "
			+ "VALUES(:lodgBoardingDaId, :description, :rateOfDa, :status, :remark) ";
}
