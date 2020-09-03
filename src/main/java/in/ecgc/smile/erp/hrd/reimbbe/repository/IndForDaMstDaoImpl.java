package in.ecgc.smile.erp.hrd.reimbbe.repository;

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

import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class IndForDaMstDaoImpl implements IndForDaMstDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	/* For parameterized query */
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	/*Constructor for autowire jdbc and datasource*/
	@Autowired
	public IndForDaMstDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<IndForDaMst> getAllIndForDa() {
		
		List<IndForDaMst> indForDaList = jdbcOperations.query(TadaQueries.GET_ALL_IND_FOR_DA_MST, 
				 new RowMapper<IndForDaMst>() {
			@Override
			public IndForDaMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				IndForDaMst indForDa = new IndForDaMst(); 
				indForDa.setIndForDaId(rs.getInt("ind_for_da_id"));
				indForDa.setMinHour(rs.getInt("min_hour"));
				indForDa.setMaxHour(rs.getInt("max_hour"));
				indForDa.setRateOfDa(rs.getInt("rate_of_da"));
				indForDa.setType(rs.getString("type"));
				indForDa.setStatus(rs.getString("status"));
				
				return indForDa;
			}
		});
		return indForDaList;
	}

	@Override
	public int saveIndForDa(IndForDaMst indForDaMst) {
		
		int indForDaId=jdbcOperations.queryForObject("SELECT emp_reimb.ecgc_hrd_int_seq_no_tbl_func('tada_ind_for_da_mst')", Integer.class);
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("indForDaId", indForDaId);
		namedParameters.put("minHour", indForDaMst.getMinHour());
		namedParameters.put("maxHour", indForDaMst.getMaxHour());
		namedParameters.put("rateOfDa", indForDaMst.getRateOfDa());
		namedParameters.put("type", indForDaMst.getType());
		namedParameters.put("status", indForDaMst.getStatus());
		namedParameters.put("remark", indForDaMst.getRemark());
		
		int result =namedParameterJdbcOperations.update(TadaQueries.INSERT_IND_FOR_DA_MST, namedParameters);
		return result;
	}

	@Override
	public int updateIndForDa(IndForDaMst indForDaMst) {
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("indForDaId", indForDaMst.getIndForDaId());
		namedParameters.put("minHour", indForDaMst.getMinHour());
		namedParameters.put("maxHour", indForDaMst.getMaxHour());
		namedParameters.put("rateOfDa", indForDaMst.getRateOfDa());
		namedParameters.put("type", indForDaMst.getType());
		namedParameters.put("status", indForDaMst.getStatus());
		namedParameters.put("remark", indForDaMst.getRemark());
		
		int result =namedParameterJdbcOperations.update(TadaQueries.UPDATE_IND_FOR_DA_MST, namedParameters);
		return result;
	}

	@Override
	public List<IndForDaMst> getIndForDa(String type) {
		List<IndForDaMst> indForDaList = jdbcOperations.query(TadaQueries.GET_IND_FOR_DA_MST, new Object [] {type},
				 new RowMapper<IndForDaMst>() {
			@Override
			public IndForDaMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				IndForDaMst indForDa = new IndForDaMst(); 
				
				indForDa.setMinHour(rs.getInt("min_hour"));
				indForDa.setMaxHour(rs.getInt("max_hour"));
				indForDa.setRateOfDa(rs.getInt("rate_of_da"));
				
				return indForDa;
			}
		});
		return indForDaList;
	}

}
