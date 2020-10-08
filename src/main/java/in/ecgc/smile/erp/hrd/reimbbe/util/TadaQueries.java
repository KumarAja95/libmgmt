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
	
	String GET_ACTIVE_LODG_BORD_DA_MST = "SELECT tada_ind_lod_brd_id, description, rate_of_da "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_lodging_boarding_mst WHERE status='A'";
	
	String INSERT_LODG_BORD_DA_MST = "INSERT INTO emp_reimb.ecgc_hrd_tada_ind_lodging_boarding_mst "
			+ "(tada_ind_lod_brd_id, description, rate_of_da, status, meta_remarks) "
			+ "VALUES(:lodgBoardingDaId, :description, :rateOfDa, :status, :remark) ";
	
	String UPDATE_LODG_BORD_DA_MST = "UPDATE emp_reimb.ecgc_hrd_tada_ind_lodging_boarding_mst "
			+ "SET description=:description, rate_of_da=:rateOfDa, status=:status, meta_remarks=:remark "
			+ "WHERE tada_ind_lod_brd_id=:lodgBoardingDaId";
	
	String INSERT_DOMESTIC_TADA_DTL = "INSERT INTO emp_reimb.ecgc_hrd_tada_ind_dtl_trn "
			+ "(ind_tour_id, adv_settle_flg, emp_no, purpose, tour_type, dep_dt, dep_travel_mode, dep_train_type, dep_travel_class, "
			+ "arr_dt, arr_travel_mode, arr_train_type, arr_travel_class, dep_fare, total_expenses, amt_claimed, arr_fare, days_period, act_work_days, city_name, "
			+ "application_date, oth_exp, total_da, eligible_da, conveyance_exp, hotel_exp, hotel_tax, city_class, city_category_id, "
			+ "act_dep_to_time, dep_dt_tm, dep_from_tm_time, arrival_tm_time, arr_tm_dt, office_accommodation, boarding_lodging, "
			+ "ret_dep_tm_time, ret_dep_tm_dt, ret_arr_tm_time, ret_arr_tm_dt, arr_time) "
			+ "VALUES(:indTourId, :advSetFlg, :empNo, :purpose, :tourType, :depdt, :depTrvlMode, :depTrainType, :depTrvlClss, "
			+ ":arrDt, :arrTrvlMode, :arrTrainType, :arrTrvlClss, :depfare, :totalExp, :amtClaimed, :arrFare, :daysPeriod, :actWrkDays, :city, "
			+ ":applicationDt, :othExp, :totalDa, :eligibleDa, :conveyanceExp, :hotelExp, :hotelTax, :cityClss, :cityCatgId, "
			+ "to_timestamp(:actDepTime, 'hh24:mi'), to_timestamp(:depdtTm, 'hh24:mi'), to_timestamp(:depTmTime, 'hh24:mi'), to_timestamp(:arrTmTime, 'hh24:mi'), "
			+ ":arrTmDt, :officeAccomo, :boardingLodging, "
			+ "to_timestamp(:retDepTmTime, 'hh24:mi'), :retDepTmDate, to_timestamp(:retArrTmTime, 'hh24:mi'), :retArrTmDate, to_timestamp(:arrTime, 'hh24:mi'))";
	
	String SELECT_DOMESTIC_ADV_FOR_SET = "SELECT ind_tour_id, emp_no, purpose, tour_type, total_expenses, amt_claimed, application_date, total_appr "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_dtl_trn int_dtl_trn "
			+ "LEFT JOIN emp_reimb.hrd_ltc_tada_adv_set_mapping_trn adv_set_map_trn on  int_dtl_trn.ind_tour_id = adv_set_map_trn.adv_id "
			+ "where adv_set_map_trn.adv_id is null and int_dtl_trn.emp_no=? and int_dtl_trn.adv_settle_flg='A';";

	String SELECT_DOMESTIC_ADV_BY_TOUR_ID = "SELECT ind_tour_id, emp_no, purpose, tour_type, dep_dt, dep_travel_mode, dep_train_type, "
			+ "dep_travel_class, arr_dt, arr_travel_mode, arr_train_type, arr_travel_class, dep_fare, total_expenses, amt_claimed, "
			+ "amt_approved, arr_fare, days_period, act_work_days, city_name, application_date, oth_exp, total_da, eligible_da, "
			+ "conveyance_exp, hotel_exp, hotel_tax, city_class, city_category_id, act_dep_to_time, dep_dt_tm, dep_from_tm_time, "
			+ "arrival_tm_time, arr_tm_dt, office_accommodation, boarding_lodging, ret_dep_tm_time, ret_dep_tm_dt, ret_arr_tm_time, "
			+ "ret_arr_tm_dt, arr_time "
			+ "FROM emp_reimb.ecgc_hrd_tada_ind_dtl_trn "
			+ "WHERE ind_tour_id=?";
	
	String INSERT_ADV_SET_MAPPING = "INSERT INTO emp_reimb.hrd_ltc_tada_adv_set_mapping_trn "
			+ "(adv_set_id, process_id, set_id, adv_id) "
			+ "VALUES(:advSetId, :process, :setId, :advId)";
}
