import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierManagement {

	private JFrame frame;
	private JTextField supplierTF;
	private JTextField costTF;
	private JTable table;
	private JTextField productTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierManagement window = new SupplierManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupplierManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void clear() {
		supplierTF.setText(null);
		costTF.setText(null);
		productTF.setText(null);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1127, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel TitleLabel = new JLabel("SUPPLIER MANAGEMENT");
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		TitleLabel.setBounds(357, 11, 386, 66);
		frame.getContentPane().add(TitleLabel);
		
		JLabel SupplierNameLabel = new JLabel("Supplier Name");
		SupplierNameLabel.setBounds(37, 99, 87, 14);
		frame.getContentPane().add(SupplierNameLabel);
		
		JLabel CostLabel = new JLabel("Cost for Supplier");
		CostLabel.setBounds(37, 142, 118, 14);
		frame.getContentPane().add(CostLabel);
		
		JLabel ProductTypeLabel = new JLabel("Products Supplied");
		ProductTypeLabel.setBounds(37, 193, 118, 14);
		frame.getContentPane().add(ProductTypeLabel);
		
		JLabel DeliverySpeedLabel = new JLabel("Delivery Speed");
		DeliverySpeedLabel.setBounds(37, 250, 87, 14);
		frame.getContentPane().add(DeliverySpeedLabel);
		
		supplierTF = new JTextField();
		supplierTF.setBounds(165, 96, 625, 20);
		frame.getContentPane().add(supplierTF);
		supplierTF.setColumns(10);
		
		costTF = new JTextField();
		costTF.setColumns(10);
		costTF.setBounds(165, 139, 86, 20);
		frame.getContentPane().add(costTF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 308, 1091, 261);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Supplier Name", "Cost of Supplier", "Products Supplied", "Delivery Speed"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(118);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Very Slow", "Slow", "Normal", "Fast", "Very Fast"}));
		comboBox.setBounds(165, 246, 117, 22);
		frame.getContentPane().add(comboBox);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model;
				model = (DefaultTableModel) table.getModel();
				model.insertRow(model.getRowCount(), new Object [] {supplierTF.getText(),costTF.getText(),productTF.getText(), comboBox.getSelectedItem()});
				clear();
			}
		});
		SaveButton.setBounds(849, 121, 89, 23);
		frame.getContentPane().add(SaveButton);
		
		JButton RemoveButton = new JButton("Remove");
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				model.removeRow(SelectedRowIndex);
				
				 
			}
		});
		RemoveButton.setBounds(849, 184, 89, 23);
		frame.getContentPane().add(RemoveButton);
		
		productTF = new JTextField();
		productTF.setColumns(10);
		productTF.setBounds(165, 190, 625, 20);
		frame.getContentPane().add(productTF);
	}
}
