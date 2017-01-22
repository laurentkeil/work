
package impl.ws;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Folder
 */
public class FolderWS implements api.Folder, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = -7036118039955264562L;
	
	/**
	 * nom du dossier
	 */
	private String name;
	/**
	 * chemin du dossier
	 */
	private String path;
	/**
	 * description du dossier
	 */
	private String description;
	/**
	 * date de création du dossier
	 */
	private String date;
	/**
	 * type de dossier
	 */
	private int type;
	/**
	 * = true si il y a des notifications pour le dossier, false sinon
	 */
	private boolean notified;
	/**
	 * = true si le dossier est visible, false sinon
	 */
	private boolean visibility;
	
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String folderStr;

	/**
	 * Constructeur de l'objet FolderWS.
	 * @param folder : un objet JSON contenant les informations sur un dossier particulière d'un cours de l'utilisateur connecté.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	public FolderWS(String folder) throws Exception {
		if(!SessionWS.deco){
			this.folderStr = folder;
    	}
    	else{
    		throw new Exception("Cette ressource n'est pas accesible à un utilisateur non-connecté.");
    	}
	}
	
	@Override
	public String getName() throws JSONException {
		try {	
			JSONObject folder = new JSONObject(folderStr);
			name = folder.getString("name");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return name;
	} 
	
	@Override
	public String getPath() throws JSONException {
		try {		
			JSONObject folder = new JSONObject(folderStr);
			path = folder.getString("path");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return path;
	} 
	
	@Override
	public String getDescription() throws JSONException {
		try {
			JSONObject folder = new JSONObject(folderStr);
			description = folder.getString("description");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return description;
	} 
	
	@Override
	public String getDate() throws JSONException {
		try {				
			JSONObject folder = new JSONObject(folderStr);
			date = folder.getString("date");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return date;
	} 
	
	@Override
	public int getType() throws JSONException {	
		try {	
			JSONObject folder = new JSONObject(folderStr);
			type = folder.getInt("type");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return type;
	}
	
	@Override
	public boolean isVisible() throws JSONException {
		try {		
			JSONObject folder = new JSONObject(folderStr);
			visibility = folder.getBoolean("visibility");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return visibility;
	}
	
	@Override
	public boolean notified() throws JSONException {
		try {				
			JSONObject folder = new JSONObject(folderStr);
			notified = folder.getBoolean("notified");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return notified;
	}

}
