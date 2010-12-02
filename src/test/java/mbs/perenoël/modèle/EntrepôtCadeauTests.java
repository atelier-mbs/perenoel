package mbs.perenoël.modèle;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class EntrepôtCadeauTests {
	
	@After
	public void après() {
		Entrepôts.cadeaux().vider();
	}
	
	@Test
	public void lEntrepôtEstVideAuDébut() {
		assertThat(Entrepôts.cadeaux().taille(), is(0));
	}

	@Test
	public void peutAjouterDansEntrepôt() {
		Entrepôts.cadeaux().ajoute(new Cadeau());

		assertThat(Entrepôts.cadeaux().taille(), is(1));
	}
	
	@Test
	public void peutRetouverUnCadeauParSonNom() {
		Cadeau cadeau = new Cadeau("Une belle rollex");
		Entrepôts.cadeaux().ajoute(cadeau);
		
		assertThat(Entrepôts.cadeaux().parId("une-belle-rollex"), is(cadeau));
	}
	
	@Test
	public void peutSupprimerUnCadeau() {
		Cadeau cadeau = new Cadeau("Une belle rollex");
		Entrepôts.cadeaux().ajoute(cadeau);
		
		Entrepôts.cadeaux().supprime(cadeau);
		
		assertThat(Entrepôts.cadeaux().taille(), is(0));
	}
}
