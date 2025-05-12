import java.util.LinkedList;

public class Town implements Comparable<Town> {
	
	String townName;
	LinkedList<Town> adjTowns = new LinkedList<>();
	
	
	
	public Town(String townName) {
		this.townName = townName;
	}
	
	public Town(Town T) {
		this.townName = T.getTownName();
	}

	@Override
	public int compareTo(Town o) {
		return(townName.compareTo(o.getTownName()));
	}
	
	public String getTownName() {
		return townName;
	}
	
	public String getName() {
		return townName;
	}
	
	public void addAdjTown(Town t) {
		adjTowns.add(t);
	}
	
	@Override
	public boolean equals(Object t) {
		if(!(t instanceof Town)) {
			return false;
		}	
		Town temp = new Town((Town) t);
		return(this.townName.equals(temp.getTownName()));
	}

	@Override
	public int hashCode() {
		return(this.townName.hashCode());
	}
	
}
