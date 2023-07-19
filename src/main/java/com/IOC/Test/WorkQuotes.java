package com.IOC.Test;

import java.util.List;

import org.springframework.stereotype.Component;

@Component 
//@Lazy
public class WorkQuotes implements Quotes {
	public WorkQuotes() {
		System.out.println("WorkQuotes");
	}
	@Override
	public List<String> getQuotes(){
		return List.of("no one can achieve success without interest in work");
	}

}
