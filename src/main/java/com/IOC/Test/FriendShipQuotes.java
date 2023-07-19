package com.IOC.Test;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope(scopeName="prototype")
public class FriendShipQuotes implements Quotes {
	
	public FriendShipQuotes() {
		System.out.println("FriendshipQuotes");
	}
	@Override
	public List<String> getQuotes(){
		return List.of("A friend is someone who understands your past, believes in your future,and accepts you just the way you are.");
		
	}

}
