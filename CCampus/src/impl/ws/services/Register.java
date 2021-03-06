
package impl.ws.services;

import java.io.*;
import java.security.Security;

import org.apache.http.HttpStatus;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.*;


/**
 * Enregistre l utilisateur ayant eu le droit de se connecter et r�cup�re un cookie que l'on renvoie.
 * @author Keil Laurent
 */
public class Register {

	// init du client http
	private static HttpClient client = new HttpClient();
	//Initialisation de la m�thode post avec l url ou la requete doit se faire
	public static PostMethod post = new PostMethod();
	
	/**
	 *  Envoie user et password en requ�te http 
	 *  et retourne un cookie g�n�r� par le serveur de claroline 
	 *  pour l'utilisateur connect� au serveur si celui-ci est valid�.
	 * @param user : identifiant de l utilisateur voulant se connecter
	 * @param pw : password encod� par l'utilisateur voulant se connecter
	 * @return cookie : un cookie correspondant � l'utilisateur pouvant �tre recuper� pendant une session active.
	 * @throws IOException : en cas de mauvais encodage des informations pour l'envoie de la requete.
	 * @throws HttpException : en cas de probl�me sur le serveur ou de violation du protocole.
	 */
	public static String registerURL(String user, String pw, String url) throws HttpException, IOException {
		//gestion du certificat
		Security.setProperty("ssl.SocketFactory.provider",LazySSLSocketFactory.class.getName());
		
        //gestion de la connexion au serveur et r�cup�ration des cookies
		
		String cookie = null;		
		
		// utilisation du user-agent de firefox
		Header header = new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");
		
		//Initialisation de la m�thode post avec l url ou la requete doit se faire
		post = new PostMethod(url);
		
		post.setRequestHeader(header);
		
		// ajout des parametres � la requ�te pour une authentification http
		post.addParameter("login", user);
		post.addParameter("password", pw);
			
		try{
			//envoie de la requ�te
			int status = client.executeMethod(post);
			 			
			if (status != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + post.getStatusLine());
			}
						 
			Cookie[] cookies = client.getState().getCookies();
			 //capture du cookie utile.
			cookie = cookies[0].toString();			   
					
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} 
		finally{		 
			//fermeture de la connexion		 
			post.releaseConnection();
		}
		return cookie;
	}	
	
	public static HttpClient getClient() {
		return client;
	}

}