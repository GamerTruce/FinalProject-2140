import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import AddItem.ButtonListener;
//import AddItem.RadioListener;

public class ModifyList extends JFrame {

	private JPanel contentPane;
	
		
    private JButton add, delete, edit;
    private JLabel msg;
    private int radioSelect = 0;
    private int isChecked = 0;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

	

	/**
	 * Create the frame.
	 */
	public ModifyList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
        //inputPanel.setLayout(new GridLayout(0,1));
            

       

       
       JPanel btnPanel = new JPanel();
        add = new JButton("Add item");
        delete = new JButton("Delete item");
        edit = new JButton("Edit item");
        ButtonListener buttonListener = new ButtonListener();
        add.addActionListener(buttonListener);
        delete.addActionListener(buttonListener);
        edit.addActionListener(buttonListener);

        btnPanel.add(add);
        btnPanel.add(delete);
        btnPanel.add(edit);
        btnPanel.setPreferredSize(new Dimension(349,40));

     

        getContentPane().add(btnPanel, BorderLayout.NORTH);
        
        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StockList st = new StockList();
            	st.setVisible(true);
        	}
        });
        contentPane.add(btnNewButton_1, BorderLayout.CENTER);

       
        setPreferredSize(new Dimension(400, 350));
	}
	
private class ButtonListener implements ActionListener
{

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == add)
        {
        	AddItem at = new AddItem();
    		at.setVisible(true);
        }else {
        	if(event.getSource() == delete) {
        		Delete d = new Delete();
        		d.setVisible(true);
        	}else {
        		if(event.getSource() == edit) {
        			Edit e = new Edit();
        			e.setVisible(true);
        		}
        	}
        }
      }
    }
 }


