package impl.ws.services;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

/**
 * Authentification du client sur le serveur et retour d'un cookie.
 * @author Keil Laurent
 */
public class Claroline {

    public static class RegisterThread extends Thread {
        private String token = null;
        final private String user;
        final private String password;

        public RegisterThread(String user, String password) {
            assert user!=null;
            assert password!=null;
            this.user = user;
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        @Override
        public void run() {
            try {
                token = Register.registerURL(user, password, "https://chouettecampus.info.fundp.ac.be");
            } catch (final HttpException e) {
                // FIXME add a logger
                token = null;
            } catch (final IOException e) {
                // FIXME add a logger
                token = null;
            }
        }

    }

    /**
     * Authentifie l'utilisateur user s'il est validé.
     * @param user : identifiant de l utilisateur voulant se connecter
     * @param password : password encodé par l'utilisateur voulant se connecter
     * @return token : un cookie correspondant à l'utilisateur pouvant être recuperé pendant une session active.
     * @throws Exception : un champ vide a ete constate
     */
    public static String login(String user, String password) throws Exception {

        final String token;

        //validation du champ user
        try {
            Validation.validationLogin(user);
        } catch (final Exception e) {
            Validation.setErreur(user, e.getMessage());
        }

        //validation du champ password
        try {
            Validation.validationPW(password);
        } catch (final Exception e) {
            Validation.setErreur(password, e.getMessage());
        }

        /* résultat global de la validation. */
        if (Validation.erreurs.isEmpty()) {
            // token = Register.registerURL(user, password, "https://chouettecampus.info.fundp.ac.be");
            final RegisterThread t = new RegisterThread(user, password);
            t.start();
            t.join();
            token = t.getToken();
        } else {
            throw new Exception("Échec de la connexion. Un champ vide a été constaté.");
        }

        return token;

    }

}