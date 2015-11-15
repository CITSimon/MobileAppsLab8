package ie.cit.android.songplayer;

import java.io.Serializable;

/**
 * Created by Simon on 11/11/2015.
 */
public class Song implements Serializable
{
    private String url;
    private String artist;
    private String songName;

    public Song(String url, String artist, String songName)
    {
        this.url = url;
        this.artist = artist;
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString()
    {
        return getArtist()+ " - "+getSongName();
    }
}
