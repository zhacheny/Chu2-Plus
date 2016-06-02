import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JToolBar;
import javax.swing.JTextPane;

public class Gallery extends JFrame {

	//protected static final Component frame = null;
	private JPanel contentPane;
	private JLabel label;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gallery frame = new Gallery();
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
	public Gallery() {
		/*addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getModifiersEx()==e.ALT_DOWN_MASK+e.CTRL_DOWN_MASK) {
					List frame = new List();
					frame.setVisible(true);
					}
			}
		});*/
		
		this.setUndecorated(true);
		Point origin = new Point();
		

		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JLabel LabelColor = new JLabel("RGB(238, 238, 238)");
		LabelColor.setForeground(Color.BLACK);
		LabelColor.setBackground(SystemColor.window);
		LabelColor.setBounds(102, 0, 145, 16);
		contentPane.add(LabelColor);
		
		JLabel LabelColorW = new JLabel("RGB(238, 238, 238)");
		LabelColorW.setForeground(Color.WHITE);
		LabelColorW.setBackground(SystemColor.window);
		LabelColorW.setBounds(102, 16, 145, 16);
		contentPane.add(LabelColorW);
		
		JLabel LabelPointW = new JLabel("(0, 0)");
		LabelPointW.setForeground(Color.WHITE);
		LabelPointW.setBackground(SystemColor.window);
		LabelPointW.setBounds(0, 16, 90, 16);
		contentPane.add(LabelPointW);

		
		final JLabel picLabel = new JLabel("");
		
		
		picLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = Gallery.this.getLocation();
				Gallery.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});
		picLabel.setInheritsPopupMenu(false);
		picLabel.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
			
			public void mouseClicked(MouseEvent arg0) {
				if((arg0.getClickCount()==1)&&(arg0.getModifiersEx()==arg0.ALT_DOWN_MASK)) {
					Gallery.this.dispose();
				}
				if(arg0.getClickCount()==2) {
					
					String url = "";
				
				JFileChooser jfc = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Picture Files(*.jpg/*.gif/*.bmp/*.png)","jpg","jpeg","gif","bmp","png");
				jfc.setFileFilter(filter);
			    if(jfc.showOpenDialog(Gallery.this)==JFileChooser.APPROVE_OPTION ){
			    	Image src = null;
			    	url = jfc.getSelectedFile().getAbsolutePath();
			    	File _file = new File(url); 
					try {
						
						src = javax.imageio.ImageIO.read(_file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}  
			    picLabel.setIcon(new ImageIcon(url));
			    picLabel.resize(src.getWidth(null),src.getHeight(null));
			    Gallery.this.resize(src.getWidth(null),src.getHeight(null));
			    //BufferedImage bi=getImg(url);
			    
			   // System.out.println(url);
			    label.setText(url);
			}
				}
				
			    }
		});
		
		JLabel LabelPoint = new JLabel("(0, 0)");
		LabelPoint.setForeground(Color.BLACK);
		LabelPoint.setBackground(SystemColor.window);
		picLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1) {
					String url=label.getText();
					Point p=e.getPoint();
					if (url!="") {
						int pixel=getImg(url).getRGB(p.x,p.y );
						LabelPoint.setText("("+p.x+", "+p.y+")");
						LabelColor.setText("RGB("+
						((pixel & 0xff0000 ) >> 16)+", "+((pixel & 0xff00 ) >> 8)+", "+(pixel & 0xff )+")");
						LabelPointW.setText("("+p.x+", "+p.y+")");
						LabelColorW.setText("RGB("+
						((pixel & 0xff0000 ) >> 16)+", "+((pixel & 0xff00 ) >> 8)+", "+(pixel & 0xff )+")");
						System.out.println(pixel);
					}	
				}
			}
		});
		LabelPoint.setBounds(0, 0, 90, 16);
		contentPane.add(LabelPoint);
		
		
		
		picLabel.setIcon(new ImageIcon(""));
		picLabel.setBounds(0, 0, 300, 400);
		contentPane.add(picLabel);
		
		
		
		
		
		
		
			}
	
	
	public BufferedImage getImg(String url) {
	       
	        	BufferedImage bi = null;
		        File _file = new File(url);
		        try {
		            bi = ImageIO.read(_file);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return bi;
	        
			
		 
	    }
}

