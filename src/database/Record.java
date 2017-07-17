/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import java.io.*;

public class Record implements Serializable {
	private String title, genre, artist;
	private float price;
	private int barcode, number;
	
	public Record(String name, String artist, String genre, float price, int number, int barcode) {
		this.title = name;
		this.artist = artist;
		this.genre = genre;
		this.price = price;
		this.number = number;
		this.barcode = barcode;
	}
	
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public float getPrice() {
		return price;
	}

	public int getNumber() { return number; }
	
	public int getBarCode() {
		return barcode;
	}

    public void setNumber(int number) { this.number = number; }

    public String toString() {
		return "Title: " +title+ "\nArtist: " +artist+ "\nGenre: " +genre+ "\nPrice: U$" +price+ "\nBar Code: " +barcode+ "\n\n";
	}

}
