
package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur un dossier particulèr (folder) d'un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Folder {

	/**
	 * @return name : le nom du dossier folder du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getName() throws JSONException;
	/**
	 * @return path : le chemin d'accès du dossier du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getPath() throws JSONException;
	/**
	 * @return description : la description du dossier du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDescription() throws JSONException;
	/**
	 * @return date : la date de création du dossier du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDate() throws JSONException;
	/**
	 * @return type : le type de dossier du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getType() throws JSONException;
	/**
	 * @return true si le dossier du cours de l'utilisateur connecté est visible, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean isVisible() throws JSONException;
	/**
	 * @return true si le dossier du cours de l'utilisateur connecté possède des notifications (nouveautés), false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean notified() throws JSONException;

}
