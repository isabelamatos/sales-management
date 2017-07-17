/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) {
		JFMain main = new JFMain();
		main.setVisible(true);

		try {
			main.setIconImage(ImageIO.read(new File("./icon.png")));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
