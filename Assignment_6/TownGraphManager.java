import java.util.ArrayList;

public class TownGraphManager implements TownGraphManagerInterface{
	
	public Graph townGraph = new Graph();
	
	public TownGraphManager() {
	
	}
	

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town temp1 = new Town(town1);
		Town temp2 = new Town(town2);
		townGraph.addEdge(temp1, temp2, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town temp1 = new Town(town1);
		Town temp2 = new Town(town2);
		return(townGraph.getEdge(temp1, temp2).getName());
	}

	@Override
	public boolean addTown(String v) {
		Town temp = new Town(v);
		if(townGraph.containsVertex(temp)) {
			return false;
		}
		townGraph.addVertex(temp);
		return true;
	}

	@Override
	public Town getTown(String name) {
		Town temp = new Town(name);
		if(townGraph.containsVertex(temp)) {
			return temp;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town temp = new Town(v);
		return(townGraph.containsVertex(temp));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roadNames = new ArrayList<>();
		for(Road r : townGraph.edgeSet()) {
			roadNames.add(r.getName());
		}
		return roadNames;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town temp1 = new Town(town1);
		Town temp2 = new Town(town2);
		if(townGraph.getEdge(temp1, temp2).equals(road)) {
			Road tempRoad = townGraph.getEdge(temp1, temp2);
			townGraph.removeEdge(tempRoad.getSource(),tempRoad.getDestination(),tempRoad.getWeight(),tempRoad.getName());
			return true;
		}	
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		Town temp = new Town(v);
		return(townGraph.removeVertex(temp));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String>townNames = new ArrayList<>();
		for(Town t : townGraph.vertexSet()) {
			townNames.add(t.getTownName());
		}
		return townNames;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

}
