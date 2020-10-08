package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.ExpensesReimbMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.NewspaperReimb;
import in.ecgc.smile.erp.hrd.reimbbe.util.NewspaperReimbQueries;



@Repository
public class NewspaperReimbDaoImpl implements NewspaperReimbDao{
	
	
	private JdbcOperations jdbcOperations;
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	@Autowired
	public NewspaperReimbDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
		
	}

	@Override
	public ExpensesReimbMst getExpensesMstList(int rankId, String processCd) {
		
		ExpensesReimbMst expenseReimb;
		try {
			expenseReimb =(ExpensesReimbMst) jdbcOperations.query(NewspaperReimbQueries.GET_EXPENSES_REIMB_ELIGIBILITY,new Object[] { rankId, processCd },new RowMapper<ExpensesReimbMst>() {

			@Override
			public ExpensesReimbMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				ExpensesReimbMst expensesReimbMst=new ExpensesReimbMst();
				expensesReimbMst.setExpEligId(rs.getInt("expenses_elgblty_id"));
				expensesReimbMst.setRankCd(rs.getInt("rank_cd"));
				expensesReimbMst.setEligiAmt(rs.getBigDecimal("eligible_amt"));
				expensesReimbMst.setFinancialYear(rs.getString("financial_year"));
				expensesReimbMst.setStatus(rs.getString("status"));
				expensesReimbMst.setProcessCd(rs.getString("process_cd"));
				return expensesReimbMst;
			}
		});
		}catch(Exception e) {
		
			expenseReimb=null;
		}
		return expenseReimb;
	}
		
	
	

	@Override
	public List<ExpensesReimbMst> getExpensesMstList() {
		List<ExpensesReimbMst> list;
		try {
		  list =jdbcOperations.query(NewspaperReimbQueries.GET_EXPENSES_REIMB_ELIGIBILITY,new RowMapper<ExpensesReimbMst>() {

			@Override
			public ExpensesReimbMst mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				ExpensesReimbMst expensesReimbMst=new ExpensesReimbMst();
				expensesReimbMst.setExpEligId(rs.getInt("expenses_elgblty_id"));
				expensesReimbMst.setRankCd(rs.getInt("rank_cd"));
				expensesReimbMst.setEligiAmt(rs.getBigDecimal("eligible_amt"));
				expensesReimbMst.setFinancialYear(rs.getString("financial_year"));
				expensesReimbMst.setStatus(rs.getString("status"));
				expensesReimbMst.setProcessCd(rs.getString("process_cd"));
				System.out.println(expensesReimbMst);
				return expensesReimbMst;
			}
		});
		}catch(Exception e) {
		
			list=null;
		}
		return list;
	}

	@Override
	public int addExpensesMstdata(ExpensesReimbMst expensesReimbMst) {
		//Date createdDt=Date.valueOf(expensesReimbMst.getCreatedDt());
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  
	       namedParameters.put("rankCd", expensesReimbMst.getRankCd());
		   namedParameters.put("eligibleAmt", expensesReimbMst.getEligiAmt() );
		   namedParameters.put("financialYear", expensesReimbMst.getFinancialYear() );
	       namedParameters.put("processCd", expensesReimbMst.getProcessCd());
	       namedParameters.put("status",  expensesReimbMst.getStatus());
		  // namedParameters.put("createdDt", createdDt);
		  // namedParameters.put("CreatedBy", expensesReimbMst.getCreatedBy());
		  
		   try {
				  int result =namedParameterJdbcOperations.update(NewspaperReimbQueries.INSERT_EXPENSES_REIMB_ELIGIBILITY_RECORD,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}

	@Override
	public int updateExpensesMst(ExpensesReimbMst expensesReimbMst) {
		//Date updateDt=Date.valueOf(expensesReimbMst.getLastUpdateDt());
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  namedParameters.put("expEligId", expensesReimbMst.getExpEligId());
	       namedParameters.put("rankCd", expensesReimbMst.getRankCd());
		   namedParameters.put("eligibleAmt", expensesReimbMst.getEligiAmt() );
		   namedParameters.put("financialYear", expensesReimbMst.getFinancialYear() );
	       namedParameters.put("processCd", expensesReimbMst.getProcessCd());
	       namedParameters.put("status",  expensesReimbMst.getStatus());
		 //  namedParameters.put("updatedDt", updateDt);
		 //  namedParameters.put("updatedBy", expensesReimbMst.getCreatedBy());
		   
		  
		   try {
				  int result =namedParameterJdbcOperations.update(NewspaperReimbQueries.UPDATE_EXPENSES_REIMB_ELIGIBILITY,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}

	

	@Override
	public int deleteLtcExpensesMst(int expEligId) {
		try {
			  int result =jdbcOperations.update(NewspaperReimbQueries.DELETE_EXPENSES_REIMB_ELIGIBILITY, expEligId); 
			  System.out.println(result);
			  return result; 
	       }catch(Exception e) { 
		    System.out.println(e);
		    
		    e.printStackTrace(); 
	        }
	 
	return 0;
	}

	@Override
	public int addNewspaperReimbData(NewspaperReimb newspaperReimb) {
		System.out.println(newspaperReimb);
		//Date createdDt=Date.valueOf(newspaperReimb.getCreatedDt());
		  Date startDt=Date.valueOf(newspaperReimb.getStartDt());
		  Date endDt=Date.valueOf(newspaperReimb.getEndDt());
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  
	       namedParameters.put("empNo", newspaperReimb.getEmpNo());
	       
		   namedParameters.put("expEligId", newspaperReimb.getExpEligId() );
		   namedParameters.put("financialYear", newspaperReimb.getFinancialYear() );
	       namedParameters.put("processCd", newspaperReimb.getProcessCd());
	       namedParameters.put("approveStatus",  newspaperReimb.getApproveStatus());
	       namedParameters.put("startDt", startDt );
	       namedParameters.put("endDt", endDt);
	       namedParameters.put("amtClaimed",  newspaperReimb.getAmtClaimed());
		  
		  
		   try {
				  int result =namedParameterJdbcOperations.update(NewspaperReimbQueries.INSERT_ECGC_HRD_EXPENSES_REIMB_DTLS,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}

	@Override
	public int updateNewspaperReimb(NewspaperReimb newspaperReimb) {
	
		  Date approveDt=Date.valueOf(newspaperReimb.getApprovedDt());
		  
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  namedParameters.put("appNo", newspaperReimb.getAppNo());
		  namedParameters.put("approvalStatus", newspaperReimb.getApproveStatus());
		  namedParameters.put("approveDt", approveDt);
		  namedParameters.put("approvedAmt", newspaperReimb.getAmtApproved());
		  namedParameters.put("approveRemark", newspaperReimb.getApproveRemark());
		  
		  
		  
		   try {
				  int result =namedParameterJdbcOperations.update(NewspaperReimbQueries.UPDATE_ECGC_HRD_EXPENSES_REIMB_DTLS,namedParameters); 
				  System.out.println(result);
				  return result;
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
	}

	@Override
	public List<NewspaperReimb> getNewspaperReimbList(String processCd) {
		List<NewspaperReimb> list;
		try {
		  list =jdbcOperations.query(NewspaperReimbQueries.GET_NEWSPAPER_REIMB_LIST,new RowMapper<NewspaperReimb>() {

			@Override
			public NewspaperReimb mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				NewspaperReimb newspaperReimb=new NewspaperReimb();
				newspaperReimb.setAppNo(rs.getInt("app_no"));
				newspaperReimb.setEmpNo(rs.getInt("emp_no"));
				newspaperReimb.setStartDt(rs.getString("start_dt"));
				newspaperReimb.setEndDt(rs.getString("end_dt"));
				newspaperReimb.setFinancialYear(rs.getString("financial_year"));
				newspaperReimb.setAmtClaimed(rs.getDouble("amt_claimed"));
				newspaperReimb.setApproveStatus(rs.getString("approval_status"));
				System.out.println(newspaperReimb);
				return newspaperReimb;
			}
		});
		}catch(Exception e) {
		
			list=null;
		}
		return list;
	}

	@Override
	public NewspaperReimb getNewspaperReimbByAppNo(int appNo) {
		NewspaperReimb news;
		try {
		news  =jdbcOperations.queryForObject(NewspaperReimbQueries.GET_NEWSPAPER_REIMB_BY_ID,new Object[] {appNo},new RowMapper<NewspaperReimb>() {

			@Override
			public NewspaperReimb mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				NewspaperReimb newspaperReimb=new NewspaperReimb();
				newspaperReimb.setAppNo(rs.getInt("app_no"));
				newspaperReimb.setEmpNo(rs.getInt("emp_no"));
				newspaperReimb.setStartDt(rs.getString("start_dt"));
				newspaperReimb.setEndDt(rs.getString("end_dt"));
				newspaperReimb.setFinancialYear(rs.getString("financial_year"));
				newspaperReimb.setAmtClaimed(rs.getDouble("amt_claimed"));
				newspaperReimb.setApproveStatus(rs.getString("approval_status"));
				System.out.println(newspaperReimb);
				return newspaperReimb;
			}
		});
		}catch(Exception e) {
		
			news=null;
		}
		return news;
	}
	

	
	
	
	
    
	

}
