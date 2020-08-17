package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.TadaTypeMstDao;

@Service
public class TadaTypeMstServiceImpl implements TadaTypeMstService{

	@Autowired
	private TadaTypeMstDao tadaTypeMstDao;
	
	@Override
	public List<TadaTypeMst> viewActiveTadaType() {
		
		return tadaTypeMstDao.getActiveTadaType();
	}

	@Override
	public List<TadaTypeMst> viewActiveTadaSubType(String type) {
		
		return tadaTypeMstDao.getActiveSubType(type);
	}

}
