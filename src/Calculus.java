import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.JSeparator;

import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Calculus extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	
	
	
	String Str[]=new String[]{"-Please select an item.","-Linear equation with one unknown","-Quadratic equation with one unknown",
			"-Three order equation with one unknown","-Linear equation group with two unknowns",
			"-Linear equation group with three unknowns"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculus frame = new Calculus();
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
	public Calculus() {
		
		this.setUndecorated(true);//no title bar
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {//double click
					Calculus.this.dispose();//hide
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();//(x,y) mouse pressed
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = Calculus.this.getLocation();
				Calculus.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);//drag
				
			}
		});
		
		setTitle("Maldini's Calculas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 375, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHint = new JLabel("Please choose a type of equation or linear:");
		labelHint.setBounds(16, 6, 271, 16);
		contentPane.add(labelHint);
		
		comboBox = new JComboBox(Str);
		comboBox.setBounds(6, 21, 363, 27);
		contentPane.add(comboBox);
		
		JButton buttonNext = new JButton("Next");
		buttonNext.setBounds(294, 181, 75, 29);
		contentPane.add(buttonNext);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("This is a little programme to solve equations. "
				+ "Please select an item from the combo box.");
		textPane.setBackground(SystemColor.window);
		textPane.setEditable(false);
		textPane.setBounds(16, 48, 340, 114);
		contentPane.add(textPane);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index=comboBox.getSelectedIndex();
				if (index==0) {
					textPane.setText("This is a little programme to solve equations. "
							+ "Please select an item from the combo box.");
				} else if (index==1) {
					textPane.setText("You are going to solve a linear equation "
							+ "with one unknown. Please simplify equation to "
							+ "\"ax + b = 0\". Click next and enter a and b.");
				} else if (index==2) {
					textPane.setText("You are going to solve a quadratic equation "
							+ "with one unknown. Please simplify equation to "
							+ "\"ax^2 + bx + c = 0\". Click next and enter a, b and c.");
				} else if (index==3) {
					textPane.setText("You are going to solve an three order equation "
							+ "with one unknown. Please simplify equation to "
							+ "\"ax^3 + bx^2 + cx + d = 0\". Click next and enter a, b, c and d.");
				} else if (index==4) {
					textPane.setText("You are going to solve a linear equation group with two unknowns. "
							+ "Please simplify equation group to \"a1x1 + a2x2 + a3 = 0; b1x1 + b2x2 + b3 = 0\". "
							+ "Click next and enter a1, a2, a3, b1, b2 and b3.");
				} else if (index==5) {
					textPane.setText("You are going to solve a linear equation group with three unknowns. "
							+ "Please simplify equation group to \"a1x1 + a2x2 + a3x3 + a4 = 0; "
							+ "b1x1 + b2x2 + b3x3 + b4 = 0; c1x1 + c2x2 +c3x3 +c4 = 0\" "
							+ "Click next and enter a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3 and"
							+ " c4.");
				}
			}
		});
		
		buttonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=comboBox.getSelectedIndex();
				if (index==1) {
					selectedIndex_1 frame = new selectedIndex_1();
					Point p=Calculus.this.getLocation();
					frame.setBounds(p.x,p.y+216,375,185);
					frame.setVisible(true);
					addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = Calculus.this.getLocation();
							Point p1 = frame.getLocation();
								frame.setLocation(p1.x+e.getX()-origin.x, p1.y+e.getY()-origin.y);
						}
					});
				} else if (index==2) {
					selectedIndex_2 frame = new selectedIndex_2();
					Point p=Calculus.this.getLocation();
					frame.setBounds(p.x,p.y+216,375,185);
					frame.setVisible(true);
					addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = Calculus.this.getLocation();
							Point p1 = frame.getLocation();
							frame.setLocation(p1.x+e.getX()-origin.x, p1.y+e.getY()-origin.y);
						}
					});
				} else if (index==3) {
					selectedIndex_3 frame = new selectedIndex_3();
					Point p=Calculus.this.getLocation();
					frame.setBounds(p.x,p.y+216,375,185);
					frame.setVisible(true);
					addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = Calculus.this.getLocation();
							Point p1 = frame.getLocation();
							frame.setLocation(p1.x+e.getX()-origin.x, p1.y+e.getY()-origin.y);
						}
					});
				} else if (index==4) {
					selectedIndex_4 frame = new selectedIndex_4();
					Point p=Calculus.this.getLocation();
					frame.setBounds(p.x,p.y+216,375,225);
					frame.setVisible(true);
					addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = Calculus.this.getLocation();
							Point p1 = frame.getLocation();
							frame.setLocation(p1.x+e.getX()-origin.x, p1.y+e.getY()-origin.y);
						}
					});
				} else if (index==5) {
					selectedIndex_5 frame = new selectedIndex_5();
					Point p=Calculus.this.getLocation();
					frame.setBounds(p.x,p.y+216,375,265);
					frame.setVisible(true);
					addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = Calculus.this.getLocation();
							Point p1 = frame.getLocation();
							
							frame.setLocation(p1.x+e.getX()-origin.x, p1.y+e.getY()-origin.y);
						}
					});
				}	
				
			}
		});
		
	}
}
