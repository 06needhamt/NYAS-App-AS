package nyas.com.nyas_app.root.root.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nyas.com.nyas_app.R;


/**
 * Created by Tom on 26/03/2015.
 */
public class PinInputDialog extends DialogFragment implements DialogInterface{

    TextView input;
    String Message;
    IConfirmDialogCompliant caller;

    @Deprecated
    public PinInputDialog() { }

    @Deprecated
    public PinInputDialog(String Message) {this.Message = Message;}

    @Deprecated
    public PinInputDialog(IConfirmDialogCompliant caller) {this.caller = caller;}

    public PinInputDialog(String message, IConfirmDialogCompliant caller) {this.Message = message; this.caller = caller;}

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        input = new EditText(getActivity());
        input.setTextColor(getActivity().getResources().getColor(R.color.Black));
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter your 4 digit pin code");
        builder.setMessage(Message);
        builder.setView(input);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try
                {
                    if(input.getText().toString().length() != 4)
                    {
                        throw new Exception("Invalid Pin Length");
                    }
                    //int temp = Integer.parseInt((String) input.getText());
                    String temp = input.getText().toString();
                    caller.doYesConfirmClick(temp);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(getActivity().getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try
                {
                    cancel();
                    if(input.getText().toString().length() != 4)
                    {
                        throw new Exception("Invalid Pin Length");
                    }
                    //int temp = Integer.parseInt((String) input.getText());
                    String temp = input.getText().toString();
                    caller.doNoConfirmClick(temp);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(getActivity().getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        return builder.create();
    }
    @Override
    public void cancel() {
        input.setText("0000");
    }
}
