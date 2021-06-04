package in.ecgc.smile.erp.hrd.reimbbe.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.util.EmployeeQueries;







@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	private JdbcOperations jdbcOperations;
	
	
	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		
		
	}

	

	
		
	@Override
	public Employee getEmployeeById(Integer empNo) {
		

		
		Employee employeeData = jdbcOperations.queryForObject(EmployeeQueries.GET_EMPLOYEE_MST_DTL_BY_ID, new Object[] {empNo}, new RowMapper<Employee>() {
			
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee(); 
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setFirstName(rs.getString("emp_firstname"));
			    employee.setLastName(rs.getString("emp_lastname"));
				employee.setGender(rs.getString("gender"));
				employee.setDob(rs.getDate("emp_dob"));
				employee.setNationality(rs.getString("nationality"));
				employee.setEmpType(rs.getString("emp_type"));
		        employee.setStatusCd(rs.getString("emp_status"));
				employee.setRankId(rs.getString("rank_cd"));
				
				
			
				
				return employee;
			}
		});
		
			
		
		 
		return employeeData;
	}
	

}
