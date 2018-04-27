/**
 * 
 */

package shortestPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Owner
 * @param <T>
 *
 */
class Populator {

	String[] token;
	ArrayList<Integer> positionNumberList = new ArrayList<Integer>();
	ArrayList<Integer> costList = new ArrayList<Integer>();
	ArrayList<Double> edgeWeightList = new ArrayList<Double>();

	/**
	 * @return
	 * @return
	 * 
	 */
	public Populator() {

		try {
			// Scanner userInput = new Scanner(System.in);
			// String inFileName;
			BufferedReader buffR = null;
			FileReader fileR = null;

			// System.out.print("Please provide input file name. ");
			// inFileName = userInput.nextLine().trim();
			File in = new File("testInputA.txt");
			// File("C:/Users/Owner/Desktop/CS560/HexShortestPath/Inputb.txt");
			// File in = new File(inFileName);
			// Scanner file = new Scanner(new
			// File("C:/Users/Owner/Desktop/CS560/HexShortestPath/Input.txt"));

			fileR = new FileReader(in);
			// fileR = new FileReader(inFileName);
			buffR = new BufferedReader(fileR);

			String thisLine;

			while ((thisLine = buffR.readLine()) != null) {
				token = thisLine.split(" ");

				lister();

			}
			buffR.close();
			fileR.close();

		} catch (IOException ex) {
			Logger.getLogger(Populator.class.getName()).log(Level.SEVERE, null, ex);
		}
		// return triplet;
	}

	public List<Integer> getPositionNumberList() {
		return positionNumberList;
	}

	public ArrayList<Integer> getCostList() {
		return costList;
	}

	public List<Double> getEdgeWeightList() {
		return edgeWeightList;
	}

	void lister() {
		if (Integer.parseInt(token[1]) > 0) {
			positionNumberList.add(Integer.parseInt(token[0]));
			costList.add(Integer.parseInt(token[1]));
			edgeWeightList.add(Double.parseDouble(token[1]) / 2);
		}

	}
	
}

