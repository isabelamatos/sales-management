/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.swing.*;
import java.util.ArrayList;

public class JFSearch extends JFrame{
	
	private Manager manager;
	private JLabel JLFrameTitle = new JLabel("Enter part of the title, artist or genre.");
	private JTextField JTxtSearch = new JTextField("");
	private JButton JBSearch = new JButton("Search");

	public JFSearch(Manager manager) {
		
		this.manager = manager;
		
		this.setLocation(500, 250);
		
		this.setTitle("Search");
		
		this.setSize(350,200);

		this.setResizable(false);
		
		JPanel painel = new JPanel(null);
		
        JLFrameTitle.setBounds(60, 20, 300, 20);
        JTxtSearch.setBounds(70, 60, 200, 20);
        JBSearch.setBounds(110, 100, 100, 30);

		painel.add(JLFrameTitle);
		painel.add(JTxtSearch);
		painel.add(JBSearch);

		this.add(painel);
		
        JBSearch.addActionListener(evento -> {
			try {
				if(JTxtSearch.getText().equals("")) {
					throw new EmptyFieldException("Empty field.");
				}
                ArrayList<Record> stock = manager.search(JTxtSearch.getText());
				ArrayList<String> result = new ArrayList<>();
				for (Record record : stock) {
				    result.add("Title: "+record.getTitle());
				    result.add("Artist: "+record.getArtist());
				    result.add("Genre: "+record.getGenre());
				    result.add("Price: "+record.getPrice());
				    result.add("Number: "+record.getNumber());
				    result.add("Bar Code: "+record.getBarCode());
				    result.add("______________________________________________________");
				    result.add(" ");
                }
                (new JLResult(result.toArray())).setVisible(true);
			} catch(OutOfStockException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Search", JOptionPane.INFORMATION_MESSAGE);
			} catch(EmptyFieldException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
