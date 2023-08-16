/**
 * Date: 08/03/2023
 * Allows for system access for applications necessary to create the Cart App
 * This class includes access to Home View and Cart View using buttons on left side of the app.
 * @author David Regio
 * @version 1.0 
*/

package CluckCo.shoppingCart;

public class SystemInfo {

    /*
     * Allows for use of Java's recent version.
     */
    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    /*
     * Allows for use of JaveFX recent version.
     */
    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

}