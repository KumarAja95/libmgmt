package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;
import in.ecgc.smile.erp.hrd.reimbbe.repository.EmployeeDao;



/**
 * Employee Service implementation
 *  
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	private EmployeeDao dao;
	
	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	
	



	@Override
	public List<EmployeeDependent> viewDependdentById(Integer empNo, String processName) {
		return dao.getDependentById(empNo, processName);
	}

	@Override
	public EmployeeDependent viewDependentByDependentId(Integer dependentId) {
		return dao.getDependentByDependentId(dependentId);
	}

	@Override
	public Employee viewEmployeeById(Integer empNo) {
		return dao.getEmployeeById(empNo);
	}

}
