/**
 *CS 560
 * SPRING 2018
 * Group Project:
 * Minimal-Cost Path through a Hexagonally-Tiled Map
 * Group 23: BROWN, TITUS - LAL, JAYTI - PENALOZA, LUZ - SCHIELE, REBECCA
 */
package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LAL, JAYTI: major body
 * @author SCHIELE, REBECCA: setup, cleanup, getter, comments
 *
 *         The reasoning behind this code was discussed by LAL, PENALOZA, and
 *         SCHIELE during a library conference 04/07/18.
 *         
 *         All group members met in the evening of 05/01/18 and the morning of 05/02/18 to discuss further restrictions
 *         on making adjacency lists.
 */
public class AdjacencyChecker {

	// DECLARE HASHMAP
	HashMap<Integer, List<Integer>> adjacencyList;

	/**
	 * Determines adjacency by comparing each position number to calculations of
	 * other position numbers.
	 */
	public AdjacencyChecker() {
		//Instantiates necessary objects
		Populator validEntries = new Populator();
		List<Integer> pNumList = validEntries.getPositionNumberList();
		adjacencyList = new HashMap<Integer, List<Integer>>();
		ArrayList<Integer> leftColumn = new ArrayList<Integer>(
				Arrays.asList(1, 16, 31, 46, 61, 76, 91, 106, 121, 136, 151, 166, 181, 196, 211, 226));
		ArrayList<Integer> rightColumn = new ArrayList<Integer>(
				Arrays.asList(8, 23, 38, 53, 68, 83, 98, 113, 128, 143, 158, 173, 188, 203, 218, 233));

		//Builds adjacency list
		for (int i = 0; i < pNumList.size(); i++) {
			int val = pNumList.get(i);
			List<Integer> list = new ArrayList<Integer>();

			// Prevents erroneous neighbors from left column to right column.
			if (leftColumn.contains(val)) {
				if (pNumList.contains(val + 8)) {
					list.add(val + 8);
				}
				if (pNumList.contains(val + 15)) {
					list.add(val + 15);
				}
				if (pNumList.contains(val - 7)) {
					list.add(val - 7);
				}
				if (pNumList.contains(val - 15)) {
					list.add(val - 15);
				}

				adjacencyList.put(val, list);

			}

			// Prevents erroneous neighbors from left column to right column.
			else if (rightColumn.contains(val)) {
				if (pNumList.contains(val + 7)) {
					list.add(val + 7);
				}

				if (pNumList.contains(val + 15)) {
					list.add(val + 15);
				}
				if (pNumList.contains(val - 8)) {
					list.add(val - 8);
				}

				if (pNumList.contains(val - 15)) {
					list.add(val - 15);
				}

				adjacencyList.put(val, list);
			}

			// Propagates neighbors from middle columns.
			else {
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
	}

	/**
	 * Returns the created adjacency list.
	 * 
	 * @return adjacency list
	 */
	public HashMap<Integer, List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

}
