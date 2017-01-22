package main;
import impl.mock.SessionMock;
import impl.ws.SessionWS;
import api.Session;

/**
 * Ouvre une session, soit en mode mock avec des données tests, soit en mode web-services qui ouvre une connexion sur le serveur avec les identifiants du client.
 * @author Keil Laurent
 */
public class FactorySession {
    static public Session getSession(String username, String password) throws Exception {
        switch (Parameters.mode) {
	        case Parameters.MOCK:
	            return new SessionMock();
	        case Parameters.WS:
	            return new SessionWS(username,password);
	        default:
	            return null;
        }
    }
}
