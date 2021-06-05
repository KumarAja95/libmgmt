package in.erp.lib.mgmtbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.erp.lib.mgmtbe.model.Customer;
import in.erp.lib.mgmtbe.repository.CustomerDao;



/**
 * Employee Service implementation
 *  
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired(required = true)
	private CustomerDao dao;

	@Override
	public Customer viewCustomerById(Integer customerId) {
		
		return dao.getCustomerById(customerId);
	}
	
	

}
