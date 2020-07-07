package org.webrtc.kite.sample.checks;

import java.util.Random;

public interface Ifilename {
	public static int num = new Random().nextInt();
	public static int getFileName() {
		return num;
	}
}
