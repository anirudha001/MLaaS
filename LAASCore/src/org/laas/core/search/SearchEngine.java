package org.laas.core.search;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.KeyValueTextInputFormat;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.laas.core.interfaces.communicator.CallBackInterface;
import org.laas.search.constants.SearchEnums;

public class SearchEngine<Input, Output> {
	
	JobConf jobConf = null;
	
	public SearchEngine(String inputPath, String outputPath, Class<? extends Mapper<?, ?, ?, ?>> mapperClass, Class<? extends Reducer<?, ?, ?, ?>> reducerClass) {
		
		jobConf =  new JobConf(SearchEngine.class);
		
		jobConf.setMapperClass(mapperClass);
		jobConf.setReducerClass(reducerClass);
		
		FileInputFormat.setInputPaths(jobConf, new Path(inputPath));
		
		FileOutputFormat.setOutputPath(jobConf, new Path(outputPath));
		
		jobConf.setInputFormat(KeyValueTextInputFormat.class);
		jobConf.setOutputFormat(TextOutputFormat.class);
		
		
		jobConf.setMapOutputKeyClass(Text.class);
		jobConf.setMapOutputValueClass(Text.class);
		
		jobConf.setOutputKeyClass(Text.class);
		jobConf.setOutputValueClass(Text.class);
		
	}
	
	public void startSearching(String... pattern) {
		
		try {
			
				jobConf.setStrings(SearchEnums.FIRST_PATTERN.toString(), pattern);
				
			
			JobClient.runJob(jobConf);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
