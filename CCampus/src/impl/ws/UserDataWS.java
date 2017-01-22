
package impl.ws;


import java.io.Serializable;

import impl.ws.services.JsonConvertor;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.UserData
 */
class UserDataWS implements api.UserData, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 3763659340900974324L;
	/**
	 *  l'identifiant de l'utilisateur connecté.
	 */
	private int userId;
	/**
	 * le nom d'utilisateur de l'utilisateur connecté.
	 */
	private String username;
	/**
	 * le prénom de l'utilisateur connecté.
	 */
	private String firstName;
	/**
	 *  le nom de famille de l'utilisateur connecté.
	 */
	private String lastName;
	/**
	 * le language utilisé de l'utilisateur connecté.
	 */
    private String language;
    /**
     * = true si l'utilisateur connecté est créateur de cours, false sinon.
     */
    private boolean isCourseCreator;
    /**
     * = true si l'utilisateur connecté est administrateur de la platforme, false sinon.
     */
    private boolean isPlatformAdmin;
    /**
     * le code officiel de l'utilisateur connecté.
     */
    private String officialCode;
    
    /**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String strJson;
	/**
	 * domaine de l'url
	 */
	private String domaine;
	/**
	 * url à accéder
	 */
	private String url;
    
	/**
	 * constructeur de l'objet UserData
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	public UserDataWS() throws Exception {
		this.domaine = "https://chouettecampus.info.fundp.ac.be/module/MOBILE/index.php?Method=";
			 
	    	// url pour la requête
	 	this.url = domaine+"getUserData";
	
	 		// Creating JSON Parser instance
	 	JsonConvertor jParser = new JsonConvertor();
	 		 
	 		// getting JSON string from URL
	 	JSONObject json = jParser.getJSONObjectFromUrl(url);
	 	this.strJson = json.toString();

	}
	
	@Override
	public int getUserId() throws JSONException {	
		try {		
			JSONObject json = new JSONObject(strJson);
			userId = json.getInt("userId");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userId;
	}
	
	@Override
	public String getUsername() throws JSONException {
		try {		
			JSONObject json = new JSONObject(strJson);
			username = json.getString("username");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return username;
	}
	
	@Override
	public String getFirstName() throws JSONException {
		try {				
			JSONObject json = new JSONObject(strJson);
			firstName = json.getString("firstname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return firstName;	
	}
	
	@Override
	public String getLastName() throws JSONException {
		try {				
			JSONObject json = new JSONObject(strJson);
			lastName = json.getString("lastname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return lastName;
	}
	
	@Override
	public String getLanguage() throws JSONException {
		try {	
			JSONObject json = new JSONObject(strJson);
			language = json.getString("language");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return language;
	}
	
	@Override
	public boolean isCourseCreator() throws JSONException {
		try {			
			JSONObject json = new JSONObject(strJson);
			isCourseCreator = json.getBoolean("isCourseCreator");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isCourseCreator;
	}
	
	@Override
	public boolean isPlatformAdmin() throws JSONException {
		try {				
			JSONObject json = new JSONObject(strJson);
			isPlatformAdmin = json.getBoolean("isPlatformAdmin");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isPlatformAdmin;
	}
	
	@Override
	public String getOfficialCode() throws JSONException {
		try {
			JSONObject json = new JSONObject(strJson);
			officialCode = json.getString("officialCode");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return officialCode;
	}

}
