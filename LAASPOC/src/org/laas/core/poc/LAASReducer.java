package org.laas.core.poc;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class LAASReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {

	@Override
	public void reduce(Text keyIN, Iterator<Text> values, OutputCollector<Text, Text> outputCollector, Reporter reporter) throws IOException {
		
	}

}
