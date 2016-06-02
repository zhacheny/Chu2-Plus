import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MyTime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTime frame = new MyTime();
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
	
	
	public MyTime() {
		
		this.setUndecorated(true);
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					MyTime.this.dispose();
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
				Point p = MyTime.this.getLocation();
				MyTime.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
				
			}
		});
		setBounds(970, 50, 280, 81);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Lucida Grande", Font.BOLD, 55));
		time.setBounds(6, 6, 268, 75);
		contentPane.add(time);
		
		SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
		Timer t=new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
			time.setText(format.format(new Date(System.currentTimeMillis())));
			}
			}, 0, 1000);
		}
	
	
}

