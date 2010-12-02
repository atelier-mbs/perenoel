package mbs.perenoël.présentation;

import mbs.perenoël.modèle.Cadeau;
import mbs.perenoël.modèle.Entrepôts;

import org.restlet.resource.Delete;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class CadeauRessource extends ServerResource{
	private Cadeau cadeau;

	@Override
	protected void doInit() throws ResourceException {
		cadeau = Entrepôts.cadeaux().parId((String) getRequestAttributes().get("id"));
	}
	
	@Delete
	public void supprime() {
		Entrepôts.cadeaux().supprime(cadeau);
	}
	
}
