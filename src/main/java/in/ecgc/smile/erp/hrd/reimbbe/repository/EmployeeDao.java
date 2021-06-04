package in.ecgc.smile.erp.hrd.reimbbe.repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;



/**
 * Employee Repository interface
 * 
 * @Author Ajay Kumar
 */
public interface EmployeeDao {

	
	public Employee getEmployeeById(Integer empNo);
}
