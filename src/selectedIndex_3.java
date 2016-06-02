import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Window.Type;


public class selectedIndex_3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectedIndex_3 frame = new selectedIndex_3();
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
	public selectedIndex_3() {
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					selectedIndex_3.this.dispose();
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
				Point p = selectedIndex_3.this.getLocation();
				selectedIndex_3.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
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
		
		JLabel labelHint_3 = new JLabel("Enter the coefficient of the equation (group).");
		labelHint_3.setBounds(6, 6, 292, 16);
		contentPane.add(labelHint_3);
		
		JButton buttonSolve_3 = new JButton("Solve");
		buttonSolve_3.setBounds(294, 150, 75, 29);
		contentPane.add(buttonSolve_3);
		
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
		txtB.setBounds(75, 34, 29, 28);
		contentPane.add(txtB);
		
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
		txtC.setBounds(146, 34, 29, 28);
		contentPane.add(txtC);
		
		txtD = new JTextField();
		txtD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtD.setText("");
			}
		});
		txtD.setText("d");
		txtD.setHorizontalAlignment(SwingConstants.CENTER);
		txtD.setColumns(10);
		txtD.setBackground(SystemColor.window);
		txtD.setBounds(198, 34, 29, 28);
		contentPane.add(txtD);
		
		JLabel label_3_1 = new JLabel("x^3 + ");
		label_3_1.setBounds(36, 40, 42, 16);
		contentPane.add(label_3_1);
		
		JLabel label_3_2 = new JLabel("x^2 + ");
		label_3_2.setBounds(105, 40, 42, 16);
		contentPane.add(label_3_2);
		
		JLabel label_3_3 = new JLabel("x + ");
		label_3_3.setBounds(175, 40, 42, 16);
		contentPane.add(label_3_3);
		
		JLabel label_3_4 = new JLabel("= 0");
		label_3_4.setBounds(229, 40, 29, 16);
		contentPane.add(label_3_4);
		
		JLabel labelClip = new JLabel("");
		labelClip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelClip.setBounds(6, 169, 232, 16);
		contentPane.add(labelClip);
		
		JTextPane resultPane_3 = new JTextPane();
		resultPane_3.setToolTipText("Click to copy.");
		resultPane_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=resultPane_3.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
					labelClip.setText("The result has been copied to Clipboard.");
				}
			}
		});
		resultPane_3.setEditable(false);
		resultPane_3.setBackground(SystemColor.window);
		resultPane_3.setBounds(17, 74, 352, 44);
		contentPane.add(resultPane_3);
		
		buttonSolve_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double a=Double.valueOf(txtA.getText());
				double b=Double.valueOf(txtB.getText());
				double c=Double.valueOf(txtC.getText());
				double d=Double.valueOf(txtD.getText());
				
				double A=b*b-3*a*c;
				double B=b*c-9*a*d;
				double C=c*c-3*b*d;
				double DELT=B*B-4*A*C;
				
				
				if (a==0) {
					double delt=c*c-4*b*d;
					if (b==0) {
						if (c!=0) {
							resultPane_3.setText("x = "+(-d/c)+".");
						} else if (d!=0) {
							resultPane_3.setText("NO SOLUTION!");
						} else {
							resultPane_3.setText("INFINITE SOLUTIONS!");
						}
					} else if (delt==0) {
						resultPane_3.setText("x1,2 = "+(-c/(2*b))+".");
					} else if (delt>0) {
						resultPane_3.setText("x1 = "+ (-c+Math.sqrt(delt))/(2*b)
								+ ", x2 = " + (-c-Math.sqrt(delt))/(2*b)+ ".");
					} else {
						resultPane_3.setText("NO SOLUTION!");
					}
				} else if (A==0&&B==0) {
					resultPane_3.setText("x = "+ -c/b + ".");
				} else if (DELT>0) {
					double Y1=A*b+3*a*((-B+Math.sqrt(DELT)/2));
					double Y2=A*b+3*a*((-B-Math.sqrt(DELT)/2));
					
					resultPane_3.setText("x = "
				+ ((-b-(Math.pow(Y1,1/3)+Math.pow(Y2, 1/3)))/(3*a)) + ".");
				} else if (DELT==0) {
					double K=B/A;
					
					resultPane_3.setText("x1 = "+ (-a/b+K) +", x2,3 = "+-K/2 +".");
				} else {
					double T=(2*A*b-3*a*B)/(2*Math.sqrt(A*A*A));
					double theta=Math.acos(T);
					
					resultPane_3.setText("x1 = " +
					(-b-2*Math.sqrt(A)*Math.cos(theta/3))/(3*a) + ", x2 = "+ 
					(-b+Math.sqrt(A)*((Math.cos(theta/3)+Math.sqrt(3)*Math.sin(theta/3))))/(3*a)+ ", x3 = "+
					(-b+Math.sqrt(A)*((Math.cos(theta/3)-Math.sqrt(3)*Math.sin(theta/3))))/(3*a)+ ".");
				}
			}
		});
	}

}
