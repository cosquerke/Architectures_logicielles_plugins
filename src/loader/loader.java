package loader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import interfaces.IAfficheur;

public class loader {
	private static loader loader_singleton;
	
	private loader() { // Singleton donc prive
		// TODO Auto-generated constructor stub
		
	}

	public static loader getInstance() {
		return lazyLoader();
	}
	
	private static loader lazyLoader() {
		if (loader_singleton == null) {
			loader_singleton = new loader();
		}
		return loader_singleton;
	}
	
	public IAfficheur getAfficheur() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		String chemin_fichier_classe = "src/Appli/data/classes.txt";
		
		List <String> liste_classes = Files.readAllLines(Paths.get(chemin_fichier_classe));
			
		return (IAfficheur) Class.forName(liste_classes.get(0)).getConstructor().newInstance();
	}
}
