package impl.common;

public class Utils {
    /**
     *
     * @param prefix not null
     * @return retourne une chaine al�atoire avec prefix comme pr�fixe
     */
    static public  String getRandomString(String prefix) {
        assert prefix!=null;
        return prefix+" "+Long.toString(System.currentTimeMillis());
    }

}
