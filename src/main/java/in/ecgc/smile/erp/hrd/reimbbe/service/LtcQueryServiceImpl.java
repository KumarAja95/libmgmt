package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;
import in.ecgc.smile.erp.hrd.reimbbe.repository.LtcDao;


@Repository
public class LtcQueryServiceImpl implements LtcQueryService {
	
	@Autowired(required = true)
	private LtcDao dao;
	
	public LtcDao getDao() {
		return dao;
	}

	public void setDao(LtcDao dao) {
		this.dao = dao;
	}
	
	
	

	@Override
	public List<LtcTxn> getAdvanceApprovalList(int empId) {
		return dao.getAdvanceApproveList(empId);
	}

	@Override
	public LtcTxn getLtcDataByLtcTxnId(int ltcTxnId) {
		LtcTxn ltcData= dao.getLtcDataByLtcTxnId(ltcTxnId);
		ltcData.setLtcDepList(dao.getLtcDependentList(ltcTxnId));
		LtcEmpTrv empTrv=dao.getLtcEmpTravData(ltcTxnId);
		System.out.println(empTrv);
		ltcData.setEmpTrvData(empTrv);
		System.out.println(ltcData);
		return ltcData;
	}

	@Override
	public List<LtcTxn> getLtcList(int empId, String advSetStatus) {
		
		return dao.getAdvSetList(empId,advSetStatus);
	}

	@Override
	public List<LtcEligiblty> getLtcEligibltyList(String rankId) {
		
		return dao.getLtcEligibltyList(rankId);
	}

	@Override
	public LtcEligiblty getLtcEliDtlByLtcNo(int ltcNo) {
		return dao.getLtcEligiblityData(ltcNo);
	}

	

	@Override
	public List<LtcEmpDepTrv> getLtcDepTravList(int ltcTxnId) {
		return dao.getLtcDependentList(ltcTxnId);
	}

	@Override
	public LtcEmpTrv getEmpTravData(int ltcTxnId) {
		return dao.getLtcEmpTravData(ltcTxnId);
		
	}

	@Override
	public LtcExtention getLtcExtentionData(int ltcExtId) {
		return dao.getLtcExtentionData(ltcExtId);
	}

	@Override
	public List<LtcExtention> getLtcExtentionList(int empNo) {
		return dao.getLtcExtentionList(empNo);
	}

	@Override
	public List<String> getBlockYearList() {
		return dao.getBlockYearList();
	}

	@Override
	public List<String> getTravelList( int flag) {
		switch(flag) {
		case 1: 
			return dao.getTravelModeList();
		case 2:
			return dao.getTravelClassList();
	
		case 3:
			return dao.getTrainTypeList("RAIL");
		}
		
			return null;
	}
	
	
	
	
	@Override
	public List<String> getTravelModeList( ) {
		 
			return dao.getTravelModeList();
		
	}
	
	@Override
	public List<String> getTravelClassList(String travelMode ) {
		 
			return dao.getTravelClassList(travelMode);
		
	}
	
	
	@Override
	public List<String> getTrainTypeList(String travelMode ) {
		 
			return dao.getTrainTypeList(travelMode);
		
	}

	@Override
	public List<LtcEligiblty> getLtcEligibltyMstList() {
		return dao.getLtcEligibltyMstList();
	}
	
}
