package lesson_8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Win extends JFrame {
	public Win() {
	setBounds(500, 100, 800, 600);
	setTitle("GUI");
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new GridLayout(3,2));
	
	JPanel[] jp = new JPanel[6];
	for(int i = 0; i < 4 /*jp.length*/; i++) {
		jp[i] = new JPanel();
		add(jp[i]);
		jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
	}
	//DZ start
	/* jbutton+++
	 * jtextfield+++
	 * jtable
	 * */
	///jp4
	jp[4] = new JPanel();
	add(jp[4]);
	jp[4].setBackground(new Color(255,10,10));
	
	jp[4].setLayout(new FlowLayout());
	
	JButton[] jbs = new JButton[3];
	for(int i = 0; i < jbs.length; i++) {
		jbs[i] = new JButton("#" + i);
		jp[4].add(jbs[i]);
	}
	jbs[0].addActionListener(e -> System.out.println("button1"));
	jbs[1].addActionListener(e -> System.out.println("button2"));
	jbs[2].addActionListener(e -> System.out.println("button3"));
	
	JTextField jtf = new JTextField(25);
	jp[4].add(jtf);
	jtf.addActionListener(e -> System.out.println("Your message: " + jtf.getText()));
	
	///jp5
	jp[5] = new JPanel();
	add(jp[5]);
	jp[5].setBackground(new Color(10,99,110));
	
	String[][] data = new String[][] {{"a", "1"}, {"b", "2"}};
	String[] header = new String[] {"letter", "id"};
	
	JTable table = new JTable(data, header);
	jp[5].add(table);
	//DZ end
	/////	
	jp[0].setLayout(new BorderLayout());
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	jp[0].add(jsp);
	/////	
	jp[1].setLayout(new FlowLayout());// для строк
	JRadioButton[] jrb = new JRadioButton[4];
	ButtonGroup bgr = new ButtonGroup();
	ButtonGroup bgr2 = new ButtonGroup();
	ButtonGroup bgr3 = new ButtonGroup();
	
	for(int i = 0; i < jrb.length; i++) {
		jrb[i] = new JRadioButton("Option#" + i);
		if(i < 2) {
			bgr.add(jrb[i]);
		}else {
			bgr2.add(jrb[i]);
		}
		jp[1].add(jrb[i]);
	}
	JCheckBox[] jcb = new JCheckBox[4];
	for(int i = 0; i < jcb.length; i++) {
		jcb[i] = new JCheckBox("Check #" + i);
		//bgr3.add(jrb[i]);
		jp[1].add(jcb[i]);
	}
	/////	
	jp[2].setLayout(new FlowLayout());
	String[] comboStr = {"Item #1", "Item #2", "Item #3", "Item #4"};
	JComboBox<String> jcombo1 = new JComboBox<>(comboStr);
	JComboBox<String> jcombo2 = new JComboBox<>(comboStr);//выпадающие списки
	jp[2].add(jcombo1);
	jp[2].add(jcombo2);
	
//	jcombo1.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("//////");
//		}
//	});
	
	jcombo1.addActionListener(e -> System.out.println("///123123"));
//	jcombo1.addActionListener(e -> {
//								System.out.println(jcombo1.getSelectedItem().toString() + "***");
//								});
//	jcombo1.addActionListener(new ActionComBox());
//	jcombo1.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println(jcombo1.getSelectedItem().toString());
//		}
//	});
	/////
	jp[3].setLayout(null);
	JSlider js = new JSlider();
	JLabel jlab = new JLabel("Value: 50");
	js.setMaximum(100);
	js.setMinimum(0);
	js.setValue(50);
	jp[3].add(jlab);
	jp[3].add(js);
	
	js.addChangeListener(e -> jlab.setText("Value: " + js.getValue()));
	jlab.setBounds(10, 10, 100, 20);
	js.setBounds(20, 40, 300, 100);
	js.setBackground(new Color(160, 255, 160));
	/////
	JMenuBar mainMenu = new JMenuBar();
	JMenu mFile = new JMenu("File");
	JMenu mEdit = new JMenu("Edit");
	JMenuItem miFileNew = new JMenuItem("New");
	JMenuItem miFileExit = new JMenuItem("Exit");
	
	setJMenuBar(mainMenu);
	
	mainMenu.add(mFile);
	mainMenu.add(mEdit);
	
	mFile.add(miFileNew);
	mFile.addSeparator();
	mFile.add(miFileExit);
	
	miFileExit.addActionListener(e ->{
		System.out.println("exit");
		System.exit(0);
	});
	
	
	
	
	setVisible(true);
	}
	
}
