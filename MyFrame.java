package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	
	JPanel buttonPanel, mainPanel;
	JButton b1, b2;
	JTextArea textArea;
	
	public MyFrame()
	{
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");
		this.setSize(300, 300);
		this.setLayout(new BorderLayout());
		
		b1 = new JButton("Click Left");
		b2 = new JButton("Click Right");
		
		
		//do button adding to panel and panel to frame first
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                textArea.setText("Left button was clicked");
            }
        });   
		
		
		b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                textArea.setText("Right button was clicked");
            }
        }); 
		
		mainPanel = new JPanel();
		textArea = new JTextArea("Text will be here");
		mainPanel.add(textArea);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(mainPanel, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	

}

