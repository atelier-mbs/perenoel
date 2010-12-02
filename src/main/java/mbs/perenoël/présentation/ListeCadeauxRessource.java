package mbs.perenoël.présentation;

import mbs.perenoël.modèle.Cadeau;
import mbs.perenoël.modèle.Entrepôts;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ListeCadeauxRessource extends ServerResource {

	@Get
	public Representation représente() {
		return new PatronDeVue("liste-cadeaux.ftl").avec("cadeaux",
				Entrepôts.cadeaux().tous()).représentation();
	}
	
	@Post
	public void ajoute(Form formulaire) {
		if (formulaire == null || formulaire.getFirstValue("nom") == null) {
			setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
			return;
		}
		Cadeau cadeau = new Cadeau(formulaire.getFirstValue("nom"));
		Entrepôts.cadeaux().ajoute(cadeau);
		setLocationRef("/cadeaux/" + cadeau.getId());
		setStatus(Status.SUCCESS_CREATED);
	}
}
