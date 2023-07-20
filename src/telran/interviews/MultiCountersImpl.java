package telran.interviews;

import java.util.*;


public class MultiCountersImpl implements MultiCounters {
	
	private HashMap<Object, Integer> items;
	private TreeMap<Integer, HashSet<Object>> setOfItem;
	public MultiCountersImpl() {
		items = new HashMap<>();
		setOfItem = new TreeMap<>();
	}
	

	@Override
	public Integer addItem(Object item) {
		Integer q = items.get(item);		

		if(q != null) {
			removeAndAdd(item, q, "remove");			
		} else {
			q = 0;
		}

		removeAndAdd(item, q + 1, "add");		
		items.put(item, q + 1);

		return q + 1;
	}
	
	private void removeAndAdd(Object item, int q, String removeOrAdd) {
		HashSet<Object> setObjects = setOfItem.get(q) == null ? 
				new HashSet<>() : setOfItem.get(q);
		if(removeOrAdd == "add") {			
			setObjects.add(item);
		}
		if(removeOrAdd == "remove") { 
			setObjects.remove(item);			
		}
		setOfItem.put(q, setObjects);
		
		if(setObjects.isEmpty()) {
			setOfItem.remove(q);
		}
		
		
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer q = items.get(item);
		boolean res = q != null;
		if (res == true) {
			items.remove(item);
			removeAndAdd(item, q, "remove");
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		return setOfItem.isEmpty() ? 
				new HashSet<Object>(0) 
				: setOfItem.get(setOfItem.lastKey());
	}

}
