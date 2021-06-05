 package in.erp.lib.mgmtbe.util;

/**
 * A util interface for working with Queries.
 * @Author Ajay Kumar
 */
public interface OrderQueries {
    
    String UPDATE_ORDER_BY_ID = "UPDATE public.orders "
    		+ "SET submission_date=:sctSubDt, delay_of_days=:delayDays, charge_amt=:chargeAmt "
    		+ "WHERE order_id=:OrderId";
}
