import java.io.File;


public class Driver {

	public static void main(String[] args) 
	{
		
		PathManager manager = new PathManager(new File("final.data"));
		manager.findPaths();
		
//		JFileChooser chooser = new JFileChooser();
//		
//		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
//			edgeNodeBuilder.readFromFile(chooser.getSelectedFile());
	}

}
