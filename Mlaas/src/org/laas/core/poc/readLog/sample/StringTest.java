package org.laas.core.poc.readLog.sample;

import java.util.HashMap;
import java.util.Map;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String line= "723150 03812  20000101    44.7 24    40.3 24 1022.0 21 9999.9  0      6.0 24     3.2 24    15.0    20.0    64.0     30.9   0.00D 999.9 100000";
		Map<Integer, Integer> m =new HashMap<Integer,Integer>();
		 Character c=null; 
		 //System.out.println(line.length());
		 for(int i=0;i<line.length();i++)
		 {
			 //c=line.charAt(5);
			 //System.out.println(c);
			 if(!c.isWhitespace(line.charAt(i))||!c.isSpaceChar(line.charAt(i)))
			 {
				 //System.out.println("white");
				 int j  =  i;
				 int count = 0;
				 //System.out.println(c.isSpaceChar(7));
				for (j = i; j<line.length() && !c.isSpaceChar(line.charAt(j)); j++) {
					//while((!(c.isWhitespace(line.charAt(j)))  || !c.isSpaceChar(line.charAt(j)))  &&  j < line.length()){
					count+=1;
					j++;
					
				} 
				//System.out.println(count);
				 m.put(i, count);
				 i=j-1;
				 
			 }
		 }

		 for(int i:m.keySet())
		 {
			 System.out.println("i = "+i);
			 System.out.println("Key Set :"+m.get(i));
		 }
	}

}















