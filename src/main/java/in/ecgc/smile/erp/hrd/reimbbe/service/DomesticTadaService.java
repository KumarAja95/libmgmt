package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;

public interface DomesticTadaService {

	public boolean addDomesticTadaAdv(DomesticTada domTada);
	
	public List<DomesticTada> domesticAdvListForSet(int empNo);
	
	public DomesticTada domesticAdvForSet(int indTourId);
	
	public boolean saveDomesticTadaSet(DomesticTada domTada);
}
