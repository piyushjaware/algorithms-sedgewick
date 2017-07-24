package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class Connection {

	private List<Integer> sites = new ArrayList<Integer>();

	public boolean has(int site) {
		return sites.contains(site);
	}

	/**
	 * Add a site to the connection
	 * 
	 * @param site2
	 */
	public void connect(int site2) {
		sites.add(site2);
	}

	public void addSites(int site1, int site2) {
		sites.add(site1);
		sites.add(site2);
	}

	// getters and setters
	public List<Integer> getSites() {
		return sites;
	}

	public void setSites(List<Integer> sites) {
		this.sites = sites;
	}

}
