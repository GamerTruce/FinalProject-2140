import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import ModifyList.ButtonListener;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField pID;
	private JLabel msg;
	private JButton enter, clear;
	private JButton btnNewButton;



	/**
	 * Create the frame.
	 */
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel messagePanel = new JPanel();
        msg = new JLabel("Enter product ID for item you wish to delete.");
        messagePanel.add(msg);
        messagePanel.setPreferredSize(new Dimension(349,40));
        
		JPanel inputPanel = new JPanel();
        pID = new JTextField(30);
        JLabel idLabel = new JLabel("Product ID:");

        inputPanel.add(idLabel);
        inputPanel.add(pID);
        inputPanel.setPreferredSize(new Dimension(349,120));
        

        JPanel btnPanel = new JPanel();
        enter = new JButton("Enter");
        clear = new JButton("Clear");
        ButtonListener buttonListener = new ButtonListener();
        enter.addActionListener(buttonListener);
        clear.addActionListener(buttonListener);

         btnPanel.add(enter);
         btnPanel.add(clear);
         btnPanel.setPreferredSize(new Dimension(349,40));

        
        getContentPane().add(messagePanel, BorderLayout.NORTH);
        getContentPane().add(inputPanel);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        
        btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ModifyList m = new ModifyList();
        		m.setVisible(true);
        	}
        });
        btnPanel.add(btnNewButton);
	}
	
	private class ButtonListener implements ActionListener
	{

	    public void actionPerformed(ActionEvent event)
	    {
	        if(event.getSource() == enter)
	        {
	        	if(pID.getText().length() >0) {
	        		for (String i[] : UserLogin.products){
	        			if (i[0].equals(pID.getText())){
	        				int index = UserLogin.products.indexOf(i);
	        		        UserLogin.products.remove(index);
	        		        msg.setText("Item deleted");
	        		      }
	        		    }
	        	}else {
	        		msg.setText("Enter product ID");
	        	}
	        }else {
	        	pID.setText("");
	        }
	        
	      }
	    }
	 }
	

  
