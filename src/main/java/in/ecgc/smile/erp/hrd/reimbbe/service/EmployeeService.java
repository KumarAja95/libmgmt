package in.ecgc.smile.erp.hrd.reimbbe.service;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
public interface EmployeeService {
	
	public Employee viewEmployeeById(Integer empNo);

}
