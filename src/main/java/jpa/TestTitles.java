package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class TestTitles implements CommandLineRunner {
    @Autowired
    TitlesRepo titleRepo;
	public static void main(String[] args) {
		SpringApplication.run(TestTitles.class, args);

	}
	public void displayPrices() {
		for(var v : titleRepo.getPrice())
			System.out.println(v.getTitle()+" "+v.getPrice());
		
	}
	public void displayTitlesMatch() {
		for(var p:titleRepo.getTitlesMatch("is"))
			System.out.println(p.getTitle());
	}
	public void displayCount() {
		System.out.println(titleRepo.count());
	}
	
	public void displayId() {
		System.out.println(titleRepo.findById("BU1032").get().getTitle());
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		//displayPrices();
		//displayTitlesMatch();
		//displayId();
		//displayCount();
		
	}
	
}
