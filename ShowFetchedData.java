package StudentDatabase.gitRepo.StudentDatabaseSystem;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
public class ShowFetchedData extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width = 700;
    int height = 600;
    int RollNo;
    
    JLabel title, name, rollno, fathername, mothername, dob, email, gender, aadharcard, enrollment, address;
    JLabel country, state, city, phoneno, percentage;
    
    JLabel nameAns, rollnoAns, fathernameAns, mothernameAns, dobAns, emailAns, genderAns, aadharcardAns, enrollmentAns, addressAns;
    JLabel countryAns, stateAns, cityAns, phonenoAns, percentageAns;
    
    ResultSet result;

    public ShowFetchedData(Point loc, ResultSet results) throws SQLException {
//        public ShowFetchedData(Point loc) throws SQLException {
        result = results;
        createFrame(loc);
    }
    
    private void createFrame(Point loc) throws SQLException{        
        setLayout(null);
        
        // comment following line before running main program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JLabel("Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        add(title);
        
        name = new JLabel("Name : ");
        name.setBounds(50, 100, 100, 20);
        add(name);
        
        nameAns = new JLabel();
        nameAns.setBounds(200, 100, 500, 20);
        nameAns.setFont(new Font("", Font.PLAIN, 12));
        add(nameAns);
        
        rollno = new JLabel("Roll No. ");
        rollno.setBounds(50, 125, 100, 20);
        add(rollno);
        
        rollnoAns = new JLabel();
        rollnoAns.setBounds(200, 125, 500, 20);
        rollnoAns.setFont(new Font("", Font.PLAIN, 12));
        add(rollnoAns);
        
        fathername = new JLabel("Father Name ");
        fathername.setBounds(50, 150, 100, 20);
        add(fathername);
        
        fathernameAns = new JLabel();
        fathernameAns.setBounds(200, 150, 500, 20);
        fathernameAns.setFont(new Font("", Font.PLAIN, 12));
        add(fathernameAns);
        
        mothername = new JLabel("Mother Name ");
        mothername.setBounds(50, 175, 100, 20);
        add(mothername);
        
        mothernameAns = new JLabel();
        mothernameAns.setBounds(200, 175, 500, 20);
        mothernameAns.setFont(new Font("", Font.PLAIN, 12));
        add(mothernameAns);
        
        dob = new JLabel("DOB ");
        dob.setBounds(50, 200, 100, 20);
        add(dob);
        
        dobAns = new JLabel();
        dobAns.setBounds(200, 200, 500, 20);
        dobAns.setFont(new Font("", Font.PLAIN, 12));
        add(dobAns);
        
        email = new JLabel("Email ");
        email.setBounds(50, 225, 100, 20);
        add(email);
        
        emailAns = new JLabel();
        emailAns.setBounds(200, 225, 500, 20);
        emailAns.setFont(new Font("", Font.PLAIN, 12));
        add(emailAns);
        
        gender = new JLabel("Gender ");
        gender.setBounds(50, 250, 100, 20);
        add(gender);
        
        genderAns = new JLabel();
        genderAns.setBounds(200, 250, 500, 20);
        genderAns.setFont(new Font("", Font.PLAIN, 12));
        add(genderAns);
        
        aadharcard = new JLabel("Aadhar Card No. ");
        aadharcard.setBounds(50, 275, 100, 20);
        add(aadharcard);
        
        aadharcardAns = new JLabel();
        aadharcardAns.setBounds(200, 275, 500, 20);
        aadharcardAns.setFont(new Font("", Font.PLAIN, 12));
        add(aadharcardAns);
        
        enrollment = new JLabel("Enrollment No. ");
        enrollment.setBounds(50, 300, 100, 20);
        add(enrollment);
        
        enrollmentAns = new JLabel();
        enrollmentAns.setBounds(200, 300, 500, 20);
        enrollmentAns.setFont(new Font("", Font.PLAIN, 12));
        add(enrollmentAns);
        
        address = new JLabel("Address ");
        address.setBounds(50, 325, 100, 20);
        add(address);
        
        addressAns = new JLabel();
        addressAns.setBounds(200, 325, 500, 20);
        addressAns.setFont(new Font("", Font.PLAIN, 12));
        add(addressAns);
        
        
        country = new JLabel("Country ");   
        country.setBounds(50, 350, 100, 20);
        add(country);
        
        countryAns = new JLabel();
        countryAns.setBounds(200, 350, 500, 20);
        countryAns.setFont(new Font("", Font.PLAIN, 12));
        add(countryAns);
             
        state = new JLabel("State ");
        state.setBounds(50, 375, 100, 20);
        add(state);
        
        stateAns = new JLabel();
        stateAns.setBounds(200, 375, 500, 20);
        stateAns.setFont(new Font("", Font.PLAIN, 12));
        add(stateAns);
        
        city = new JLabel("City ");
        city.setBounds(50, 400, 100, 20);
        add(city);
        
        cityAns = new JLabel();
        cityAns.setBounds(200, 400, 500, 20);
        cityAns.setFont(new Font("", Font.PLAIN, 12));
        add(cityAns);
        
        phoneno = new JLabel("Phone No. ");
        phoneno.setBounds(50, 425, 100, 20);
        add(phoneno);
        
        phonenoAns = new JLabel();
        phonenoAns.setBounds(200, 425, 500, 20);
        phonenoAns.setFont(new Font("", Font.PLAIN, 12));
        add(phonenoAns);
        
        percentage = new JLabel("Percentage ");
        percentage.setBounds(50, 450, 100, 20);
        add(percentage);
        
        percentageAns = new JLabel();
        percentageAns.setBounds(200, 450, 500, 20);
        percentageAns.setFont(new Font("", Font.PLAIN, 12));
        add(percentageAns);
        
        while(result.next()){
            String ans = result.getString(1);
            nameAns.setText(ans);
            ans = result.getString(2);
            rollnoAns.setText(ans);
            ans = result.getString(3);
            fathernameAns.setText(ans);
            ans = result.getString(4);
            mothernameAns.setText(ans);
            ans = result.getString(5);
            dobAns.setText(ans);
            ans = result.getString(6);
            emailAns.setText(ans);
            ans = result.getString(7);
            genderAns.setText(ans);
            ans = result.getString(8);
            aadharcardAns.setText(ans);
            ans = result.getString(9);
            enrollmentAns.setText(ans);
            ans = result.getString(10);
            addressAns.setText(ans);
            ans = result.getString(11);
            countryAns.setText(ans);
            ans = result.getString(12);
            stateAns.setText(ans);
            ans = result.getString(13);
            cityAns.setText(ans);
            ans = result.getString(14);
            phonenoAns.setText(ans);
            ans = result.getString(15);
            percentageAns.setText(ans);
        }
        
        
        setTitle("Student information");
        setVisible(true);
        setLocation(loc);
        setSize(width, height);
        
        
        
    }
    
    public static void main(String args[]) throws SQLException{
//        new ShowFetchedData(new Point(300, 100));
    }
    
}
