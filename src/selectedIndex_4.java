import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Window.Type;

import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class selectedIndex_4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtA_1;
	private JTextField txtA_2;
	private JTextField txtB_1;
	private JTextField txtB_2;
	private JTextField txtA_3;
	private JTextField txtB_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectedIndex_4 frame = new selectedIndex_4();
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
	public selectedIndex_4() {
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					selectedIndex_4.this.dispose();
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
				Point p = selectedIndex_4.this.getLocation();
				selectedIndex_4.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});
		this.setUndecorated(true);
		setTitle("Maldini's Calculas");
		setType(Type.UTILITY);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 316, 375, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHint_4 = new JLabel("Enter the coefficient of the equation (group).");
		labelHint_4.setBounds(6, 6, 292, 16);
		contentPane.add(labelHint_4);
		
		JButton buttonSolve_4 = new JButton("Solve");
		buttonSolve_4.setBounds(294, 190, 75, 29);
		contentPane.add(buttonSolve_4);
		
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
		
		JLabel label_4_1 = new JLabel("x1 + ");
		label_4_1.setBounds(35, 40, 34, 16);
		contentPane.add(label_4_1);
		
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
		txtA_2.setBounds(66, 34, 29, 28);
		contentPane.add(txtA_2);
		
		JLabel label_4_2 = new JLabel("x2 + ");
		label_4_2.setBounds(95, 40, 34, 16);
		contentPane.add(label_4_2);
		
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
		txtB_2.setBounds(66, 74, 29, 28);
		contentPane.add(txtB_2);
		
		JLabel label_4_3 = new JLabel("x1 + ");
		label_4_3.setBounds(35, 80, 34, 16);
		contentPane.add(label_4_3);
		
		JLabel label_4_4 = new JLabel("x2 + ");
		label_4_4.setBounds(95, 80, 34, 16);
		contentPane.add(label_4_4);
		
		JLabel labelClip = new JLabel("");
		labelClip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelClip.setBounds(6, 209, 232, 16);
		contentPane.add(labelClip);
		
		JTextPane resultPane_4 = new JTextPane();
		resultPane_4.setToolTipText("Click to copy.");
		resultPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=resultPane_4.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
					labelClip.setText("The result has been copied to Clipboard.");
				}
			}
		});
		resultPane_4.setEditable(false);
		resultPane_4.setBackground(SystemColor.window);
		resultPane_4.setBounds(17, 114, 352, 44);
		contentPane.add(resultPane_4);
		
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
		
		JLabel label_4_5 = new JLabel("= 0");
		label_4_5.setBounds(156, 40, 34, 16);
		contentPane.add(label_4_5);
		
		JLabel label_4_6 = new JLabel("= 0");
		label_4_6.setBounds(156, 80, 34, 16);
		contentPane.add(label_4_6);
		
		buttonSolve_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double a1=Double.valueOf(txtA_1.getText());
				double a2=Double.valueOf(txtA_2.getText());
				double a3=Double.valueOf(txtA_3.getText());
				double b1=Double.valueOf(txtB_1.getText());
				double b2=Double.valueOf(txtB_2.getText());
				double b3=Double.valueOf(txtB_3.getText());
				
				if (a1*b2!=a2*b1) {
					resultPane_4.setText("x1 = " +
				-(a3*b2-a2*b3)/(a1*b2-a2*b1) +", x2 = "+ (a3*b1-a1*b3)/(a1*b2-a2*b1) + ".");
				} else if (a1*b3!=a3*b1) {
					resultPane_4.setText("NO SOLUTION!");
				} else {
					resultPane_4.setText("INFINITE SOLUTIONS!");
				}
				
			}
		});
		
		
		
	}
}
