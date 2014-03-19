package org.laas.core.poc.readLog;


import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.laas.core.poc.readLog.LogMapper;
import org.laas.core.poc.readLog.LogReducer;

public class PocMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		JobConf jb=new JobConf(PocMain.class);
		 jb.setInputFormat(TextInputFormat.class);
		 jb.setOutputFormat(TextOutputFormat.class);
		 
		 jb.setMapOutputKeyClass(LogKey.class);
		 jb.setMapOutputValueClass(LongWritable.class);
		 
		 jb.setMapperClass(LogMapper.class);
		 
		 jb.setOutputKeyClass(LogKey.class);
		 jb.setOutputValueClass(LongWritable.class);
		 
		 jb.setReducerClass(LogReducer.class);
		 
		 FileInputFormat.setInputPaths(jb, new Path("/home/anirudha/Desktop/xyz"));
		 
		 FileOutputFormat.setOutputPath(jb, new Path("/home/anirudha/Desktop/hadout"));
		 
			String startLocForServiceType="43";
			String lenOfServiceType="4";
			
			String startLocForThreadName="23";
			String lenOfThreadName="19";
			
			String startLocForThreadId="43";
			String lenOfThreadId="1";
			
			String startLocForStartTime="0";
			String lenOfStartTime="21";
			
			String dateOnlyFormat="MM/dd/yy ";
			String dateTimeFormat="MM/dd/yy hh:mm:ss,mmm";

		 jb.setStrings("pattern","Starting Line of", startLocForServiceType,lenOfServiceType,startLocForThreadName,lenOfThreadName,startLocForThreadId,lenOfThreadId,startLocForStartTime,lenOfStartTime,dateOnlyFormat,dateTimeFormat);
		 
		  JobClient.runJob(jb);
		 

	}

}
