package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;




public interface LtcDao {

	public int addLtcAdvData(LtcTxn ltcData);
	
	public List<LtcTxn> getAdvanceApproveList(int empId);
	
	public List<LtcTxn> getAdvSetList(int empId,String advSetStatus);
	
	
	public LtcTxn getLtcDataByLtcTxnId(int ltcTxnId);
	
	public int addLtcAdvSettlement(LtcTxn ltcData);
	
	public int addMappingData(int advLtcTxnId,int setLtcTxnId);
	
	public int addLtcDepTrvData(LtcEmpDepTrv ltcEmpDepTrv);
	
	public int addLtcEmpTrvData(LtcEmpTrv ltcEmpTrv);
	
	public int addLtcDirSettlement(LtcTxn ltcData);
	
	
	public List<LtcEligiblty>  getLtcEligibltyList(String rankId);
	
	public List<LtcEligiblty>  getLtcEligibltyMstList();
	
	
	public int addLtcEligibltydata(LtcEligiblty ltcEligiblty);
	
	public int updateLtcEligiblty(LtcEligiblty ltcEligiblty);
	
	public LtcEligiblty getLtcEligiblityData(int ltcNo);
	
	public int deleteLtcEligibltyData(int ltcNo);
	
	public int updateApproveAdvSet(LtcTxn ltcTxn);
	
	public int updateLtcEmpDepTrvDtl(LtcEmpDepTrv ltcEmpDepTrv);
	
	public int updateLtcEmpTrvDtl(LtcEmpTrv ltcEmpTrv);
	
	
	
	
	public List<LtcEmpDepTrv> getLtcDependentList(int ltcTxnId);
	
	
	public LtcEmpTrv getLtcEmpTravData(int ltcTxnId);

	public int updateLtcAppForCheck(LtcTxn ltcTxn);
	
	public int addLtcExtentionData(LtcExtention ltcExt);
	
	
	public int updateLtcExtApp(LtcExtention ltcExt);
	
	public LtcExtention getLtcExtentionData(int ltcExtId);
	
	public List<LtcExtention> getLtcExtentionList(int empNo);
	
	public List<String> getBlockYearList();
	
	public List<String> getTravelModeList();

	public List<String> getTravelClassList();
	
	public List<String> getTravelClassList(String travelMode);
	
	public List<String> getTrainTypeList(String travelMode);
	
	public int updateLtcEmpTrvDataForCheck(LtcEmpTrv ltcEmpTrv);
	
	public int updateLtcEmpDepTrvDataCheck(LtcEmpDepTrv ltcEmpDepTrv);
	
} 
