 package in.ecgc.smile.erp.hrd.reimbbe.util;

/**
 * A util interface for working with Queries.
 * @Author Ajay Kumar
 */
public interface EmployeeQueries {
    
    String GET_EMPLOYEE_MST_DTL_BY_ID = "SELECT emp_no, emp_firstname,  emp_lastname,  emp_dob, gender, nationality, emp_type,  "
			+ " emp_status, class_cd, rank_cd FROM public.\"ecgc_hrd_emp_mst\"  WHERE emp_no=?";
}
