package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.CityClassMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.CityClassMstDao;

@Service
public class CityClassMstServiceImpl implements CityClassMstService{

	@Autowired
	private CityClassMstDao dao;
	
	public CityClassMstDao getDao() {
		return dao;
	}

	@Override
	public List<CityClassMst> viewAllCityAndClass() {
		
		return getDao().getAllCityAndClass();
	}

}
