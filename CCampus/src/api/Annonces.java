
package api;

import java.io.IOException;

import org.json.JSONException;

/**
 * Permet d'obtenir des informations sur les annonces d'un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Annonces {

	/**
	 * @return sysCode : le code du cours(sysCode) de l'utilisateur connecté pour lequel on récupère les informations sur les annonces.
	 */
	String getSysCode();
	/**
	 * @return le nombre d'annonces pour le cours (sysCode) de l'utilisateur connecté pour lequel on récupère les informations sur les annonces.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int nbAnnonces() throws JSONException;
	/**
	 * @return un tableau d'entiers contenant chaque ressourceId des nbAnnonces annonces du cours de l'utilisateur.
	 * Seulement ces nbAnnonces premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int[] getAllAnnoncesID() throws JSONException;
	/**
	 * @return un tableau de chaine de caractères contenant chaque title des nbAnnonces annonces du cours de l'utilisateur.
	 * Seulement ces nbAnnonces premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String[] getAllAnnoncesTitle() throws JSONException;
	/**
	 * @param resID : l'identifiant d'une annonce du cours de l'utilisateur.
	 * @return un Objet Annonce contenant les informations sur une annonce (identifié par resID) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si l'id entré ne correspond à aucune annonce disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Annonce getAnnonce(int resID) throws JSONException, IOException, Exception;
	/**
	 * @param titre : le titre d'une annonce du cours de l'utilisateur.
	 * @return un Objet Annonce contenant les informations sur une annonce (identifié par resID, ou par titre) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si le titre entré ne correspond à aucune annonce disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Annonce getAnnonce(String titre) throws JSONException, IOException, Exception;

}
