package in.ecgc.smile.erp.hrd.reimbbe.repository;

import in.ecgc.smile.erp.hrd.reimbbe.model.TadaCityMst;

public interface TadaCityMstDao {

	public TadaCityMst getTadaCityDaHotelAmt(String rankId, String cityClsDa, String cityClsHotel);
}
