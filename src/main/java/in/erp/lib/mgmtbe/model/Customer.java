package in.erp.lib.mgmtbe.model;

/**
 *Customer Model class
 *@Author Ajay Kumar
 *
 **/
public class Customer {

	private Integer customerId;
	
	private String customerName;
	
	private Integer customerAge;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge
				+ "]";
	}
	
}
