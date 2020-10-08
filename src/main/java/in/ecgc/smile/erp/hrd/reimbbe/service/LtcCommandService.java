package in.ecgc.smile.erp.hrd.reimbbe.service;


import in.ecgc.smile.erp.hrd.reimbbe.model.LtcEligiblty;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcExtention;
import in.ecgc.smile.erp.hrd.reimbbe.model.LtcTxn;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
public interface LtcCommandService {
	
	public int addLtcAdvData(LtcTxn ltcData);
	
	public int addLtcDirSettlement(LtcTxn ltcData);
	
	public int  addLtcAdvSettlement(LtcTxn ltcData);

    public boolean addLtcEligibltydata(LtcEligiblty ltcEligiblty);
	
	public boolean updateLtcEligiblty(LtcEligiblty ltcEligiblty);
	
	public boolean deleteLtcEligibltyData(int ltcNo);
	
	public boolean updateApproveAdvSet(LtcTxn ltcTxn);
	
	public boolean updateLtcAppForCheck(LtcTxn ltcData);
	
     public boolean addLtcExtentionData(LtcExtention ltcExt);
	
	
	public boolean updateLtcExtApp(LtcExtention ltcExt);
	
	

}
