package com;

import java.util.HashMap;

public class HashMapWrapper {

	static HashMap sessionHashmap;


	private HashMapWrapper(){

	}

	public static HashMap getHashMapInstance(){
	if(sessionHashmap==null)
	sessionHashmap= new HashMap();

	return sessionHashmap;
	}


	
	
}
