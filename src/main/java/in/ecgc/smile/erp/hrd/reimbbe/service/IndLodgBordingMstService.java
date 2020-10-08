package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;

public interface IndLodgBordingMstService {

	public List<IndLodgBordingMst> viewAllLodgBordingDa();
	
	public boolean addLodgBoardingDa(IndLodgBordingMst lodgBoardingMst);
	
	public List<IndLodgBordingMst> viewActiveLodgBordingDa();
	
	public boolean modifyLodgBoardingDa(IndLodgBordingMst lodgBoardingMst);
}
