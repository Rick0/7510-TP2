package Grupo8;

/*
 * Clase encargada de contar el tiempo.
 */
public class Timer {

	private long elapsedTime;


	public Timer() {
		elapsedTime = 0;
	}


	public void reset() {
		elapsedTime = 0;
	}


	public void startCounting() {
		elapsedTime = System.nanoTime();
	}


	public long getElapsedTime() {
		return (System.nanoTime() - elapsedTime);
	}


	public String getElapsedTimeInNs() {	//  nano seconds
		return (System.nanoTime() - elapsedTime) + "ns";
	}


	public String getElapsedTimeInUs() {	// micro seconds
		return ((System.nanoTime() - elapsedTime)/1000) + "us";
	}


	public String getElapsedTimeInMs() {	//  mili seconds
		return ((System.nanoTime() - elapsedTime)/1000000) + "ms";
	}


	public String getElapsedTimeInSeg() {	//       seconds
		return ((System.nanoTime() - elapsedTime)/1000000000) + "s";
	}

}
