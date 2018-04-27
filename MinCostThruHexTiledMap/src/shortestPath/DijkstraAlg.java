/**
 * 
 */
package shortestPath;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Owner
 *
 */
class DijkstraAlg {
	int currentVertex;
	int currVerIndex;
	int currAdjNIndex;
	int distIndex;
	int parIndex;
	int w;
	int MAXV = 233;
	int start = 226;
	double MAXDOUB = 9999.0;
	double currentWeight;
	double dist;
	Boolean[] inTree;
	// List<Integer> pNumList;
	Double[] distance;
	Integer[] parent;
	// Populator validEntries;
	// AdjacencyChecker aCheck;
	int currentAdjNeighbor;
	List<Integer> pNumList;
	private int curVertIndex;
	// List<Double> cList;

	/**
		 * 
		 */

	public DijkstraAlg() {

		currVerIndex = 0;
		currAdjNIndex = 0;
		distIndex = 0;
		parIndex = 0;
		Populator validEntries = new Populator();

		List<Integer> cList = validEntries.getCostList();
		List<Double> eWeightList = validEntries.getEdgeWeightList();
		AdjacencyChecker aCheck = new AdjacencyChecker();
		// MAXV = pNumList.size();
		inTree = new Boolean[68 + 1];
		distance = new Double[68 + 1];
		parent = new Integer[68 + 1];

		pNumList = validEntries.getPositionNumberList();
		currentVertex = start;
		currVerIndex = pNumList.indexOf(currentVertex);
		currentVertex = start;
	//	System.out.println(currentVertex);
		initialize(currVerIndex);
		int aCheckCount = 0;
		// int[] aCheckPrim = ((Collection<Integer>)
		// aCheck.getAdjacencyList()).stream().mapToInt(Integer::intValue).toArray();
		// for (int i = 0; i < 233; i++) {
		// System.out.println(aCheck.getAdjacencyList().get(i));
		// if (aCheck.getAdjacencyList().get(i) != null) {
		// System.out.println(aCheck.getAdjacencyList().get(i));

		// }
		// System.out.println(aCheck.getAdjacencyList().containsKey(validEntries));
		// }

		// int j = 0;
		// System.out.println(pNumList.indexOf(currentVertex));
		while (!inTree[currVerIndex] && (currentVertex != 8)) {
			/*
			 * 21 while ( !intree[v] ) 22 { 23 intree[v] = TRUE ; //21 While the
			 * current vertex is not in the tree, //23 place the current vertex
			 * in the tree
			 */
			// j++;
			inTree[currVerIndex] = Boolean.TRUE;
			// System.out.println(aCheck.getAdjacencyList().get(38));

			// }
			// System.out.println(pNumIndex);
			// System.out.println(pNumList.);
			/*
			 * 24 p = g-> edges[v] ; 25 while ( p != NULL ) 26 { 27 w = p->y ;
			 * 28 weight = p->weight ; //24 get the adjacency list for the
			 * current vertex. //25 while there are unvisited adjacent
			 * neighbors, //27 Visit the next unvisited neighbor and get its
			 * vertex //28 Set weight equal to the edge weight of the currently
			 * visited adjacent neighbor //29-33 relax() //34 Go to the next
			 * unvisited neighbor (may be redundant.)
			 */
			// int j = 0;
			// currVerIndex = pNumList.indexOf(currentVertex);

			// while (aCheck.getAdjacencyList().get(j) != null) {
			// while(currentVertex != 8)
			// int j = 0;

			for (int j = 0; j < (aCheck.getAdjacencyList().get(currentVertex).size()); j++) {
				// do{
				// if(currentVertex != 8){
				currentAdjNeighbor = aCheck.getAdjacencyList().get(currentVertex).get(j);
				// if ((currentAdjNeighbor != null)) {

				// if (aCheck.getAdjacencyList().get(currentVertex).get(j)
				// != null) {
				// System.out.println(aCheck.getAdjacencyList().get(currentVertex).get(j));
				currentWeight = eWeightList.get(currVerIndex);
				// System.out.println(currentWeight);
				relax(pNumList);
				// if(currentVertex == 8){
				// break;
				// }
				// }
				// }
				// j++;
				// }while(currentAdjNeighbor != 8);

			}

			// line36
			currentVertex = 1;
			dist = MAXDOUB;
			for (int i = 1; i <= 68; i++)
				if (!inTree[i] && (dist > distance[i])) {
					dist = distance[i];
					currentVertex = pNumList.get(i);
					currVerIndex = i;
				}

			// System.out.println(currentVertex);

//			pathOut(aCheck, start, currentVertex);
		}

		//for (int i = 0; i < parent.length - 1; i++) {
			pathOut(aCheck, start, currentVertex);
		//PathOut pathOut = new PathOut(aCheck, start, currentVertex);
			// System.out.println(parent[i]);
			// System.out.println(pNumList.get(i) + " " + distance[i] + " " +
			// parent[i]);
		//}

	}
	/*
	 * 36 v = 1 ; 37 dist = MAXINT ; 38 for ( i = 1 ; i <= g->nvertices ; i++ )
	 * 39 if ( !intree[i] && (dist > distance[i]) ) 40 { 41 dist = distance[i] ;
	 * 42 v = i ; 43 } 44 } //36 Set the current vertex equal to 1
	 * 
	 * //37 Set the current shortest distance equal to MAXINT
	 * 
	 * //38 For index i from 1 to the number of vertices in the graph
	 * 
	 * //39 If the value located in the intree array at the position of index i
	 * is FALSE AND the current distance is greater than the value of the
	 * distance array located in the position of index i
	 * 
	 * //41 Then set the current distance equal to value of the distance array
	 * located in the position of
	 * 
	 * //42 Also, set the value of the current vertex equal to index i.
	 */

	// aCheck.getAdjacencyList()
	// .forEach((k, v) -> System.out.println("Position Number: " + k + "
	// Adjacent Vertices: " + v));
	// System.out.println(aCheck.getAdjacencyList().values());
	// System.out.println(aCheck.getAdjacencyList().get(i));

	// for (int k = 1; k <
	// aCheck.getAdjacencyList().values().size(); k++) {
	// System.out.println("A check: " + aCheckCount++ + " " +
	// aCheck.getAdjacencyList().get(k));
	// }
	// System.out.println(aCheck.getAdjacencyList().values().size());

	// }
	// }

	void initialize(int currVerIndex2) {
		Arrays.fill(inTree, Boolean.FALSE);
		Arrays.fill(distance, MAXDOUB);
		Arrays.fill(parent, -1);
		distance[currVerIndex2] = 0.0;
	}

	void relax(List<Integer> pNumList) {
		/*
		 * 29 >>> if ( distance[w] > (distance[v] + weight) ) 30 { 31 >>>
		 * distance[w] = distance[v] + weight ; 32 parent[w] = v ; 33 }
		 * 
		 * 
		 * // 29 If the value of the distance array located in the position of
		 * the vertex of the currently visited adjacent neighbor is greater than
		 * the sum of the value of the distance array located in the position of
		 * the current vertex and weight,
		 * 
		 * //31 then set value of the distance array located in the position of
		 * the vertex of the currently visited adjacent neighbor equal the sum
		 * of the value of the distance array located in the position of the
		 * current vertex and weight.
		 * 
		 * // 32 Also, place the current vertex in the location of the parent
		 * array which corresponds to the vertex of the currently visited
		 * adjacent neighbor.
		 */
		// validEntries = new Populator();

		// pNumList = validEntries.getPositionNumberList();

		currAdjNIndex = pNumList.indexOf(currentAdjNeighbor);
		if (distance[currAdjNIndex] > (distance[currVerIndex] + currentWeight)) {
			distance[currAdjNIndex] = (distance[currVerIndex] + currentWeight);
			parent[currAdjNIndex] = currentVertex;
		}
	}
	/*
	 * if(distance[currentAdjNeighbor]>(distance[currentVertex]+currentWeight))
	 * 
	 * { // take // smaller // distance distance[currentAdjNeighbor] =
	 * (distance[currentVertex] + currentWeight); parent[currentAdjNeighbor] =
	 * currentVertex; }
	 * 
	 * }
	 */

	void pathOut(AdjacencyChecker adjC, int s, int cVert) {
		Populator validEntries = new Populator();
		pNumList = validEntries.getPositionNumberList();
		curVertIndex = pNumList.indexOf(cVert);
		if (cVert == s) {
			System.out.println(s);
		}

		else if (parent[curVertIndex] == -1) {

		}

		else {
			//cVert = parent[currVerIndex];
			pathOut(adjC, s, parent[curVertIndex]);
			System.out.println(cVert);
		}
	}

	/*
	 * void findMin() { Map.Entry<Integer, List<Integer>> maxEntry = null; for
	 * (int i = 0; i < aCheck.getAdjacencyList().values().size(); i++) {
	 * aCheck.getAdjacencyList().get(i); } for (Map.Entry<Integer,
	 * List<Integer>> entry : aCheck.getAdjacencyList().entrySet()) { // if
	 * (maxEntry == null || ((Boolean) //
	 * entry.getValue()).compareTo(maxEntry.getValue()) > 0) // { // maxEntry =
	 * entry; // } // Math.max(entry.getValue()); }
	 * 
	 * }
	 */
}
