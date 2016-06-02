import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



@SuppressWarnings("serial")
public class NotePad extends JFrame {
 
	private JPanel contentPane;
	private Clipboard clipboard;
	private JTextField txtWords;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					NotePad frame = new NotePad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame
	
	public NotePad() {
		
		
		this.setUndecorated(true);
		//AWTUtilities.setWindowOpaque(this, false);
		setTitle("Notepad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 450, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);        //automatically space 
		textArea.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textArea);//scrollpanel
		scroll.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		contentPane.add(scroll);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		
		//Clear function
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setVerticalAlignment(SwingConstants.TOP);
		toolBar.add(btnClear);
		btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		//Copy function
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clipboard clipboard=getToolkit().getSystemClipboard();
				String str=textArea.getText();
				StringSelection text=new StringSelection(str);
				if (str=="") {
					
				} else {
					clipboard.setContents(text, null);
				}
			
			}
		});
		btnCopy.setVerticalAlignment(SwingConstants.TOP);
		toolBar.add(btnCopy);
		btnCopy.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		
		//Paste function
		JButton btnPaste = new JButton("Paste");
				btnPaste.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						   Transferable contents=clipboard.getContents(this); 
						    if(contents!=null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) { 
						     try{
						      String string= (String) contents.getTransferData(DataFlavor.stringFlavor); 
						      //textArea.setText("");
						      textArea.append(string); 
						     }catch (Exception ex){
						      ex.printStackTrace(); 
						     }
						   }
						  }
				});
		btnPaste.setVerticalAlignment(SwingConstants.TOP);
		toolBar.add(btnPaste);
		btnPaste.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		//import txt function
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "";
				
				JFileChooser jfc = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","TXT");
				jfc.setFileFilter(filter);
			    if(jfc.showOpenDialog(NotePad.this)==JFileChooser.APPROVE_OPTION ){
			    	url = jfc.getSelectedFile().getAbsolutePath();
			    }
			    
				/*String url = JOptionPane.showInputDialog(null,
								"Enter the file's url (Such like /Users/caolineng/Desktop): ",
								"URL",
								JOptionPane.QUESTION_MESSAGE) ;*/
				
				new LinkedList<String>(); 
				java.io.File file = new java.io.File(url);
				try {
					
					Scanner input = new Scanner(file);
					String str = "";
					while(input.hasNext()==true){
						str += input.nextLine() + "\n";
						}
					
					textArea.setText(str);
					input.close();
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnImport.setVerticalAlignment(SwingConstants.TOP);
		btnImport.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		toolBar.add(btnImport);
		
		//export txt function
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "";
				
				JFileChooser jfc = new JFileChooser();
				
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jfc.setDialogType(JFileChooser.SAVE_DIALOG);
				jfc.setApproveButtonText("Save");
				
				if(jfc.showSaveDialog(NotePad.this)==JFileChooser.APPROVE_OPTION ){
					url = jfc.getSelectedFile().getAbsolutePath();
				
					/*String url = JOptionPane.showInputDialog(null,
										"Enter the url (Such like /Users/caolineng/Desktop): ",
										"URL",
										JOptionPane.QUESTION_MESSAGE) ;*/
					new LinkedList<String>(); 
					java.io.File file = new java.io.File(url);
					if (file.exists()) {
						int copy = JOptionPane.showConfirmDialog(null,"Do you want to replace your txt file?", "sure", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (copy == JOptionPane.YES_OPTION){
							try {
								java.io.PrintWriter output = new java.io.PrintWriter(file);
								StringBuffer sb = new StringBuffer();
								sb.append(textArea.getText());
																	
								Scanner input = new Scanner(sb.toString());
								String str = "";
								while(input.hasNext()==true){
									str += input.nextLine() + "\n";
								}
								//java.io.PrintWriter output = new java.io.PrintWriter(file);
								output.print(str);
								output.close();
							}catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}else{System.exit(0);
						}
					}else{
						try {
							java.io.PrintWriter output = new java.io.PrintWriter(file);
							StringBuffer sb = new StringBuffer();
							sb.append(textArea.getText());
															
							Scanner input = new Scanner(sb.toString());
							String str = "";
							while(input.hasNext()==true){
							str += input.nextLine() + "\n";
						}
						//java.io.PrintWriter output = new java.io.PrintWriter(file);
						output.print(str);
						output.close();
						}catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						}
						//or FileOutputStream fos = new FileOutputStream(new File("\\\\192.168.0.2\\a.txt"));
				}		
			
				}
		});
		btnExport.setVerticalAlignment(SwingConstants.TOP);
		btnExport.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		toolBar.add(btnExport);
		
		//search
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StringBuffer sb = new StringBuffer();
				sb.append(textArea.getText());
				
				String searchWords =
				JOptionPane.showInputDialog(null,
				"Enter the words: ",
				"Search",
				JOptionPane.QUESTION_MESSAGE);
				
				int x = sb.toString().length();
				int z = searchWords.length();
				String newsb = sb.toString().replaceAll(searchWords, "");
				int y = newsb.length();
				int times = (x - y)/z;
				
				/*Map<String,Integer> map = new HashMap<String, Integer>();
				StringTokenizer st = new
				
				StringTokenizer(sb.toString(),",.! \n");
				while (st.hasMoreTokens()) {
	                 String letter = st.nextToken();
	                 int count, count2;
	                 count2 = 0;
	                 if (map.get(letter) == null) {
	                     count = 1;
	                 } else {
	                     count = map.get(letter).intValue() + 1;
	                 }
	                 map.put(letter,count);
	             }
				
				Set<WordEntity> set = new TreeSet<WordEntity>();
	             for (String key : map.keySet()) {
	                 set.add(new WordEntity(key,map.get(key)));
	             }
	            
	             
				
				/*String []strs = sb.toString().replace(", ", "\n").replace(". ", "\n").replace(" ", "\n").replace("  ", "\n").replace("   ", "\n").replace("\n\n", "\n").replace("\n\n\n", "\n").replace("\n\n\n\n", "\n").split("\n");//replace all to space
				
				for (int i = 0; i < strs.length; i++) {
	  				if (strs[i] == searchWords)
	  				{
	  					count += 1;
	  				}
	  				System.out.println(i+":\t"+strs[i]);
	  				}
  				
				
	             int times = 0;
				
	             for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
	                 WordEntity w = it.next();
	                 if (w.getKey() == searchWords){
	                	 times = w.getCount();
	                	}
	                 System.out.println("单词:" + w.getKey() + " 出现的次数为： " + w.getCount());
	               
	                 
	             }*/	
  				JOptionPane.showMessageDialog(null,
	             				"Matches " + searchWords + " " + times +" times",
	             				"Result",
	             				JOptionPane.QUESTION_MESSAGE);
			}
		});
		btnSearch.setVerticalAlignment(SwingConstants.TOP);
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		toolBar.add(btnSearch);
		
		JButton btnFrame = new JButton("Small Frame");
		btnFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s=btnFrame.getText();
				if (s=="Small Frame") {
					btnFrame.setText("Big Frame");
					Point p=NotePad.this.getLocation();
					NotePad.this.setBounds(p.x, p.y, 450, 300);
					
				}
				if (s=="Big Frame") {
					btnFrame.setText("Small Frame");
					Point p=NotePad.this.getLocation();
					NotePad.this.setBounds(p.x, p.y, 450, 600);
				}
				
			}
		});
		btnFrame.setVerticalAlignment(SwingConstants.TOP);
		btnFrame.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		toolBar.add(btnFrame);
		
		Point origin = new Point();
		
		txtWords = new JTextField();
		txtWords.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = NotePad.this.getLocation();
				NotePad.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
		});
		//words counts
		txtWords.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount()==2) {
					NotePad.this.dispose();
				}
				StringBuffer sb = new StringBuffer();
				sb.append(textArea.getText());

				String []strs = sb.toString().replace(", ", "\n").replace(". ", "\n").replace(" ", "\n").replace("  ", "\n").replace("   ", "\n").replace("\n\n", "\n").replace("\n\n\n", "\n").replace("\n\n\n\n", "\n").split("\n");//replace all to space
				for (int i = 0; i < strs.length; i++) {
  				if (strs[i] != "" && strs[i] != "\n")
  				{
  				}
  				//System.out.println(i+":\t"+strs[i]);
  				}
				

				/*Scanner s = new Scanner("sb.toString()"); 
				//s.useDelimiter(" |,|\\."); 
				repeat = (s.nextLine()).charAt(0)-'0';
				for(ri=1; ri<=repeat; ri++){
			         String line = s.nextLine(); 
			          count = line.split(" ").length + count;
			          System.out.println(count);
				}
				txtWords.setText("Letters:" + sb.length()+"      Words:" + count);*/
				
				txtWords.setText("Letters: " + sb.length() + "" + "         Words: " + strs.length);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		
		txtWords.setForeground(new Color(255, 255, 255));
		txtWords.setBackground(new Color(119, 136, 153));
		txtWords.setEditable(false);
		txtWords.setText("Letters:0         Words:0");
		contentPane.add(txtWords, BorderLayout.SOUTH);
		txtWords.setColumns(1);
		
		
	}
	
}