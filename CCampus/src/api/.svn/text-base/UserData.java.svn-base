package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations séparément sur l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface UserData {
	
	/**
	 * @return userId  : l'identifiant de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	int getUserId() throws JSONException;
	/**
	 * @return username : le nom d'utilisateur de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	String getUsername() throws JSONException;
	/**
	 * @return firstName  : le prénom de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	String getFirstName() throws JSONException;
	/**
	 * @return lastName  : le nom de famille de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	String getLastName() throws JSONException;
	/**
	 * @return language  : le language utilisé de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	String getLanguage() throws JSONException;
	/**
	 * @return true si l'utilisateur connecté est créateur de cours, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	boolean isCourseCreator() throws JSONException;
	/**
	 * @return true si l'utilisateur connecté est administrateur de la platforme, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	boolean isPlatformAdmin() throws JSONException;
	/**
	 * @return officialCode  : le code officiel de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	String getOfficialCode() throws JSONException;

}
