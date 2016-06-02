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


public class selectedIndex_5 extends JFrame {

	private JPanel contentPane;
	private JTextField txtA_1;
	private JTextField txtB_1;
	private JTextField txtC_1;
	private JTextField txtA_2;
	private JTextField txtB_2;
	private JTextField txtC_2;
	private JTextField txtA_3;
	private JTextField txtB_3;
	private JTextField txtC_3;
	private JTextField txtA_4;
	private JTextField txtB_4;
	private JTextField txtC_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectedIndex_5 frame = new selectedIndex_5();
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
	public selectedIndex_5() {
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					selectedIndex_5.this.dispose();
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
				Point p = selectedIndex_5.this.getLocation();
				selectedIndex_5.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});
		this.setUndecorated(true);
		setTitle("Maldini's Calculas");
		setType(Type.UTILITY);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 316, 375, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Enter the coefficient of the equation (group).");
		label.setBounds(6, 6, 292, 16);
		contentPane.add(label);
		
		txtA_1 = new JTextField();
		txtA_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA_1.setText("");
			}
		});
		txtA_1.setText("a1");
		txtA_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtA_1.setColumns(10);
		txtA_1.setBackground(SystemColor.window);
		txtA_1.setBounds(6, 34, 29, 28);
		contentPane.add(txtA_1);
		
		txtB_1 = new JTextField();
		txtB_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB_1.setText("");
			}
		});
		txtB_1.setText("b1");
		txtB_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtB_1.setColumns(10);
		txtB_1.setBackground(SystemColor.window);
		txtB_1.setBounds(6, 74, 29, 28);
		contentPane.add(txtB_1);
		
		txtC_1 = new JTextField();
		txtC_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtC_1.setText("");
			}
		});
		txtC_1.setText("c1");
		txtC_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtC_1.setColumns(10);
		txtC_1.setBackground(SystemColor.window);
		txtC_1.setBounds(6, 114, 29, 28);
		contentPane.add(txtC_1);
		
		JLabel label_5_1 = new JLabel("x1 + ");
		label_5_1.setBounds(35, 40, 34, 16);
		contentPane.add(label_5_1);
		
		JLabel label_5_5 = new JLabel("x1 + ");
		label_5_5.setBounds(35, 80, 34, 16);
		contentPane.add(label_5_5);
		
		JLabel label_5_9 = new JLabel("x1 + ");
		label_5_9.setBounds(35, 120, 34, 16);
		contentPane.add(label_5_9);
		
		txtA_2 = new JTextField();
		txtA_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA_2.setText("");
			}
		});
		txtA_2.setText("a2");
		txtA_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtA_2.setColumns(10);
		txtA_2.setBackground(SystemColor.window);
		txtA_2.setBounds(67, 34, 29, 28);
		contentPane.add(txtA_2);
		
		txtB_2 = new JTextField();
		txtB_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB_2.setText("");
			}
		});
		txtB_2.setText("b2");
		txtB_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtB_2.setColumns(10);
		txtB_2.setBackground(SystemColor.window);
		txtB_2.setBounds(67, 74, 29, 28);
		contentPane.add(txtB_2);
		
		txtC_2 = new JTextField();
		txtC_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtC_2.setText("");
			}
		});
		txtC_2.setText("c2");
		txtC_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtC_2.setColumns(10);
		txtC_2.setBackground(SystemColor.window);
		txtC_2.setBounds(67, 114, 29, 28);
		contentPane.add(txtC_2);
		
		JLabel label_5_2 = new JLabel("x2 + ");
		label_5_2.setBounds(95, 40, 34, 16);
		contentPane.add(label_5_2);
		
		JLabel label_5_6 = new JLabel("x2 + ");
		label_5_6.setBounds(95, 80, 34, 16);
		contentPane.add(label_5_6);
		
		JLabel label_5_10 = new JLabel("x2 + ");
		label_5_10.setBounds(95, 120, 34, 16);
		contentPane.add(label_5_10);
		
		txtA_3 = new JTextField();
		txtA_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA_3.setText("");
			}
		});
		txtA_3.setText("a3");
		txtA_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtA_3.setColumns(10);
		txtA_3.setBackground(SystemColor.window);
		txtA_3.setBounds(127, 34, 29, 28);
		contentPane.add(txtA_3);
		
		txtB_3 = new JTextField();
		txtB_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB_3.setText("");
			}
		});
		txtB_3.setText("b3");
		txtB_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtB_3.setColumns(10);
		txtB_3.setBackground(SystemColor.window);
		txtB_3.setBounds(127, 74, 29, 28);
		contentPane.add(txtB_3);
		
		txtC_3 = new JTextField();
		txtC_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtC_3.setText("");
			}
		});
		txtC_3.setText("c3");
		txtC_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtC_3.setColumns(10);
		txtC_3.setBackground(SystemColor.window);
		txtC_3.setBounds(127, 114, 29, 28);
		contentPane.add(txtC_3);
		
		JLabel lblX = new JLabel("x3 + ");
		lblX.setBounds(155, 40, 34, 16);
		contentPane.add(lblX);
		
		JLabel lblX_1 = new JLabel("x3 + ");
		lblX_1.setBounds(155, 80, 34, 16);
		contentPane.add(lblX_1);
		
		JLabel lblX_2 = new JLabel("x3 + ");
		lblX_2.setBounds(155, 120, 34, 16);
		contentPane.add(lblX_2);
		
		txtA_4 = new JTextField();
		txtA_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA_4.setText("");
			}
		});
		txtA_4.setText("a4");
		txtA_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtA_4.setColumns(10);
		txtA_4.setBackground(SystemColor.window);
		txtA_4.setBounds(187, 34, 29, 28);
		contentPane.add(txtA_4);
		
		txtB_4 = new JTextField();
		txtB_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB_4.setText("");
			}
		});
		txtB_4.setText("b4");
		txtB_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtB_4.setColumns(10);
		txtB_4.setBackground(SystemColor.window);
		txtB_4.setBounds(187, 74, 29, 28);
		contentPane.add(txtB_4);
		
		txtC_4 = new JTextField();
		txtC_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtC_4.setText("");
			}
		});
		txtC_4.setText("c4");
		txtC_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtC_4.setColumns(10);
		txtC_4.setBackground(SystemColor.window);
		txtC_4.setBounds(187, 114, 29, 28);
		contentPane.add(txtC_4);
		
		JLabel label_5_4 = new JLabel("= 0");
		label_5_4.setBounds(216, 40, 34, 16);
		contentPane.add(label_5_4);
		
		JLabel label_5_8 = new JLabel("= 0");
		label_5_8.setBounds(216, 80, 34, 16);
		contentPane.add(label_5_8);
		
		JLabel label_5_12 = new JLabel("= 0");
		label_5_12.setBounds(216, 120, 34, 16);
		contentPane.add(label_5_12);
		
		JLabel labelClip = new JLabel("");
		labelClip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelClip.setBounds(6, 249, 232, 16);
		contentPane.add(labelClip);
		
		JTextPane resultPane_5 = new JTextPane();
		resultPane_5.setToolTipText("Click to copy.");
		resultPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=resultPane_5.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
					labelClip.setText("The result has been copied to Clipboard.");
				}
			}
		});
		resultPane_5.setEditable(false);
		resultPane_5.setBackground(SystemColor.window);
		resultPane_5.setBounds(16, 154, 352, 44);
		contentPane.add(resultPane_5);
		
		JButton buttonSolve_5 = new JButton("Solve");
		buttonSolve_5.setBounds(293, 230, 75, 29);
		contentPane.add(buttonSolve_5);
		
		buttonSolve_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double a1=Double.valueOf(txtA_1.getText());
				double a2=Double.valueOf(txtA_2.getText());
				double a3=Double.valueOf(txtA_3.getText());
				double a4=Double.valueOf(txtA_4.getText());
				double b1=Double.valueOf(txtB_1.getText());
				double b2=Double.valueOf(txtB_2.getText());
				double b3=Double.valueOf(txtB_3.getText());
				double b4=Double.valueOf(txtB_4.getText());
				double c1=Double.valueOf(txtC_1.getText());
				double c2=Double.valueOf(txtC_2.getText());
				double c3=Double.valueOf(txtC_3.getText());
				double c4=Double.valueOf(txtC_4.getText());
				
				double modA=a1*b2*c3+b1*c2*a3+c1*a2*b3-(a3*b2*c1+b3*c2*a1+c3*a2*b1);
				double ele1=a2*b3*c4+b2*c3*a4+c2*a3*b4-(a4*b3*c2+b4*c3*a2+c4*a3*b2);
				double ele2=a1*b4*c3+b1*c4*a3+c1*a4*b3-(a4*b1*c3+b4*c1*a3+c4*a1*b3);
				double ele3=a4*b1*c2+b4*c1*a2+c4*b2*a1-(a4*c1*b2+b4*a1*c2+c4*a2*b1);
				if (modA!=0) {
					resultPane_5.setText("x1 = " + -ele1/modA
							+ ", x2 = " + -ele2/modA + ", x3 = " + -ele3/modA + ".");
				} else if ((ele1==0)&&(ele2==0)&&(ele3==0)) {
					resultPane_5.setText("INFINITE SOLUTIONS!");
				} else {
					resultPane_5.setText("NO SOLUTION!"); 
				}
			}
		});
		
	}

}
