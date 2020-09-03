package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class TadaTypeMstDaoImpl implements TadaTypeMstDao{

	@Autowired(required =true)
	private JdbcOperations jdbcOperations;
	
	@Override
	public List<TadaTypeMst> getActiveTadaType() {
		List<TadaTypeMst> tadaTypeList = jdbcOperations.query(TadaQueries.GET_ACTIVE_TADA_TYPE, new RowMapper<TadaTypeMst>() {

			@Override
			public TadaTypeMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				TadaTypeMst tadaType = new TadaTypeMst();
				tadaType.setType(rs.getString("type"));
				
				return tadaType;
			}
	
	});
		return tadaTypeList;
	}

	@Override
	public List<TadaTypeMst> getActiveSubType(String type) {
		List<TadaTypeMst> tadaSubTypeList = jdbcOperations.query(TadaQueries.GET_ACTIVE_TADA_SUBTYPE, 
				new Object[] {type}, new RowMapper<TadaTypeMst>() {

			@Override
			public TadaTypeMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				TadaTypeMst tadaSubType = new TadaTypeMst();
				tadaSubType.setSubType(rs.getString("sub_type"));
				return tadaSubType;
			}
	});
		return tadaSubTypeList;
	}

}
