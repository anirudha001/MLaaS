package org.laas.core.poc.readLog.anirudha;


import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.laas.core.poc.readLog.anirudha.LogMapper;
import org.laas.core.poc.readLog.anirudha.LogReducer;

public class PocMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {//throws IOException {
	//public void start() throws Exception{
		System.out.print("Anirudha is happy :)");
		JobConf jb=new JobConf(PocMain.class);
		 jb.setInputFormat(TextInputFormat.class);
		 jb.setOutputFormat(TextOutputFormat.class);
		 
		//jb.setMapOutputKeyClass(Text.class);
	//  jb.setMapOutputValueClass(IntWritable.class);
		 
		
		 
		 jb.setOutputKeyClass(Text.class);
		 jb.setOutputValueClass(IntWritable.class);
		 jb.setMapperClass(LogMapper.class);
		 //jb.setCombinerClass(LogReducer.class);
		 jb.setReducerClass(LogReducer.class);
		 
		// jb.setInputFormat(TextInputFormat.class);
		//	jb.setOutputFormat(TextOutputFormat.class);
		 
		 FileInputFormat.setInputPaths(jb, new Path("/home/anirudha/Desktop/loggs"));
		 
		 FileOutputFormat.setOutputPath(jb, new Path("/home/anirudha/Desktop/loggsout"));
		 
		 
		// String startLocForThreadName="36";
			//String lenOfThreadName="1";
			
			String startLocForThreadId="37";
			String lenOfThreadId="1";
			
			
			String startLocForStartTime="0";
			String lenOfStartTime="16";
			
			String dateOnlyFormat="yyyy-mm-dd";
			String dateTimeFormat="yyyy-mm-dd hh:mm";

		 jb.setStrings("pattern",startLocForThreadId,lenOfThreadId,startLocForStartTime,lenOfStartTime,dateOnlyFormat,dateTimeFormat);
		 System.out.println("Anirudha is not ");
		  try {
			JobClient.runJob(jb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}

}
