import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import util.EdgeNodeBuilder;
import entities.Node;
import entities.PathFinder;
import graphs.WDGraph;


public class PathManager {

	WDGraph graph;
	Queue<Node> startNodes, endNodes;
	Queue<PathFinder> pathFinders;
	
	public PathManager(File dataFile)
	{
		graph = new WDGraph();
		startNodes = new LinkedList<Node>();
		endNodes = new LinkedList<Node>();
		pathFinders = new LinkedList<PathFinder>();
		
		setUpGraph(dataFile);
		setUpFinders();
	}
	
	public void findPaths()
	{
		while( !pathFinders.isEmpty() )
			pathFinders.poll().findBestPath();
	}

	private void setUpFinders() {
		while( !startNodes.isEmpty() && !endNodes.isEmpty() )
			pathFinders.add(new PathFinder(graph, startNodes.poll(), endNodes.poll()));
	}

	private void setUpGraph(File file) {
		EdgeNodeBuilder builder = new EdgeNodeBuilder(graph);
		builder.readFromFile(file);
		startNodes = builder.getStartNodes();
		endNodes = builder.getEndNodes();
	}

}
