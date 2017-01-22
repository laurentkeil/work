
package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur un dossier particul�r (folder) d'un cours particulier de l'utilisateur connect�.
 * @author Keil Laurent
 */
public interface Folder {

	/**
	 * @return name : le nom du dossier folder du cours de l'utilisateur connect�.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String getName() throws JSONException;
	/**
	 * @return path : le chemin d'acc�s du dossier du cours de l'utilisateur connect�.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String getPath() throws JSONException;
	/**
	 * @return description : la description du dossier du cours de l'utilisateur connect�.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String getDescription() throws JSONException;
	/**
	 * @return date : la date de cr�ation du dossier du cours de l'utilisateur connect�.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String getDate() throws JSONException;
	/**
	 * @return type : le type de dossier du cours de l'utilisateur connect�.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	int getType() throws JSONException;
	/**
	 * @return true si le dossier du cours de l'utilisateur connect� est visible, false sinon.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	boolean isVisible() throws JSONException;
	/**
	 * @return true si le dossier du cours de l'utilisateur connect� poss�de des notifications (nouveaut�s), false sinon.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	boolean notified() throws JSONException;

}
