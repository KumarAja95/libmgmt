package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;

public interface IndForDaMstDao {

	public List<IndForDaMst> getAllIndForDa();
	
	public int saveIndForDa(IndForDaMst indForDaMst);
	
	public int updateIndForDa(IndForDaMst indForDaMst);
	
	public List<IndForDaMst> getIndForDa(String type);
}
