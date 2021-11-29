import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import ModifyList.ButtonListener;

public class Edit extends JFrame {

	private JPanel contentPane;
	
	private JTextField pID, pName, pQuan, pPrice;
    private JButton enter, clear;
    private JLabel msg;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;


	/**
	 * Create the frame.
	 */
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0,1));
        
		pID = new JTextField(30);
		pName = new JTextField(30);
        pQuan = new JTextField(30);
        pPrice = new JTextField(30);
        JLabel iLabel = new JLabel("Product ID:");
        JLabel nLabel = new JLabel("Product name:");
        JLabel qLabel = new JLabel("Product quantity:");
        JLabel pLabel = new JLabel("Product price:");

        inputPanel.add(iLabel);
        inputPanel.add(pID);
        inputPanel.add(nLabel);
        inputPanel.add(pName);
        inputPanel.add(qLabel);
        inputPanel.add(pQuan);
        inputPanel.add(pLabel);
        inputPanel.add(pPrice);
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
        
        JPanel messagePanel = new JPanel();
        msg = new JLabel("Enter product ID for item you wish to edit and new name/quantity/price in the relevant field(s)");
        messagePanel.add(msg);
        messagePanel.setPreferredSize(new Dimension(349,40));

     

        getContentPane().add(messagePanel, BorderLayout.NORTH);
        getContentPane().add(inputPanel);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        
        btnNewButton_2 = new JButton("Back");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ModifyList m = new ModifyList();
        		m.setVisible(true);
        	}
        });
        btnPanel.add(btnNewButton_2);

       
        setPreferredSize(new Dimension(400, 350));
	}
	
	private class ButtonListener implements ActionListener
	{
		Random random = new Random();
	    public void actionPerformed(ActionEvent event)
	    {
	    	boolean inList = false;
	        if(event.getSource() == enter) {
	        	if(pID.getText().length() > 0) {
	        		if (pName.getText().length() > 0 || pQuan.getText().length() > 0 || pPrice.getText().length() > 0) {
	        			for (String i[] : UserLogin.products){
	        		         if (i[0].equals(pID.getText())){
	        		           inList = true;
	        		           break;
	        		         }
	        		    }
	        			if (inList == false) {
	        				msg.setText("Poduct ID does not exist");
	        		        pID.setText("");
	        			    pName.setText("");
	        			    pQuan.setText("");
	        			    pPrice.setText("");
	        			    msg.setText("");
	        			}
	        			if (pName.getText().length() > 0) {
	        				for (String i[] : UserLogin.products){
		        	            String[] namePart = i[0].split("(?<=\\D)(?=\\d)");
		        	            if (namePart[0].equals(pName.getText())){
		        	            	msg.setText("Product name already exists");
		        	            	pName.setText("");
		        	            }
	        	            }
	        			}
	        				if (pName.getText().length() > 0) {
	        					for (String i[] : UserLogin.products){
	        						if (i[0].equals(pName.getText())){
	        							i[0] = pName.getText() + random.nextInt(999 - 100);
	        							break;
	        						}
	        					}
	        	             }
	        				if (pQuan.getText().length() > 0) {
	        					if (Integer.parseInt(pQuan.getText()) <= 0){
	        						msg.setText("Invalid quantity. Enter an integer greater than 0");
	        		                pQuan.setText("");
	        		               }
	        		        }
	        				if (pQuan.getText().length() > 0) {
	        					for (String i[] : UserLogin.products){
	        						if (i[0].equals(pID.getText())){
	        							i[1] = pQuan.getText();
	        							break;
	        		               }
	        		             }
	        				}
	        				if (pPrice.getText().length() > 0) {
	        					if (Integer.parseInt(pPrice.getText()) <= 0){
	        						msg.setText("Invalid price. Enter an integer greater than 0");
	        		                pPrice.setText("");
	        		             }
	        		         }
	        				if (pPrice.getText().length() > 0) {
	        					for (String i[] : UserLogin.products){
	        						if (i[0].equals(pID.getText())){
	        							i[2] = pPrice.getText();
	        							break;
	        		                 }
	        		             }
	        				}
	        				msg.setText("Product updated");	        				
	        		}else {
	        			msg.setText("Field missing");
	        		}
	        }else {
	        	msg.setText("Product ID missing");
	        }
	      }
	        pID.setText("");
	        pName.setText("");
	        pQuan.setText("");
	        pPrice.setText("");
	        msg.setText("");
	    }
	}

}

