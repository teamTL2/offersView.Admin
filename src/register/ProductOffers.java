package register;

public class ProductOffers {
	private String _productName;
	private String _productDiscount; //p.x. -20%
	
	public ProductOffers(){
		
	}
	
	public void setProductName(String productName){
		_productName = productName;
	}
	
	public void setProductDiscount(String productDiscount){
		_productDiscount = productDiscount;
	}
	
	public String getProductName(){
		return _productName;
	}
	
	public String getProductDiscount(){
		return _productDiscount;
	}
}
