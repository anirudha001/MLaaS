package org.laas.core.poc.readLog.sample.anjish;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class LogReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text>{

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("10.25".split("\\.")[0]));
	}
	
	
	
	long start = 0;
	@Override
	public void reduce(Text key, Iterator<IntWritable> value, OutputCollector<Text, Text> collector, Reporter reporter)
			throws IOException {
		
	/*if(start == 0) {
		start = Integer.parseInt(key.toString().split("\\.")[0]);
	}*/
		
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		
		
				
				while(value.hasNext())	
				{
					int o=value.next().get();
					  if (!counts.containsKey(o))
					        counts.put(o, 0);
					    counts.put(o, 1 + counts.get(o));	
					
				}
				
							
				
				for (int j : counts.keySet())
				{
				    System.out.printf("j: %d, count: %d%n", j, counts.get(j));
				    collector.collect(new Text(key + "," + j+","+counts.get(j)), new Text(""));
				}
				
					
				
				
		
		
	}
		
	}

	
	

