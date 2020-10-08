package in.ecgc.smile.erp.hrd.reimbbe.repository;

import java.util.List;

import in.ecgc.smile.erp.hrd.reimbbe.model.ExpensesReimbMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.NewspaperReimb;





public interface NewspaperReimbDao {

	
    public ExpensesReimbMst  getExpensesMstList(int rankId, String process_cd);
	
	public List<ExpensesReimbMst>  getExpensesMstList();
	
	public int addExpensesMstdata(ExpensesReimbMst expensesReimbMst);
	
	public int updateExpensesMst(ExpensesReimbMst expensesReimbMst);
	
	public int deleteLtcExpensesMst(int expEligId);
	
	public int addNewspaperReimbData(NewspaperReimb newspaperReimb);
	
	public int updateNewspaperReimb(NewspaperReimb newspaperReimb);
	
	public List<NewspaperReimb> getNewspaperReimbList(String processCd);
	
	public NewspaperReimb getNewspaperReimbByAppNo(int appNo);
}
