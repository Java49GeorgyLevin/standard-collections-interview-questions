package telran.interviews;

import java.util.*;

public class ConnectionsPoolImpl implements ConnectionsPool {
	
	LinkedHashMap<Integer, HashMap<String, Integer>> connections;
	
	int limit; //limit of connections number in a pool
	public ConnectionsPoolImpl(int limit) {
		this.limit = limit;
		
		connections = new LinkedHashMap<>(16, 0.75f, true) {
			 protected boolean removeEldestEntry(Map.Entry<Integer, HashMap<String, Integer>> eldest) {
				return size() > limit;
			}
		};			
	};


	
	@Override
	public boolean addConnection(Connection connection) {
		if(connections.containsKey(connection.id)) {
			return false;
		} else {
			HashMap<String, Integer> ipAddressPort = new HashMap<>();
			ipAddressPort.put(connection.ipAddress, connection.port);
			connections.put(connection.id, ipAddressPort);
		}
		return true;
	}

	@Override
	public Connection getConnection(int id) {
		Connection conn = null;
		
		if(connections.containsKey(id)) {
			HashMap<String, Integer> ipAddressPort = connections.get(id);
			String ipAddress = (String) ipAddressPort.keySet().toArray()[0];
			int port = ipAddressPort.get(ipAddress);
			
			conn = new Connection(id, ipAddress, port);
			connections.remove(id);
			addConnection(conn);
		}
		
		// TODO Auto-generated method stub
		return conn;
	}

	

}
