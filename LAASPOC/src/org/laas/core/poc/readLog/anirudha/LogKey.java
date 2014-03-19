/**
 * 
 */
package org.laas.core.poc.readLog.anirudha;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.io.WritableComparable;

/**
 * @author Admin
 *
 */
public class LogKey implements WritableComparable<LogKey> {

	Date logStartDateInMilliSecs;
	
	
	public LogKey()
	{
		
	}
	
	
	public LogKey(Date logStartDateInMilliSecs) {
		super();
		this.logStartDateInMilliSecs = logStartDateInMilliSecs;
		
		//this.threadName = threadName;
		
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		String[] values = in.readLine().split(",");
		
		//logStartDateInMilliSecs = Long.parseLong(values[0]);
		
		//threadName = values[2];
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeBytes(toString(true));
	}

	@Override
	public int compareTo(LogKey o) {
		
		int compareResult = 0;
		
		if(!(logStartDateInMilliSecs == o.logStartDateInMilliSecs )) {
			compareResult = logStartDateInMilliSecs.compareTo(o.logStartDateInMilliSecs);
		}
		
		
		return compareResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogKey [logStartDateInMilliSecs=").append(logStartDateInMilliSecs).append("]");
		return builder.toString();
	}

	public String toString(boolean onlyComma) {
		
		if(!onlyComma) {
			return toString();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(logStartDateInMilliSecs).append(",");
				
		return builder.toString();
	}
}
