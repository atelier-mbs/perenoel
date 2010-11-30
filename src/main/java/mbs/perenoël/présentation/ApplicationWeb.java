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
        ajouteRessourcesStatiques(routeur);
        return routeur;
    }

	private void ajouteRessourcesStatiques(Router router) {
		router.attach("/css", ressourceStatique("css"));
        router.attach("/js", ressourceStatique("js"));
        router.attach("/images", ressourceStatique("images"));
	}

    private Directory ressourceStatique(String répertoire) {
        return new Directory(getContext(), new Reference(Protocol.CLAP, "class/" + répertoire));
    }
}
