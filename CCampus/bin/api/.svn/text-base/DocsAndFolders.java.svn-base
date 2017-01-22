package api;

import java.io.IOException;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur les documents et dossiers de documents (qui n'en contient pas forcément) d'un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface DocsAndFolders {

	/**
	 * @return sysCode : le code du cours(sysCode) de l'utilisateur connecté pour lequel on récupère les informations sur les documents et dossiers.
	 */
	String getSysCode();
	/**
	 * @return le nombre de documents et dossiers pour le cours (sysCode) de l'utilisateur connecté pour lequel on récupère les informations sur les documents et dossiers.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int nbDocsAndFolders() throws JSONException;
	/**
	 * @return le nombre de documents pour le cours (sysCode) de l'utilisateur connecté.
	 */
	int nbDocs();
	/**
	 * @return le nombre de dossiers pour le cours (sysCode) de l'utilisateur connecté.
	 */
	int nbFolders();
	/**
	 * @return un tableau de chaine de caractères contenant chaque name des nbFolders dossiers du cours de l'utilisateur.
	 * Seulement ces nbFolders premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String[] getFoldersName() throws JSONException;
	/**
	 * @return un tableau de chaine de caractères contenant chaque name des nbDocs documents du cours de l'utilisateur.
	 * Seulement ces nbDocs premières cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String[] getDocsName() throws JSONException;
	/**
	 * @param name : le nom d'un dossier du cours de l'utilisateur.
	 * @return un Objet Folder contenant les informations sur un dossier de documents (identifié par name) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si le nom entré ne correspond à aucun dossier disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Folder getFolder(String name) throws JSONException, IOException, Exception;
	/**
	 * @param name : le nom d'un document du cours de l'utilisateur.
	 * @return un Objet Doc contenant les informations sur une document (identifié par name) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws IOException : si le nom entré ne correspond à aucun document disponible.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Doc getDoc(String name) throws JSONException, IOException, Exception;

}
