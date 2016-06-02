import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Thanks extends JFrame {

	private JPanel contentPane;
	private InputStream inputStream = null; 
	private String file = ""; 
	private AudioFormat format;
    private byte[] samples;
    private Clip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thanks frame = new Thanks();
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
	public Thanks() {
		
		setAlwaysOnTop(true);
		setResizable(false);
		this.setUndecorated(true);
		Point origin = new Point();
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					Thanks.this.dispose();
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
				Point p = Thanks.this.getLocation();
				Thanks.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
				
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(515, 287, 250, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ICon = new JLabel("");
		ICon.setIcon(new ImageIcon("DATA/PIC/LOGO.png"));
		ICon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Thanks sound =new Thanks("DATA/MUSIC/Michael Blake - What PI Sounds Like.wav");
				  InputStream stream =new ByteArrayInputStream(sound.getSamples());
				        // play the sound
				        sound.play(stream);
				        // exit
				        //System.exit(0);
			}
		});
		ICon.setHorizontalAlignment(SwingConstants.CENTER);
		ICon.setBounds(56, 17, 136, 115);
		contentPane.add(ICon);
		
		JLabel lblCopyright = new JLabel("(c) Copyright");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(6, 133, 238, 16);
		contentPane.add(lblCopyright);
		
		JLabel lblChu = new JLabel("Chu2+ contributors and others");
		lblChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChu.setBounds(6, 151, 238, 16);
		contentPane.add(lblChu);
		
		JButton btnMore = new JButton("More");
		btnMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s=btnMore.getText();
				Point p = Thanks.this.getLocation();
				if (s=="More") {
					setBounds(p.x, p.y, 250, 320);
					btnMore.setText("Back");
				}
				if (s=="Back") {
					setBounds(p.x, p.y, 250, 225);
					btnMore.setText("More");
				}
			}
		});
		btnMore.setBounds(80, 190, 80, 29);
		contentPane.add(btnMore);
		
		JLabel lblVersions = new JLabel("Version: Spark shadow (2.0)");
		lblVersions.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersions.setBounds(6, 169, 238, 16);
		contentPane.add(lblVersions);
		
		JLabel lblEcho = new JLabel("Echo");
		lblEcho.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcho.setBounds(6, 231, 238, 16);
		contentPane.add(lblEcho);
		
		JLabel lblElaineMaldiniVince = new JLabel("Elaine Maldini Vince");
		lblElaineMaldiniVince.setHorizontalAlignment(SwingConstants.CENTER);
		lblElaineMaldiniVince.setBounds(6, 249, 238, 16);
		contentPane.add(lblElaineMaldiniVince);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(6, 267, 238, 16);
		contentPane.add(lblMax);
		
		JLabel lblAndyNero = new JLabel("Andy Nero");
		lblAndyNero.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndyNero.setBounds(6, 285, 238, 16);
		contentPane.add(lblAndyNero);
	}
	

	
	
public Thanks(String filename) {
    try {
        // open the audio input stream
        AudioInputStream stream =AudioSystem.getAudioInputStream(new File(filename));
        format = stream.getFormat();
        // get the audio samples
        samples = getSamples(stream);
    }
    catch (UnsupportedAudioFileException ex) {
        ex.printStackTrace();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
}

public byte[] getSamples() {
    return samples;
}

 private byte[] getSamples(AudioInputStream audioStream) {
    // get the number of bytes to read
    int length = (int)(audioStream.getFrameLength() * format.getFrameSize());
    // read the entire stream
    byte[] samples = new byte[length];
    DataInputStream is = new DataInputStream(audioStream);
    try {
        is.readFully(samples);
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
    // return the samples
    return samples;
}

 public void play(InputStream source) {
    // use a short, 100ms (1/10th sec) buffer for real-time
    // change to the sound stream
    int bufferSize = format.getFrameSize() *
        Math.round(format.getSampleRate() / 10);
    byte[] buffer = new byte[bufferSize];
    // create a line to play to
    SourceDataLine line;
    try {
        DataLine.Info info =
            new DataLine.Info(SourceDataLine.class, format);
        line = (SourceDataLine)AudioSystem.getLine(info);
        line.open(format, bufferSize);
    }
    catch (LineUnavailableException ex) {
        ex.printStackTrace();
        return;
    }
    // start the line
    line.start();
    // copy data to the line
    try {
        int numBytesRead = 0;
        while (numBytesRead != -1) {
            numBytesRead =
                source.read(buffer, 0, buffer.length);
            if (numBytesRead != -1) {
               line.write(buffer, 0, numBytesRead);
            }
        }
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
    // wait until all data is played, then close the line
    line.drain();
    line.close();
}
}