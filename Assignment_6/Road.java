
public class Road implements Comparable<Road> {
	
	Town source, destination;
	int weight;
	String name; 

	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		weight = degrees;
		this.name = name;
	}
	
	public Road(Road r) {
		this.source = r.getSource();
		this.destination = r.getDestination();
		weight = r.getWeight();
		this.name = r.getName();
	}
	
	@Override
	public boolean equals(Object r) {
		if(!(r instanceof Road)) {
			return false;
		}
		Road temp = (Road) r;
		if((this.source.equals(temp.getSource()) || this.source.equals(temp.getDestination()))) {
			if(this.destination.equals(temp.getDestination()) || this.destination.equals(temp.getSource())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equivalentRoad(Road r) {
		return(this.source.equals(r.getSource()) && this.destination.equals(r.getDestination()));
	}
	
	@Override
	public int compareTo(Road o) {
		if(this.weight < o.getWeight()) {
			return -1;
		}
		if(this.weight == o.getWeight()) {
			return 0;
		}
		if(this.weight > o.getWeight()) {
			return 1;
		}
	}
	
	public Town getSource() {
		return source;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return(this.name.hashCode());
	}
	
	
	
	

}
