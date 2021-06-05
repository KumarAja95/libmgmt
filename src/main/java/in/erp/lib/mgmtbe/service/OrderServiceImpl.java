package in.erp.lib.mgmtbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.erp.lib.mgmtbe.model.Order;
import in.erp.lib.mgmtbe.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao dao;
	
	@Override
	public boolean returnBook(Order order) {
		
		return dao.returnBook(order)==1 ? true : false;
	}

}
