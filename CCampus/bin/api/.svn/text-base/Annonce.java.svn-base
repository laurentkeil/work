
package api;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur une annonce particulère (ann) d'un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Annonce {

	/**
	 * @return ressourceId : le code entier identifiant l'annonce ann du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getRessourceID() throws JSONException;
	/**
	 * @return title : le titre de l'annonce du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getTitle() throws JSONException;
	/**
	 * @return content : le contenu de l'annonce du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getContent() throws JSONException;
	/**
	 * @return visibleFrom : la date depuis laquelle l'annonce du cours de l'utilisateur connecté est visible.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String visibleFrom() throws JSONException;
	/**
	 * @return visibleUntil : la date jusqu'à laquelle l'annonce du cours de l'utilisateur connecté est visible.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String visibleUntil() throws JSONException;
	/**
	 * @return visibility = true si l'annonce est visible, false sinon. 
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean isVisible() throws JSONException;
	/**
	 * @return rank : le rang (un entier) de l'annonce du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getRank() throws JSONException;
	/**
	 * @return date : la date de création de l'annonce du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDate() throws JSONException;
	/**
	 * @return true si il y a eu des notifications (nouveautés) pour l'annonce du cours de l'utilisateur connecté, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean notified() throws JSONException;

}
