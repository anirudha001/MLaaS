package org.laas.core.poc.readLog.sample;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;


public class String3 {
    String line = "723150 03812  20000101  44.7 24    40.3 24 1022.0 21 9999.9  0      6.0 24     3.2 24    15.0    20.0    64.0     30.9   0.00D 999.9 100000";
    
    public static void main(String args[]){
        String3 sr = new String3();
        sr.runText();
    }
    
    public void runText(){
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;
        //int count = 0;
        //IntegerArray ii = new IntegerArray(10);
        //for(i = 0; i < line.length(); i++){
        while(i < line.length()){
            //count = 0;
            if(!Character.isWhitespace(line.charAt(i))){
                //for(j = i; (!Character.isWhitespace(line.charAt(i)) && j < line.length()); j++){
                j =i;
                int count = 0;
                while(j< line.length() && !Character.isWhitespace(line.charAt(j))){
                    //System.out.println("Non White: " + i + " , " + j);
                    
                    if (!hmap.containsKey(i))
				        hmap.put(i,   0);
				    hmap.put(i, 1 + hmap.get(i));
				    
                       j++;
                }
               
                i = j-1;
                
                //count++;
            }i++;
            //System.out.println(count);
            
        }
        
       // System.out.println(hmap.get(0));
       
        for(int k:hmap.keySet())
        {
        	System.out.println("StartLoc :  "+k+" StartLen : "+hmap.get(k));
        }
        System.out.println(hmap.get(7));
        System.out.println(hmap.get(2));
        
        /*while(Character.isWhitespace(line.charAt(i)) && i < line.length()){
            
            i++;
        }*/
    }
}
