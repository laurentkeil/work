
package impl.ws;


import java.io.Serializable;

import impl.ws.services.JsonConvertor;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.CourseTool
 */
public class CourseToolWS implements api.CourseTool, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = -136588211266539191L;
	/**
	 * url à accéder
	 */
	private String url;
	/**
	 * code du cours
	 */
	private String sysCode;
	/**
	 * = true si il y a le module annonce pour le cours sysCode, false sinon.
	 */
	private boolean isAnn;
	/**
	 * = true si il y a au moins une notification (nouveauté) pour au moins une annonce pour le cours sysCode, false sinon.
	 */
	private boolean annNotif;
	/**
	 * = true si il y a le module document pour le cours sysCode, false sinon.
	 */
	private boolean isDnL;
	/**
	 * = true si il y a au moins une notification (nouveauté) pour au moins un document pour le cours sysCode, false sinon.
	 */
	private boolean dnlNotif;
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String jsonStr;
	
	/**
	 * Constructeur de l'objet CourseTool
	 * @param sysCode : code du cours de l'utilisateur pour lequel on obtient les outils disponibes et nouveautés.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	public CourseToolWS(String sysCode) throws Exception{
		this.url = "https://chouettecampus.info.fundp.ac.be/module/MOBILE/index.php?Method=getCourseToolList&cidReq=" + sysCode;
		// Creating JSON Parser instance
		JsonConvertor jParser = new JsonConvertor();
				 
		// getting JSON string from URL
		JSONObject json = jParser.getJSONObjectFromUrl(url);	
		this.jsonStr = json.toString();
	}

	@Override
	public String getSysCode() throws JSONException {
		try {	
			JSONObject json = new JSONObject(jsonStr);
			sysCode = json.getString("SysCode");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sysCode;
	}
	
	@Override
	public boolean isAnn() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			isAnn = json.getBoolean("isAnn");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isAnn;
	}
	
	@Override
	public boolean isDnL() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			isDnL = json.getBoolean("isDnL");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isDnL;
	}
	
	@Override
	public boolean annNotif() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			annNotif = json.getBoolean("annNotif");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return annNotif;
	}
	
	@Override
	public boolean dnlNotif() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			dnlNotif = json.getBoolean("dnlNotif");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return dnlNotif;
	}

}
