package mbs.perenoël.modèle;

import java.util.List;

import com.google.common.collect.Lists;

public class EntrepôtCadeau {

	private List<Cadeau> liste = Lists.newArrayList();

	public int taille() {
		return liste.size();
	}

	public void ajoute(Cadeau cadeau) {
		liste.add(cadeau);
	}

	public Cadeau parId(String id) {
		for (Cadeau cadeau : liste) {
			if (cadeau.getId().equals(id)) {
				return cadeau;
			}
		}
		return null;
	}

	public void supprime(Cadeau cadeau) {
		liste.remove(cadeau);
	}

	public void vider() {
		liste.clear();
	}

	public List<Cadeau> tous() {
		return liste;
	}
}
