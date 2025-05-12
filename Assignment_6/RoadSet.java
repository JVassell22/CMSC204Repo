import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class RoadSet implements Set<Road>{
	
	LinkedList<Road> roadList;
	
	public RoadSet() {
		roadList = new LinkedList<>();
	}
	
	public RoadSet(LinkedList<Road> r) {
		roadList = new LinkedList<>(r);
	}

	public RoadSet(RoadSet roadSet) {
		roadList = new LinkedList<>(roadSet);
	}

	@Override
	public int size() {
		return roadList.size();
	}

	@Override
	public boolean isEmpty() {
		return(roadList.isEmpty());
	}

	@Override
	public boolean contains(Object o) {
		return(roadList.contains(o));
	}

	@Override
	public Iterator<Road> iterator() {
		return(roadList.iterator());
	}

	@Override
	public Object[] toArray() {
		return(roadList.toArray());
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(Road e) {
		return(roadList.add(e));
	}

	@Override
	public boolean remove(Object o) {
		return(roadList.remove(o));
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return(roadList.containsAll(c));
	}

	@Override
	public boolean addAll(Collection<? extends Road> c) {
		return(roadList.addAll(c));
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return(roadList.retainAll(c));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return(roadList.removeAll(c));
	}

	@Override
	public void clear() {
		roadList.clear();
	}

}
