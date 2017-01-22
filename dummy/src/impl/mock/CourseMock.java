package impl.mock;

import impl.common.Utils;
import api.Directory;

class CourseMock implements api.Course {

    final String description = Utils.getRandomString("description cours");
    final String titulaire=Utils.getRandomString("titulaire");

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitulaire() {
        return titulaire;
    }

    @Override
    public Directory getRootDirectory() {
        return new DirectoryMock(0.4);
    }

}
