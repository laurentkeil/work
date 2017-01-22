package impl.mock;

import impl.common.Utils;

class DocumentMock implements api.Document {
    final String name = Utils.getRandomString("document");
    final byte[] content = new byte[] { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 0 };

    @Override
    public String getName() {
        return name;
    }

    @Override
    public byte[] getContent() {
        return content;
    }

}
