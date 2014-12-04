import javax.swing.JFileChooser;

import util.EdgeNodeBuilder;
import entities.Graph;


public class Driver {

	public static void main(String[] args) 
	{
		Graph graph = new Graph();
		
		EdgeNodeBuilder edgeNodeBuilder = new EdgeNodeBuilder(graph);
		
		JFileChooser chooser = new JFileChooser();
		
		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
			edgeNodeBuilder.readFromFile(chooser.getSelectedFile());
	}

}
