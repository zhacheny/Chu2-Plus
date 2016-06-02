import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;


public class selectedIndex_1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectedIndex_1 frame = new selectedIndex_1();
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
	public selectedIndex_1() {
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					selectedIndex_1.this.dispose();
				}
			}//double click to close
			@Override
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = selectedIndex_1.this.getLocation();
				selectedIndex_1.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});//drag the frame
		this.setUndecorated(true);
		setType(Type.UTILITY);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Maldini's Calculas");
		//setBounds(100, 316, 375, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonSolve_1 = new JButton("Solve");
		buttonSolve_1.setBounds(294, 150, 75, 29);
		contentPane.add(buttonSolve_1);
		
		JLabel labelHint_1 = new JLabel("Enter the coefficient of the equation (group).");
		labelHint_1.setToolTipText("");
		labelHint_1.setBounds(6, 6, 292, 16);
		contentPane.add(labelHint_1);
		
		txtA = new JTextField();
		txtA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtA.setText("");
			}
		});
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText("a");
		txtA.setBackground(SystemColor.window);
		txtA.setBounds(6, 34, 29, 28);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtB.setText("");
			}
		});
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setText("b");
		txtB.setBackground(SystemColor.window);
		txtB.setColumns(10);
		txtB.setBounds(59, 34, 29, 28);
		contentPane.add(txtB);
		
		JLabel label_1_1 = new JLabel("x + ");
		label_1_1.setBounds(35, 40, 34, 16);
		contentPane.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("= 0");
		label_1_2.setBounds(92, 40, 34, 16);
		contentPane.add(label_1_2);
		
		JLabel labelClip = new JLabel("");
		labelClip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelClip.setBounds(6, 169, 232, 16);
		contentPane.add(labelClip);
		
		JTextPane resultPane_1 = new JTextPane();
		resultPane_1.setToolTipText("Click to copy.");
		resultPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=resultPane_1.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
					labelClip.setText("The result has been copied to Clipboard.");
				}
			}
		});
		resultPane_1.setEditable(false);
		resultPane_1.setBackground(SystemColor.window);
		resultPane_1.setBounds(17, 74, 352, 44);
		contentPane.add(resultPane_1);
		
		
		
		buttonSolve_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double a=Double.valueOf(txtA.getText());
				double b=Double.valueOf(txtB.getText());
				if (a!=0) {
					resultPane_1.setText("x = "+(-b/a)+".");
				} else if (b!=0) {
					resultPane_1.setText("NO SOLUTION!");
				} else {
					resultPane_1.setText("INFINITE SOLUTIONS!");
				}
			}
		});
	}
}
