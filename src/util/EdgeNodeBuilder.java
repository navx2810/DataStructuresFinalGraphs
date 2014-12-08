package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import entities.Node;
import graphs.WDGraph;

class CoordStruct
{
	public double latitude, longitude, height;

	public CoordStruct(double latitude, double longitude, double height) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
	}
	
}

/*
 * http://en.wikipedia.org/wiki/Graph_traversal
 */
public class EdgeNodeBuilder 
{
	private enum state { VERTICIES, EDGES, CASES }
	
	private ArrayList<Node> nodes;
	private Queue<Node> startNodes, endNodes;
	private WDGraph graph;
	private HashMap<Node, CoordStruct> coordMap;
	private HashMap<Node, String> locationNameMap;
	
	public EdgeNodeBuilder(WDGraph graph) 
	{
		this.graph = graph;
		nodes = graph.nodes;
		startNodes = new LinkedList<Node>();
		endNodes = new LinkedList<Node>();
		coordMap = new HashMap<Node, CoordStruct>();
		locationNameMap = new HashMap<Node, String>();
	}
	
	public void readFromFile(File file)
	{
		try 
		{
			Scanner scanner = new Scanner(file);
			
			@SuppressWarnings("unused")
			int numOfVertices = Integer.parseInt(scanner.nextLine());		// Calculated through the size of the nodeList
			
			state readingState = state.VERTICIES;
			
			while ( scanner.hasNext() )
			{
				String line = scanner.nextLine();
				
				if( isAnIdentifier(line) )
				{
					switch (readingState) 
					{
					case VERTICIES:
						readingState = state.EDGES; break;
					case EDGES:
						readingState = state.CASES; break;
					case CASES:
						break;
					default:
						readingState = state.VERTICIES; break;
					}
					
				line = scanner.nextLine();
				}
				
				switch (readingState) 
				{
				case VERTICIES:
					readNode(line);
					break;
				case EDGES:
					readEdge(line);
					break;
				default:
					readCase(line);
					break;
				}
			}
			
			scanner.close();
			
			System.out.println("***************************************************************\n*****\tProgram Output for Section K\t*****\n***************************************************************");
			System.out.println("\tFile was read appropriately\n");
			
			System.out.println("***************************************************************\n*****\tProgram Output for Section L\t*****\n***************************************************************");
			System.out.println("\t Graph was created sucessfully\n");
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		
	}
	
	public Queue<Node> getStartNodes() {
		return startNodes;
	}
	
	public Queue<Node> getEndNodes() {
		return endNodes;
	}
	
	private boolean isAnIdentifier(String line) 
	{
		for( char c : line.toCharArray() )
			if ( Character.isWhitespace(c) || c == ',' )
				return false;
		return true;
	}

	private void readNode(String line)
	{
		String[] container = line.split(",");
		int id = Integer.parseInt(container[0]);
		double longitude = Double.parseDouble(container[1]);
		double latitude = Double.parseDouble(container[2]);
		double height  = Double.parseDouble(container[3]);
		
		Node node = new Node(id);
		coordMap.put(node, new CoordStruct(latitude, longitude, height));
		nodes.add(node);
		locationNameMap.put(node, container[4]);
		
//		nodes.add(new GPSNode(id, container[4], longitude, latitude, height));
	}
	
	private void readEdge(String line)
	{
		String[] container = line.split(" ");
		int v_id1 = Integer.parseInt(container[0]);
		int v_id2 = Integer.parseInt(container[1]);
		int edge_state = Integer.parseInt(container[2]);
		
		Node a = nodes.get(v_id1);
		Node b = nodes.get(v_id2);
		
		if ( edge_state == 1)
			graph.addEdge( a, b, calculateDistances( coordMap.get(a), coordMap.get(b) ) );
		else
		{
			graph.addEdge(a, b, calculateDistances( coordMap.get(a), coordMap.get(b) ) );
			graph.addEdge(b, a, calculateDistances( coordMap.get(a), coordMap.get(b) ) );
		}
	}
	
	private void readCase(String line)
	{
		String[] container = line.split(" ");
		Node a = nodes.get( Integer.parseInt(container[0]) );
		Node b = nodes.get( Integer.parseInt(container[1]) );
		
		startNodes.add(a);
		endNodes.add(b);
	}
	
	private double calculateDistances(CoordStruct origin, CoordStruct destination)
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
	
	public HashMap<Node, String> getLocationNameMap() 
	{
		return locationNameMap;
	}
	
}
