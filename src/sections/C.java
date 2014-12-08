package sections;
import entities.Node;
import graphs.WDGraph;


public class C {

	public C()
	{
		
		System.out.println("***************************************************************\n*****\tProgram Output for Section C\t*****\n***************************************************************");
		
		WDGraph wdGraph = new WDGraph();
		
		for(int x = 0; x < 6; x++)
			wdGraph.nodes.add(new Node(x));
		
		Node currentNode = wdGraph.nodes.get(1);
		currentNode.addEdgeTo(wdGraph.nodes.get(2), 3);
		currentNode.addEdgeTo(wdGraph.nodes.get(5), 2);
		
		currentNode = wdGraph.nodes.get(2);
		currentNode.addEdgeTo(wdGraph.nodes.get(5), 4);
		currentNode.addEdgeTo(wdGraph.nodes.get(1), 1);
		
		currentNode = wdGraph.nodes.get(3);
		currentNode.addEdgeTo(wdGraph.nodes.get(2), 9);
		currentNode.addEdgeTo(wdGraph.nodes.get(4), 3);
		currentNode.addEdgeTo(wdGraph.nodes.get(5), 2);
		
		currentNode = wdGraph.nodes.get(4);
		currentNode.addEdgeTo(wdGraph.nodes.get(3), 2);
		currentNode.addEdgeTo(wdGraph.nodes.get(5), 4);
		
		currentNode = wdGraph.nodes.get(5);
		currentNode.addEdgeTo(wdGraph.nodes.get(4), 4);
		
		String s = "V2 is adjacent to: ";
		for( Node node : wdGraph.nodes.get(2).getAdjacentNodes() )
			s += node + " ";
		System.out.println(s);
		
		s = "V5 is adjacent to: ";
		for( Node node : wdGraph.nodes.get(5).getAdjacentNodes() )
			s += node + " ";
		System.out.println(s);
	
	}
	
}
