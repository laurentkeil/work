package impl.mock;

import impl.common.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import api.CommonDirectory;


class DirectoryMock implements api.Directory {
    final String name=Utils.getRandomString("directory");
    final List<CommonDirectory> content=new LinkedList<CommonDirectory>();
    private final Random rnd=new Random();
    private final double seuil;

    DirectoryMock(double proba){
        rnd.setSeed(99);
        seuil=proba;
        for (int i=0;i<10;i++) {
            content.add(newEntry());
        }
    }

    private CommonDirectory newEntry() {
        if (rnd.nextFloat()<seuil) {
            return new DirectoryMock(seuil/2.0);
        } else {
            return new DocumentMock();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<CommonDirectory> getContents() {
        return Collections.unmodifiableList(content);
    }

}
