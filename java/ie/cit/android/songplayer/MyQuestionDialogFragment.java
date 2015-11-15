package ie.cit.android.songplayer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by Simon on 12/11/2015.
 */
public class MyQuestionDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Bundle b = getArguments();
        final Song theSong = (Song)b.get("song");

        AlertDialog.Builder builder = new  AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.video_question);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent viewVideo = new Intent(Intent.ACTION_VIEW);
                viewVideo.setData(Uri.parse(theSong.getUrl()));

                startActivity(viewVideo);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
