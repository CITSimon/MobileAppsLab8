package ie.cit.android.songplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Simon on 12/11/2015.
 */
public class SongController
{
    private static final int YOUTUBE_URL_INDEX = 0;
    private static final int ARTIST_INDEX = 1;
    private static final int SONG_TITLE_INDEX = 2;

    //Pass in the InputStream retrieved from the Android raw resources
    public static ArrayList<Song> readSongsFromStream(InputStream ioStream)
    {
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            //Read through the file line by line
            InputStreamReader ioStreamReader = new InputStreamReader(ioStream);
            BufferedReader br = new BufferedReader(ioStreamReader);

            //Each line is of the following form :  youtube url#artist name#song title
            //e.g. https://www.youtube.com/watch?v=XmSdTa9kaiQ#U2#With or Without You
            //We split each String and create a Song object

            String currLine = "";
            while ((currLine = br.readLine()) != null) {
                String[] parts = currLine.split("#");
                //Instantiate Song object
                Song songNew =
                        new Song(parts[YOUTUBE_URL_INDEX], parts[ARTIST_INDEX], parts[SONG_TITLE_INDEX]);
                songs.add(songNew);
            }
        }
        catch(IOException ioex)
        {
            System.out.println(ioex.getMessage());
        }
        return songs;
    }
}
