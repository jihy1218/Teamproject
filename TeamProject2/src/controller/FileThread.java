package controller;

import database.File;

public class FileThread extends Thread {

@Override
	public void run() {
	
	
	while(true) {
		File.fileload(1);
		File.fileload(2);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		File.filesave(1);
		File.filesave(2);
		
		
		
	}
		
	}
	
}
