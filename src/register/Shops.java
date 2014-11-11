package register;

import java.util.List;

public class Shops {
	private String _name;
	private String _street;//Mporei na min xriazete!!
	private String _coordinates;//???(X,Y)???
	private List<ProductOffers> _offers;
	
	public Shops(){
		
	}
	
	public void setName(String name){
		_name = name;
	}
	
	public void setStreet(String street){
		_street = street;
	}
	
	public void setCoordinates(String coordinates){
		_coordinates = coordinates;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getStreet(){
		return _street;
	}
	
	public String getCoordinates(){
		return _coordinates;
	}
	
	public List<ProductOffers> getOffers(){
		return _offers;
		
	}
}
