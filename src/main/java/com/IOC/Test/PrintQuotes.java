package com.IOC.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintQuotes implements CommandLineRunner  {
	
	@Autowired
	   Quotes quotes;
		
		

		@Override
		public void run(String... args) throws Exception {
			for (var v : quotes.getQuotes())
				System.out.println(v);

}
}
