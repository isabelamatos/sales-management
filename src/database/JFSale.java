/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.swing.*;

public class JFSale extends JFrame{
	
	private Manager manager;
	private JLabel JLBarCode = new JLabel("Bar code: ");
    private JLabel JLNumber = new JLabel("Number: ");
	private JTextField JTxtBarCode = new JTextField("");
	private JTextField JTxtNumber = new JTextField("");
	private JButton JBConfirm = new JButton("Confirm");
	
	public JFSale(Manager manager) {
		
		this.manager = manager;
		
		this.setLocation(500, 250);
		
		this.setTitle("Sale");
		
		this.setSize(350,200);

		this.setResizable(false);
		
		JPanel painel = new JPanel(null);
		
		JLBarCode.setBounds(15, 50, 100, 20);
		JLNumber.setBounds(190, 50, 100, 20);
		JTxtBarCode.setBounds(75, 50, 70, 20);
		JTxtNumber.setBounds(246, 50, 70, 20);
		JBConfirm.setBounds(110, 100, 100, 30);
		
		painel.add(JTxtBarCode);
		painel.add(JBConfirm);
		painel.add(JTxtNumber);
		painel.add(JLBarCode);
		painel.add(JLNumber);
		
		this.add(painel);
		
		JBConfirm.addActionListener(evento -> {
			try {
                if (JTxtBarCode.getText().equals("") || JTxtNumber.getText().equals("")) {
                    throw new EmptyFieldException("Empty field.");
                } else if (Integer.parseInt(JTxtBarCode.getText()) <= 0 || Integer.parseInt(JTxtNumber.getText()) <= 0) {
                    throw new NotPositiveNumberException("Bar code and number should be positive numbers. Please, check this and try again.");
                }
                Record record = manager.searchByBarCode(Integer.parseInt(JTxtBarCode.getText()));
                int answer = JOptionPane.showConfirmDialog(new JFrame(), record + JTxtNumber.getText() + " units.", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    manager.sell(Integer.parseInt(JTxtBarCode.getText()), Integer.parseInt(JTxtNumber.getText()));
                    JOptionPane.showMessageDialog(new JFrame(), "Sale registered successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch(OutOfStockException e) {
			    JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);;
			} catch(EmptyFieldException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(new JFrame(), "Bar code and number should be integer numbers. Please, check this and try again.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch(NotPositiveNumberException e) {
			    JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
			this.setVisible(false);
		});
	}
}
