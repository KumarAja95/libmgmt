package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.IndForDaMst;
import in.ecgc.smile.erp.hrd.reimbbe.repository.IndForDaMstDao;

@Service
public class IndForDaMstServiceImpl implements IndForDaMstService{

	@Autowired
	private IndForDaMstDao dao;
	
	public IndForDaMstDao getDao() {
		return dao;
	}

	@Override
	public List<IndForDaMst> viewAllIndForDa() {
		
		return getDao().getAllIndForDa();
	}

	@Override
	public boolean addIndForDa(IndForDaMst indForDaMst) {
		int result = getDao().saveIndForDa(indForDaMst);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public boolean modifyIndForDa(IndForDaMst indForDaMst) {
		int result = getDao().updateIndForDa(indForDaMst);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public List<IndForDaMst> viewIndForDa(String type) {
		return getDao().getIndForDa(type);
	}

}
