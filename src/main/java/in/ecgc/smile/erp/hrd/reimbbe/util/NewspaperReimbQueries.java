package in.ecgc.smile.erp.hrd.reimbbe.util;

public interface NewspaperReimbQueries {
	
	
	String INSERT_ECGC_HRD_EXPENSES_REIMB_DTLS = "INSERT INTO public.\"ECGC_HRD_EXPENSES_REIMB_DTLS\" ( emp_no, expenses_elg_id, process_cd, financial_year, start_dt, end_dt, amt_claimed, approval_status) "
			   + "VALUES(  :empNo, :expEligId, :processCd, :financialYear, :startDt, :endDt, :amtClaimed, :approveStatus)";
	
	
	
	String UPDATE_ECGC_HRD_EXPENSES_REIMB_DTLS="UPDATE  public.\"ECGC_HRD_EXPENSES_REIMB_DTLS\" SET  approval_status= :approvalStatus , approved_dt= :approveDt , approved_amt= :approvedAmt, approval_remarks= :approveRemark "
	+"  WHERE app_no=:appNo";
	
	
	String INSERT_EXPENSES_REIMB_ELIGIBILITY_RECORD="INSERT INTO public.\"ECGC_HRD_EXPENSES_REIMB_ELIGIBILITY_MST\" ( rank_cd, process_cd, eligible_amt, financial_year, status) "
			   + "VALUES(  :rankCd, :processCd, :eligibleAmt, :financialYear, :status)";
	
	String GET_EXPENSES_REIMB_ELIGIBILITY_LIST="SELECT * FROM public.\"ECGC_HRD_EXPENSES_REIMB_ELIGIBILITY_MST\" WHERE rank_id=? and process_cd=?";
	
	String GET_EXPENSES_REIMB_ELIGIBILITY="SELECT * FROM public.\"ECGC_HRD_EXPENSES_REIMB_ELIGIBILITY_MST\"";
	
	String UPDATE_EXPENSES_REIMB_ELIGIBILITY="UPDATE  public.\"ECGC_HRD_EXPENSES_REIMB_ELIGIBILITY_MST\" SET rank_cd=:rankCd, process_cd=:processCd, eligible_amt=:eligibleAmt, financial_year=:financialYear, status= :status WHERE expenses_elgblty_id=:expEligId";

	
	String DELETE_EXPENSES_REIMB_ELIGIBILITY = "DELETE FROM public.\"ECGC_HRD_EXPENSES_REIMB_ELIGIBILITY_MST\" WHERE expenses_elgblty_id=?";

	String GET_NEWSPAPER_REIMB_LIST="SELECT * FROM public.\"ECGC_HRD_EXPENSES_REIMB_DTLS\"";
	
	String GET_NEWSPAPER_REIMB_BY_ID="SELECT * FROM public.\"ECGC_HRD_EXPENSES_REIMB_DTLS\" WHERE app_no=?";
}
