/**
 * @author cgrod
 *
 */
package Blogcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {

	private int entryID;
	private String title;
	private String director;
	private String genre;
	private String postDate;
	private static int IDGenerator = 0;

	public Entry(String title, String director, String genre, String postDate) {
		this.entryID = IDGenerator++;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.postDate = postDate;
	}

	public void setID(int entryID) {
		this.entryID = entryID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setGenre(String genre) {
		this. = genre;
	}

	// setting current date
	public void setPostDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.postDate = dateFormat.format(date);
	}

	public int getEntryId() {
		return this.entryID;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDirector() {
		return this.director;
	}

	public String getGenre() {
		return this.genre;
	}

	public String getDate() {
		return this.postDate;
	}
}
