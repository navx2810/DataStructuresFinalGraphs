package sections;

import entities.Node;
import graphs.WGraph;

public class E {

	public WGraph graph;
	
	public E() 
	{
		System.out.println("***************************************************************\n*****\tProgram Output for Section E\t*****\n***************************************************************");
		
		graph = new WGraph();
		
		for(int x = 0; x < 6; x++)
			graph.nodes.add(new Node(x));
		
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(2), 3.0);
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(5), 2.0);
		graph.addEdge(graph.nodes.get(1), graph.nodes.get(0), 2.0);
		
		graph.addEdge(graph.nodes.get(2), graph.nodes.get(5), 4.0);
		graph.addEdge(graph.nodes.get(2), graph.nodes.get(1), 1.0);
		
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(2), 9.0);
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(4), 3.0);
		graph.addEdge(graph.nodes.get(3), graph.nodes.get(5), 2.0);
		
		graph.addEdge(graph.nodes.get(4), graph.nodes.get(3), 2.0);
		graph.addEdge(graph.nodes.get(4), graph.nodes.get(5), 4.0);
		
		graph.addEdge(graph.nodes.get(5), graph.nodes.get(4), 4.0);
		
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
