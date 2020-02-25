import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.Caret;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JScrollPane jsp ;
	/**
	 * Launch the application.
	 */
	
	String result = "" ;
	
	public static void main(String[] args) {
		//result = str ;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 504);
		frame.setName("Mystery Guest smell");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnChoose = new JButton("choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isDirectory()) {
						//System.out.println("You selected the directory: " + jfc.getSelectedFile());
						String path= jfc.getSelectedFile().getAbsolutePath();
					    textField_1.setText(path);
					    
					    
					    StatementsLinesExample se = new StatementsLinesExample() ;
					    String resu = se.statementsByLine(jfc.getSelectedFile()) ;
					    
					    result = resu ;
					    
					    
					}
				}
				
			}
		});
		btnChoose.setBounds(361, 11, 91, 33);
		frame.getContentPane().add(btnChoose);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 11, 322, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		
		btnNewButton = new JButton("Analize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//textPane.setText("bal"+"\n"+"hello");
				
				textPane.setText(result);
				
				jsp = new JScrollPane(textPane);
				jsp.setBounds(29, 66, 547, 373);
				
				frame.add(jsp);
				//frame.pack();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(473, 11, 97, 33);
		frame.getContentPane().add(btnNewButton);
		
		//JTextPane textPane = new JTextPane();
		textPane.setBounds(29, 66, 547, 373);
		frame.getContentPane().add(textPane);
		
		
	}
}
