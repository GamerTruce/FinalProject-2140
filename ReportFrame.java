import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReportFrame {
    JFrame f;
    JTable j;

    // Constructor
    ReportFrame()
    {
        f = new JFrame();
        f.setTitle("Products");

        // Data to be displayed in the JTable
        String[][] data = readFile();

        // Column Names
        String[] columnNames = { "ID", "Quantity", "Price" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }

    private String[][] readFile() {
       File text = new File("Stock List.txt");
        Scanner scnr = null;
       try {
           scnr = new Scanner(text);
       } catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
      
       List<String> inputList = new ArrayList<String>();
       while(scnr.hasNextLine()){
           String eachLine = scnr.nextLine();
           //System.out.println(eachLine);
           inputList.add(eachLine);
       }
      
       String [][] input = new String[inputList.size()][4];
        //Reading each line of file using Scanner class
       int i = 0;
        for(String row : inputList) {
             String [] line = row.split("\\s");
             input[i][0] = line[2];
             input[i][1] = line[6];
             input[i][2] = line[10];
             input[i][3] = line[3];
             i++;
         }
       return input;
   }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		b = true;
		
	}

    private void excel(JTable table){
        try
        {
          TableModel m = table.getModel();
          FileWriter fw = new FileWriter(new file("report.xls"));
          for(int i = 0; i < m.getColumnCount(); i++){
            fw.write(m.getColumnName(i) + "\t");
          }
          fw.write("\n");
          for(int i=0; i < m.getRowCount(); i++) {
            for(int j=0; j < m.getColumnCount(); j++) {
              fw.write(m.getValueAt(i,j).toString()+"\t");
            }
            fw.write("\n");
          }
          fw.close();
        }
        catch(IOException e){ System.out.println(e); }
      }
}

