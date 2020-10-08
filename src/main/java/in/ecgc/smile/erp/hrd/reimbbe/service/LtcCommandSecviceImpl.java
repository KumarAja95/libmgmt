package in.ecgc.smile.erp.hrd.reimbbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.EmployeeDependent;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;
import in.ecgc.smile.erp.hrd.reimbbe.repository.EmployeeDao;
import in.ecgc.smile.erp.hrd.reimbbe.repository.LtcDao;

@Service
public class LtcCommandSecviceImpl implements LtcCommandService{

	@Autowired(required = true)
	private LtcDao dao;
	
	
	@Autowired(required = true)
	private EmployeeDao dao1;
	
	public LtcDao getDao() {
		return dao;
	}

	public void setDao(LtcDao dao) {
		this.dao = dao;
	}

	@Override
	public int addLtcAdvData(LtcTxn ltcData) {
		int result = dao.addLtcAdvData(ltcData);
		int result1=0;
		
		
		if(ltcData.getLtcDepList()!=null) {
			for(LtcEmpDepTrv ltcEmpDepTrv : ltcData.getLtcDepList()) {
			if(ltcEmpDepTrv.getDependentId()==0) {
				continue;
			}		
		
			EmployeeDependent empDep= dao1.getDependentByDependentId(ltcEmpDepTrv.getDependentId());
			ltcEmpDepTrv.setNameOfDependent(empDep.getDependentName());
			ltcEmpDepTrv.setRelation(empDep.getRelation());
			ltcEmpDepTrv.setLtcTxnId(result);
			result1=getDao().addLtcDepTrvData(ltcEmpDepTrv);
			if(result1 == 1)
				continue;
			break;
		}
		
		}
		if(ltcData.getEmpTrvData()!=null) {
			LtcEmpTrv ltcEmpTrv=ltcData.getEmpTrvData();
		       if(ltcEmpTrv.getStatus().equals("V")){
		    	   ltcEmpTrv.setEmpNo(ltcData.getEmpNo());
		    	   ltcEmpTrv.setLtcTxnId(result);
				result1=getDao().addLtcEmpTrvData(ltcEmpTrv);
			}	
		}
		if(result1==1){
			return result;
		}else
			return 0;
		
	}

	@Override
	public int addLtcAdvSettlement(LtcTxn ltcData) {
		int result = dao.addLtcAdvSettlement(ltcData);
		int result1=0;
		
		if(ltcData.getLtcDepList()!=null) {
		for(LtcEmpDepTrv ltcDep : ltcData.getLtcDepList()) {
			
		
			ltcDep.setLtcTxnId(result);
			ltcDep.setEmpNo(ltcData.getEmpNo());
			result1=dao.addLtcDepTrvData(ltcDep);
			if(result1 == 1)
				continue;
			break;
		}
	}else
	{
		result1=1;
	}
		
		if(ltcData.getEmpTrvData()!=null) {
			LtcEmpTrv ltcEmpTrv=ltcData.getEmpTrvData();
		       
		    	   ltcEmpTrv.setEmpNo(ltcData.getEmpNo());
		    	   ltcEmpTrv.setLtcTxnId(result);
				result1=dao.addLtcEmpTrvData(ltcEmpTrv);
				
		}
		if(result1==1){
			return result;
		}else
			return 0;
		
	}
	
	
	@Override
	public int addLtcDirSettlement(LtcTxn ltcData) {
		int result = dao.addLtcDirSettlement(ltcData);
		int result1=0;
		
		if(ltcData.getLtcDepList()!=null) {
			for(LtcEmpDepTrv ltcEmpDepTrv : ltcData.getLtcDepList()) {
				if(ltcEmpDepTrv.getDependentId()==0) {
					continue;
				}		
		
			EmployeeDependent empDep= dao1.getDependentByDependentId(ltcEmpDepTrv.getDependentId());
			ltcEmpDepTrv.setNameOfDependent(empDep.getDependentName());
			ltcEmpDepTrv.setRelation(empDep.getRelation());
			ltcEmpDepTrv.setLtcTxnId(result);
			result1=getDao().addLtcDepTrvData(ltcEmpDepTrv);
			if(result1 == 1)
				continue;
			break;
		}
		}
		
		if(ltcData.getEmpTrvData()!=null) {
			LtcEmpTrv ltcEmpTrv=ltcData.getEmpTrvData();
		       if(ltcEmpTrv.getStatus().equals("V")){
		    	   ltcEmpTrv.setEmpNo(ltcData.getEmpNo());
		    	   ltcEmpTrv.setLtcTxnId(result);
				result1=getDao().addLtcEmpTrvData(ltcEmpTrv);
			}	
		}
		if(result1==1){
			return result;
		}else
			return 0;
	
	}
	

	@Override
	public boolean addLtcEligibltydata(LtcEligiblty ltcEligiblty) {
		int result = getDao().addLtcEligibltydata(ltcEligiblty);
		System.out.println(result);
		if(result==1) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean updateLtcEligiblty(LtcEligiblty ltcEligiblty) {
		int result = getDao().updateLtcEligiblty(ltcEligiblty);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteLtcEligibltyData(int ltcNo) {
		int result = getDao().deleteLtcEligibltyData(ltcNo);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateApproveAdvSet(LtcTxn ltcData) {
		int result = getDao().updateApproveAdvSet(ltcData);
		if(ltcData.getLtcDepList()!=null) {
			for(LtcEmpDepTrv ltcDep : ltcData.getLtcDepList()) {
				
			
				
				result=dao.updateLtcEmpDepTrvDtl(ltcDep);
				if(result == 1)
					continue;
				break;
			}
		}
			
			if(ltcData.getEmpTrvData()!=null) {
				LtcEmpTrv ltcEmpTrv=ltcData.getEmpTrvData();
			      
			    	  
					result=dao.updateLtcEmpTrvDtl(ltcEmpTrv);
					
			}
			if(result==1) {
				return true;
			}
			return false;
	}

	@Override
	public boolean updateLtcAppForCheck(LtcTxn ltcData) {
		System.out.println(ltcData);
		System.out.println(ltcData.getEmpTrvData());
		int result=dao.updateLtcAppForCheck(ltcData);
		if(ltcData.getLtcDepList()!=null) {
			for(LtcEmpDepTrv ltcDep : ltcData.getLtcDepList()) {
				
			
				
				result=dao.updateLtcEmpDepTrvDataCheck(ltcDep);
				if(result == 1)
					continue;
				break;
			}
		}
			
			if(ltcData.getEmpTrvData()!=null) {
				LtcEmpTrv ltcEmpTrv=ltcData.getEmpTrvData();
			       
			    	  
					result=dao.updateLtcEmpTrvDataForCheck(ltcEmpTrv);
					System.out.println(result);
					
			}
			if(result==1) {
				return true;
			}
			return false;
	}

	@Override
	public boolean addLtcExtentionData(LtcExtention ltcExt) {
		int result = getDao().addLtcExtentionData(ltcExt);
		if(result==1) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean updateLtcExtApp(LtcExtention ltcExt) {
		int result = getDao().updateLtcExtApp(ltcExt);
		System.out.println(result);
		if(result==1) {
			return true;
		}
		return false;
	}
	
	
}
