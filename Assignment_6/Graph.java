import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph implements GraphInterface<Town,Road> {
	
	HashMap<Town,RoadSet> adjList = new HashMap<>();
	RoadSet edgeSet = new RoadSet();
	int size = 0;
	
	public Graph() {
		
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(Road r : adjList.get(sourceVertex)) {
			if(r.getDestination().equals(destinationVertex)) {
				return r;
			}
		}
		return null;	
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		adjList.get(sourceVertex).add(new Road(temp));
		adjList.get(destinationVertex).add(new Road(temp));
		edgeSet.add(temp);
		return temp;
	} 

	@Override
	public boolean addVertex(Town v) {
		if(!adjList.containsKey(v)) {
			adjList.put(v, new RoadSet());
			size++;
			return true;
		}	
		return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road r : adjList.get(sourceVertex)) {
			if(r.getDestination().equals(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		if(adjList.containsKey(v)) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		RoadSet temp = new RoadSet(adjList.get(vertex));
		return temp;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road temp = null;
		Set<Road> sourceRoads = adjList.get(sourceVertex);
		Set<Road> destRoads = adjList.get(destinationVertex);
		for(Road r : sourceRoads) {
			if(r.getDestination().equals(destinationVertex)) {
				temp = r;
				sourceRoads.remove(r);
				destRoads.remove(r);
			}
		}
		return temp;
	}

	@Override
	public boolean removeVertex(Town v) {
		if(adjList.containsKey(v)) {
			adjList.remove(v);
			size--;
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
	}

	@Override
	public Set<Road> edgeSet() {
		return edgeSet;
	}

	@Override
	public Set<Town> vertexSet() {
		return(adjList.keySet());
	} 

}
