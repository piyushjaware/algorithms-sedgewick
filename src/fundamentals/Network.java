package fundamentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Network {

	private static List<Connection> connections = new ArrayList<Connection>();

	public static void main(String[] args) {

		int[][] a = { { 1, 2 }, { 3, 4 }, { 1, 4 } };

		Connection c0 = new Connection();
		c0.addSites(a[0][0], a[0][1]);
		connections.add(c0);

		for (int i = 1; i < a.length; i++) {
			handleConnection(a[i][0], a[i][0]);
		}
	}

	private static void handleConnection(int site1, int site2) {
		Map<Integer, Integer> r = new HashMap<Integer, Integer>();
		r.put(site1, null);
		r.put(site2, null);

		for (Entry<Integer, Integer> entry : r.entrySet()) {
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).has(entry.getKey())) {
					entry.setValue(i);
				}
			}
		}

		if (r.get(0) != null && r.get(0) == r.get(1)) {
			// both sites belong to one connection

		} else if (r.get(0) != null && r.get(1) != null) {
			// both sites belong to different conns
		} else if (r.get(0) != null && r.get(1) == null) {
			// add site1
		} else if (r.get(0) == null && r.get(1) != null) {
			// add site2
		} else {
			// both null. create a new connection
		}

		System.out.println(connections);

	}

}
