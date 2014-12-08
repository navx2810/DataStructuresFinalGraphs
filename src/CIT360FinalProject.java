import java.io.File;

import sections.C;
import sections.D;
import sections.E;
import sections.F;
import sections.G;
import sections.H;
import sections.I;
import sections.J;


public class CIT360FinalProject {

	public static void main(String[] args) 
	{
		
		C c = new C();
		D d = new D();
		E e = new E();
		F f = new F();
		G g = new G( c.graph );
		H h = new H( d.graph );
		I i = new I( e.graph );
		J j = new J( f.graph );
		
		PathManager manager = new PathManager(new File("final.data"));
		manager.findPaths();
		
//		JFileChooser chooser = new JFileChooser();
//		
//		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
//			edgeNodeBuilder.readFromFile(chooser.getSelectedFile());
	}

}
