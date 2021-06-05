package in.erp.lib.mgmtbe.model;

/**
 *Book Model class
 *@Author Ajay Kumar
 *
 **/
public class Book {

	private Integer bookId;
	
	private String bookName;
	
	/* Status book available or not */
	private boolean status;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", status=" + status + "]";
	}
}
