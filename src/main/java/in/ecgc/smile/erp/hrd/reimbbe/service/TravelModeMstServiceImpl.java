package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.TravelModeMstDao;

@Service
public class TravelModeMstServiceImpl implements TravelModeMstService{

	@Autowired
	private TravelModeMstDao dao;
	
	public TravelModeMstDao getDao() {
		return dao;
	}

	@Override
	public List<TravelModeMst> viewAllTrvlMode() {
		
		return getDao().getAllTrvlMode();
	}

	@Override
	public boolean addTrvlMode(TravelModeMst trvlModMst) {
		int result = getDao().saveTrvlMode(trvlModMst);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean modifyTrvlMode(TravelModeMst trvlModMst) {
		int result = getDao().updateTrvlMode(trvlModMst);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public List<TravelModeMst> viewActiveTrvlMode() {
		
		return getDao().getActiveTrvlMode();
	}

}
