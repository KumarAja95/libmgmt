package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;

public interface IndForDaMstService {
	
	public List<IndForDaMst> viewAllIndForDa();
	
	public boolean addIndForDa(IndForDaMst indForDaMst);
	
	public boolean modifyIndForDa(IndForDaMst indForDaMst);
	
	public List<IndForDaMst> viewIndForDa(String type);

}
