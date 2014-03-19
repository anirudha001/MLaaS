/**
 * 
 */
package org.laas.core.poc.readLog;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * @author Admin
 *
 */
public class LogKey implements WritableComparable<LogKey> {

	Long logStartDateInMilliSecs;
	String threadName;
	Integer threadId;
	String serviceType;
	
	public LogKey()
	{
		
	}
	
	
	public LogKey(Long logStartDateInMilliSecs, String threadName, Integer threadId, String serviceType) {
		super();
		this.logStartDateInMilliSecs = logStartDateInMilliSecs;
		this.threadName = threadName;
		this.threadId = threadId;
		this.serviceType = serviceType;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		String[] values = in.readLine().split(",");
		
		logStartDateInMilliSecs = Long.parseLong(values[0]);
		threadName = values[1];
		threadId = Integer.parseInt(values[2]);
		serviceType = values[3];
	}

	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeBytes(toString(true));
	}

	@Override
	public int compareTo(LogKey o) {
		
		int compareResult = 0;
		
		if(!(logStartDateInMilliSecs == o.logStartDateInMilliSecs && threadId == o.threadId && threadName == o.threadName  && serviceType == o.serviceType)) {
			compareResult = logStartDateInMilliSecs.compareTo(o.logStartDateInMilliSecs);
		}
		
		
		return compareResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogKey [logStartDateInMilliSecs=")
				.append(logStartDateInMilliSecs).append(", threadName=")
				.append(threadName).append(", threadId=").append(threadId)
				.append(", serviceType=").append(serviceType).append("]");
		return builder.toString();
	}

	public String toString(boolean onlyComma) {
		
		if(!onlyComma) {
			return toString();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(logStartDateInMilliSecs).append(",")
				.append(threadName).append(",")
				.append(threadId).append(",")
				.append(serviceType);
		return builder.toString();
	}
}
