package Appli;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import Appli.data.Personne;
import interfaces.IAfficheur;
import loader.loader;

public class Appli {
	private IAfficheur afficheur;

	public Appli() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		afficheur = loader.getInstance().getAfficheur();		
	}

	public void affiche(Personne p) {
		this.afficheur.affiche(p);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Appli mon_app = new Appli();
		Personne p = new Personne("Didier");
		
		mon_app.affiche(p);
	}

}
