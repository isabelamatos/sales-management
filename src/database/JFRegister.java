/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.swing.*;

public class JFRegister extends JFrame{
	
	private Manager manager;
	private JButton JBConfirm = new JButton("Confirm");
	private JLabel JLFrameTitle = new JLabel("Complete all the fields correctly.");
	private JLabel JLTitle = new JLabel("Title: ");
	private JLabel JLGenre = new JLabel("Genre: ");
	private JLabel JLArtist = new JLabel("Artist: ");
	private JLabel JLPrice = new JLabel("Price: ");
	private JLabel JLNumber = new JLabel("Number: ");
	private JLabel JLBarCode = new JLabel("Bar code: ");
	private JTextField JTxtTitle = new JTextField("");
	private JTextField JTxtGenre = new JTextField("");
	private JTextField JTxtArtist = new JTextField("");
	private JTextField JTxtNumber = new JTextField("");
	private JTextField JTxtBarCode = new JTextField("");
	private JTextField JTxtPrice = new JTextField("");
	
	public JFRegister(Manager manager) {

		this.manager = manager;
		
		this.setLocation(450, 250);
		
		this.setTitle("Register");
		
		this.setSize(500,300);

		this.setResizable(false);
		
		JPanel painel = new JPanel(null);
	
		JBConfirm.setBounds(200, 200, 100, 30);
		JLFrameTitle.setBounds(150, 20, 300, 20);
		JLTitle.setBounds(30, 60, 100, 20);
		JLGenre.setBounds(30, 100, 100, 20);
		JLArtist.setBounds(30, 140, 100, 20);
		JLPrice.setBounds(280, 60, 100, 20);
		JLNumber.setBounds(280, 100, 100, 20);
		JLBarCode.setBounds(280, 140, 100, 20);
		JTxtTitle.setBounds(80, 60, 100, 25);
		JTxtGenre.setBounds(80, 100, 100, 25);
		JTxtArtist.setBounds(80, 140, 100, 25);
		JTxtPrice.setBounds(350, 60, 100, 25);
		JTxtNumber.setBounds(350, 100, 100, 25);
		JTxtBarCode.setBounds(350, 140, 100, 25);

		painel.add(JBConfirm);
		painel.add(JLTitle);
		painel.add(JLFrameTitle);
		painel.add(JLGenre);
		painel.add(JLArtist);
		painel.add(JLPrice);
		painel.add(JLNumber);
		painel.add(JLBarCode);
		painel.add(JTxtTitle);
		painel.add(JTxtGenre);
		painel.add(JTxtArtist);
		painel.add(JTxtPrice);
		painel.add(JTxtNumber);
		painel.add(JTxtBarCode);

		this.add(painel);
		
		JBConfirm.addActionListener(evento -> {
			try {
				if(JTxtArtist.getText().equals("") || JTxtGenre.getText().equals("") || JTxtTitle.getText().equals("") || JTxtPrice.getText().equals("") || JTxtBarCode.getText().equals("") || JTxtNumber.getText().equals("")) {
					throw new EmptyFieldException("Empty Field.");
				}

				if(Float.parseFloat(JTxtPrice.getText()) < 1 || Integer.parseInt((JTxtBarCode).getText()) < 1 || Integer.parseInt(JTxtNumber.getText()) < 1) {
					throw new NotPositiveNumberException("Price, number and bar code should be positive number. Please, check this and try again.");
				}
				manager.register(JTxtTitle.getText(), JTxtArtist.getText(), JTxtGenre.getText(), Float.parseFloat(JTxtPrice.getText()), Integer.parseInt(JTxtNumber.getText()), Integer.parseInt(JTxtBarCode.getText()));
                JOptionPane.showMessageDialog(new JFrame(), "Registration successfully completed." , "Menssagem", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(new JFrame(), "Please, check price (number), bar code (integer), number (integer) and try again.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch(EmptyFieldException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch(NotPositiveNumberException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}	
}