package in.erp.lib.mgmtbe.service;

import in.erp.lib.mgmtbe.model.Customer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
public interface CustomerService {
	
	public Customer viewCustomerById(Integer customerId);

}
