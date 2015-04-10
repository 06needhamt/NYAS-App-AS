package nyas.com.nyas_app.root.root.dialogs;

/**
 * Created by Thomas Needham on 26/03/2015.
 * This interface defines the methods required to handle events ad return data from dialog fragments
 * with two buttons for example {@link nyas.com.nyas_app.root.root.dialogs.PinInputDialog}
 */
public interface IConfirmDialogCompliant {

    /**
     * This method is called when the positive button is pressed on the dialog Fragment
     * @see android.app.AlertDialog.Builder#setPositiveButton(CharSequence, android.content.DialogInterface.OnClickListener)
     * @param pin the pin entered into the dialog fragment by the user
     */
    public void doYesConfirmClick(String pin);

    /**
     * This method is called when the negative button is pressed on the dialog Fragment
     * @see android.app.AlertDialog.Builder#setNegativeButton(CharSequence, android.content.DialogInterface.OnClickListener)
     * @param pin the pin entered into the dialog fragment by the user
     *
     */
    public void doNoConfirmClick(String pin);
}
