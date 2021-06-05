package in.erp.lib.mgmtbe.repository;

import in.erp.lib.mgmtbe.model.Customer;



/**
 * Customer Repository interface
 * 
 * @Author Ajay Kumar
 */
public interface CustomerDao {

	
	public Customer getCustomerById(Integer empNo);
}
