package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpDepTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEmpTrv;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;


public interface LtcQueryService {
	

	
	public List<LtcTxn> getAdvanceApprovalList(int empId);
	
	public LtcTxn getLtcDataByLtcTxnId(int ltcTxnId);
	
	public List<LtcTxn>  getLtcList(int empId ,String advStatus);
	
	public List<LtcEligiblty>  getLtcEligibltyList(String rankId);
	
	public List<LtcEligiblty>  getLtcEligibltyMstList();
	
	public LtcEligiblty getLtcEliDtlByLtcNo(int ltcNo);
	

	
	public List<LtcEmpDepTrv> getLtcDepTravList(int ltcTxnId);
	
	public LtcEmpTrv  getEmpTravData(int ltcTxnId);
	
    public LtcExtention getLtcExtentionData(int ltcExtId);
	
	public List<LtcExtention> getLtcExtentionList(int empNo);
	
	
	public List<String> getBlockYearList();
	
	public List<String> getTravelList( int flag);
	
	public List<String> getTrainTypeList(String travelMode );
	
	public List<String> getTravelClassList(String travelMode );
	
	public List<String> getTravelModeList( );

}
