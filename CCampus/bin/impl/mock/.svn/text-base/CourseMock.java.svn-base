
package impl.mock;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import api.Annonces;
import api.CourseTool;
import api.DocsAndFolders;

/**
 * implémention mock avec des données tests de l'interface.
 * @see api.Course
 * @author Keil Laurent
 */
public class CourseMock implements api.Course, Serializable  {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = -366449789093953162L;
	/**
	 * id de cours
	 */
	private int cours_id;
	/**
	 * code de cours
	 */
	private String syscode;
	/**
	 * directory du cours
	 */
	private String directory;
	/**
	 * base de donnée du cours
	 */
	private String db;
	/**
	 * code officiel du cours
	 */
	private String officialCode;
	/**
	 * titre du cours
	 */
    private String title;
    /**
     * titulaire du cours
     */
    private String titular;
    /**
     * language du cours
     */
    private String language;  
    /**
     * type d'accès au cours (public, platform...)
     */
    private String access;
    /**
     * le status du cours
     */
    private String status;
    /**
     * la source du cours
     */
    private String sourceCourseId;
    /**
     * la date d'expiration du cours
     */
    private String expirationDate;    
    /**
     * la date de création du cours
     */
    private String creationDate; 	 
    /**
     * =1 si l'utilisateur est manageur du cours, 0 sinon.
     */
    private int isCourseManager;     
    /**
     * l'e-mail officiel du titulaire du cours
     */
    private String officialEmail;
	/**
	 * notified = true si il y a des nouveautés pour l'annonce, false sinon
	 */
    private boolean notified;
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
    private String cours;
	
	/**
	 * Constructeur de l'objet CourseMock
	 * @param courseStr : objet JSON contenant les informations du cours "cours" en particulier.
	 */
	public CourseMock(String courseStr) {
		this.cours = courseStr;
	}

	@Override
	public int getCoursID() throws JSONException {	
		try {		
			JSONObject c = new JSONObject(cours);
			cours_id = c.getInt("cours_id");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return cours_id;
	}
	
	@Override
	public String getSyscode() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			syscode = c.getString("sysCode");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return syscode;
	} 

	@Override
	public String getDirectory() throws JSONException {
		try {		
			JSONObject c = new JSONObject(cours);
			directory = c.getString("directory");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return directory;
	}

	@Override
	public String getOfficialCode() throws JSONException {
		try {		
			JSONObject c = new JSONObject(cours);
			officialCode = c.getString("officialCode");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return officialCode;
	}

	@Override
	public String getDb() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			db = c.getString("db");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return db;
	}

	@Override
	public String getTitle() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			title = c.getString("title");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return title;
	}

	@Override
	public String getTitular() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			titular = c.getString("titular");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return titular;
	}

	@Override
	public String getLanguage() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			language = c.getString("language");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return language;
	}

	@Override
	public String getAccess() throws JSONException {
		try {				
			JSONObject c = new JSONObject(cours);
			access = c.getString("access");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return access;
	}

	@Override
	public String getStatus() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			status = c.getString("status");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String getSourceCourseId() throws JSONException {
		try {		
			JSONObject c = new JSONObject(cours);
			sourceCourseId = c.getString("sourceCourseId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sourceCourseId;
	}

	@Override
	public String getExpirationDate() throws JSONException {
		try {				
			JSONObject c = new JSONObject(cours);
			expirationDate = c.getString("expirationDate");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return expirationDate;
	}

	@Override
	public String getCreationDate() throws JSONException {
		try {				
			JSONObject c = new JSONObject(cours);
			creationDate = c.getString("creationDate");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return creationDate;
	}

	@Override
	public int isCourseManager() throws JSONException {	
		try {		
			JSONObject c = new JSONObject(cours);
			isCourseManager = c.getInt("isCourseManager");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isCourseManager;
	}

	@Override
	public String getOfficialEmail() throws JSONException {
		try {		
			JSONObject c = new JSONObject(cours);
			officialEmail = c.getString("officialEmail");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return officialEmail;
	}

	@Override
	public boolean notified() throws JSONException {
		try {	
			JSONObject c = new JSONObject(cours);
			notified = c.getBoolean("notified");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return notified;
	}

	@Override
	public CourseTool getCourseTool() throws JSONException {
		CourseTool courseTool = new CourseToolMock(getSyscode());
		return courseTool;
	}
	
	@Override
	public Annonces getAnnonces() throws JSONException {
		Annonces annonces = new AnnoncesMock(getSyscode());
		return annonces;
	}
	
	@Override
	public DocsAndFolders getDocs() throws JSONException {
		DocsAndFolders docs = new DocsAndFoldersMock(getSyscode());
		return docs;
	}


}
