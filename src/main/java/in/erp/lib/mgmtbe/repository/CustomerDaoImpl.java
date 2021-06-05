package in.erp.lib.mgmtbe.repository;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.erp.lib.mgmtbe.model.Customer;







@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	
	private JdbcOperations jdbcOperations;
	
	
	@Autowired
	public CustomerDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		
		
	}

	

	
		
	@Override
	public Customer getCustomerById(Integer empNo) {
		 
		return new Customer();
	}
	

}
