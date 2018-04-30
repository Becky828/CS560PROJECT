/**
 *CS 560
 * SPRING 2018
 * Group Project:
 * Minimal-Cost Path through a Hexagonally-Tiled Map
 * Group 23: BROWN, TITUS - LAL, JAYTI - PENALOZA, LUZ - SCHIELE, REBECCA
 */
package shortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LAL, JAYTI: major body
 * @author SCHIELE, REBECCA: setup, cleanup, getter, comments
 *
 *         The reasoning behind this code was discussed by LAL, PENALOZA, and
 *         SCHIELE during a library conference 04/07/18.
 */
public class AdjacencyChecker {

	// DECLARE HASHMAP
	HashMap<Integer, List<Integer>> adjacencyList;

	/**
	 * Determines adjacency by comparing each position number to calculations of
	 * other position numbers.
	 */
	public AdjacencyChecker() {
		Populator validEntries = new Populator();
		List<Integer> pNumList = validEntries.getPositionNumberList();
		adjacencyList = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < pNumList.size(); i++) {
			int val = pNumList.get(i);

			List<Integer> list = new ArrayList<Integer>();

			if (pNumList.contains(val + 7)) {
				list.add(val + 7);
			}
			if (pNumList.contains(val - 7)) {
				list.add(val - 7);
			}
			if (pNumList.contains(val - 8)) {
				list.add(val - 8);
			}
			if (pNumList.contains(val + 8)) {
				list.add(val + 8);
			}
			if (pNumList.contains(val - 15)) {
				list.add(val - 15);
			}
			if (pNumList.contains(val + 15)) {
				list.add(val + 15);
			}

			adjacencyList.put(val, list);
		}

	}

	/**
	 * Returns the created adjacency list.
	 * 
	 * @return  adjacency list
	 */
	public HashMap<Integer, List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

}
