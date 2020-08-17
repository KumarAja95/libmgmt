package in.ecgc.smile.erp.hrd.reimbbe.util;

public interface EmployeeQueries {

	String GET_ACTIVE_TADA_TYPE = "SELECT DISTINCT type "
			+ "FROM emp_reimb.\"ecgc_hrd_tada_type_mst\" "
			+ "where status = true";
	
	String GET_ACTIVE_TADA_SUBTYPE = "SELECT sub_type "
			+ "FROM emp_reimb.\"ecgc_hrd_tada_type_mst\" "
			+ "where status = true and type=?";
}
