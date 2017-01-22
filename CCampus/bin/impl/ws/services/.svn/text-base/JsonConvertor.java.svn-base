
package impl.ws.services;

import impl.ws.SessionWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
 
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 

/**
 * Permet de parser le format JSON du contenu d'un fichier à partir d'une url auquel l'utilisateur a le droit de connexion.
 * @author Keil Laurent
 */
public class JsonConvertor {
 
    static InputStream is = null;
    static JSONObject jObj = null;
    static JSONArray jTab = null;
    static String json = "";
 
    /**
     * constructeur de l'objet JsonConvertor.
     */
    public JsonConvertor() {
 
    }
 
    /**
     * Permet de parser le format JSON du contenu d'un fichier à partir d'une url auquel l'utilisateur a le droit de connexion en retournant un objet JSON.
     * @param url : l'url pour laquelle on doit parser le contenu au format JSON
     * @return : un JSONObject contenant le format JSON du contenu de la page url.
     * @throws Exception : si l'utilisateur n'est pas connecté.
     */
    public JSONObject getJSONObjectFromUrl(String url) throws Exception {
 
    	HttpClient httpClient = new HttpClient();
        // Making HTTP request
        try {
        	if(!SessionWS.deco){
	            // HttpClient provenant du client enregistré sur le serveur.
	            httpClient = Register.getClient();
        	}
        	else{
        		throw new Exception("Cette ressource n'est pas accesible à un utilisateur non-connecté.");
        	}
            GetMethod methodes = new GetMethod(url);

            httpClient.executeMethod(methodes);   
 
	        try {
	        	BufferedReader br = null;
	        	br = new BufferedReader(new InputStreamReader(methodes.getResponseBodyAsStream()));
	            StringBuilder sb = new StringBuilder();
	        	String readLine = null;       	 
	        	// Tant que la ligne en cours n’est pas vide      	 
	        	while(((readLine = br.readLine()) != null))      	 
	        	{ 
	        		sb.append(readLine + "\n");	        		
	        	}
	            
	            json = sb.toString();
	            if(json.contains("[]")){
	            	json = "{}";
	            }
	            
	        } catch (Exception e) {
	            System.out.println("Buffer Error : Error converting result " + e.toString());
	        }
	        
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
        	System.out.println("JSON Parser : Error parsing data " + e.toString());
        }
 
        // return JSON Object
        return jObj;
 
    }
    
    /**
     * Permet de parser le format JSON du contenu d'un fichier à partir d'une url auquel l'utilisateur a le droit de connexion en retournant un tableau JSON.
     * @param url : l'url pour laquelle on doit parser le contenu au format JSON
     * @return : un JSONArray contenant le format JSON du contenu de la page url.
     * @throws Exception : si l'utilisateur n'est pas connecté.
     */
    public JSONArray getJSONArrayFromUrl(String url) throws Exception {
 
    	HttpClient httpClient = new HttpClient();
        // Making HTTP request
        try {
        	if(!SessionWS.deco){
	            // HttpClient provenant du client enregistré sur le serveur.
	            httpClient = Register.getClient();
        	}
        	else{
        		throw new Exception("Cette ressource n'est pas accesible à un utilisateur non-connecté.");
        	}
 
            GetMethod methodes = new GetMethod(url);

            httpClient.executeMethod(methodes);
            
            try {
	        	BufferedReader br = null;
	        	br = new BufferedReader(new InputStreamReader(methodes.getResponseBodyAsStream()));
	            StringBuilder sb = new StringBuilder();
	        	String readLine = null;       	 
	        	// Tant que la ligne en cours n’est pas vide      	 
	        	while(((readLine = br.readLine()) != null))      	 
	        	{ 
	        		sb.append(readLine + "\n");	        		
	        	}
	            
	            json = sb.toString();
	            
	        } catch (Exception e) {
	            System.out.println("Buffer Error : Error converting result " + e.toString());
	        }
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		// try parse the string to a JSON Array
        try {
        	jTab = new JSONArray(json);      
        } catch (JSONException e) {
        	System.out.println("JSON Parser : Error parsing data " + e.toString());
        }
 
        // return JSON Array
        return jTab;
    }
}