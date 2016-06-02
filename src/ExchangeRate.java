
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;


public class ExchangeRate extends JFrame implements ActionListener
{
 private JFrame frame = new JFrame("ExchangeRate");
 private JPanel contentPane;
 private JTextField source = new JTextField();
 private JTextField result = new JTextField();
 private String[] name=new String[]{"USD","CNY","EUR","GBP"};
 private float[] rate=new float[]{1,(float)6.093,(float)0.739,(float)0.618};
 private JComboBox combobox1=null;
 private JComboBox combobox2=null;
 private double sum;
 JButton Change;
 

 public static void main(String[] args) {

  
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     ExchangeRate frame = new ExchangeRate();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public ExchangeRate() {
 	 	setResizable(false);
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setUndecorated(true);
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					ExchangeRate.this.dispose();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p =ExchangeRate.this.getLocation();
				ExchangeRate.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
				
			}
		});
	 
  setBounds(1011, 292, 239, 86);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  combobox1 = new JComboBox(name);
  combobox1.setModel(new DefaultComboBoxModel(new String[] {"USD", "CNY", "EUR", "GBP" }));
  combobox1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
  combobox1.setBounds(6, 6, 93, 27);
  contentPane.add(combobox1);
  
  combobox2 = new JComboBox(name);
  combobox2.setModel(new DefaultComboBoxModel(new String[] {"USD", "CNY", "EUR", "GBP" }));
  combobox2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
  combobox2.setBounds(140, 6, 93, 27);
  contentPane.add(combobox2);
  
  source = new JTextField();
  source.setBackground(SystemColor.window);
  source.setBounds(6, 49, 93, 34);
  contentPane.add(source);
  source.setColumns(10);
  
  result = new JTextField();
  result.setBackground(SystemColor.window);
  result.setBounds(140, 49, 93, 34);
  contentPane.add(result);
  result.setColumns(10);
  
  Change = new JButton(">>");
  Change.setFont(new Font("Lucida Grande", Font.BOLD, 10));
  Change.setBounds(105, 28, 29, 27);
  contentPane.add(Change);
  Change.setOpaque(false);
  Change.setContentAreaFilled(false);
  Change.setBorder(null);
  
  combobox1.addActionListener(this);
  combobox2.addActionListener(this);
  Change.addActionListener(this);
 }

public void actionPerformed(ActionEvent e) {

java.text.DecimalFormat df = new java.text.DecimalFormat("#.000000");
String text=source.getText();
String sum1;
int cbx = combobox1.getSelectedIndex();
int cb1x=combobox2.getSelectedIndex();
if(e.getSource()==Change)
{
    try
 {
 sum=Float.parseFloat(text);
    sum1=df.format((double)rate[cb1x]/(double)rate[cbx]*sum);
    result.setText(sum1);
    }
    catch(NumberFormatException nfe)
    {
     result.setText("");
    }
     }
}
}