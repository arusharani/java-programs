package jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {

	@Autowired
	CategoryRepo catRepo;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);

	}

	public void displayAll() {

		for (var v : catRepo.findAll())
			System.out.println(v.getDescripation());

	}

	public void update(String code, String desc) {
		var c = new Categories();
		c.setCode(code);
		c.setDescripation(desc);
		catRepo.save(c);
		System.out.println("update sucessfully");
	}

	public void saveCategories() {
		var a = new Categories();
		a.setCode("c");
		a.setDescripation("aaa");

		var e = new Categories();
		e.setCode("b");
		e.setDescripation("bbb");

		catRepo.saveAll(List.of(a, e));

	}

	public void deleteById() {
		catRepo.deleteById("code");
		System.out.println("deleted sucessfully");
	}

	@Override
	public void run(String... args) throws Exception {
		// displayAll();
		// deleteById();
		// update("tv","mitv");
		saveCategories();

	}

}
