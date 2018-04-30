/**
 *CS 560
 * SPRING 2018
 * Group Project:
 * Minimal-Cost Path through a Hexagonally-Tiled Map
 * Group 23: BROWN, TITUS - LAL, JAYTI - PENALOZA, LUZ - SCHIELE, REBECCA
 *
 * As of 04/29/18, all group members met three times to discuss code implementation for this class.  
 * BROWN, PENALOZA, and SCHIELE discussed implementation of minimum extraction and pathOut on 04/24/18.
 * 
 * PENALOZA and SCHIELE met up briefly on 04/14/18 to discuss Dijkstra's Algorithm implementation.
 */
package shortestPath;

//IMPORTS
import java.util.Arrays;
import java.util.List;

/**
 * @author BROWN, TITUS - PENALOZA, LUZ: relax and minimum extraction
 * @author PENALOZA, LUZ: path out
 * @author SCHIELE, REBECCA: setup, cleanup, comments
 *
 */
public class DijkstraAlg {

	// INSTANCE DECLARATION
	Populator validEntries;
	AdjacencyChecker aCheck;

	// INITIALIZE MARKERS
	int START = 226;
	int END = 8;

	// INIIALIZE NEEDED VERTICES
	int currentVertex = 0;
	int currentAdjNVertex = 0;

	// INITIALIZE INDICES
	int currVerIndex = 0;
	private int curVertIndex;
	int currAdjNIndex = 0;
	int distIndex = 0;
	int parIndex = 0;

	// INITIALIZE WORKING VALUES
	int MAXV = 0;
	double MAXDOUB = 9999.0;
	double currentWeight = 0;
	double dist = 0;
	int aListSize = 0;

	// TREE DECLARATION
	Boolean[] inTree;
	Double[] distance;
	Integer[] parent;

	// LIST DECLARATION
	List<Integer> pNumList;
	List<Double> eWeightList;

	public DijkstraAlg() {
		dijkstraPrep();
		initialize();

		// While the current vertex is not in the tree, place the current vertex
		// in the tree.
		while (!inTree[currVerIndex] && (currentVertex != END)) {
			inTree[currVerIndex] = Boolean.TRUE;

			// Determine the edge weights for the current vertex and adjacent
			// neighbors for relax.
			aListSize = aCheck.getAdjacencyList().get(currentVertex).size();
			for (int j = 0; j < aListSize; j++) {
				currentAdjNVertex = aCheck.getAdjacencyList().get(currentVertex).get(j);
				currentWeight = eWeightList.get(currVerIndex);
				relax();
			}

			// Extract the minimim vertex from inTree.
			currentVertex = 1;
			dist = MAXDOUB;
			for (int i = 1; i <= MAXV; i++)
				if (!inTree[i] && (dist > distance[i])) {
					dist = distance[i];
					currentVertex = pNumList.get(i);
					currVerIndex = i;
				}
		}

		// Print the shortest path.
		pathOut(aCheck, START, currentVertex);
	}

	/**
	 * Instantiates necessary objects, gets needed data, and prepares working
	 * arrays.
	 */
	private void dijkstraPrep() {
		validEntries = new Populator();
		aCheck = new AdjacencyChecker();
		pNumList = validEntries.getPositionNumberList();
		eWeightList = validEntries.getEdgeWeightList();

		if (validEntries.getStart() != START) {
			System.out.println("Start required to be at position 226.");
			java.lang.System.exit(-1);

		}
		if (validEntries.getEnd() != END) {
			System.out.println("End required to be at position 8.");
			java.lang.System.exit(-2);

		} else {
			currentVertex = START;

		}
		currVerIndex = pNumList.indexOf(currentVertex);
		MAXV = pNumList.size();
		inTree = new Boolean[MAXV + 1];
		distance = new Double[MAXV + 1];
		parent = new Integer[MAXV + 1];
	}

	/**
	 * Initializes the working arrays.
	 */
	void initialize() {
		Arrays.fill(inTree, Boolean.FALSE);
		Arrays.fill(distance, MAXDOUB);
		Arrays.fill(parent, -1);
		distance[currVerIndex] = 0.0;
	}

	/**
	 * Updates the optimal distance by choosing the lesser of the current
	 * optimal distance and the distance of the adjacent neighbor. Updates the
	 * parent of the adjacent neighbor when the adjacent neighbor distance is
	 * lesser.
	 */
	void relax() {
		currAdjNIndex = pNumList.indexOf(currentAdjNVertex);
		if (distance[currAdjNIndex] > (distance[currVerIndex] + currentWeight)) {
			distance[currAdjNIndex] = (distance[currVerIndex] + currentWeight);
			parent[currAdjNIndex] = currentVertex;
		}
	}

	/**
	 * Prints out the the vertices of the shortest path based on the
	 * breadth-first tree created by Dijkstra's.
	 * 
	 * @param adjC
	 *            The working instance of AdjacencyChecker
	 * @param s
	 *            The starting vertex
	 * @param cVert
	 *            The current vertex
	 */
	void pathOut(AdjacencyChecker adjC, int s, int cVert) {
		Populator validEntries = new Populator();
		pNumList = validEntries.getPositionNumberList();
		curVertIndex = pNumList.indexOf(cVert);
		if (cVert == s) {
			System.out.println(s);
		} else if (parent[curVertIndex] == -1) {
		} else {
			pathOut(adjC, s, parent[curVertIndex]);
			System.out.println(cVert);
		}
	}

}
