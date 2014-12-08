import java.io.File;

import sections.C;


public class CIT360FinalProject {

	public static void main(String[] args) 
	{
		
		C c = new C();
		
		PathManager manager = new PathManager(new File("final.data"));
		manager.findPaths();
		
//		JFileChooser chooser = new JFileChooser();
//		
//		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
//			edgeNodeBuilder.readFromFile(chooser.getSelectedFile());
	}

}
