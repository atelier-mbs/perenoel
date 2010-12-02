package mbs.perenoël.présentation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import mbs.perenoël.modèle.Cadeau;
import mbs.perenoël.modèle.Entrepôts;

import org.junit.Before;
import org.junit.Test;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class ListeCadeauxRessourceTests extends RessourceTests {
	private ClientResource ressource;

	@Before
	public void avant() {
		ressource = créeRessource("/cadeaux");
	}

	@Test
	public void peutRécupérerListe() throws Exception {
		Representation représentation = ressource.get();

		assertThat(ressource.getStatus(), is(Status.SUCCESS_OK));
		assertThat(représentation.getText(), containsString("<html><ul></ul></html>"));
	}

	@Test
	public void peutRécupérerListeAvecUnCadeau() throws Exception {
		Entrepôts.cadeaux().ajoute(new Cadeau("Un voyage"));

		Representation représentation = ressource.get();

		assertThat(ressource.getStatus(), is(Status.SUCCESS_OK));
		assertThat(représentation.getText(), containsString("<html><ul><li>Un voyage</li></ul></html>"));
	}

	@Test
	public void peutAjouterUnCadeauÀLaListe() {
		ressource.post(new Form("nom=Une Rolex"));

		assertThat(ressource.getStatus(), is(Status.SUCCESS_CREATED));
		assertThat(ressource.getLocationRef().getPath(), is("/cadeaux/une-rolex"));
		assertThat(Entrepôts.cadeaux().parId("une-rolex"), notNullValue());
	}

	@Test
	public void onDoitFournirUnFormulaireLorsDeLAjout() {
		try {
			ressource.post(new Form());
			fail();
		} catch (ResourceException e) {
			assertThat(e.getStatus(), is(Status.CLIENT_ERROR_BAD_REQUEST));
		}
	}

	@Test
	public void onDoitFournirUnNomLorsDeLAjout() {
		try {
			ressource.post(new Form("nom="));
			fail();
		} catch (ResourceException e) {
			assertThat(e.getStatus(), is(Status.CLIENT_ERROR_BAD_REQUEST));
		}
	}
}
