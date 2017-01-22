
package impl.ws;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * impl�mention avec les donn�es des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Doc
 */
public class DocWS implements api.Doc, Serializable {

	 /**
	  * R�f�rence de s�rialisation
	  */
	private static final long serialVersionUID = 2079552098058047406L;
	/**
	 * nom du document
	 */
	private String name;
	/**
	 * extension du document
	 */
	private String extension;
	/**
	 * url de t�l�chargement du document
	 */
	private String url;
	/**
	 * chemin du document
	 */
	private String path;
	/**
	 * description du document
	 */
	private String description;
	/**
	 * taille du document
	 */
	private int size;
	/**
	 * date de cr�ation du document
	 */
	private String date;
	/**
	 * type de document
	 */
	private int type;
	/**
	 * = true si il y a des notifications pour le document, false sinon
	 */
	private boolean notified;
	/**
	 * = true si le document est visible, false sinon
	 */
	private boolean visibility;
	
	/**
	 * Chaine de caract�re contenant le fichier au format JSON
	 */
	private String docStr;

	/**
	 * Constructeur de l'objet DocWS.
	 * @param doc : un objet JSON contenant les informations sur un document particuli�re d'un cours de l'utilisateur connect�.
	 * @throws Exception : si l'utilisateur n'est pas connect�.
	 */
	public DocWS(String doc) throws Exception {
		if(!SessionWS.deco){
			this.docStr = doc;
    	}
    	else{
    		throw new Exception("Cette ressource n'est pas accesible � un utilisateur non-connect�.");
    	}
	}
	

	@Override
	public String getName() throws JSONException {
		try {		
			JSONObject doc = new JSONObject(docStr);
			name = doc.getString("name");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return name;
	} 
	
	@Override
	public String getExtension() throws JSONException {
		try {		
			JSONObject doc = new JSONObject(docStr);
			extension = doc.getString("extension");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return extension;
	} 
	
	@Override
	public String getUrl() throws JSONException {
		try {				
			JSONObject doc = new JSONObject(docStr);
			url = doc.getString("url");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return url;
	} 
	
	@Override
	public String getPath() throws JSONException {
		try {	
			JSONObject doc = new JSONObject(docStr);
			path = doc.getString("path");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return path;
	} 
	
	@Override
	public String getDescription() throws JSONException {
		try {		
			JSONObject doc = new JSONObject(docStr);
			description = doc.getString("description");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return description;
	} 

	@Override
	public int getSize() throws JSONException {	
		try {				
			JSONObject doc = new JSONObject(docStr);
			size = doc.getInt("size");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return size;
	}
	
	@Override
	public String getDate() throws JSONException {
		try {	
			JSONObject doc = new JSONObject(docStr);
			date = doc.getString("date");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return date;
	} 
	
	@Override
	public int getType() throws JSONException {	
		try {				
			JSONObject doc = new JSONObject(docStr);
			type = doc.getInt("type");	
		} catch (JSONException e) {
			e.printStackTrace();
		}		return type;
	}
	
	@Override
	public boolean isVisible() throws JSONException {
		try {			
			JSONObject doc = new JSONObject(docStr);
			visibility = doc.getBoolean("visibility");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return visibility;
	}
	
	@Override
	public boolean notified() throws JSONException {
		try {	
			JSONObject doc = new JSONObject(docStr);
			notified = doc.getBoolean("notified");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return notified;
	}

}
