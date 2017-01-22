package api;

import org.json.JSONException;

/**
 * Permet d'obtenir des informations sur les updates pour l'utilisateur connecté depuis sa dernière connexion.
 * @author Keil Laurent
 */
public interface Updates {
	/**
	 * @return un tableau d'objet Update contenant nbUpdates updates et des informations les concernant pour l'utilisateur connecté depuis sa dernière connexion.
	 * </br>Seulement ces nbUpdates premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	Update[] getUpdatesTab() throws JSONException;
	/**
	 * @return nb : le nombre de modifications de ressources différentes depuis la dernière connexion de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON 
	 */
	int nbUpdates() throws JSONException;
}
