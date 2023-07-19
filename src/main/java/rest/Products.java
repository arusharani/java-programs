package rest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 private int Prodid;
	 private String Prodname;
	 private double Price;
	public int getProdid() {
		return Prodid;
	}
	public void setProdid(int prodid) {
		Prodid = prodid;
	}
	public String getProdname() {
		return Prodname;
	}
	public void setProdname(String prodname) {
		Prodname = prodname;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	 
	
	

}
