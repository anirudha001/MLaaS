package com;

import org.apache.log4j.Logger;

public class LogThread extends Thread {

	static org.apache.log4j.Logger log = Logger.getLogger(Log.class);
	/*public LogThread(String string) {
		
		super(string);
	}*/
	
	/*public LogThread(int a)
	{
		LogThread [] t= new LogThread[a];
		for (int i = 0; i <a; i++) {
			
			t[i].setName("Thread"+i);
			
		}
	}*/

	public LogThread(String string) {
		
		super(string);
	}

	public void run()
	{
		
		
		for (int i = 1; i <=60; i++) {
			
			if(i<=15)
			{
				try {
					Thread.sleep((long) (Math.random()*15*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug(""+i);
				//System.out.format("%d %s%n",i,getName());
				
			}
			if(i>15 && i<=30)
			{
				try {
					Thread.sleep((long) (Math.random()*30*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug(""+i);
				//System.out.format("%d %s%n",i,getName());
				
			}
			
			if(i>30 && i<=45)
			{
				try {
					Thread.sleep((long) (Math.random()*46*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug(""+i);
				//System.out.format("%d %s%n",i,getName());
				
			}
			
			if(i>=45 && i<=60)
			{
				try {
					Thread.sleep((long) (Math.random()*60*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug(""+i);
				//System.out.format("%d %s%n",i,getName());
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		LogThread[] t=new LogThread[4];
		
		for (int i = 0; i < 4; i++) {
			
			t[i]=new LogThread("Thread"+i);
			Thread.sleep((long) (Math.random()*30*1000));
			t[i].start();
			
		}
		
		
		
		
		
		

	}

}
