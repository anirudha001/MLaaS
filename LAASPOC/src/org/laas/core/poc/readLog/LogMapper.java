package org.laas.core.poc.readLog;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.laas.core.poc.readLog.LogKey;

public class LogMapper extends MapReduceBase implements Mapper<LongWritable, Text, LogKey, LongWritable>{

	String startPattern;
	String endPattern;
	
	int startLocForServiceType;
	int lenOfServiceType;
	
	int startLocForThreadName;
	int lenOfThreadName;
	
	int startLocForThreadId;
	int lenOfThreadId;
	
	int startLocForStartTime;
	int lenOfStartTime;
	
	String dateOnlyFormat;
	String dateTimeFormat;
	
	@Override
	public void configure(JobConf job) {
		super.configure(job);
		
		String patterns[] = job.getStrings("pattern");
		
		startPattern = patterns[0];
		
		startLocForServiceType = Integer.parseInt(patterns[1]);
		lenOfServiceType = Integer.parseInt(patterns[2]);
		
		startLocForThreadName = Integer.parseInt(patterns[3]);
		lenOfThreadName = Integer.parseInt(patterns[4]);
		
		startLocForThreadId = Integer.parseInt(patterns[5]);
		lenOfThreadId = Integer.parseInt(patterns[6]);
		
		startLocForStartTime = Integer.parseInt(patterns[7]);
		lenOfStartTime = Integer.parseInt(patterns[8]);
		System.out.println("here---"+lenOfStartTime);
		
		dateOnlyFormat = patterns[9];
		dateTimeFormat = patterns[10];
	
		
	}
	
	
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<LogKey, LongWritable> collector, Reporter arg3) throws IOException {
		
		if(value.find(startPattern) != -1) {
			
		 String line = value.toString();
		 
		 Long milliSecsForDateOnly;
		 Long milliSecsForDateTime;
		 
		try {
			milliSecsForDateOnly = new SimpleDateFormat(dateOnlyFormat).parse(line.substring(startLocForServiceType, startLocForServiceType + lenOfServiceType)).getTime();
			milliSecsForDateTime = new SimpleDateFormat(dateTimeFormat).parse(line.substring(startLocForServiceType, startLocForServiceType + lenOfServiceType)).getTime();
			
		} catch (ParseException e) {
			milliSecsForDateOnly = 0l;
			milliSecsForDateTime = 0l;
		}
		
		 String threadName = line.substring(startLocForThreadName, startLocForThreadName + lenOfThreadName);
		 Integer threadId = Integer.parseInt(line.substring(startLocForThreadId, startLocForThreadId + lenOfThreadId));
		 String serviceType = line.substring(startLocForServiceType, startLocForServiceType + lenOfServiceType);
		 
		 LogKey logKey = new LogKey(milliSecsForDateOnly, threadName, threadId, serviceType);
		 
		 collector.collect(logKey, new LongWritable(milliSecsForDateTime));
			
		}	
	}
}
