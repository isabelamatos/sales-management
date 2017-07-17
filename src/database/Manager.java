/**
 * Created by Isabela on 16/05/2017.
 */
package database;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Manager {

	private ArrayList<Record> stock;

	public Manager() {
		try{
			FileInputStream fin = new FileInputStream("stock.dat");
			ObjectInputStream in = new ObjectInputStream(fin);
			stock = (ArrayList<Record>) in.readObject();
			in.close();
		} catch(IOException e) {
			stock = new ArrayList<Record>();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void register(String title, String artist, String genre, float price, int amount, int barcode) {
		for(Record record : stock) {
			if(record.getBarCode() == barcode) {
				record.setNumber(record.getNumber() + amount);
				return;
			}
		}
		try {
			FileOutputStream fout = new FileOutputStream("stock.dat", false);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			Record record = new Record(title, artist, genre, price, amount, barcode);
			stock.add(record);
			out.writeObject(stock);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "The file could not be opened.", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	public void sell(int barcode, int number) throws OutOfStockException {
	    for(Record record : stock){
			if(barcode == record.getBarCode()) {
				if(record.getNumber() == number) {
					stock.remove(record);
				} else if (record.getNumber() > number) {
					record.setNumber(record.getNumber() - number);
				} else {
				    throw new OutOfStockException("Quantity Unavailable.");
                }
				try {
					FileOutputStream fout = new FileOutputStream("stock.dat", false);
					ObjectOutputStream out = new ObjectOutputStream(fout);

					out.writeObject(stock);
					out.close();
				} catch (IOException e){
					e.printStackTrace();
					JOptionPane.showConfirmDialog(null, "The file could not be opened.", "Erro", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				return;
			}
		}
		throw new OutOfStockException("Out of stock.");
	}

	public ArrayList<Record> search(String key) throws OutOfStockException{
		ArrayList<Record> result = new ArrayList<>();
		for(int i = 0; i < stock.size(); i++) {
			if(stock.get(i).getTitle().toLowerCase().contains(key.toLowerCase()) || stock.get(i).getGenre().toLowerCase().contains(key.toLowerCase()) || stock.get(i).getArtist().toLowerCase().contains(key.toLowerCase())) {
				result.add(stock.get(i));
			}
		}
		if(result.size() == 0) {
			throw new OutOfStockException("No results.");
		}
		return result;
	}


	public Record searchByBarCode(int barcode) throws OutOfStockException {
	    for(Record record : stock) {
	        if(record.getBarCode() == barcode) {
	            return record;
            }
        }
        throw new OutOfStockException("Out of stock.");
    }

    public ArrayList<Record> getStock() {
	    return stock;
    }
}
