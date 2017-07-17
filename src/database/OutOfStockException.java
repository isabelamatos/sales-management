/**
 * Created by Isabela on 16/05/2017.
 */
package database;

public class OutOfStockException extends Exception{
	public OutOfStockException(String msg) {
		super(msg);
	}
}
