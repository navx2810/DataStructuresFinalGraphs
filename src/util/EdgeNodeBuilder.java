package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import entities.Graph;
import entities.Node;


/*
 * http://en.wikipedia.org/wiki/Graph_traversal
 */
public class EdgeNodeBuilder 
{
	private enum state { VERTICIES, EDGES, CASES }
	
	private ArrayList<Node> nodes;
	private Queue<Node> startNodes, endNodes;
	private Graph graph;
	
	public EdgeNodeBuilder(Graph graph) 
	{
		this.graph = graph;
		nodes = new ArrayList<Node>();
		startNodes = new LinkedList<Node>();
		endNodes = new LinkedList<Node>();
	}
	
	public void readFromFile(File file)
	{
		try 
		{
			Scanner scanner = new Scanner(file);
			
			@SuppressWarnings("unused")
			int numOfVertices = Integer.parseInt(scanner.nextLine());
			
			state readingState = null;
			
			while ( scanner.hasNext() )
			{
				String line = scanner.nextLine();
				if ( line.equals("V") )
					readingState = state.VERTICIES;
				else if ( line.equals("E") )
					readingState = state.EDGES;
				else if ( line.equals("N") )
					readingState = state.CASES;
				
				switch (readingState) 
				{
				case VERTICIES:
					readNode(line);
					break;
				case EDGES:
					readEdge(line);
					break;
				case CASES:
					readCase(line);
					break;
				default:
					break;
				}
			}
			
			scanner.close();
			this.graph.nodes = nodes;
			this.graph.endNodes = endNodes;
			this.graph.startNodes = startNodes;
			
			
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		
	}
	
	private void readNode(String line)
	{
		String[] container = line.split(",");
		int id = Integer.parseInt(container[0]);
		int longitude = Integer.parseInt(container[1]);
		int latitude = Integer.parseInt(container[2]);
		int height  = Integer.parseInt(container[3]);
		
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
			a.addEdgeTo(b);
		else
		{
			a.addEdgeTo(b);
			b.addEdgeTo(a);
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
