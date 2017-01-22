
package impl.ws.services;

import java.util.HashMap;
import java.util.Map;

/** 
 * Vérifie si les champs encode par l utilisateur ne sont pas vides.
 * @author Keil Laurent
 */
public class Validation {
	
	 public static Map<String, String> erreurs      = new HashMap<String, String>();
	
	 /**
	  * valide le login de l'utilisateur en vérifiant s'il n'est pas vide.
	  * @param login :  identifiant de l utilisateur voulant se connecter.
	  * @throws Exception
	  */ 
    public static void validationLogin( String login ) throws Exception {
        if ( login == "" || login == null ) {
            throw new Exception( "Merci de saisir votre identifiant." );
        }
    }
    
    /**
     * valide le password de l'utilisateur en vérifiant s'il n'est pas vide.
     * @param password : password encodé par l'utilisateur voulant se connecter
     * @throws Exception
     */
    public static  void validationPW( String password ) throws Exception {
        if ( password == "" || password == null ) {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
    /**
     * place dans erreurs les differents messages d'erreurs associés aux champs entrés par l'utilisateur lors de sa tentative de connexion.
     * @param champ
     * @param message
     */
    public static void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

}
