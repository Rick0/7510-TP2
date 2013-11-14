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


	public long getElapsedTimeInNs() {	//  nano seconds
		return (System.nanoTime() - elapsedTime);
	}


	public long getElapsedTimeInUs() {	// micro seconds
		return ((System.nanoTime() - elapsedTime)/1000);
	}


	public long getElapsedTimeInMs() {	//  mili seconds
		return ((System.nanoTime() - elapsedTime)/1000000);
	}


	public long getElapsedTimeInSeg() {	//       seconds
		return ((System.nanoTime() - elapsedTime)/1000000000);
	}

}
