package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;

public interface TadaTypeMstService {

	public List<TadaTypeMst> viewActiveTadaType();
	
	public List<TadaTypeMst> viewActiveTadaSubType(String type);
}
