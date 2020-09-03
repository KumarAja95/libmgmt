package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;

public interface TravelModeMstService {

	public List<TravelModeMst> viewAllTrvlMode();
	
	public boolean addTrvlMode(TravelModeMst trvlModMst);
	
	public boolean modifyTrvlMode(TravelModeMst trvlModMst);
	
	public List<TravelModeMst> viewActiveTrvlMode();
}
