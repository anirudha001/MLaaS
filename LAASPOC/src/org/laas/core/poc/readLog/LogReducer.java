package org.laas.core.poc.readLog;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.laas.core.poc.readLog.anirudha.LogKey;

public class LogReducer extends MapReduceBase implements Reducer<LogKey, LongWritable, LogKey, LongWritable>{

	@Override
	public void reduce(LogKey key, Iterator<LongWritable> value, OutputCollector<LogKey, LongWritable> collector, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

	
	
}
