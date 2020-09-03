package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaCityMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class TadaCityMstDaoImpl implements TadaCityMstDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public TadaCityMst getTadaCityDaHotelAmt(String rankId, String cityClsDa, String cityClsHotel) {
		
		
		TadaCityMst tadaCity = jdbcOperations.queryForObject(TadaQueries.GET_CITY_DA_AMT_MST, new Object [] {rankId, cityClsDa},
		new RowMapper<TadaCityMst>(){
			@Override
			public TadaCityMst  mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				TadaCityMst objTadaCity = new TadaCityMst();
				objTadaCity.setDaAmt(rs.getInt("da_amt"));
				return objTadaCity;
			}
		});
		TadaCityMst tadaCityHotel = jdbcOperations.queryForObject(TadaQueries.GET_CITY_HOTEL_AMT_MST, new Object [] {rankId, cityClsHotel},
				new RowMapper<TadaCityMst>(){
					@Override
					public TadaCityMst  mapRow(ResultSet rs, int rowNum) throws SQLException{
						
						TadaCityMst objTadaCity = new TadaCityMst();
						objTadaCity.setHotelAmt(rs.getInt("hotel_amt"));
						return objTadaCity;
					}
				});
		tadaCity.setHotelAmt(tadaCityHotel.getHotelAmt());
		return tadaCity;
	}

}
