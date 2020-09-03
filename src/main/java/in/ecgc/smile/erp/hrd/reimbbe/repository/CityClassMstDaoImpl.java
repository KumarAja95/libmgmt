package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.CityClassMst;
import in.ecgc.smile.erp.hrd.reimbbe.util.TadaQueries;

@Repository
public class CityClassMstDaoImpl implements CityClassMstDao{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public List<CityClassMst> getAllCityAndClass() {
		List<CityClassMst> cityClassList = jdbcOperations.query(TadaQueries.GET_ALL_CITY_CLASS_MST, 
				 new RowMapper<CityClassMst>() {
			@Override
			public CityClassMst mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityClassMst cityClass = new CityClassMst(); 
				cityClass.setCityCd(rs.getString("city_cd"));
				cityClass.setCity(rs.getString("city"));
				cityClass.setCatCdDa(rs.getString("cat_cd_da"));
				cityClass.setCatCdHotel(rs.getString("cat_cd_hotel"));
				
				return cityClass;
			}
		});
		return cityClassList;
	}
	
	

}
