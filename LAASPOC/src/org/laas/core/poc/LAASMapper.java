package org.laas.core.poc;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.laas.search.constants.SearchEnums;


public class LAASMapper extends MapReduceBase implements Mapper<Text, Text, Text, Text> {

	String[] patterns;
	
	
	
	@Override
	public void configure(JobConf job) {
		
		super.configure(job);
		
		patterns = job.getStrings(SearchEnums.FIRST_PATTERN.toString());
		
		System.out.println("************ Patterns" + Arrays.toString(patterns));
		
	}
	
	
	@Override
	public void map(Text keyIN, Text valueIN, OutputCollector<Text, Text> outputCollector, Reporter reporter) throws IOException {
	
		System.out.println("LAASMapper.map()");
		
		System.out.println("keyIN: " + keyIN + " valueIN:" + valueIN);
		
		for (int loop = 0; loop < patterns.length; loop++) {
			
			if(patterns[loop].equals(valueIN)) {
				
			}
		}		
	}	
}
