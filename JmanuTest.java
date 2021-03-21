import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import  javax.swing.*;


public class JmanuTest extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuFile, menuTools, menuHelp, menuOption;
    JMenuItem mOpen, mSave, mExit, mTool1, mTool2, aboutProgramm, mOption1, mOption2;
    JCheckBoxMenuItem chOption3;
    JTextArea t_area;
    JTextField t_find;
    JButton b_find;

    public JmanuTest(){
        setTitle("Menu moje nie twoje a moje");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
            mOpen = new JMenuItem("Open..", 'O');
            menuFile.add(mOpen);
            mOpen.addActionListener(this);
            mSave = new JMenuItem("Save");
            menuFile.add(mSave);
            mSave.addActionListener(this);
            mExit = new JMenuItem("Exit");
            menuFile.addSeparator();
            menuFile.add(mExit);
                mExit.addActionListener(this);
                mExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        menuTools = new JMenu("Tools");
            mTool1 = new JMenuItem("Tool 1");
            menuTools.add(mTool1);
                mTool1.setEnabled(false);
            mTool2 = new JMenuItem("Cm to inch");
            menuTools.add(mTool2);
            mTool2.addActionListener(this);
            menuOption = new JMenu("Options");
                mOption1 = new JMenuItem("Option 1");
                menuOption.add(mOption1);
                mOption2 = new JMenuItem("Option 2");
                menuOption.add(mOption2);
                chOption3 = new JCheckBoxMenuItem("Option 3");
                menuOption.add(chOption3);
                    chOption3.addActionListener(this);
            menuTools.add(menuOption);
        menuHelp = new JMenu("Help");
            aboutProgramm = new JMenuItem("About program");
            menuHelp.add(aboutProgramm);
                aboutProgramm.addActionListener(this);

        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        menuBar.add(menuHelp);
        
        t_area = new JTextArea();
        JScrollPane t_scroll = new JScrollPane(t_area);
        t_scroll.setBounds(20, 40, 700, 400);
        add(t_scroll);
        
        t_find = new JTextField();
        t_find.setBounds(20, 460, 300, 20);
        add(t_find);
        
        b_find = new JButton("Find");
        b_find.setBounds(340, 460, 70, 20);
        add(b_find);
        b_find.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if(source == mExit) 
        {	int answer = JOptionPane.showConfirmDialog(null, "Are you suru want to exit?", "Question", JOptionPane.YES_NO_OPTION);
        	if (answer == JOptionPane.YES_OPTION || answer == JOptionPane.CLOSED_OPTION) dispose();}
       
        if (source == chOption3)
        {	if (chOption3.isSelected()) mTool1.setEnabled(true);
            else if(chOption3.isSelected()==false) mTool1.setEnabled(false); }
       
        if(source == aboutProgramm)
        {	JOptionPane.showMessageDialog(this, "This program is fucking super \n and Stannis rules motherfuckers!", "Opis programu", JOptionPane.WARNING_MESSAGE);}
        
        if (source == mTool2) 
        {	String cm_s = JOptionPane.showInputDialog("Type lenght in cm");
        	double cm_d = Double.parseDouble(cm_s);
        	double inch_d = cm_d/2.54; 
        	String inch_s = String.format("%.2f", inch_d);
        	JOptionPane.showMessageDialog(null, cm_s + " cm = " + inch_s + " inches"); }
        
        if(source == mOpen)
        {	JFileChooser choose_file = new JFileChooser();
        	if ( choose_file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        		{File file = choose_file.getSelectedFile();
        		// JOptionPane.showMessageDialog(null, "I have choosen file : " + file.getName() + "\n" + "Path: " + file.getAbsolutePath());
        		
					Scanner sc;
					try {
						sc = new Scanner(file);
						while(sc.hasNext()) t_area.append(sc.nextLine() +"\n");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
			
        		}
        }
        
        if(source == mSave)
        {	JFileChooser choose_folder = new JFileChooser();
        	if ( choose_folder.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        		{File file = choose_folder.getSelectedFile();
        		 JOptionPane.showMessageDialog(null, "I have save file : " + file.getName() + "\n" + "to: " + file.getAbsolutePath());
	        		 try {
						PrintWriter to_w = new PrintWriter(file);
						Scanner sc_w = new Scanner(t_area.getText());
						while ( sc_w.hasNext()) to_w.println(sc_w.nextLine() + "\n");
						to_w.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
        		}
        }
        
        if(source == b_find)
        {
        	String text = t_area.getText();
        	String find_text = t_find.getText();
        }
    }

    public static void main(String[] args){
        JmanuTest apkMenu = new JmanuTest();
        apkMenu.setVisible(true);
    }




}
