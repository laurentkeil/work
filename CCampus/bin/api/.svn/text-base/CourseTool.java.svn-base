
package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations séparément sur les outils disponibles et nouveautés du cours cid de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface CourseTool {
	/**
	 * @return sysCode : le nom du cours de l'utilisateur connecté auquel l'objet CourseTool référence.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	 String getSysCode() throws JSONException;
	/**
	* @return true si il y a le module annonce pour le cours sysCode, false sinon.
	* @throws JSONException : dans le cas d'un problème de format JSON 
	*/
	boolean isAnn() throws JSONException;
	/**
	 * @return true si il y a le module document pour le cours sysCode, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	boolean isDnL() throws JSONException;
	/**
	 * @return true si il y a au moins une notification (nouveauté) pour au moins une annonce pour le cours sysCode, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean annNotif() throws JSONException;
	/**
	 * @return true si il y a au moins une notification (nouveauté) pour au moins un document pour le cours sysCode, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	boolean dnlNotif() throws JSONException;

}
