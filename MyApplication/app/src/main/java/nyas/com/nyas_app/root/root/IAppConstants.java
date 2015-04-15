package nyas.com.nyas_app.root.root;

/**
 * Created by Thomas Needham on 07/04/2015.
 * This interface stores constant variables which need to be accessed globally throughout the app
 * The variables declared within this interface can be accessed in any class by making the class implement it
 * for Example
 * <pre>
 * {@code
 *  public class TestClass implements IAppConstants
 *  {
 *      String Test = PREF_Names;
 *      // test will equal "myAppPrefs"
 *  }
 * }
 * </pre>
 * @author Thomas Needham
 */
public interface IAppConstants {

    public static final String PREF_NAMES = "myAppPrefs";
    public static final String APPOINTMENT_FILE_NAME = "appointments.bin";
}
