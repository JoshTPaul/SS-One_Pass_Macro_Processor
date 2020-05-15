import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class gui extends JFrame {
	public static int identifier = 0;
	public static JLabel lblNewLabel;
	public static JLabel lblNewLabel_1;
	public static JLabel lblNewLabel_2;
	public static JLabel lblNewLabel_3;
	public static JLabel lblNewLabel_4;
	public static JLabel msgConsole;
	public static JEditorPane editorPane;
	public static JEditorPane editorPane_1;
	public static FileWriter IN;
	public static FileReader OUT;
	public static FileReader DEFTAB;
	public static FileReader NAMTAB;
	public static FileReader ARGTAB;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() 
	{
		
		
		setTitle("System Software Minor Project (1DS17CS047-050)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		/*MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(((JLabel)e.getSource()).getText() + " clicked.");
                ((JLabel)e.getSource()).setBackground(new Color(200,20,20));
                
            }
        };
        */
		
		lblNewLabel = new JLabel("INPUT");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("INPUT clicked.");
				lblNewLabel.setBackground(new Color(4, 13, 191));
				lblNewLabel_1.setBackground(new Color(0,0,0));
				lblNewLabel_2.setBackground(new Color(0,0,0));
				lblNewLabel_3.setBackground(new Color(0,0,0));
				lblNewLabel_4.setBackground(new Color(0,0,0));
				msgConsole.setText("Enter the code to be passed through the Macro Processor and click Execute.");
				editorPane.setVisible(true);
				editorPane_1.setVisible(false);
			}
			
		});
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(4, 13, 191));
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel Light", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 100, 91);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("OUTPUT");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("OUTPUT clicked.");
				identifier = 1;
				lblNewLabel.setBackground(new Color(0,0,0));
				lblNewLabel_1.setBackground(new Color(4, 13, 191));
				lblNewLabel_2.setBackground(new Color(0,0,0));
				lblNewLabel_3.setBackground(new Color(0,0,0));
				lblNewLabel_4.setBackground(new Color(0,0,0));
				msgConsole.setText("Output from the latest execution.");
				
				try {
					int i;
					String out="";
					OUT=new FileReader("OUT.txt");
					while((i=OUT.read())!= -1) {
						out+=(char) i;
					}
					editorPane.setVisible(false);
					editorPane_1.setVisible(true);
					editorPane_1.setText(out);
					} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Corbel Light", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 90, 100, 91);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DEFTAB");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("DEFTAB clicked");
				lblNewLabel.setBackground(new Color(0,0,0));
				lblNewLabel_1.setBackground(new Color(0,0,0));
				lblNewLabel_2.setBackground(new Color(4, 13, 191));
				lblNewLabel_3.setBackground(new Color(0,0,0));
				lblNewLabel_4.setBackground(new Color(0,0,0));
				msgConsole.setText("DEFTAB from the latest execution.");
				
				try {
					int i;
					String out="";
					DEFTAB=new FileReader("DEFTAB.txt");
					while((i=DEFTAB.read())!= -1) {
						out+=(char) i;
					}
					editorPane.setVisible(false);
					editorPane_1.setVisible(true);
					editorPane_1.setText(out);					
					} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Corbel Light", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(0, 192, 100, 89);
		contentPane.add(lblNewLabel_2);
		
		
		
		lblNewLabel_3 = new JLabel("NAMTAB");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("NAMTAB clicked");
				lblNewLabel.setBackground(new Color(0,0,0));
				lblNewLabel_1.setBackground(new Color(0,0,0));
				lblNewLabel_2.setBackground(new Color(0,0,0));
				lblNewLabel_3.setBackground(new Color(4, 13, 191));
				lblNewLabel_4.setBackground(new Color(0,0,0));
				msgConsole.setText("NAMTAB from the latest execution.");
				
				try {
					int i;
					String out="";
					NAMTAB=new FileReader("NAMTAB.txt");
					while((i=NAMTAB.read())!= -1) {
						out+=(char) i;
					}
					editorPane.setVisible(false);
					editorPane_1.setVisible(true);
					editorPane_1.setText(out);					
					} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 292, 100, 89);
		lblNewLabel_3.setOpaque(true);
		contentPane.add(lblNewLabel_3);
		
		
		
		lblNewLabel_4 = new JLabel("ARGTAB");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ARGTAB clicked");
				lblNewLabel.setBackground(new Color(0,0,0));
				lblNewLabel_1.setBackground(new Color(0,0,0));
				lblNewLabel_2.setBackground(new Color(0,0,0));
				lblNewLabel_3.setBackground(new Color(0,0,0));
				lblNewLabel_4.setBackground(new Color(4, 13, 191));
				msgConsole.setText("ARGTAB from the latest execution.");
				
				try {
					int i;
					String out="";
					ARGTAB=new FileReader("ARGTAB.txt");
					while((i=ARGTAB.read())!= -1) {
						out+=(char) i;
					}
					editorPane.setVisible(false);
					editorPane_1.setVisible(true);
					editorPane_1.setText(out);					
					} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Corbel Light", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(0, 392, 100, 89);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(3, 23, 140));
		panel.setBounds(100, 0, 573, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("One-Pass Macro Processor");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Corbel Light", Font.PLAIN, 40));
		lblNewLabel_5.setBounds(10, 11, 553, 80);
		panel.add(lblNewLabel_5);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		editorPane.setBounds(20, 101, 528, 388);
		panel.add(editorPane);
		
		msgConsole = new JLabel("Enter the code to be passed through the Macro Processor and click Execute.");
		msgConsole.setForeground(new Color(255, 255, 255));
		msgConsole.setFont(new Font("Corbel", Font.BOLD, 16));
		msgConsole.setBounds(10, 501, 553, 23);
		panel.add(msgConsole);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		editorPane_1.setBounds(20, 102, 528, 387);
		editorPane_1.setVisible(false);
		panel.add(editorPane_1);
		
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.out.println("Executing...");
				String s = editorPane.getText();
				if(s.length()!=0) 
				{
					try {
						IN = new FileWriter("IN.txt");
						IN.write(s);
						IN.close();
						macroProcessor.main(null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					msgConsole.setText("Please enter the Assembly code before clicking the Execute button.");
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(112, 128, 144));
		btnNewButton.setBounds(10, 501, 80, 23);
		contentPane.add(btnNewButton);
		
	
	}
}
