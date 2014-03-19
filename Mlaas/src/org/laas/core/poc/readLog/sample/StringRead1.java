package org.laas.core.poc.readLog.sample;

import java.util.HashMap;
import java.util.Map;


public class StringRead1 {
    String line = "723150 03812  20000101";//    44.7 24    40.3 24 1022.0 21 9999.9  0      6.0 24     3.2 24    15.0    20.0    64.0     30.9   0.00D 999.9 100000";
    
    public static void main(String args[]){
        StringRead1 sr = new StringRead1();
        sr.runText();
    }
    
    public void runText(){
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;
        int count;
        
        for(i = 0; i < line.length(); i++){
            count = 0;
            if(!Character.isWhitespace(line.charAt(i))){
                //for(j = i; (!Character.isWhitespace(line.charAt(i)) && j < line.length()); j++){
                /*while(!Character.isWhitespace(line.charAt(j))){
                    System.out.println("Non White: " + i + " , " + j);
                    j++;
                }*/
                
                count++;
            }
            System.out.println(count);
        }
    }
}
