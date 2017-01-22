import impl.mock.SessionMock;
import impl.ws.SessionWS;
import api.Session;

public class FactorySession {
    static public Session getSession(String username, String password) {
        switch (Parameters.mode) {
        case Parameters.MOCK:
            return new SessionMock();
        case Parameters.WS:
            return new SessionWS();
        default:
            return null;
        }
    }
}
