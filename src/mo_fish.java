
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class mo_fish extends JFrame {
	
	
	Date now = new Date();
	Date now4 = new Date();
	private final JLabel lbl1_1 = new JLabel("00");
	private final JLabel lbl1_2 = new JLabel("00");
	private final JLabel lbl1_3 = new JLabel("00");
	private final JLabel lbl2_1 = new JLabel("00");
	private final JLabel lbl2_2 = new JLabel("00");
	private final JLabel lbl2_3 = new JLabel("00");
	private final JLabel tip = new JLabel("The timers haven't begin.");

	public mo_fish() {
		
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		setResizable(false);
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		now4.setHours(0);
		now4.setMinutes(0);
		now4.setSeconds(0);
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					mo_fish.this.dispose();
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
				Point p = mo_fish.this.getLocation();
				mo_fish.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
				
			}
		});
		
		this.setBounds(1000, 140,250,143);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		
		lbl1_1.setVerticalAlignment(SwingConstants.TOP);
		lbl1_1.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl1_1.setBounds(6, 0, 73, 73);
		
		getContentPane().add(lbl1_1);
		
		lbl1_2.setVerticalAlignment(SwingConstants.TOP);
		lbl1_2.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl1_2.setBounds(91, 0, 73, 73);
		
		getContentPane().add(lbl1_2);
		
		lbl1_3.setVerticalAlignment(SwingConstants.TOP);
		lbl1_3.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl1_3.setBounds(176, 0, 73, 73);
		
		getContentPane().add(lbl1_3);
		
		lbl2_1.setVerticalAlignment(SwingConstants.TOP);
		lbl2_1.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl2_1.setBounds(6, 67, 73, 73);
		
		getContentPane().add(lbl2_1);
		lbl2_2.setVerticalAlignment(SwingConstants.TOP);
		lbl2_2.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl2_2.setBounds(91, 67, 73, 73);
		
		getContentPane().add(lbl2_2);
		
		lbl2_3.setVerticalAlignment(SwingConstants.TOP);
		lbl2_3.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lbl2_3.setBounds(176, 67, 73, 73);
		
		getContentPane().add(lbl2_3);
		tip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tip.setBounds(6, 124, 238, 16);
		
		getContentPane().add(tip);

		//this.setSize(700, 300);
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		myEvent();
	}

	public void myEvent() {
		
		
		this.addMouseListener(new MouseListener() {
			Timer timer = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date now42 = new Date(now4.getTime() + 140);
					now4 = now42;
					SimpleDateFormat formatter1_1 = new SimpleDateFormat("HH");
					SimpleDateFormat formatter1_2 = new SimpleDateFormat("mm");
					SimpleDateFormat formatter1_3 = new SimpleDateFormat("ss");
					
					//lbl2.setFont(new Font("????",Font.ITALIC,65));
					lbl1_1.setText(formatter1_1.format(now4));
					lbl1_2.setText(formatter1_2.format(now4));
					lbl1_3.setText(formatter1_3.format(now4));
					
					//lbl.setForeground(Color.gray);
				}
			});
			
			Timer timer2 = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date now3 = new Date(now.getTime() + 140);
					now = now3;
					SimpleDateFormat formatter2_1 = new SimpleDateFormat("HH");
					SimpleDateFormat formatter2_2 = new SimpleDateFormat("mm");
					SimpleDateFormat formatter2_3 = new SimpleDateFormat("ss");
					
					//lbl2.setFont(new Font("????",Font.ITALIC,65));
					lbl2_1.setText(formatter2_1.format(now));
					lbl2_2.setText(formatter2_2.format(now));
					lbl2_3.setText(formatter2_3.format(now));
					
					//lbl3.setForeground(Color.gray);
				}
			});
			
			
			
			public void mouseClicked(MouseEvent e) {
				
			}

			
			public void mousePressed(MouseEvent e) {
				
			}

			
			public void mouseReleased(MouseEvent e) {
				
			}

			
			public void mouseEntered(MouseEvent e) {
				//lbl2.setText("<html><bChicken Blood</body></html>");
				//lbl2.setVerticalAlignment(SwingConstants.TOP);
				//lbl2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
				tip.setText("You are in Chicken Blood Mode.");
				timer2.stop();
				timer.start();
				
				return;
			}

			
			public void mouseExited(MouseEvent e) {
				
				//lbl2.setText("<html><body>Catch Fish</body></html>");
				//lbl2.setVerticalAlignment(SwingConstants.TOP);
				//lbl2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
				tip.setText("You are cathing fish.");
				timer.stop();
				timer2.start();
				
				return;
			}
			
		});
	}
	public static void main(String[] args) {
		mo_fish t = new mo_fish();
	}
}