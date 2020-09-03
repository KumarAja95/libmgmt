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

import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class TravelModeMstDaoImpl implements TravelModeMstDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	/* For parameterized query */
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	/*Constructor for autowire jdbc and datasource*/
	@Autowired
	public TravelModeMstDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<TravelModeMst> getAllTrvlMode() {
		List<TravelModeMst> trvlModList = jdbcOperations.query(TadaQueries.GET_ALL_TRVL_MOD_MST, 
				 new RowMapper<TravelModeMst>() {
			@Override
			public TravelModeMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				TravelModeMst trvlMod = new TravelModeMst(); 
				trvlMod.setTrvlModId(rs.getString("trvl_mod_id"));
				trvlMod.setTrvlMod(rs.getString("trvl_mod"));
				trvlMod.setStatus(rs.getString("status"));
				trvlMod.setRemark(rs.getString("meta_remarks"));
				
				return trvlMod;
			}
		});
		return trvlModList;
	}

	@Override
	public int saveTrvlMode(TravelModeMst trvlModMst) {
		
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("trvlModId", trvlModMst.getTrvlModId());
		namedParameters.put("trvlMod", trvlModMst.getTrvlMod());
		namedParameters.put("status", trvlModMst.getStatus());
		namedParameters.put("createdBy", trvlModMst.getCreatedBy());
		namedParameters.put("createdDt", trvlModMst.getCreatedDt());
		namedParameters.put("remark", trvlModMst.getRemark());
		
		
		int result =namedParameterJdbcOperations.update(TadaQueries.INSERT_TRVL_MODE_MST, namedParameters);
		return result;
	}

	@Override
	public int updateTrvlMode(TravelModeMst trvlModMst) {
		
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("trvlModId", trvlModMst.getTrvlModId());
		namedParameters.put("trvlMod", trvlModMst.getTrvlMod());
		namedParameters.put("status", trvlModMst.getStatus());
		namedParameters.put("lastUpdatedBy", trvlModMst.getLastUpdatedBy());
		namedParameters.put("lastUpdatedDt", trvlModMst.getLastUpdatedDt());
		namedParameters.put("remark", trvlModMst.getRemark());
		
		
		int result =namedParameterJdbcOperations.update(TadaQueries.UPDATE_TRVL_MODE_MST, namedParameters);
		return result;
	}

	@Override
	public List<TravelModeMst> getActiveTrvlMode() {
		List<TravelModeMst> trvlModList = jdbcOperations.query(TadaQueries.GET_ACTIVE_TRVL_MOD_MST, 
				 new RowMapper<TravelModeMst>() {
			@Override
			public TravelModeMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				TravelModeMst trvlMod = new TravelModeMst(); 
				trvlMod.setTrvlModId(rs.getString("trvl_mod_id"));
				trvlMod.setTrvlMod(rs.getString("trvl_mod"));
				
				return trvlMod;
			}
		});
		return trvlModList;
	}

}
