package org.laas.core.poc.readLog.anirudha;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class LogMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	
	
	
	String startPattern;
	String endPattern;
	
	int startLocForThreadId;
	int lenOfThreadId;

	//int startLocForThreadName;
	//int lenOfThreadName;
	
	int startLocForStartTime;
	int lenOfStartTime;
	
	String dateOnlyFormat;
	String dateTimeFormat;
	
	@Override
	public void configure(JobConf job) {
		super.configure(job);
		
		String patterns[] = job.getStrings("pattern");
		
		//startPattern = patterns[0];
		
		
		
		startLocForThreadId = Integer.parseInt(patterns[0]);
		lenOfThreadId = Integer.parseInt(patterns[1]);
		
		
		
		System.out.println("************startLOCForThreadId***********  "+startLocForThreadId);
		System.out.println("************lenOfThreadId***********  "+lenOfThreadId);
		
		startLocForStartTime = Integer.parseInt(patterns[2]);
		lenOfStartTime = Integer.parseInt(patterns[3]);
		
		System.out.println("************startLocForStartTime***********  "+startLocForStartTime);
		System.out.println("************lenOfStartTime***********  "+lenOfStartTime);
		
		dateOnlyFormat = patterns[4];
		dateTimeFormat = patterns[5];
		
		System.out.println("**********dateOnlyFormat*************  "+dateOnlyFormat);
		System.out.println("************dateTimeFormat***********  "+dateTimeFormat);
	
		
	}
	
	
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text,  IntWritable> collector, Reporter reporter) throws IOException {
		
	//	if(value.find(startPattern) == -1) {
			
		 String line = value.toString();
		 
		 System.out.println("************LINE*************** = "+line);
		 
		 Date DateOnly;
		 Date DateTime = null;
		 
		try {
			
		/*	oldScheduledDate = "16-05-2011 02:00:00";
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date oldDate = (Date)formatter.parse(oldScheduledDate);  */
			
			//DateOnly = new SimpleDateFormat(dateOnlyFormat).parse(line.substring(startLocForStartTime, startLocForStartTime + lenOfStartTime));
			// DateTime = new SimpleDateFormat(dateTimeFormat).parse(line.substring(startLocForStartTime, startLocForStartTime + lenOfStartTime));
			
			DateFormat formatter=new SimpleDateFormat(dateTimeFormat);
			DateTime=formatter.parse(line.substring(startLocForStartTime, startLocForStartTime + lenOfStartTime));
			
			
			
			
			System.out.println("**********DateTime*********"+DateTime);
			

			
			
			
			
			
		} catch (ParseException e) {
			
			System.out.println("Parse Exception : "+e );
		}
		
		 // String threadName = line.substring(startLocForThreadName, startLocForThreadName + lenOfThreadName);
		 int threadId = Integer.parseInt(line.substring(startLocForThreadId, startLocForThreadId + lenOfThreadId));
		
		 final IntWritable one =new IntWritable(threadId);
		
		 
		 String s= line.substring(startLocForStartTime, startLocForStartTime+lenOfStartTime);
		 
		 Text word =new Text();
		 //word.set(s);
		 word.set(DateTime.getTime() + "");
		 
		 
		 System.out.println("**********Date String*********"+s);
		 
		 System.out.println("*************Thread Id************** = "+threadId);
		 
		 System.out.println("*************IntWritable Thread Id************** = "+one);
		 
		// LogKey logKey = new LogKey(DateTime);
		 
		 
		 
		 collector.collect(new Text(word),one);
			
		}	
	}

