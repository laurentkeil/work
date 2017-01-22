/**
 * 
 */
package impl.mock;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/** 
 * implémention mock avec des données tests de l'interface.
 * crée une session en mode mock / données tests
 * @author Keil Laurent
 * @see api.UserData
 */
public class UserDataMock implements api.UserData, Serializable  {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 7929834636195201202L;
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
	 * constructeur de l'objet UserDataMock / post de données test pour le mock
	 */
	public UserDataMock() {
	    JSONObject json = new JSONObject();
		try{
	    	json.put("userId", "1");
	    	json.put("username", "claro");
	    	json.put("firstname", "laurent");
	    	json.put("lastname", "keil");
	    	json.put("language", "francais");
	    	json.put("isCourseCreator", "true");
	    	json.put("isPlatformAdmin", "true");
	    	json.put("officialCode", "");
	    }catch (JSONException e) {
	    	e.printStackTrace();
	    }
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
			firstName = json.getString("firstName");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return firstName;	
	}
	
	@Override
	public String getLastName() throws JSONException {
		try {				
			JSONObject json = new JSONObject(strJson);
			lastName = json.getString("lastName");
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
