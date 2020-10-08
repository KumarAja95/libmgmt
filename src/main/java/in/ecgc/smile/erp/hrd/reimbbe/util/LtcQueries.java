package in.ecgc.smile.erp.hrd.reimbbe.util;

public interface LtcQueries {

	String INSERT_LTC_ADV_RECORD = "INSERT INTO public.\"ECGC_HRD_LTC_TXN\" ( emp_no, application_dt,block_year, ltc_type, adv_settle_flg,"
			                 +" place_of_travel, total_fare, amount_claimed, travel_detail,leave_applied, year_of_travel )"
			                 +"VALUES ( :empNo, :appDate, :blockYear, :ltcType, :advSettleFlg,"
		                  	+" :placeOfTravel,  :totalFare, :amtClaimed, :travelDetail,:leaveApplied, :yearOfTravel) RETURNING ltc_txn_id";
	
	
	String INSERT_LTC_ADV_SET_RECORD = "INSERT INTO public.\"ECGC_HRD_LTC_TXN\" ( emp_no, application_dt,block_year, ltc_type, adv_settle_flg, onward_dt_of_journey,"
            +" onward_fare, return_dt_of_journey, return_fare, place_of_travel, total_fare, travel_detail, year_of_travel,journey_frm, journey_to, settlement_amt )"
            +"VALUES ( :empNo, :appDate, :blockYear, :ltcType, :advSettleFlg, :onwardDtOfJourney, :onwardFare, :returnDtOfJourney,  "
         	+":returnFare, :placeOfTravel,  :totalFare, :travelDetail, :yearOfTravel, :journeyFrm, :journeyTo, :settlementAmt) RETURNING ltc_txn_id";

	String INSERT_LTC_DIR_SET_RECORD = "INSERT INTO public.\"ECGC_HRD_LTC_TXN\" ( emp_no, application_dt,block_year, ltc_type, adv_settle_flg, onward_dt_of_journey,"
            +" onward_fare, return_dt_of_journey, return_fare, place_of_travel, total_fare, amount_claimed, travel_detail, year_of_travel ,journey_frm, journey_to)"
            +"VALUES ( :empNo, :appDate, :blockYear, :ltcType, :advSettleFlg, :onwardDtOfJourney, :onwardFare, :returnDtOfJourney,  "
         	+":returnFare, :placeOfTravel,  :totalFare, :amtClaimed, :travelDetail, :yearOfTravel, :journeyFrm, :journeyTo) RETURNING ltc_txn_id";

	String GET_LTC_ADVANCE_APPROVAL_LIST = "SELECT * FROM public.\"ECGC_HRD_LTC_TXN\" WHERE emp_no=?";
	
	String GET_LTC_APPLICATION_LIST=       "SELECT * FROM public.\"ECGC_HRD_LTC_TXN\" WHERE emp_no=? AND adv_Settle_flg=?";
	
	
	String GET_LTC_DATA_BY_LTCTXNID = "SELECT * FROM public.\"ECGC_HRD_LTC_TXN\" WHERE ltc_txn_id=?";
	
	String UPDATE_APPROVE_ADVANCE_SETTLEMENT = "UPDATE public.\"ECGC_HRD_LTC_TXN\" SET amount_approved=? ,approval_status=?,approved_by=?, approved_dt=?"
			+",aprv_remarks=?  WHERE ltc_txn_id=?";
	
	String ADD_LTC_MAPPING = "INSERT INTO public.\"HRD_LTC_TADA_ADV_SET_MAPPING\" (adv_id,set_id) values(?,?)";
	
	String INSERT_LTC_ELIGIBLTY_RECORD="INSERT INTO public.\"HRD_LTC_ELIGIBLTY_MST\" ( description, rank_id,travel_mode,travel_class,train_type, eff_date) "
			   + "VALUES( :description, :rankId, :travelMode, :travelClass, :trainType, :effDate)";
	
	String GET_LTC_ELIGIBLTY_LIST="SELECT * FROM public.\"HRD_LTC_ELIGIBLTY_MST\" WHERE rank_id=?";
	
	String GET_LTC_ELIGIBLTY="SELECT * FROM public.\"HRD_LTC_ELIGIBLTY_MST\"";
	
	String UPDATE_ELIGIBLTY_DATA="UPDATE  public.\"HRD_LTC_ELIGIBLTY_MST\" SET rank_id=?, description=?, travel_mode=?, travel_class=?, train_type=?, eff_date=?  WHERE ltc_no=?";

	String GET_LTC_ELIGIBLTY_BY_LTCNO="SELECT * FROM public.\"HRD_LTC_ELIGIBLTY_MST\" WHERE ltc_no=?";
	
	String DELETE__LTC__ELIGIBLITY_DATA = "DELETE FROM public.\"HRD_LTC_ELIGIBLTY_MST\" WHERE ltc_no=?";
	
	
    
    
    String INSERT_LTC_EMP_TRV_DATA="INSERT INTO public.\"ECGC_HRD_LTC_EMP_TRV_DTL\"(ltc_txn_id, emp_no , dep_travel_mode, dep_train_type, dep_travel_class, "
    		+" arr_travel_mode, arr_train_type, arr_travel_class, arr_fare_claimed, dep_fare_claimed, arr_fare_apprved, dep_fare_apprved)"
    		+"VALUES (:ltcTxnId, :empNo, :depTrvMode, :depTrainType, :depTrvClass,  :arrTrvMode, :arrTrainType, :arrTrvClass, :arrFareClaim, :depFareClaim, :arrFareAppr, :depFareAppr)";
    
    String INSERT_LTC_EMP_DEP_TRV_DATA="INSERT INTO public.\"ECGC_HRD_LTC_EMP_DEP_TRV_DTL\"(ltc_txn_id, emp_no , dependent_id, name_of_dependent, relation, dep_travel_mode, dep_train_type, dep_travel_class,  "
    		+" arr_travel_mode, arr_train_type, arr_travel_class , arr_fare_claimed, dep_fare_claimed,  arr_fare_apprved, dep_fare_apprved)"
    		+"VALUES (:ltcTxnId, :empNo , :dependentId, :dependentName, :relation, :depTrvMode, :depTrainType, :depTrvClass, :arrTrvMode, :arrTrainType, :arrTrvClass, :arrFareClaim, :depFareClaim,:arrFareAppr, :depFareAppr)";
   
    String GET_LTC_EMP_DEP_TRV_LIST="SELECT * FROM public.\"ECGC_HRD_LTC_EMP_DEP_TRV_DTL\" WHERE ltc_txn_id=?";
    
    String GET_LTC_EMP_TRV_DATA="SELECT * FROM public.\"ECGC_HRD_LTC_EMP_TRV_DTL\" WHERE ltc_txn_id=?";
    
    
    String UPDATE_LTC_EMP_DEP_TRV_DATA="UPDATE public.\"ECGC_HRD_LTC_EMP_DEP_TRV_DTL\"  SET dep_fare_apprved=?, arr_fare_apprved=? WHERE ltc_emp_dep_trv_id=?";

    String UPDATE_LTC_EMP_TRV_DATA="UPDATE public.\"ECGC_HRD_LTC_EMP_TRV_DTL\"  SET dep_fare_apprved=?, arr_fare_apprved=? WHERE ltc_emp_trv_id=?";

   String UPDATE_LTC_APP_FOR_CHECK="UPDATE public.\"ECGC_HRD_LTC_TXN\" SET   block_year=:blockYear, ltc_type=:ltcType, " 
   		           + "onward_fare= :onwardFare,  return_fare=:returnFare, place_of_travel=:placeOfTravel, total_fare= :totalFare," 
   		         	+ "amount_claimed=:amtClaimed, travel_detail= :travelDetail, year_of_travel=:yearOfTravel ,journey_frm=:journeyFrm, journey_to =:journeyTo, settlement_amt=:settlementAmt WHERE ltc_txn_id=:ltcTxnId";


   String INSERT_LTC_EXTENTION_DATA="INSERT INTO public.\"ECGC_HRD_LTC_EXTENTION\"( emp_no , block_year, extention_year, extention_status, reason_of_extension,application_dt )"
   		+"VALUES ( :empNo, :blockYear, :extentionYear, :extentionStatus,  :reasonOfExtention,:appliDate)";
   
   
   String UPDATE_LTC_EXTENTION_APPROVAL ="UPDATE public.\"ECGC_HRD_LTC_EXTENTION\" SET approval_status=? where ltc_extention_id=?";
   

    String GET_LTC_EXTENTION_DATA =  "SELECT * FROM public.\"ECGC_HRD_LTC_EXTENTION\" where ltc_extention_id=?";
    
    String GET_LTC_EXTENTION_LIST =  "SELECT * FROM public.\"ECGC_HRD_LTC_EXTENTION\" where emp_no=?";

    String GET_LTC_BLOCK_YEAR_LIST =  "SELECT block_year FROM public.\"HRD_LTC_BLOCK_YEAR_MST\"" ;

    String GET_LTC_ELIGI_TRAVEL_MODE = "SELECT DISTINCT  travel_mode FROM public.\"HRD_LTC_ELIGIBLTY_MST\" ";
    
    String GET_LTC_ELIGI_TRAVEL_CLASS = "SELECT DISTINCT travel_class  FROM public.\"HRD_LTC_ELIGIBLTY_MST\" ";
    
    String GET_LTC_ELIGI_TRAIN_TYPE = "SELECT DISTINCT train_type FROM public.\"HRD_LTC_ELIGIBLTY_MST\" WHERE travel_mode=?";


    String GET_LTC_ELIGI_TRAVEL_CLASS1 = "SELECT DISTINCT travel_class  FROM public.\"HRD_LTC_ELIGIBLTY_MST\" WHERE travel_mode=?";
    

    String UPDATE_LTC_EMP_TRV_DATA_FOR_CHECK = "UPDATE public.\"ECGC_HRD_LTC_EMP_TRV_DTL\" SET   dep_travel_mode=:depTravMode, dep_Train_type=:depTrainType, " 
	           + "dep_travel_class= :depTravClass,  dep_fare_claimed=:depFareClaim,  arr_travel_mode=:arrTravMode, arr_Train_type=:arrTrainType,"
	           	           + "arr_travel_class= :arrTravClass,  arr_fare_claimed=:arrFareClaim  WHERE ltc_emp_trv_id=:ltcEmpTrvId";



    String UPDATE_LTC_EMP_DEP_TRV_DATA_FOR_CHECK = "UPDATE public.\"ECGC_HRD_LTC_EMP_DEP_TRV_DTL\" SET   dep_travel_mode=:depTravMode, dep_Train_type=:depTrainType, " 
	           + "dep_travel_class= :depTravClass,  dep_fare_claimed=:depFareClaim,  arr_travel_mode=:arrTravMode, arr_Train_type=:arrTrainType,"
	           	           + "arr_travel_class= :arrTravClass,  arr_fare_claimed=:arrFareClaim  WHERE ltc_emp_dep_trv_id=:ltcEmpDepTrvId";


}


