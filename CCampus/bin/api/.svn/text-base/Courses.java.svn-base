package api;

import java.io.IOException;

import org.json.JSONException;

/**
 * Permet d'obtenir des informations sur les cours de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Courses {

	/**
	 * @return le nombre de cours accessible à l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int nbCours() throws JSONException;
	/**
	 * @return un tableau d'entiers contenant chaque cours_id des nbCours cours de l'utilisateur.
	 * Seulement ces nbCours premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int[] getAllCoursesID() throws JSONException;
	/**
	 * @return un tableau de chaine de caractères contenant chaque syscode des nbCours cours de l'utilisateur.
	 * Seulement ces nbCours premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String[] getAllCoursesSyscode() throws JSONException;
	/**
	 * @param cid : l'identifiant d'un cours particulier de l'utilisateur
	 * @return un Objet Course contenant les informations sur un cours (identifié par cid) de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si l'id entré ne correspond à aucun cours disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Course getCourse(int cid) throws JSONException, IOException, Exception;
	/**
	 * @param syscode : le code identifiant un cours particulier de l'utilisateur
	 * @return un Objet Course contenant les informations sur un cours de code "syscode" de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si le code entré ne correspond à aucun cours disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté. 
	 */
	Course getCourse(String syscode) throws JSONException, IOException, Exception;

}
