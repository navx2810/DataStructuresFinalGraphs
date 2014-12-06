import java.io.File;

import util.EdgeNodeBuilder;
import entities.Graph;
import graphs.WDGraph;
import graphs.WGraph;


public class Driver {

	public static void main(String[] args) 
	{
		WDGraph graph = new WDGraph();
		
		EdgeNodeBuilder edgeNodeBuilder = new EdgeNodeBuilder(graph);
		
		edgeNodeBuilder.readFromFile(new File("final.data"));
		
//		JFileChooser chooser = new JFileChooser();
//		
//		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
//			edgeNodeBuilder.readFromFile(chooser.getSelectedFile());
	}

}
