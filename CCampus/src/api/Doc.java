
package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur un document particuler (doc) d'un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Doc {
	
	/**
	 * @return name : le nom du document doc du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getName() throws JSONException;
	/**
	 * @return extension : le format du document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getExtension() throws JSONException;
	/**
	 * @return url : l'url (de téléchargement) auquel se trouve le document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getUrl() throws JSONException;
	/**
	 * @return path : le chemin d'accès du document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getPath() throws JSONException;
	/**
	 * @return description : la description du document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDescription() throws JSONException;
	/**
	 * @return size : la taille en byte du document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getSize() throws JSONException;
	/**
	 * @return date : la date de création du document du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDate() throws JSONException;
	/**
	 * @return type : le type de dossier du document de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getType() throws JSONException;
	/**
	 * @return true si le document du cours de l'utilisateur connecté est visible, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean isVisible() throws JSONException;
	/**
	 * @return true si le document du cours de l'utilisateur connecté possède des notifications (nouveautés), false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean notified() throws JSONException;

}
