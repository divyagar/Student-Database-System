package StudentDatabase.gitRepo.StudentDatabaseSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FetchData extends JFrame implements ActionListener{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width, height;
    
    String rollNo;
    String Name;
    JLabel title, rollno, name;
    JButton getByRollNo, getByName;
    JPanel main;
    JTextField byRollNo, byName;
    
    ResultSet results;
    boolean resultExists = false, getRollNumber = false;
    
    public FetchData(Point loc, int w, int h) {
        width = w;
        height = h;
        createFrame(loc);
    }
    
    private void createFrame(Point loc){
        setLayout(null);
        
        // comment following line before running main program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JLabel("Fetch Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        add(title);
        
        main = new JPanel();
        main.setLayout(null);
        main.setSize(590, 200);
        main.setLocation(50, 140);

        rollno = new JLabel("Roll No.");
        rollno.setBounds(30, 25, 100, 30);
        main.add(rollno);

        byRollNo = new JTextField(20);
        byRollNo.setBounds(140, 30, 200, 20);
        main.add(byRollNo);
        
        getByRollNo = new JButton("Search");
        getByRollNo.setBounds(440, 25, 80, 30);
        main.add(getByRollNo);
        getByRollNo.addActionListener(this);
        
        name = new JLabel("Name");
        name.setBounds(30, 95, 100, 30);
        main.add(name);

        byName = new JTextField(20);
        byName.setBounds(140, 100, 200, 20);
        main.add(byName);
        
        getByName = new JButton("Search");
        getByName.setBounds(440, 95, 80, 30);
        main.add(getByName);
        getByName.addActionListener(this);
        
        
        
        add(main);
        
        setTitle("Fetch information");
        setLocation(loc);
        setSize(width, height);
        setVisible(true);
        
    }
    
    private void fetchDataFromDatabase(String data){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String link = "jdbc:mysql://localhost:3308/StudentDatabase?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(link, username, password);
            String sql = "";
            if(getRollNumber)
                sql = "select * from student where RollNo = " + data;
            
            else
                sql = "select * from student where Name = " + data;
            
            Statement stmt = con.createStatement();
            results = stmt.executeQuery(sql);
            
            if(!results.isBeforeFirst()){
                if(getRollNumber){
                    JOptionPane.showMessageDialog(rootPane, "No student from Provided roll no.");
                    getRollNumber = false;
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "No student from Provided Name");
                return;
            }
            else{
                resultExists = true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Some error occurred");
        }
    }
    
    
    
    public static void main(String args[]){
        new FetchData(new Point(300, 100), 700, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getByRollNo){
            rollNo = byRollNo.getText();
            getRollNumber = true;
            fetchDataFromDatabase(rollNo); 
            getRollNumber = false;
        }
        else{
            Name = byName.getText();
            fetchDataFromDatabase(Name);
        }
            
            try {
                if(resultExists){
                    ShowFetchedData dataObj = new ShowFetchedData(getLocation(), results, getWidth(), getHeight());
                    dispose();
                }
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Some error occurred");
            }
    }
    
}
