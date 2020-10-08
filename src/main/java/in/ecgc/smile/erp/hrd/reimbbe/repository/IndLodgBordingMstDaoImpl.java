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

import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class IndLodgBordingMstDaoImpl implements IndLodgBordingMstDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	/*Constructor for autowire jdbc and datasource*/
	@Autowired
	public IndLodgBordingMstDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<IndLodgBordingMst> getAllLodgBordingDa() {
		List<IndLodgBordingMst> indLodBordList = jdbcOperations.query(TadaQueries.GET_ALL_LODG_BORD_DA_MST, 
				 new RowMapper<IndLodgBordingMst>() {
			@Override
			public IndLodgBordingMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				IndLodgBordingMst indLodBord = new IndLodgBordingMst(); 
				indLodBord.setLodBordId(rs.getInt("tada_ind_lod_brd_id"));
				indLodBord.setDescription(rs.getString("description"));
				indLodBord.setRateOfDa(rs.getInt("rate_of_da"));
				indLodBord.setStatus(rs.getString("status"));
				indLodBord.setRemark(rs.getString("meta_remarks"));
				
				return indLodBord;
			}
		});
		return indLodBordList;
	}

	@Override
	public int saveLodgBoardingDa(IndLodgBordingMst lodgBoardingMst) {
		int lodgBoardingDaId = jdbcOperations.queryForObject("SELECT emp_reimb.ecgc_hrd_int_seq_no_tbl_func('tada_ind_lodg_bord_mst')", Integer.class);
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("lodgBoardingDaId", lodgBoardingDaId);
		namedParameters.put("description", lodgBoardingMst.getDescription());
		namedParameters.put("rateOfDa", lodgBoardingMst.getRateOfDa());
		namedParameters.put("status", lodgBoardingMst.getStatus());
		namedParameters.put("remark", lodgBoardingMst.getRemark());
		
		
		int result =namedParameterJdbcOperations.update(TadaQueries.INSERT_LODG_BORD_DA_MST, namedParameters);
		return result;
	}

	@Override
	public List<IndLodgBordingMst> getActiveLodgBordingDa() {
		
		return jdbcOperations.query(TadaQueries.GET_ACTIVE_LODG_BORD_DA_MST, 
				 new RowMapper<IndLodgBordingMst>() {
			@Override
			public IndLodgBordingMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				IndLodgBordingMst indLodBord = new IndLodgBordingMst(); 
				indLodBord.setLodBordId(rs.getInt("tada_ind_lod_brd_id"));
				indLodBord.setDescription(rs.getString("description"));
				indLodBord.setRateOfDa(rs.getInt("rate_of_da"));
				
				return indLodBord;
			}
		});
	}

	@Override
	public int updateLodgBoardingDa(IndLodgBordingMst lodgBoardingMst) {
		
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("lodgBoardingDaId", lodgBoardingMst.getLodBordId());
		namedParameters.put("description", lodgBoardingMst.getDescription());
		namedParameters.put("rateOfDa", lodgBoardingMst.getRateOfDa());
		namedParameters.put("status", lodgBoardingMst.getStatus());
		namedParameters.put("remark", lodgBoardingMst.getRemark());
		
		return namedParameterJdbcOperations.update(TadaQueries.UPDATE_LODG_BORD_DA_MST, namedParameters);
	}
}
