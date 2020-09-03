package in.ecgc.smile.erp.hrd.reimbbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaCityMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.TadaCityMstDao;

@Service
public class TadaCityMstServiceImpl implements TadaCityMstService{

	@Autowired
	private TadaCityMstDao dao;
	
	public TadaCityMstDao getDao() {
		return dao;
	}

	@Override
	public TadaCityMst viewTadaCityDaHotelAmt(String rankId, String cityClsDa, String cityClsHotel) {
		
		return getDao().getTadaCityDaHotelAmt(rankId, cityClsDa, cityClsHotel);
	}

}
