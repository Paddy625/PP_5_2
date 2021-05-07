package pp_5_2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import pp_5_2.MainClass.result;
import javax.swing.JButton;
import java.awt.AWTEvent;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;

public class Problem_plecakowy extends javax.swing.JFrame implements ActionListener {
	
	private JFrame frame;
	private JTextField quantityInsert;
	private JTextField capacityInsert;
	private JTextField weightInsert;
	private JTextField valueInsert;
	private JTextField indexDisplay;
	private JTextField weightDisplay;
	private JTextField valueDisplay;
	private JTextField subjectDisplay;
	private JTextField solutionDisplayValue;
	private JTextField solutionDisplayWeight;
	private JButton diceBtn;
	private JButton solveBtn;
	
	 RandomNumberGenerator rng = new RandomNumberGenerator(1);
     List<Integer> values = new ArrayList<Integer>();
     List<Integer> weight = new ArrayList<Integer>();
     int cost = 0;
     int load = 0;
     MainClass outer = new MainClass();
     result res = outer.new result(0, 0);
     Scanner in = new Scanner(System.in);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem_plecakowy window = new Problem_plecakowy();
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
	public Problem_plecakowy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		quantityInsert = new JTextField();
		quantityInsert.setBounds(10, 39, 86, 20);
		frame.getContentPane().add(quantityInsert);
		quantityInsert.setColumns(10);
		
		capacityInsert = new JTextField();
		capacityInsert.setBounds(443, 39, 86, 20);
		frame.getContentPane().add(capacityInsert);
		capacityInsert.setColumns(10);
		
		weightInsert = new JTextField();
		weightInsert.setBounds(165, 39, 86, 20);
		frame.getContentPane().add(weightInsert);
		weightInsert.setColumns(10);
		
		diceBtn = new JButton("Losuj problem");
		diceBtn.addActionListener(this);
		diceBtn.setBounds(200, 84, 156, 50);
		frame.getContentPane().add(diceBtn);
		
		JLabel lblNewLabel = new JLabel("Ilo\u015B\u0107");
		lblNewLabel.setBounds(10, 14, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zakres warto\u015Bci");
		lblNewLabel_1.setBounds(308, 14, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zakres wag");
		lblNewLabel_2.setBounds(165, 14, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		valueInsert = new JTextField();
		valueInsert.setBounds(308, 39, 86, 20);
		frame.getContentPane().add(valueInsert);
		valueInsert.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pojemno\u015B\u0107 plecaka");
		lblNewLabel_3.setBounds(443, 14, 98, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		indexDisplay = new JTextField();
		indexDisplay.setEditable(false);
		indexDisplay.setBounds(10, 154, 519, 20);
		frame.getContentPane().add(indexDisplay);
		indexDisplay.setColumns(10);
		
		weightDisplay = new JTextField();
		weightDisplay.setEditable(false);
		weightDisplay.setBounds(10, 200, 519, 20);
		frame.getContentPane().add(weightDisplay);
		weightDisplay.setColumns(10);
		
		valueDisplay = new JTextField();
		valueDisplay.setEditable(false);
		valueDisplay.setBounds(10, 244, 519, 20);
		frame.getContentPane().add(valueDisplay);
		valueDisplay.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Indeksy");
		lblNewLabel_4.setBounds(10, 136, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Wagi");
		lblNewLabel_5.setBounds(10, 185, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Warto\u015Bci");
		lblNewLabel_6.setBounds(10, 231, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		solveBtn = new JButton("Rozwi\u0105\u017C");
		solveBtn.setBounds(200, 275, 156, 50);
		solveBtn.addActionListener(this);
		frame.getContentPane().add(solveBtn);
		
		subjectDisplay = new JTextField();
		subjectDisplay.setEditable(false);
		subjectDisplay.setBounds(10, 360, 519, 20);
		frame.getContentPane().add(subjectDisplay);
		subjectDisplay.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Wybrane przedmioty");
		lblNewLabel_7.setBounds(10, 335, 143, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Warto\u015B\u0107 wybranych przedmiot\u00F3w:");
		lblNewLabel_8.setBounds(10, 391, 210, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Waga wybrancyh przedmiot\u00F3w:");
		lblNewLabel_9.setBounds(20, 426, 181, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		solutionDisplayValue = new JTextField();
		solutionDisplayValue.setEditable(false);
		solutionDisplayValue.setBounds(230, 388, 86, 20);
		frame.getContentPane().add(solutionDisplayValue);
		solutionDisplayValue.setColumns(10);
		
		solutionDisplayWeight = new JTextField();
		solutionDisplayWeight.setEditable(false);
		solutionDisplayWeight.setBounds(230, 423, 86, 20);
		frame.getContentPane().add(solutionDisplayWeight);
		solutionDisplayWeight.setColumns(10);
	}

	@Override 
	public void actionPerformed(ActionEvent e) {//losowanie problemu
		int count = Integer.parseInt(quantityInsert.getText());
        int weightMax = Integer.parseInt(weightInsert.getText());
        int valueMax = Integer.parseInt(valueInsert.getText());
        int capacity = Integer.parseInt(capacityInsert.getText());
        String v = "";
        String ind = "";
        String w = "";
		if(e.getSource()==diceBtn)
		{
			  indexDisplay.setText("");
	          valueDisplay.setText("");
	          weightDisplay.setText("");
	          values.clear();
	          weight.clear();
	          // === Losowanie przedmiotów ===
	          for (int i = 0; i < count; i++) {
	              values.add(rng.nextInt(1, valueMax));
	              v +=values.get(i) + "  ";
	              ind += i+1 + "  ";
	          }
	          
	          for (int i = 0; i < count; i++) {
	              weight.add(rng.nextInt(1, weightMax));
	              w +=values.get(i) + "  ";
	          }
	          indexDisplay.setText(ind);
              valueDisplay.setText(v);
              weightDisplay.setText(w);
		}
		
		if(e.getSource()==solveBtn)
		{
			  String s = "";
	          // === Problem plecakowy ===
	          res = outer.knapsack(weight, values, capacity);
	          
	          if (res != null)
	          {
	          solutionDisplayValue.setText(String.valueOf(res.cost));
	          solutionDisplayWeight.setText(String.valueOf(res.load));
	          for (int i = 0; i < res.packed.size(); i++) 
	              s +=res.packed.get(i) + "  ";
	          subjectDisplay.setText(s);
	          }
	          
		}
	}
	
	
}
