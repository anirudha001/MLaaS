package org.laas.core.poc.readLog.sample;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Stringf {
    //String line = "723150 03812  20000101    44.7 24    40.3 24 1022.0 21 9999.9  0      6.0 24     3.2 24    15.0    20.0    64.0     30.9   0.00D 999.9 100000";
    //String meta = "STN,WBAN,YEARMODA,TEMP,DEWP,SLP,STP,VISIB,WDSP,MXSPD,GUST,MAX,MIN,PRCP,SNDP,FRSHTT,ABC,DEF,GHI,JKL,MNO,PQR";
    String line = "2013-02-10 14:34:17 825 DEBUG [Thread0]";
    String meta = "date,time,port,type,thread_id";
    
    public static void main(String args[]){
        Stringf sr = new Stringf();
        
        sr.runText();
    }
    
    public void runText(){
        Map<String, Integer[]> hmap = new HashMap<String, Integer[]>();
        int i = 0;
        int j = 0;
        int count = 0;
        Character c = null;
        int length = line.length();
        System.out.println(length);
        String metadata[] = meta.split(",");
        System.out.println(metadata.length);
        while(i < length){
            if(!Character.isWhitespace(line.charAt(i))){
                j =i;
                while(j < length &&  !Character.isWhitespace(line.charAt(j))){
                    j++;
                }
                //System.out.println("Non White: " + i + " , " + j);
                Integer[] temp = new Integer[2];//{i,j};
                temp[0] = i;
                //temp[1] = j - i;//for length
                temp[1] = j - i;//for length - 1
                //temp[1] = j - 1;//for 0-9
                //temp[1] = j;//for 0-10
                
                if(!hmap.containsKey(metadata[count]))
                        hmap.put(metadata[count], temp);
                count += 1;
                
                i = j-1;
            }
            i++;            
        }
        
        Set<Entry<String, Integer[]>> set = hmap.entrySet();
        for(Entry<String, Integer[]> me :set){
            System.out.print(me.getKey()+"\t");
            Integer[] temp = me.getValue();
            System.out.print(temp[0]+"\t");
            System.out.print(temp[1]+"\n");
        }
    }
}
