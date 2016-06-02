
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI_Main extends JFrame {

	private JPanel contentmainPane;
	private JFrame clockframe;
	private JFrame Equationframe;
	private JFrame tonyframe;
	private JLabel clocklabel;
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Main frame = new GUI_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

		public GUI_Main() {
			this.setUndecorated(true);
			//setIconImage(Toolkit.getDefaultToolkit().getImage("DATA/ICONS/info.png"));
			
		setResizable(false);
		setForeground(new Color(139, 0, 0));
		setFont(new Font("Abril Fatface", Font.PLAIN, 12));
		setTitle("Chu - 2");
		setBackground(SystemColor.window);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 50, 76, 559);
		contentmainPane = new JPanel();
		contentmainPane.setBorder(null);
		setContentPane(contentmainPane);
		contentmainPane.setLayout(null);
		contentmainPane.setBackground(SystemColor.window);
		
		JButton ButtonCal = new JButton("");
		ButtonCal.setToolTipText("<html><p>Calculus</p><p>DOUBLE CLICK TO EXIT.</p></html>");
		
		ButtonCal.setBackground(new Color(169, 169, 169));
		ButtonCal.setForeground(Color.BLACK);
		ButtonCal.setIcon(new ImageIcon("DATA/PIC/Maldini's Calculus.png"));
		ButtonCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculus frame = new Calculus();
				frame.setVisible(true);
			}
			
		});
		ButtonCal.setBounds(6, 6, 64, 64);
		ButtonCal.setOpaque(false);
		ButtonCal.setContentAreaFilled(false);
		ButtonCal.setBorder(null);
		contentmainPane.add(ButtonCal);
		
		JButton ButtonClo = new JButton("");
		ButtonClo.setToolTipText("<html><p>Time</p><p>DOUBLE CLICK TO EXIT.</p></html>");
		
		ButtonClo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyTime frame = new MyTime();
				frame.setVisible(true);
			}});
		ButtonClo.setBackground(new Color(169, 169, 169));
		ButtonClo.setIcon(new ImageIcon("DATA/PIC/clock.png"));
		ButtonClo.setBounds(6, 75, 64, 64);
		ButtonClo.setOpaque(false);
		ButtonClo.setContentAreaFilled(false);
		ButtonClo.setBorder(null);
		contentmainPane.add(ButtonClo);
		
		JButton ButtonExc = new JButton("");
		ButtonExc.setToolTipText("<html><p>Exchange Rate</p><p>DOUBLE CLICK TO EXIT.</p.");
		ButtonExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExchangeRate frame = new ExchangeRate();
			     frame.setVisible(true);
			}
		});
		ButtonExc.setBackground(new Color(169, 169, 169));
		ButtonExc.setIcon(new ImageIcon("DATA/PIC/Exchange Rate.png"));
		ButtonExc.setBounds(6, 144, 64, 64);
		ButtonExc.setOpaque(false);
		ButtonExc.setContentAreaFilled(false);
		ButtonExc.setBorder(null);
		contentmainPane.add(ButtonExc);
		
		JButton ButtonMof = new JButton("");
		ButtonMof.setToolTipText("<html><p>Catch Fish</p><p>PUT MOUSE ON THE FRAME TO START.</p><p>DOUBLE CLICK TO EXIT.</p></html>");
		ButtonMof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mo_fish();
			}
		});
		ButtonMof.setBackground(new Color(169, 169, 169));
		ButtonMof.setIcon(new ImageIcon("DATA/PIC/Catch Fish.png"));
		ButtonMof.setBounds(6, 213, 64, 64);
		ButtonMof.setOpaque(false);
		ButtonMof.setContentAreaFilled(false);
		ButtonMof.setBorder(null);
		contentmainPane.add(ButtonMof);
		
		JButton ButtonNot = new JButton("");
		ButtonNot.setToolTipText("<html><p>Notepad</p><p>DOUBLE CLICK ON THE COUNT BAR TO EXIT.</p></html>");
		ButtonNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotePad frame = new NotePad();
				frame.setVisible(true);
			}
		});
		ButtonNot.setBackground(new Color(169, 169, 169));
		ButtonNot.setIcon(new ImageIcon("DATA/PIC/NotePad.png"));
		ButtonNot.setBounds(6, 282, 64, 64);
		ButtonNot.setOpaque(false);
		ButtonNot.setContentAreaFilled(false);
		ButtonNot.setBorder(null);
		contentmainPane.add(ButtonNot);
		
		JButton ButtonChu = new JButton("");
		ButtonChu.setToolTipText("<html><p>Thanks</p><p>CLICK ON THE ICON TO PLAY MUSIC.</p><p>DOUBLE CLICK TO EXIT.</p></html>");
		ButtonChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thanks frame = new Thanks();
				frame.setVisible(true);
			}
		});
		ButtonChu.setBackground(new Color(169, 169, 169));
		ButtonChu.setIcon(new ImageIcon("DATA/PIC/info.png"));
		ButtonChu.setBounds(6, 351, 64, 64);
		ButtonChu.setOpaque(false);
		ButtonChu.setContentAreaFilled(false);
		ButtonChu.setBorder(null);
		contentmainPane.add(ButtonChu);
		
		JButton ButtonExt = new JButton("");
		ButtonExt.setToolTipText("Exit");
		ButtonExt.setIcon(new ImageIcon("DATA/PIC/Exit.png"));
		ButtonExt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		ButtonExt.setBackground(new Color(169, 169, 169));
		ButtonExt.setBounds(6, 489, 64, 64);
		ButtonExt.setOpaque(false);
		ButtonExt.setContentAreaFilled(false);
		ButtonExt.setBorder(null);
		contentmainPane.add(ButtonExt);
		
		JButton ButtonGal = new JButton("");
		ButtonGal.setToolTipText("<html><p>Gallery</p><p>DOUBLE CLICK TO OPEN THE FILE.</p><p>SINGLE CLICK TO GET THE POSITION.</p><p>PRESS ALT AND CLICK TO EXIT.</p></html>");
		ButtonGal.setIcon(new ImageIcon("DATA/PIC/Gallery.png"));
		ButtonGal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gallery frame = new Gallery();
				frame.setVisible(true);
			}
		});
		ButtonGal.setBackground(new Color(169, 169, 169));
		ButtonGal.setBounds(6, 420, 64, 64);
		ButtonGal.setOpaque(false);
		ButtonGal.setContentAreaFilled(false);
		ButtonGal.setBorder(null);
		contentmainPane.add(ButtonGal);
		
		
		
		
		}
}