package jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Categories {
	@Id
	@Column(name = "code")
	private String code;
	
	private String descripation;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescripation() {
		return descripation;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}

	@Override
	public String toString() {
		return "Categories [code=" + code + ", descripation=" + descripation + "]";
	}
    
	

	

}
