package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
public interface EmployeeService {
	
	
	
	
	public List<EmployeeDependent> viewDependdentById(Integer empNo, String processName);
	
	public EmployeeDependent viewDependentByDependentId(Integer dependentId);
	
	public Employee viewEmployeeById(Integer empNo);

}
