/**
 *CS 560
 * SPRING 2018
 * Group Project:
 * Minimal-Cost Path through a Hexagonally-Tiled Map
 * Group 23: BROWN, TITUS - LAL, JAYTI - PENALOZA, LUZ - SCHIELE, REBECCA
 */

package shortestPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author LAL, JAYTI - PENALOZA, LUZ: preliminary input, try-catch statements
 * @author SCHIELE, REBECCA: buffered reader implementation, lister, getters,
 *         cleanup, comments
 *
 */
class Populator {
	int s;
	int e;
	StringTokenizer st;
	String[] token;
	int tokenCount = 0;

	// ARRAY SETUP
	ArrayList<Integer> positionNumberList = new ArrayList<Integer>();
	ArrayList<Integer> costList = new ArrayList<Integer>();
	ArrayList<Double> edgeWeightList = new ArrayList<Double>();

	/**
	 * Reads input from a text file and uses token comparisons to set up list of
	 * valid entries.
	 */
	public Populator() {
		try {
			BufferedReader buffR = null;
			FileReader fileR = null;
			File in = new File("testInputA.txt");
			// File("C:/Users/Owner/Desktop/CS560/HexShortestPath/Inputb.txt");
			fileR = new FileReader(in);
			buffR = new BufferedReader(fileR);

			// What happens when a text file is empty
			if (buffR.readLine() == null) {
				System.out.println("Please supply a nonempty textfile.");
				java.lang.System.exit(-3);
			}
			String thisLine;

			while ((thisLine = buffR.readLine()) != null) {
				token = thisLine.split(" ");
				st = new StringTokenizer(thisLine);

				// Only takes input from when both required columns have data.
				if (st.countTokens() == 2) {
					lister();
				}
			}
			buffR.close();
			fileR.close();
		} catch (IOException ex) {
			Logger.getLogger(Populator.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Creates working lists with position numbers whose costs are greater than
	 * zero.
	 */
	void lister() {
		if ((isNumeric(token[1])) && (Integer.parseInt(token[1]) > 0)) {

			// Required for verifying correct start.
			if (Integer.parseInt(token[0]) == 226) {
				s = Integer.parseInt(token[0]);
			}

			// Required for verifying correct end.
			if (Integer.parseInt(token[0]) == 8) {
				e = Integer.parseInt(token[0]);
			}

			positionNumberList.add(Integer.parseInt(token[0]));
			costList.add(Integer.parseInt(token[1]));
			edgeWeightList.add(Double.parseDouble(token[1]) / 2);
		}
	}

	/**
	 * Returns starting position number. 226 when present and zero when not.
	 * 
	 * @return starting position number
	 */
	public int getStart() {
		return s;
	}

	/**
	 * Returns ending position number. 8 when present and zero when not.
	 * 
	 * @return ending position number
	 */
	public int getEnd() {
		return e;
	}

	/**
	 * Returns the position number list.
	 * 
	 * @return position number list
	 */
	public List<Integer> getPositionNumberList() {
		return positionNumberList;
	}

	/**
	 * Returns the edge weight list.
	 *
	 * @return edge weight list
	 */
	public List<Double> getEdgeWeightList() {
		return edgeWeightList;
	}

	/**
	 * Determines if a token is numeric.
	 * 
	 * @param str
	 *            A given token
	 * @return true if numeric and false if not.
	 */
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
