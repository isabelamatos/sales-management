/**
 * Created by Isabela on 16/05/2017.
 */
package database;

import javax.swing.*;

public class JLResult extends JFrame {

    private JList list;

    public JLResult(Object[] results) {

        this.setLocation(500,200);

        this.setTitle("Empire Records");

        this.setSize(400,400);

        this.setResizable(false);

        list = new JList(results);
        list.setVisibleRowCount(results.length);
        add(new JScrollPane(list));
    }

}
