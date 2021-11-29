package ly.algjamia.jdbc;

import java.util.Date;

public class Product {
	private Integer prID;
	private String PrName;
	private Float prPrice;
	private Date prDate;

	public Product() {

	}
	
	
	public Product(Integer prID, String prName, Float prPrice) {
		super();
		this.prID = prID;
		PrName = prName;
		this.prPrice = prPrice;
	}


	public Product(Integer prID, String prName, Float prPrice, Date prDate) {
		super();
		this.prID = prID;
		PrName = prName;
		this.prPrice = prPrice;
		this.prDate = prDate;
	}

	public Product(String prName, Float prPrice) {
		super();
		PrName = prName;
		this.prPrice = prPrice;
	}

	public Integer getPrID() {
		return prID;
	}

	public void setPrID(Integer prID) {
		this.prID = prID;
	}

	public String getPrName() {
		return PrName;
	}

	public void setPrName(String prName) {
		PrName = prName;
	}

	public Float getPrPrice() {
		return prPrice;
	}

	public void setPrPrice(Float prPrice) {
		this.prPrice = prPrice;
	}

	public Date getPrDate() {
		return prDate;
	}

	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}

	@Override
	public String toString() {
		return "Product [prID=" + prID + ", PrName=" + PrName + ", prPrice=" + prPrice + ", prDate=" + prDate + "]";
	}

}
