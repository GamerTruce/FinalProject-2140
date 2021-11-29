import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import Menu.RadioListener;

//import Login.ButtonListener;
//import Login.RadioListener;

public class AddItem extends JFrame {
	
	private JPanel contentPane;

	private JTextField pName, pQuan, pPrice;
    private JButton enter, clear;
    private JLabel msg;
    private int radioSelect = 0;
    private int isChecked = 0;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    
	

	/**
	 * Create the frame.
	 */
	public AddItem() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
        JPanel inputPanel = new JPanel();
        //inputPanel.setLayout(new GridLayout(0,1));
        pName = new JTextField(30);
        pQuan = new JTextField(30);
        pPrice = new JTextField(30);
        JLabel nLabel = new JLabel("Product name:");
        JLabel qLabel = new JLabel("Product quantity:");
        JLabel pLabel = new JLabel("Product price:");

        inputPanel.add(nLabel);
        inputPanel.add(pName);
        inputPanel.add(qLabel);
        inputPanel.add(pQuan);
        inputPanel.add(pLabel);
        inputPanel.add(pPrice);
        inputPanel.setPreferredSize(new Dimension(349,120));

     

        RadioListener radioListener = new RadioListener();

       
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
        msg = new JLabel("<<MSG>>");
        messagePanel.add(msg);
        messagePanel.setPreferredSize(new Dimension(349,40));
     

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(btnPanel);
        
        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StockList st = new StockList();
        		st.setVisible(true);
        	}
        });
        btnPanel.add(btnNewButton_1);
        getContentPane().add(messagePanel, BorderLayout.SOUTH);

       
        setPreferredSize(new Dimension(400, 350));
}
	private class ButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == enter)
            {
                if(pName.getText().length() > 0 && pQuan.getText().length() > 0 && pPrice.getText().length() > 0)
                {
                	for (String i[] : UserLogin.products){
                      String[] namePart = i[0].split("(?<=\\D)(?=\\d)");
                      if (namePart[0].equals(pName.getText())){
                    	  msg.setText("Product name already exists");
                    	  pName.setText("");
                      }
                    }   
                    Random random = new Random();
                    String ID = pName.getText() + random.nextInt(999 - 100);
                    
                    Integer quantity =  Integer.parseInt(pQuan.getText());
                    if (quantity <= 0){
                      if (quantity <= 0){
                    	  msg.setText("Invalid quantity. Enter an integer greater than 0");
                    	  pQuan.setText("");
                      }
                    }
                    Integer price =  Integer.parseInt(pPrice.getText());
                    if (price <= 0){
                      if (price <= 0){
                        msg.setText("Invalid price. Enter an integer greater than 0");
                        pPrice.setText("");
                      }
                    }
                    String[] item = {ID, quantity.toString(), price.toString()};
                    UserLogin.products.add(item);
                                        
                    if (pName.getText().length() > 0 && pQuan.getText().length() > 0 && pPrice.getText().length() > 0) {
               		 msg.setText("New product succesfully added");
                    }
                    
                    for (String[] x : UserLogin.products) {
                    	System.out.println(Arrays.toString(x));
                    }
                                      
                 }else {
                	 msg.setText("Fields missing");
                }
            } else {
                pName.setText("");
                pQuan.setText("");
                pPrice.setText("");
                buttonGroup.clearSelection();
                radioSelect = 0;
                msg.setText("<<MSG>>>");
            }
        }
    }
	private class RadioListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent event)
        {
            radioSelect = 1;
        }
    }

    private class AcceptListener implements ItemListener
    {

        public void itemStateChanged(ItemEvent event)
        {
            if(isChecked == 0)
                isChecked = 1;
            else
                isChecked = 0;
        }
    }

}
