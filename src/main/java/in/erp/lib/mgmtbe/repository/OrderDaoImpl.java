package in.erp.lib.mgmtbe.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import in.erp.lib.mgmtbe.model.Order;
import in.erp.lib.mgmtbe.util.OrderQueries;

@Repository
public class OrderDaoImpl implements OrderDao{

	private JdbcOperations jdbcOperations;
	
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	@Autowired
	public OrderDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
	}

	
	@Override
	public int returnBook(Order order) {
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("sctSubDt", order.getActualSubmitDt());
		namedParameters.put("chargeAmt", order.getChargeAmt());
		namedParameters.put("delayDays", order.getDelayOfDays());
		namedParameters.put("OrderId", order.getOrderId());
		
		int result =namedParameterJdbcOperations.update(OrderQueries.UPDATE_ORDER_BY_ID, namedParameters);
		return result;
	}

}
