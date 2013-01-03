package pt.isep.dei.simov.android.sellit.data.dto.entity;

import pt.isep.dei.simov.android.sellit.data.dto.SELLITDTO;

public class ProductDTO implements SELLITDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long productId;
	private String productTitle;
	private String productDescription;
	private String productCategory;
	private String productPrice;
	private String productDate;
	private String productLocation;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

}
