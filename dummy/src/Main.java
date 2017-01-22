import api.CommonDirectory;
import api.Course;
import api.Directory;
import api.Session;

public class Main {
    static public void main(String[] args) {
        final Session session = FactorySession.getSession("ven", "ven***");
        for (final Course course: session.getCourses()) {
            System.out.printf("Cours %s de %s\n",course.getDescription(),course.getTitulaire());
            for (final CommonDirectory d:course.getRootDirectory().getContents()) {
                System.out.printf("%c %s\n", isDirectory(d)? 'D' : 'F', d.getName());
            }
        }
    }

    private static boolean isDirectory(CommonDirectory d) {
            assert d!=null;
            return Directory.class.isInstance(d);
    }
}
