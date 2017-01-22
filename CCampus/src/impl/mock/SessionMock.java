package impl.mock;

import java.io.Serializable;

import org.json.JSONException;

import api.Courses;
import api.Updates;
import api.UserData;

/**
 * implémention mock avec des données tests de l'interface.
 * crée une session en mode mock / données tests
 * @see api.Session
 * @see java.io.Serializable
 * @author Keil Laurent
 */
public class SessionMock implements api.Session, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = -5646135478335432906L;

	/**
	 * constructeur de SessionMock
	 */
	public SessionMock() {
        System.out.println("Session opened.");		
    }

	@Override
	public void closeSession() {
        System.out.println("Session Closed.");		
	}

	@Override
	public UserData getUserData() {
		UserData userdata = new UserDataMock();	
		return userdata;
	}

	@Override
	public Courses getCourses() throws JSONException {
		Courses courses = new CoursesMock();	
		return courses;
	}

	@Override
	public Updates getUpdates() {
		Updates updates = new UpdatesMock();	
		return updates;
	}

}
