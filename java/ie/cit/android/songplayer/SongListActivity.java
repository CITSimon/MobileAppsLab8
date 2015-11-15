package ie.cit.android.songplayer;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Simon on 12/11/2015.
 */
public class SongListActivity extends ListActivity {
    private ArrayList<Song> songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream stream =
                getResources().openRawResource(R.raw.musiclist);
        //Call to controller
        songList = SongController.readSongsFromStream(stream);
        //Setup the Adapter
        ArrayAdapter<Song> songListAdapter = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, songList);
        setListAdapter(songListAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Get the selected Song object
        Song selectedSong = songList.get(position);
        MyQuestionDialogFragment dialogFrag =
                new MyQuestionDialogFragment();
        Bundle b = new Bundle();
        b.putSerializable("song", selectedSong);
        dialogFrag.setArguments(b);
        dialogFrag.show(getFragmentManager(), "yesNoDialog");
    }
}
