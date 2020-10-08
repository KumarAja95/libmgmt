package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.IndLodgBordingMstDao;

@Service
public class IndLodgBordingMstServiceImpl implements IndLodgBordingMstService{

	@Autowired
	private IndLodgBordingMstDao dao;
	
	public IndLodgBordingMstDao getDao() {
		return dao;
	}

	@Override
	public List<IndLodgBordingMst> viewAllLodgBordingDa() {
		
		return getDao().getAllLodgBordingDa();
	}

	@Override
	public boolean addLodgBoardingDa(IndLodgBordingMst lodgBoardingMst) {
		int result = getDao().saveLodgBoardingDa(lodgBoardingMst);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public List<IndLodgBordingMst> viewActiveLodgBordingDa() {
		
		return getDao().getActiveLodgBordingDa();
	}

	@Override
	public boolean modifyLodgBoardingDa(IndLodgBordingMst lodgBoardingMst) {

		return (getDao().updateLodgBoardingDa(lodgBoardingMst) == 1 ? true : false);
	}

}
