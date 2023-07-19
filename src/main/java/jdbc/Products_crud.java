package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Products_crud implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	
//1
	public void addProduct(String ProdName, double Price,int Qoh,String Remarks,String CatCode,int tax) {
		jdbcTemplate.update("insert into products values(?,?,?,?,?,?)", ProdName,Price,Qoh,Remarks,CatCode,tax );
		System.out.println("Added Successfully!");
	}
//2
	public void updateProduct() {
		jdbcTemplate.update("UPDATE products set Price=500 where ProdId = 101" );
		System.out.println("Update Successfully!");
	}
	//3
	public void deleteSales() {
		jdbcTemplate.update(" DELETE FROM Sales WHERE Invno=5" );
		System.out.println("Delete Successfully!");
	}
	//4
	public void totalSales(int pId) {
		var res = jdbcTemplate.queryForList("  SELECT sum(Qty) FROM sales s join products p on p.ProdId=s.Prodid WHERE s.Prodid=?", pId);
		
		for(var a : res)
		System.out.println(a);
	}
	//5
	public void displayAvgPrice() {
		var res = jdbcTemplate.queryForList(" SELECT avg(p.Price) avg_price,c.CatDesc from categories c join products p on c.CatCode=p.CatCode group BY c.CatDesc");
		
		for(var s:res)
			System.out.println(s);
	}
	//6
	public void changePrice(int pid_1,int pid_2) {
	 jdbcTemplate.update(" UPDATE products set Price=price+price*0.10 WHERE ProdId=?",pid_1);
	 jdbcTemplate.update("  UPDATE products set Price=price-price*0.10 WHERE ProdId=?",pid_2);
	 System.out.println("update sucessfully");
	}
		
	

	
	

	@Override
	public void run(String... args) throws Exception {
		
		//addProduct("Iphone",50000,5,"good","hd",12);
		// updateProduct();
		//deleteSales();
		//totalSales(101);
		//displayAvgPrice();
		//changePrice(101,102);
		
	}

}