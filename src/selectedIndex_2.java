import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Window.Type;


public class selectedIndex_2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectedIndex_2 frame = new selectedIndex_2();
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
	public selectedIndex_2() {
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					selectedIndex_2.this.dispose();
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
				Point p = selectedIndex_2.this.getLocation();
				selectedIndex_2.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});
		this.setUndecorated(true);
		setTitle("Maldini's Calculas");
		setType(Type.UTILITY);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 316, 375, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHint_2 = new JLabel("Enter the coefficient of the equation (group).");
		labelHint_2.setBounds(6, 6, 292, 16);
		contentPane.add(labelHint_2);
		
		txtA = new JTextField();
		txtA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA.setText("");
			}
		});
		txtA.setText("a");
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setColumns(10);
		txtA.setBackground(SystemColor.window);
		txtA.setBounds(6, 34, 29, 28);
		contentPane.add(txtA);
		
		JLabel label_2_1 = new JLabel("x^2 + ");
		label_2_1.setBounds(35, 40, 42, 16);
		contentPane.add(label_2_1);
		
		txtB = new JTextField();
		txtB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB.setText("");
			}
		});
		txtB.setText("b");
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setColumns(10);
		txtB.setBackground(SystemColor.window);
		txtB.setBounds(76, 34, 29, 28);
		contentPane.add(txtB);
		
		JLabel label_2_2 = new JLabel("x + ");
		label_2_2.setBounds(104, 40, 29, 16);
		contentPane.add(label_2_2);
		
		txtC = new JTextField();
		txtC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtC.setText("");
			}
		});
		txtC.setText("c");
		txtC.setHorizontalAlignment(SwingConstants.CENTER);
		txtC.setColumns(10);
		txtC.setBackground(SystemColor.window);
		txtC.setBounds(128, 34, 29, 28);
		contentPane.add(txtC);
		
		JLabel label_2_3 = new JLabel("= 0");
		label_2_3.setBounds(157, 40, 29, 16);
		contentPane.add(label_2_3);
		
		JLabel labelClip = new JLabel("");
		labelClip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelClip.setBounds(6, 169, 232, 16);
		contentPane.add(labelClip);
		
		JTextPane resultPane_2 = new JTextPane();
		resultPane_2.setToolTipText("Click to copy.");
		resultPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=resultPane_2.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
					labelClip.setText("The result has been copied to Clipboard.");
				}
			}
		});
		resultPane_2.setEditable(false);
		resultPane_2.setBackground(SystemColor.window);
		resultPane_2.setBounds(16, 74, 352, 44);
		contentPane.add(resultPane_2);
		
		JButton buttonSolve_2 = new JButton("Solve");
		
		buttonSolve_2.setBounds(293, 150, 75, 29);
		contentPane.add(buttonSolve_2);
		contentPane.setLayout(null);
		
		buttonSolve_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double a=Double.valueOf(txtA.getText());
				double b=Double.valueOf(txtB.getText());
				double c=Double.valueOf(txtC.getText());
				double delt=b*b-4*a*c;
				if (a==0) {
					if (b!=0) {
						resultPane_2.setText("x = "+(-c/b)+".");
					} else if (c!=0) {
						resultPane_2.setText("NO SOLUTION!");
					} else {
						resultPane_2.setText("INFINITE SOLUTIONS!");
					}
				} else if (delt==0) {
					resultPane_2.setText("X1,2 = "+(-b/(2*a))+".");
				} else if (delt>0) {
					resultPane_2.setText("X1 = "+((-b+Math.sqrt(delt))/(2*a))
							+", X2 = "+((-b-Math.sqrt(delt))/(2*a))+".");
				} else {
					resultPane_2.setText("NO SOLUTION!");
				}
			}
		});
		
	}

}
