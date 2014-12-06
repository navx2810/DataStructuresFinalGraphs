package graphs;

import java.util.ArrayList;

import entities.Node;

public class WDGraph 
{
	public ArrayList<Node> nodes;	// Adjacency List
	public Node entry, destination;
	
	public WDGraph() 
	{
		nodes = new ArrayList<Node>();
	}
		
	public void addEdge(Node origin, Node destination)
	{
		origin.addEdgeTo(destination, calculateDistances(origin, destination));
	}
	
	protected double calculateDistances(Node origin, Node destination)
	{
		double lat1 = origin.latitude;
		double lng1 = origin.longitude;
		double lat2 = destination.latitude;
		double lng2 = destination.longitude;
		
		double earthRadius = 3958.75;	// Converts to Miles
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	}

	public void setEntryAndDestination(Node entry, Node destination) 
	{
		this.entry = entry;
		this.destination = destination;
	}
}
