package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndLodgBordingMst;

public interface IndLodgBordingMstDao {

	public List<IndLodgBordingMst> getAllLodgBordingDa();
	
	public int saveLodgBoardingDa(IndLodgBordingMst lodgBoardingMst);
}