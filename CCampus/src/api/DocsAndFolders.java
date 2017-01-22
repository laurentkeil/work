package api;

import java.io.IOException;

import org.json.JSONException;

/**
 * permet d'obtenir des informations sur les documents et dossiers de documents (qui n'en contient pas forc�ment) d'un cours particulier de l'utilisateur connect�.
 * @author Keil Laurent
 */
public interface DocsAndFolders {

	/**
	 * @return sysCode : le code du cours(sysCode) de l'utilisateur connect� pour lequel on r�cup�re les informations sur les documents et dossiers.
	 */
	String getSysCode();
	/**
	 * @return le nombre de documents et dossiers pour le cours (sysCode) de l'utilisateur connect� pour lequel on r�cup�re les informations sur les documents et dossiers.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	int nbDocsAndFolders() throws JSONException;
	/**
	 * @return le nombre de documents pour le cours (sysCode) de l'utilisateur connect�.
	 */
	int nbDocs();
	/**
	 * @return le nombre de dossiers pour le cours (sysCode) de l'utilisateur connect�.
	 */
	int nbFolders();
	/**
	 * @return un tableau de chaine de caract�res contenant chaque name des nbFolders dossiers du cours de l'utilisateur.
	 * Seulement ces nbFolders premi�res cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String[] getFoldersName() throws JSONException;
	/**
	 * @return un tableau de chaine de caract�res contenant chaque name des nbDocs documents du cours de l'utilisateur.
	 * Seulement ces nbDocs premi�res cases du tableau sont accessibles.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 */
	String[] getDocsName() throws JSONException;
	/**
	 * @param name : le nom d'un dossier du cours de l'utilisateur.
	 * @return un Objet Folder contenant les informations sur un dossier de documents (identifi� par name) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 * @throws IOException : si le nom entr� ne correspond � aucun dossier disponible.
	 * @throws Exception : si l'utilisateur n'est pas connect�.
	 */
	Folder getFolder(String name) throws JSONException, IOException, Exception;
	/**
	 * @param name : le nom d'un document du cours de l'utilisateur.
	 * @return un Objet Doc contenant les informations sur une document (identifi� par name) du cours de l'utilisateur.
	 * @throws JSONException : dans le cas d'un probl�me de format JSON
	 * @throws IOException : si le nom entr� ne correspond � aucun document disponible.
	 * @throws Exception : si l'utilisateur n'est pas connect�.
	 */
	Doc getDoc(String name) throws JSONException, IOException, Exception;

}
