package mbs.perenoël.présentation;

import mbs.perenoël.présentation.ServeurApplication;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.restlet.resource.ClientResource;

public abstract class RessourceTests {

    private static ServeurApplication serveur;

    @BeforeClass
    public static void avantClasseRessourceTests() throws Exception {
        serveur = new ServeurApplication();
        serveur.start();
    }

    @AfterClass
    public static void aprèsClasseRessourceTests() throws Exception {
        serveur.stop();
    }
    
    protected ClientResource créeRessource(String uri) {
        return new ClientResource("http://localhost:5555" + uri);
    }
}