package org.laas.core.poc;

import java.io.File;

import org.laas.core.search.SearchEngine;

public class POCClass {

	public static void main(String[] args) {
		
		new File("///home//rkmalaiya//out").delete();
		SearchEngine searchEngine = new SearchEngine("///home//rkmalaiya//in", "///home//rkmalaiya//out", LAASMapper.class, LAASReducer.class);
		searchEngine.startSearching("main");
	}
	
}
