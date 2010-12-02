package mbs.perenoël.présentation;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class ApplicationWeb extends Application {

	@Override
	public Restlet createRoot() {
		Router routeur = new Router();
		routeur.attach("/cadeaux", ListeCadeauxRessource.class);
		routeur.attach("/cadeaux/{id}", CadeauRessource.class);
		ajouteRessourcesStatiques(routeur);
		return routeur;
	}

	private void ajouteRessourcesStatiques(Router routeur) {
		routeur.attach("/css", ressourceStatique("css"));
		routeur.attach("/js", ressourceStatique("js"));
		routeur.attach("/images", ressourceStatique("images"));
	}

	private Directory ressourceStatique(String répertoire) {
		return new Directory(getContext(), new Reference(Protocol.CLAP, "class/" + répertoire));
	}
}
