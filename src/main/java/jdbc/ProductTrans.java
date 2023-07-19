package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ProductTrans implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void changePrice(int pid_1, int pid_2) {

		jdbcTemplate.update(" UPDATE products set Price=price+price*0.10 WHERE ProdId=?", pid_1);
		jdbcTemplate.update("  UPDATE products set Price=price-price*0.10 WHERE ProdId=?", pid_2);
		System.out.println("update sucessfully");
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
