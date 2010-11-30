package mbs.perenoël.présentation;

import org.apache.log4j.Logger;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class ServeurApplication {

    private static final Logger LOGGER = Logger.getLogger(ServeurApplication.class);
    private Component composant;

    public void start() {
        composant = new Component();
        composant.getServers().add(Protocol.HTTP, 5555);
        composant.getDefaultHost().attach(new ApplicationWeb());
        composant.getClients().add(Protocol.CLAP);
        composant.getClients().add(Protocol.HTTP);
        try {
            composant.start();
        } catch (Exception e) {
            LOGGER.error("Erreur au démarrage du serveur", e);
        }
    }

    public void stop() {
        try {
            composant.stop();
        } catch (Exception e) {
            LOGGER.error("Erreur à l'arrêt du serveur", e);
        }
    }

    public static void main(String[] args) {
        new ServeurApplication().start();
    }
}
