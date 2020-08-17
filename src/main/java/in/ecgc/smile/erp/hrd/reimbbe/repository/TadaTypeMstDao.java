package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaTypeMst;

public interface TadaTypeMstDao {

	public List<TadaTypeMst> getActiveTadaType();
	
	public List<TadaTypeMst> getActiveSubType(String type);
}
