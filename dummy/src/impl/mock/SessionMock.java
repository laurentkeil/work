package impl.mock;

import java.util.LinkedList;
import java.util.List;

import api.Course;

public class SessionMock implements api.Session {

    public SessionMock() {

    }

    @Override
    public List<Course> getCourses() {
      final List<Course> result=new LinkedList<Course>();
      for (int i=0;i<10;i++) {
          result.add(new CourseMock());
      }
      return result;
    }

    @Override
    public void closeSession() {
        System.out.println("Session Closed.");
    }

}
