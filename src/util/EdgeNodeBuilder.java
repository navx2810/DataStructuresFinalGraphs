package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import entities.Node;
import graphs.WDGraph;


/*
 * http://en.wikipedia.org/wiki/Graph_traversal
 */
public class EdgeNodeBuilder 
{
	private enum state { VERTICIES, EDGES, CASES }
	
	private ArrayList<Node> nodes;
	private Queue<Node> startNodes, endNodes;
	private WDGraph graph;
	
	public EdgeNodeBuilder(WDGraph graph) 
	{
		this.graph = graph;
		nodes = graph.nodes;
		startNodes = new LinkedList<Node>();
		endNodes = new LinkedList<Node>();
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
			System.out.println("done");
			
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
		
		nodes.add(new Node(id, container[3], longitude, latitude, height));
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
			graph.addEdge(a, b);
		else
		{
			graph.addEdge(a, b);
			graph.addEdge(b, a);
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
	
}
