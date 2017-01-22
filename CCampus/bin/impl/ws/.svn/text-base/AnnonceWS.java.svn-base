
package impl.ws;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Annonce
 */
public class AnnonceWS implements api.Annonce, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 6281038339301172369L;
	/**
	 * id de l'annonce
	 */
	private int ressourceId;	
	/**
	 * titre de l'annonce
	 */
	private String title;
	/**
	 * contenu de l'annonce
	 */
	private String content;
	/**
	 * date à laquelle l'annonce a été visible
	 */
	private String visibleFrom;
	/**
	 * date jusqu'à laquelle l'annonce sera visible
	 */
	private String visibleUntil;
	/**
	 * visibility = true si l'annonce est visible, false sinon
	 */
	private boolean visibility;
	/**
	 * rang de l'annonce
	 */
	private int rank;
	/**
	 * date de création de l'annonce
	 */
	private String date;
	/**
	 * notified = true si il y a des nouveautés pour l'annonce, false sinon
	 */
	private boolean notified;
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String annStr;

	
	/**
	 * Constructeur de l'objet AnnonceWS.
	 * @param annonceStr : un objet JSON contenant les informations sur une annonce particulière d'un cours de l'utilisateur connecté.
	 */
	public AnnonceWS(String annonceStr) {
		this.annStr = annonceStr;
	}

	@Override
	public int getRessourceID() throws JSONException {	
		try {				
			JSONObject ann = new JSONObject(annStr);
			ressourceId = ann.getInt("ressourceId");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ressourceId;
	}
	
	@Override
	public String getTitle() throws JSONException {
		try {	
			JSONObject ann = new JSONObject(annStr);
			title = ann.getString("title");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return title;
	} 
	
	@Override
	public String getContent() throws JSONException {
		try {				
			JSONObject ann = new JSONObject(annStr);
			content = ann.getString("content");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return content;
	} 	

	@Override
	public String visibleFrom() throws JSONException {
		try {		
			JSONObject ann = new JSONObject(annStr);
			visibleFrom = ann.getString("visibleFrom");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return visibleFrom;
	} 
	
	@Override
	public String visibleUntil() throws JSONException {
		try {		
			JSONObject ann = new JSONObject(annStr);
			visibleUntil = ann.getString("visibleUntil");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return visibleUntil;
	} 
	
	@Override
	public boolean isVisible() throws JSONException {
		try {
			JSONObject ann = new JSONObject(annStr);
			visibility = ann.getBoolean("visibility");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return visibility;
	}
	
	@Override
	public int getRank() throws JSONException {	
		try {	
			JSONObject ann = new JSONObject(annStr);
			rank = ann.getInt("rank");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return rank;
	}
	
	
	@Override
	public String getDate() throws JSONException {	
		try {		
			JSONObject ann = new JSONObject(annStr);
			date = ann.getString("date");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return date;
	}	

	@Override
	public boolean notified() throws JSONException {
		try {		
			JSONObject ann = new JSONObject(annStr);
			notified = ann.getBoolean("notified");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return notified;
	}
	
}
