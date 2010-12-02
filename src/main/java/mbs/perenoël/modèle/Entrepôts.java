package mbs.perenoël.modèle;

public class Entrepôts {

	private static EntrepôtCadeau entrepôtCadeau = new EntrepôtCadeau();

	public static EntrepôtCadeau cadeaux() {
		return entrepôtCadeau;
	}
}
