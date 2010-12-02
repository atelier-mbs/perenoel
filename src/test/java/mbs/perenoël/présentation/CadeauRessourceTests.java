package mbs.perenoël.présentation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import mbs.perenoël.modèle.Cadeau;
import mbs.perenoël.modèle.Entrepôts;

import org.junit.Test;
import org.restlet.data.Status;
import org.restlet.resource.ClientResource;

public class CadeauRessourceTests extends RessourceTests {
	
	@Test
	public void peutSupprimerUnCadeau() {
		Entrepôts.cadeaux().ajoute(new Cadeau( "Un Mac Book Pro"));
		ClientResource ressource = créeRessource("/cadeaux/un-mac-book-pro");
		
		ressource.delete();
		
		assertThat(ressource.getStatus(), is(Status.SUCCESS_OK));
		assertThat(Entrepôts.cadeaux().parId("un-mac-book-pro"), nullValue());
	}
}
