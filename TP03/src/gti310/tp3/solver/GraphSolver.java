package gti310.tp3.solver;
/**
 * Classe qui résolvera le problème de l'optimisation de route avec le graphe passée en paramètre
 * @author eric
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import gti310.tp3.data.Graph;
import gti310.tp3.data.OptimisedRoute;
import gti310.tp3.data.ResolutionTable;
import gti310.tp3.data.Route;


public class GraphSolver implements Solver<Graph, OptimisedRoute>{
	
	// faire nouvel objet de stockage pour la sortie
	
	ResolutionTable resolve = new ResolutionTable();
	
	@Override
	public OptimisedRoute solve(Graph inputGraph) {

		// on initialise toutes nos structures
		
		
		resolve.initialise(inputGraph.getSummitsList());
		Vector<Integer> vectSommetsRestants = new Vector<Integer>();
		Vector<Integer> vectSommetsTraites = new Vector<Integer>();
		ArrayList<Route> routes = inputGraph.getRoutes();
		
		// etat initial
		printForAnthony(resolve);

		
		int sommetActuel = inputGraph.getStartPoint();
		vectSommetsRestants.addAll(inputGraph.getSummitsList());
		
		// initialiser le point de départ
		for (int i = 0; i < resolve.getSummitList().size(); i++) {
			if(sommetActuel == resolve.getSummitList().get(i)){
				resolve.getWeightList().set(i, 0);
			}
		}
		
		// pour trouver tout les voisins du noeud actuel
		for (int j = 0; j < routes.size(); j++) {
			if(routes.get(j).getSource() == sommetActuel){
				for (int i = 0; i < resolve.getSummitList().size(); i++) {
					if(routes.get(j).getDestination() == resolve.getSummitList().get(i)){
						System.out.println("Sommet: " + routes.get(j).getDestination());
						System.out.println("Distance: " + routes.get(j).getWeight());
						
						relaxer(sommetActuel, routes.get(j).getDestination(), routes.get(j).getWeight());
						
					}
				}
			}
		}
		
			
		printForAnthony(resolve);
		
		return null;
}
	




	// Adapté depuis: http://stackoverflow.com/questions/18525474/java-minimum-and-maximum-values-in-array
	public static int getMinValue(int[] array){  
		int minValue = 99999999;  
		for(int i = 0; i < array.length; i++){  
			if(!(array[i] == 0)){
				if((array[i] < minValue)){  
					minValue = array[i];  
				}  
			}
		}  
		return minValue;  
	}  
	
	
	private void printForAnthony(ResolutionTable resolve) {

		System.out.println("Summit, Parent, Weight, IsVisited?");
		for (int i = 0; i < resolve.getSummitList().size(); i++) {
			System.out.print(resolve.getSummitList().get(i) + ",");
			System.out.print(resolve.getParentList().get(i) + ",");
			System.out.print(resolve.getWeightList().get(i) + ",");
			System.out.print(resolve.getVisitedList().get(i));
			
			System.out.println();
		}
	}
	
	
	
	private void relaxer(int sommetActuel, Integer sommetDestination, Integer poid){
		//resolve.  -> voir notes de cours diapos 8-38, 8-39: ANTHONY
		
		// la distance actuelle + poid entre les deux points < distance initiale(infini)
		//		0               + 500 (sommet2) < 999999
		//if()
		
	}
}
