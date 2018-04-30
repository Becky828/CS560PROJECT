/**
 *CS 560
 * SPRING 2018
 * Group Project:
 * Minimal-Cost Path through a Hexagonally-Tiled Map
 * Group 23: BROWN, TITUS - LAL, JAYTI - PENALOZA, LUZ - SCHIELE, REBECCA
 */
package shortestPath;

/**
 * @author SCHIELE, REBECCA
 *
 */
class Driver {
	public static void main(String[] args) {

		/*
		 * long startTime; long endTime; long elapsedTime; double seconds;
		 * startTime = System.nanoTime();
		 */

		new DijkstraAlg();

		/*
		 * endTime = System.nanoTime(); elapsedTime = (endTime - startTime);
		 * seconds = (double) elapsedTime / 1000000000.0;
		 * System.out.println(" "); System.out.println("Took " + elapsedTime +
		 * " ns"); System.out.println("Took " + seconds + " seconds");
		 */
	}

}
