package in.ecgc.smile.erp.hrd.reimbbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.smile.erp.hrd.reimbbe.model.ExpensesReimbMst;
import in.ecgc.smile.erp.hrd.reimbbe.model.NewspaperReimb;
import in.ecgc.smile.erp.hrd.reimbbe.repository.NewspaperReimbDao;



@Service
public class NewspaperReimbQueryServiceImpl implements NewspaperReimbQueryService{

	@Autowired
	private NewspaperReimbDao dao;

	@Override
	public ExpensesReimbMst getExpensesMstList(int rankId, String processCd) {
		return dao.getExpensesMstList(rankId, processCd);
	}

	@Override
	public List<ExpensesReimbMst> getExpensesMstList() {
		return dao.getExpensesMstList();
	}

	@Override
	public boolean addExpensesMstdata(ExpensesReimbMst expensesReimbMst) {
		int result= dao.addExpensesMstdata(expensesReimbMst);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateExpensesMst(ExpensesReimbMst expensesReimbMst) {
		int result= dao.updateExpensesMst(expensesReimbMst);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteLtcExpensesMst(int expEligId) {
	    int result= dao.deleteLtcExpensesMst(expEligId);
	    if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addNewspaperReimbdata(NewspaperReimb newspaperReimb) {
		int result= dao.addNewspaperReimbData(newspaperReimb);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateNewspaperReimbdata(NewspaperReimb newspaperReimb) {
		int result= dao.updateNewspaperReimb(newspaperReimb);
		if(result==1) {
			return true;
		}
		return false;
	}

	@Override
	public List<NewspaperReimb> getNewspaperReimbList(String processCd) {
		
		return dao.getNewspaperReimbList(processCd);
		
	}

	@Override
	public NewspaperReimb getNewspaperReimbByAppNo(int appNo) {
		// TODO Auto-generated method stub
		return dao.getNewspaperReimbByAppNo(appNo);
	}


	
	
	
}
