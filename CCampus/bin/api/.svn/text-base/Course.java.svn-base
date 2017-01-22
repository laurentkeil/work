package api;

import api.Annonces;

import org.json.JSONException;

/**
 * permet d'obtenir des informations séparément sur un cours particulier de l'utilisateur connecté.
 * @author Keil Laurent
 */
public interface Course {
	
	/**
	 * @return cours_id : l'identifiant du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int getCoursID() throws JSONException;
	/**
	 * @return syscode : le code du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getSyscode() throws JSONException;
	/**
	 * @return directory : le dossier du cours de l'utilisateur connecté, ou rien s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDirectory() throws JSONException;
	/**
	 * @return officialCode : le code officiel du cours de l'utilisateur connecté, ou rien s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getOfficialCode() throws JSONException;
	/**
	 * @return db : la base de donnée relative au cours de l'utilisateur connecté, ou rien s'elle est inexistante.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getDb() throws JSONException;
	/**
	 * @return title : le titre du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getTitle() throws JSONException;
	/**
	 * @return titular : le titulaire du cours de l'utilisateur connecté, ou rien s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getTitular() throws JSONException;
	/**
	 * @return language : le language utilisé pour le cours de l'utilisateur connecté, , ou rien s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getLanguage() throws JSONException;
	/**
	 * @return access : le type d'accès au cours de l'utilisateur connecté (public, platform...).
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getAccess() throws JSONException;
	/**
	 * @return status : le statut du cours de l'utilisateur connecté (activé/désactivé).
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getStatus() throws JSONException;
	/**
	 * @return sourceCourseId : la source du cours de l'utilisateur connecté, ou null s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getSourceCourseId() throws JSONException;
	/**
	 * @return expirationDate : la date d'expiration du cours de l'utilisateur connecté, ou null si elle est inexistante.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getExpirationDate() throws JSONException;
	/**
	 * @return creationDate : la date de création du cours de l'utilisateur connecté, ou null s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	String getCreationDate() throws JSONException;
	/**
	 * @return isCourseManager = 1 si l'utilisateur connecté est manageur de cours, 0 sinon. 
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	int isCourseManager() throws JSONException;
	/**
	 * @return officialEmail : l'e-mail du titulaire du cours, ou rien s'il est inexistant.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
    String getOfficialEmail() throws JSONException;
	/**
	 * @return true si il existe des notifications (nouveautés) pour le cours de l'utilisateur, false sinon.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 */
	boolean notified() throws JSONException;
	/**
	 * @return un objet CourseTool contenant des informations sur les outils disponibles du cours de l'utilisateur connecté. 
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	CourseTool getCourseTool() throws JSONException, Exception;
	/**
	 * @return un objet Annonces contenant des informations sur les annonces du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	Annonces getAnnonces() throws JSONException, Exception;
	/**
	 * @return un objet Docs contenant des informations sur les documents et dossiers du cours de l'utilisateur connecté.
	 * @throws JSONException : dans le cas d'un problème de format JSON
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	DocsAndFolders getDocs() throws JSONException, Exception;

}
