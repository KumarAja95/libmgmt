package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.ExpensesReimbMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.NewspaperReimb;




public interface NewspaperReimbQueryService {
	
   public ExpensesReimbMst  getExpensesMstList(int rankId, String processCd);
	
	public List<ExpensesReimbMst>  getExpensesMstList();
	
	public boolean addExpensesMstdata(ExpensesReimbMst expensesReimbMst);
	
	public boolean updateExpensesMst(ExpensesReimbMst expensesReimbMst);
	
	public boolean deleteLtcExpensesMst(int expEligId);
	
    public boolean addNewspaperReimbdata(NewspaperReimb newspaperReimb);
	
	public boolean updateNewspaperReimbdata(NewspaperReimb newspaperReimb);
	
	public List<NewspaperReimb> getNewspaperReimbList(String processCd);
	
	public NewspaperReimb getNewspaperReimbByAppNo(int appNo);

}
