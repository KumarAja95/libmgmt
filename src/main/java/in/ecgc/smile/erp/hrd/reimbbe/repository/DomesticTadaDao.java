package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;

public interface DomesticTadaDao {

	public int saveDomesticTadaAdv(DomesticTada domTada);
	
	public List<DomesticTada> domesticAdvListForSet(int empNo);
	
	public DomesticTada domesticAdvForSet(int indTourId);
	
	public int saveDomesticTadaSet(DomesticTada domTada);
}
