package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.TravelModeMst;

public interface TravelModeMstDao {

	public List<TravelModeMst> getAllTrvlMode();
	
	public int saveTrvlMode(TravelModeMst trvlModMst);
	
	public int updateTrvlMode(TravelModeMst trvlModMst);
	
	public List<TravelModeMst> getActiveTrvlMode();
}
