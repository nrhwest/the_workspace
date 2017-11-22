import java.time.LocalDateTime;

/**
 * Nathan West 
 * CSMC 256 
 * Project #2 
 * Purpose: To model an Song file 
 * Description: This class models the properties of an Song file. It inherits the name and
 * 				size attributes from the DigitalMedia class
 */

public class Song extends DigitalMedia implements Comparable<Song> {

	private String title = null, artist = null, album = null;

	public Song(String n, long s, String album, String artist) {
		super(n, s); // inherits name/size from DigitalMedia
		title = n;
		this.artist = artist;
		this.album = album;
	}

	public void setArtist(String artist) {
		if (artist.equals(null))
			throw new IllegalArgumentException("Artist cannot be blank!");
		else
			this.artist = artist;
		LocalDateTime change = LocalDateTime.now();
		super.setDateModified(change);
	}

	public void setAlbum(String album) {
		if (album.equals(null))
			throw new IllegalArgumentException("Album cannot be blank!");
		else
			this.album = album;
		LocalDateTime change = LocalDateTime.now();
		super.setDateModified(change);
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Song) {
			Song alt = (Song) obj;
			if (album.equals(alt.getAlbum())) {
				if (artist.equals(alt.getArtist())) {
					if (super.getName().equals(alt.getAlbum())) {
						if (super.getSize() == alt.getSize())
							return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (title.contains(".mp3"))
			title = title.replaceAll(".mp3", "");
		if (title.contains(".mp4"))
			title = title.replaceAll(".mp4", "");
		return "\nTitle: " + title + "\nArtist: " + artist + "\nAlbum: " + album;
	}

	public int compareTo(Song o) {
		int comparison = artist.toUpperCase().compareTo(o.getArtist().toUpperCase());
        if (comparison != 0)
            return comparison;
        return super.getName().toUpperCase().compareTo(o.getName().toUpperCase());
	}
}
