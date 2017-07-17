/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JFMain extends JFrame {

	private Manager manager = new Manager();

	private JButton JBRegister = new JButton("Register");
	private JButton JBSale = new JButton("Sale");
	private JButton JBSearch = new JButton("Search");
	private JButton JBStock = new JButton("Stock");
    private JLabel background = new JLabel(new ImageIcon("./background.png"));


    public JFMain() {

		this.setTitle("Empire Records");

		this.setLocation(350,100);

		this.setSize(650,550);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

		JBRegister.setBounds(30, 80, 150, 50);
		JBSale.setBounds(30, 180, 150, 50);
		JBSearch.setBounds(30, 280, 150, 50);
		JBStock.setBounds(30, 380, 150, 50);

        add(background);
		background.add(JBRegister);
		background.add(JBSale);
		background.add(JBSearch);
        background.add(JBStock);
        
        JBRegister.addActionListener(evento -> {
        	JFRegister JFRegister = new JFRegister(manager);
            try {
                JFRegister.setIconImage(ImageIO.read(new File("./icon.png")));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        	JFRegister.setVisible(true);
        });
        
        JBSale.addActionListener(evento -> {
            JFSale JFSale = new JFSale(manager);
            try {
                JFSale.setIconImage(ImageIO.read(new File("./icon.png")));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            JFSale.setVisible(true);
        });
        
        JBSearch.addActionListener(evento -> {
            JFSearch JFSearch = new JFSearch(manager);
            try {
                JFSearch.setIconImage(ImageIO.read(new File("./icon.png")));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            JFSearch.setVisible(true);
        });

        JBStock.addActionListener(evento -> {
			ArrayList<Record> stock = manager.getStock();
			ArrayList<String> resultado = new ArrayList<>();
			for (Record record : stock) {
				resultado.add("Title: "+record.getTitle());
				resultado.add("Artist: "+record.getArtist());
				resultado.add("Genre: "+record.getGenre());
				resultado.add("Price: "+record.getPrice());
				resultado.add("Number: "+record.getNumber());
				resultado.add("Bar code: "+record.getBarCode());
				resultado.add("______________________________________________________");
				resultado.add(" ");
			}

            JLResult JLResultado = new JLResult(resultado.toArray());
            try {
                JLResultado.setIconImage(ImageIO.read(new File("./icon.png")));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            JLResultado.setVisible(true);
        });
    }	
}