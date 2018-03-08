package br.unipe.util;

public class Utils {
	
	public static void wait(final int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}