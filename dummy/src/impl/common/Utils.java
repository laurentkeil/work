package impl.common;

public class Utils {
    /**
     *
     * @param prefix not null
     * @return retourne une chaine aléatoire avec prefix comme préfixe
     */
    static public  String getRandomString(String prefix) {
        assert prefix!=null;
        return prefix+" "+Long.toString(System.currentTimeMillis());
    }

}
