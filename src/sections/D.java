package sections;

import entities.Node;
import graphs.DGraph;

public class D {

	public DGraph graph;
	
	public D() 
	{
		System.out.println("***************************************************************\n*****\tProgram Output for Section D\t*****\n***************************************************************");
		
		graph = new DGraph();
		
		for(int x = 0; x < 6; x++)
			graph.nodes.add(new Node(x));
		
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(2));
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(5));
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(0));
		
		graph.addEdge(graph.nodes.get(2), graph.nodes.get(5));
		graph.addEdge(graph.nodes.get(2), graph.nodes.get(1));
		
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(2));
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(4));
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(5));
		
		graph.addEdge(graph.nodes.get(4), graph.nodes.get(3));
		graph.addEdge(graph.nodes.get(4), graph.nodes.get(5));
		
		graph.addEdge(graph.nodes.get(5), graph.nodes.get(4));
		
		String s = "V2 is adjacent to: ";
		for( Node node : graph.nodes.get(2).getAdjacentNodes() )
			s += node + " ";
		System.out.println(s);
		
		s = "V5 is adjacent to: ";
		for( Node node : graph.nodes.get(5).getAdjacentNodes() )
			s += node + " ";
		System.out.println(s + "\n\n");
	}

}
