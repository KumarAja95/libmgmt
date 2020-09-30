package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.DomesticTada;
import in.ecgc.smile.erp.hrd.reimbbe.repository.DomesticTadaDao;

@Service
public class DomesticTadaServiceImpl implements DomesticTadaService {

	@Autowired
	private DomesticTadaDao dao;
	
	public DomesticTadaDao getDao() {
		return dao;
	}

	@Override
	public boolean addDomesticTadaAdv(DomesticTada domTada) {
		int result = getDao().saveDomesticTadaAdv(domTada);
		return (result == 1 ? true : false);
	}

	@Override
	public List<DomesticTada> domesticAdvListForSet(int empNo) {
		
		return getDao().domesticAdvListForSet(empNo);
	}

	@Override
	public DomesticTada domesticAdvForSet(int indTourId) {
		
		return getDao().domesticAdvForSet(indTourId);
	}

	@Override
	public boolean saveDomesticTadaSet(DomesticTada domTada) {
		
		return (getDao().saveDomesticTadaSet(domTada) == 1 ? true : false);
	}

}
