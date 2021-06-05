package in.erp.lib.mgmtbe.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *Order Model class
 *@Author Ajay Kumar
 *
 **/
public class Order {

	/* PK */
	private Integer orderId;
	
	/* FK from customer */
	private Integer customerId;
	
	/* FK from book */
	private Integer bookId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date issueDt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date submitDt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date actualSubmitDt;
	
	private Integer delayOfDays;
	
	private float chargeAmt;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Date getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(Date issueDt) {
		this.issueDt = issueDt;
	}

	public Date getSubmitDt() {
		return submitDt;
	}

	public void setSubmitDt(Date submitDt) {
		this.submitDt = submitDt;
	}

	public Date getActualSubmitDt() {
		return actualSubmitDt;
	}

	public void setActualSubmitDt(Date actualSubmitDt) {
		this.actualSubmitDt = actualSubmitDt;
	}

	public Integer getDelayOfDays() {
		return delayOfDays;
	}

	public void setDelayOfDays(Integer delayOfDays) {
		this.delayOfDays = delayOfDays;
	}

	public float getChargeAmt() {
		return chargeAmt;
	}

	public void setChargeAmt(float chargeAmt) {
		this.chargeAmt = chargeAmt;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", bookId=" + bookId + ", issueDt="
				+ issueDt + ", submitDt=" + submitDt + ", actualSubmitDt=" + actualSubmitDt + ", delayOfDays="
				+ delayOfDays + ", chargeAmt=" + chargeAmt + "]";
	}

}
