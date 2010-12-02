package mbs.perenoël.modèle;

import mbs.perenoël.outils.Slugify;

public class Cadeau {

	private String nom;

	public Cadeau() {
	}
	
	public Cadeau(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return Slugify.slugify(getNom());
	}

	public String getNom() {
		return nom;
	}
}
