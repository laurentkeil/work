package impl.mock;

import java.io.Serializable;

import org.json.JSONException;

import api.Courses;
import api.Updates;
import api.UserData;

/**
 * impl�mention mock avec des donn�es tests de l'interface.
 * cr�e une session en mode mock / donn�es tests
 * @see api.Session
 * @see java.io.Serializable
 * @author Keil Laurent
 */
public class SessionMock implements api.Session, Serializable {

	 /**
	  * R�f�rence de s�rialisation
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
