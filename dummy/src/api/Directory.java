package api;

import java.util.List;

public interface Directory extends CommonDirectory {
    List<CommonDirectory> getContents();
}
