package in.ecgc.smile.erp.hrd.reimbbe.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.Employee;
import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;
import in.ecgc.smile.erp.hrd.reimbbe.util.EmployeeQueries;







@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	private JdbcOperations jdbcOperations;
	
	
	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		
		
	}

	

	
	@Override
	public List<EmployeeDependent> getDependentById(Integer empNo, String processName) { 
		
		List<EmployeeDependent> depnList=jdbcOperations.query(EmployeeQueries.GET_EMPLOYEE_DEPENDENT_BY_ID_PROCESS, 
				new Object[] {empNo, processName}, new RowMapper<EmployeeDependent>() {

			@Override
			public EmployeeDependent mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeDependent empDepn=new EmployeeDependent();
				empDepn.setEmpNo(rs.getInt("emp_no"));
				empDepn.setDependentId(rs.getInt("dependent_id"));
				empDepn.setProcessName(rs.getString("process_name"));
				empDepn.setDependentName(rs.getString("dependent_name"));
				empDepn.setRelation(rs.getString("relation"));
				empDepn.setDob(rs.getDate("dob"));
				empDepn.setMaritalStatus(rs.getString("marital_status"));
				return empDepn;
			}
		});

		return depnList;
	}
	
	@Override
	public EmployeeDependent getDependentByDependentId(Integer depnId) {
		
		EmployeeDependent dependent=jdbcOperations.queryForObject(EmployeeQueries.GET_EMPLOYEE_DEPENDENT_BY_DEPENDENT_ID, 
				new Object[] {depnId}, new RowMapper<EmployeeDependent>() {

			@Override
			public EmployeeDependent mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeDependent empDepn=new EmployeeDependent();
				empDepn.setEmpNo(rs.getInt("emp_no"));
				empDepn.setDependentId(rs.getInt("dependent_id"));
				empDepn.setProcessName(rs.getString("process_name"));
				empDepn.setDependentName(rs.getString("dependent_name"));
				empDepn.setRelation(rs.getString("relation"));
				empDepn.setDob(rs.getDate("dob"));
				return empDepn;
			}
		});
		return dependent;
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
