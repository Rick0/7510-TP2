package Grupo8;

/*
 * Clase encargada de contar el tiempo.
 */
public class Timer {
	
	private long elapsedTime;
//	private String timeUnit = "ns";	// nanoTime is in nano seconds
	
	
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

}
