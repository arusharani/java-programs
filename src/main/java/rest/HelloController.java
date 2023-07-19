package rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
public class HelloController {
	
	@GetMapping("/hello")
	@RequestMapping(value ="/hello",method = RequestMethod.GET)
	public String hello() {
		return "<h1>Hello Rest</h1>";
		
	}
	@GetMapping("/hello/{user}")
	public String hello( String user) {
		return "<h1>Hello " + user + "</h1>";
	}
	@GetMapping("/time1")
	public  String date() {
		var a =DateTimeFormatter.ofPattern("dd-MMM-uuuu hh:mm:ss");
		return LocalDateTime.now().format(a);
	}

	@GetMapping("/fact1/{a}")
	public int fact(@PathVariable("a")int a) {
		int fact=1;
		for(int i=1;i< a;i++)
			fact=fact*i;
		return fact;
	}

}
