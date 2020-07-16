package StudentDatabase;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Main {
    JFrame f;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    boolean proceed = false;
    
    
    Main(){
        // First authentication : If user entered 1234 it will be given permission to proceed further
        
//        authenticate();
//        while(true){
//            System.out.print("");
//            if(proceed == true)
//                break;
//        }

        // this code will execute only after user authenticated itself
        
        f = new JFrame();
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600, 450);
        f.setLocation(width/2 - 300, height/2 - 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.getContentPane().setBackground(new Color(254, 234, 250));

        JLabel title = new JLabel("Student Database System", SwingConstants.CENTER);
        title.setBounds(50, 40, 500, 80);
        title.setFont(new Font("", Font.PLAIN, 30));        
        
        JButton addStudentBtn = new JButton("Add new Student");
        addStudentBtn.setBounds(50, 160, 200, 150);
        addStudentBtn.setFont(new Font("", Font.PLAIN, 18));
        addStudentBtn.setBackground(Color.WHITE);
        
        addStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code to create a jframe that will get student data and add it to student database
            }
        });
        
        JButton fetchStudentBtn = new JButton("Fetch Student data");
        fetchStudentBtn.setBounds(320, 160, 200, 150);
        fetchStudentBtn.setFont(new Font("", Font.PLAIN, 18));   
        fetchStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code to create a jframe that will fetch student data of a particular student from student database.
            }
        });
        
        fetchStudentBtn.setBackground(Color.WHITE);

        f.add(title);
        f.add(addStudentBtn);
        f.add(fetchStudentBtn);
//        f.add(storing);
//        f.add(fetching);
        
        
    }
    
    public void authenticate(){
        f = new JFrame();
        f.setUndecorated(true);
        f.setSize(250, 100);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLocation((width/2) - 125, (height/2) - 80);
        
        f.setLayout(null);
        JLabel l = new JLabel("Enter password : ");
        l.setBounds(10, 5, 100, 30);
        JTextField tf = new JTextField(10);
        tf.setBounds(120, 12, 100, 20);
        JButton submit = new JButton("OK");
        submit.setBounds(45, 50, 60, 20);
        
        // to set focus on submit button by default
        f.getRootPane().setDefaultButton(submit);
        submit.requestFocus();
        
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(115, 50, 80, 20);
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tf.getText();
                if(password.equals(""))
                    System.exit(0);
                else if(password.equals("1234")){
                    System.out.println("correct");
                    f.dispose();
                    proceed = true;
                }
                else{
                    JOptionPane.showMessageDialog(f, "invalid password");
                }
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        f.add(l);
        f.add(tf);
        f.add(submit);
        f.add(cancel);
        f.setVisible(true);
    }
    
    public static void main(String args[]){
//        authenticate();
        new Main();
    }
    
}
