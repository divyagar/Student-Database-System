
package StudentDatabase.gitRepo.StudentDatabaseSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    static JFrame f;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    static boolean proceed = false;
    int width = 700;
    int height = 600;
    ResultSet result;
    boolean deleting = false;
    
    
    Main(){

        // this code will execute only after user authenticated itself
        
        f = new JFrame();
        f.setLayout(null);
//        f.getContentPane().setBackground(new Color(254, 234, 250));

        JLabel title = new JLabel("Student Database System", SwingConstants.CENTER);
        title.setBounds(50, 40, 600, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        JPanel mainButtons = new JPanel();
        mainButtons.setBounds(20, 150, 650, 350);
//        mainButtons.setBackground(Color.red);
        mainButtons.setLayout(null);
        f.add(mainButtons);
        
        JButton addStudentBtn = new JButton("Add new Student");
        addStudentBtn.setBounds(100, 20, 200, 120);
        addStudentBtn.setFont(new Font("", Font.PLAIN, 18));
        addStudentBtn.setBackground(Color.WHITE);
        
        addStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code to create a jframe that will get student data and add it to student database
                new AddStudent(f.getLocation(), f.getWidth(), f.getHeight());
                f.dispose();
            }
        });
        
        mainButtons.add(addStudentBtn);
        
        JButton fetchStudentBtn = new JButton("Fetch Student data");
        fetchStudentBtn.setBounds(350, 20, 200, 120);
        fetchStudentBtn.setFont(new Font("", Font.PLAIN, 18));  
        fetchStudentBtn.setBackground(Color.WHITE); 
        fetchStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FetchData(f.getLocation(), f.getWidth(), f.getHeight());
                f.dispose();
            }
        });
        
        mainButtons.add(fetchStudentBtn);
        
        JButton modifyStudentBtn = new JButton("Update Student data");
        modifyStudentBtn.setBounds(100, 180, 200, 120);
        modifyStudentBtn.setFont(new Font("", Font.PLAIN, 18));   
        modifyStudentBtn.setBackground(Color.WHITE);modifyStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = JOptionPane.showInputDialog("Enter roll Number : ");
                if((ans != null) && (ans.trim() != "")){
                    try {
                        int rollno = Integer.parseInt(ans);
                        DatabaseWork(rollno);
                        if(result.isBeforeFirst()){
                            new AddStudent(f.getLocation(), f.getWidth(), f.getHeight(), result);
                            f.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(f, "No student from provided roll no.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(f, "Some error occurred");
                    }
                }
            }
        });
        
        mainButtons.add(modifyStudentBtn);
        
        JButton deleteStudentBtn = new JButton("Delete Student data");
        deleteStudentBtn.setBounds(350, 180, 200, 120);
        deleteStudentBtn.setFont(new Font("", Font.PLAIN, 18));   
        deleteStudentBtn.setBackground(Color.WHITE);
        deleteStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = JOptionPane.showInputDialog("Enter roll Number : ");
                if( (ans != null) && (ans.trim() != "")){
                    int rollno = Integer.parseInt(ans);
                    deleting = true;
                    DatabaseWork(rollno);
                    deleting = false;
                }
                
            }
        });
        
        mainButtons.add(deleteStudentBtn);

        f.add(title);
        
        f.setVisible(true);
        f.setSize(width, height);
        f.setLocation(Screenwidth/2 - 300, ScreenHeight/2 - 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void DatabaseWork(int rollno){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String link = "jdbc:mysql://localhost:3308/StudentDatabase?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "";
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection(link, username, password);
            
            Statement stmt = con.createStatement();
            String sql = "select * from student where RollNo = " + rollno;
            
            result = stmt.executeQuery(sql);
            
            if(deleting){
                if(result.isBeforeFirst()){
                    Statement statement = con.createStatement();
                    int done = statement.executeUpdate("delete from student where RollNo = " + rollno);
                    if(done > 0){
                        JOptionPane.showMessageDialog(f, "Student data has been deleted");
                    }
                    else{
                        JOptionPane.showMessageDialog(f, "Error while deleting student data");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(f, "No student from provided roll no.");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(f, "Error while connecting to database");
        }
    }
    
    public static void authenticate(){
        f = new JFrame();
        f.setUndecorated(true);
        f.setSize(250, 100);
        f.setLocation(500, 300);
        
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
        // First authentication : If user entered 1234 it will be given permission to proceed further
        
        authenticate();
        while(true){
            System.out.print("");
            if(proceed == true)
                break;
        }

        new Main();
    }
    
}
