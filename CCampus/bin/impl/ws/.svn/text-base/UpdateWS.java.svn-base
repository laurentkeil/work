
package impl.ws;

import java.io.Serializable;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Update
 */
public class UpdateWS implements api.Update, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 4710840809058834141L;
	/**
	 * code du cours update
	 */
	private String syscode;
	/**
	 * date de modification de la ressource update
	 */
	private String date;
	/**
	 * id de la ressource update
	 */
	private String resID;
	/**
	 * code du module update (CLANN, CLDOC...)
	 */
	private String tagModule;

	@Override
	public void setSysCode(String string) {
		this.syscode = string;	
	}

	@Override
	public void setTagModule(String string) {
		this.tagModule = string;
	}

	@Override
	public void setResID(String string) {
		this.resID = string;		
	}

	@Override
	public void setDate(String string) {
		this.date = string;		
	}
	
	@Override
	public String getSysCode(){
		return syscode;
	}
	
	@Override
	public String getTagModule(){
		return tagModule;
	}
	
	@Override
	public String getResID(){
		return resID;
	}
	
	@Override
	public String getDate(){
		return date;
	}

}
