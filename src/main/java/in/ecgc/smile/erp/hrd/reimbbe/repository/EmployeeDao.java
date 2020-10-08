package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;



/**
 * Employee Repository interface
 * 
 * @Author Architecture Team C-DAC Mumbai
 */
public interface EmployeeDao {

	
	
	public List<EmployeeDependent> getDependentById(Integer empNo, String processName);
	
	public EmployeeDependent getDependentByDependentId(Integer depnId);
	
	public Employee getEmployeeById(Integer empNo);
}
