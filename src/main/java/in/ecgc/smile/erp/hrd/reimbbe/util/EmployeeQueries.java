 package in.ecgc.smile.erp.hrd.reimbbe.util;

/**
 * A util interface for working with Queries.
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
public interface EmployeeQueries {

   
    
    String GET_EMPLOYEE_DEPENDENT_BY_ID_PROCESS = "SELECT emp_no, dependent_id, dependent_name, relation, dob, marital_status, process_name "
			+ "FROM public.\"ecgc_hrd_emp_dependent_trn\" WHERE emp_no=? AND process_name=?";
    
    
    String GET_EMPLOYEE_DEPENDENT_BY_DEPENDENT_ID = "SELECT dependent_id, emp_no, dependent_name, relation, dob, process_name "
			+ "FROM public.\"ecgc_hrd_emp_dependent_trn\" where dependent_id=?";
    
    
    String GET_EMPLOYEE_MST_DTL_BY_ID = "SELECT emp_no, emp_firstname,  emp_lastname,  emp_dob, gender, nationality, emp_type,  "
			+ " emp_status, class_cd, rank_cd FROM public.\"ecgc_hrd_emp_mst\"  WHERE emp_no=?";
}
