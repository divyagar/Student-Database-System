package StudentDatabase.gitRepo.StudentDatabaseSystem;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class AddStudent extends JFrame implements ActionListener{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width, height;
    int leftAlingFirstCol = 50, leftAlignSecondCol = 170;
    int labelWidth = 110, textFieldWidth = 150;
    
    JLabel title,name, rollno, fathername, mothername, dob, email, gender, aadharcard, enrollment, address;
    JLabel country, state, city, phoneno, percentage;
    JTextField Name, RollNo, FatherName, MotherName, Dob, Email, Gender, AadharCard, Enrollment, Address;
    JTextField PhoneNo, Percentage;
    JRadioButton male, female;
    ButtonGroup genders;
    JComboBox countryList, stateList, cityList;
    JButton submit, back;
    
    int rollNoAns;
    float percentageAns;
    String nameAns, fatherAns, motherAns, dobAns, emailAns, genderAns, enrollmentAns, aadharAns, phoneAns;
    String countryAns, stateAns, cityAns, addressAns;
    boolean alteringStateList = false, modifying = false;
    ResultSet result;

    public AddStudent(Point loc, int w, int h) {
        width = w;
        height = h;
        createFrame(loc);    
    }
    
    public AddStudent(Point loc, int w, int h, ResultSet result) {
        width = w;
        height = h;
        this.result = result;
        modifying = true;
        createFrame(loc);    
    }
    
    private void createFrame(Point loc){
        setTitle("Student Database System");
        setLayout(null);
        
        // comment following line before running main program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JLabel("Add Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        add(title);
        
        // First row
        name = new JLabel("Name : ");
        name.setBounds(leftAlingFirstCol, 100, labelWidth, 20);
        add(name);
        
        Name = new JTextField(10);
        Name.setBounds(leftAlignSecondCol, 100, textFieldWidth, 20);
        add(Name);
        
        rollno = new JLabel("Roll No. : ");
        rollno.setBounds(350, 100, labelWidth, 20);
        add(rollno);
//        
        RollNo = new JTextField(10);
        RollNo.setBounds(460, 100, textFieldWidth, 20);
        add(RollNo);
        // First row ends
        
        // Second row
        
        fathername = new JLabel("Father's Name : ");
        fathername.setBounds(leftAlingFirstCol, 150, labelWidth, 20);
        add(fathername);
        
        FatherName = new JTextField(10);
        FatherName.setBounds(leftAlignSecondCol, 150, textFieldWidth, 20);
        add(FatherName);
        
        mothername = new JLabel("Mother's Name : ");
        mothername.setBounds(350, 150, labelWidth, 20);
        add(mothername);
        
        MotherName = new JTextField(10);
        MotherName.setBounds(460, 150, textFieldWidth, 20);
        add(MotherName);
        
        // Second row ends
        
        // Third row
        
        dob = new JLabel("DOB(yyyy-mm-dd) : ");
        dob.setBounds(leftAlingFirstCol, 200, labelWidth, 20);
        add(dob);
        
        Dob = new JTextField(10);
        Dob.setBounds(leftAlignSecondCol, 200, textFieldWidth, 20);
        add(Dob);
        
        email = new JLabel("Email : ");
        email.setBounds(350, 200, labelWidth, 20);
        add(email);
        
        Email = new JTextField(10);
        Email.setBounds(460, 200, textFieldWidth, 20);
        add(Email);
        
        // Third row ends
        
        // Fourth row
        
        gender = new JLabel("Gender");
        gender.setBounds(leftAlingFirstCol, 250, labelWidth, 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 250, labelWidth, 20);
        add(male);
        male.setSelected(true);
        
        female = new JRadioButton("Female");
        female.setBounds(350, 250, labelWidth, 20);
        add(female);
        
        genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        
        // Fourth row ends
        
        // Fifth row
        
        aadharcard = new JLabel("Aadhar Card : ");
        aadharcard.setBounds(leftAlingFirstCol, 300, labelWidth, 20);
        add(aadharcard);
        
        AadharCard = new JTextField(10);
        AadharCard.setBounds(leftAlignSecondCol, 300, textFieldWidth, 20);
        add(AadharCard);
        
        enrollment = new JLabel("Enrollment No. : ");
        enrollment.setBounds(350, 300, labelWidth, 20);
        add(enrollment);
        
        Enrollment = new JTextField(10);
        Enrollment.setBounds(460, 300, textFieldWidth, 20);
        add(Enrollment);
        
        // Fifth row ends
        
        // Sixth row
        
        address = new JLabel("Address : ");
        address.setBounds(leftAlingFirstCol, 350, labelWidth, 20);
        add(address);
        
        Address = new JTextField(150);
        Address.setBounds(leftAlignSecondCol, 350, 400, 20);
        add(Address);
        
        // Sixth row ends
        
        // Seventh row
        
        country = new JLabel("Country");
        country.setBounds(leftAlingFirstCol, 400, 80, 20);
        add(country);
        
        String countries[] = {"India", "USA"};
        countryList = new JComboBox(countries);
        countryList.setBounds(140, 400, 80, 20);
        add(countryList);
        countryList.addActionListener(this);
        
        state = new JLabel("State");
        state.setBounds(260, 400, 50, 20);
        add(state);
        
        stateList = new JComboBox();
        stateList.setBounds(320, 400, 80, 20);
        stateList.setEnabled(false);
        add(stateList);
        stateList.addActionListener(this);
        
        city = new JLabel("City");
        city.setBounds(440, 400, 50, 20);
        add(city);
        
        cityList = new JComboBox();
        cityList.setBounds(500, 400, 80, 20);
        cityList.setEnabled(false);
        add(cityList);
        
        // Seventh row ends
        
        // eighth row 
        
        phoneno = new JLabel("Phone No. : ");
        phoneno.setBounds(leftAlingFirstCol, 450, labelWidth, 20);
        add(phoneno);
        
        PhoneNo = new JTextField(10);
        PhoneNo.setBounds(leftAlignSecondCol, 450, textFieldWidth, 20);
        add(PhoneNo);
        
        percentage = new JLabel("Percentage : ");
        percentage.setBounds(350, 450, labelWidth, 20);
        add(percentage);
        
        Percentage = new JTextField(10);
        Percentage.setBounds(460, 450, textFieldWidth, 20);
        add(Percentage);
        
        //eighth row ends
        
        submit = new JButton("Submit");
        submit.setBounds(300, 500, 100, 30);
        add(submit);
        submit.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(0, 500, 70, 30);
        add(back);
        back.addActionListener(this);
        
        
        // If data is to be modified then this section will enter existing data into textfields
        if(modifying){
            try {
                result.next();
                Name.setText(result.getString(1));
                RollNo.setText(result.getString(2));
                FatherName.setText(result.getString(3));
                MotherName.setText(result.getString(4));
                Dob.setText(result.getString(5));
                Email.setText(result.getString(6));
                String gend = result.getString(7);
                if(gend.equals("Male")){
                    male.setSelected(true);
                }
                else{
                    female.setSelected(true);
                }
                
                AadharCard.setText(result.getString(8));
                Enrollment.setText(result.getString(9));
                Address.setText(result.getString(10));
                countryList.setSelectedItem(result.getString(11));
                stateList.setSelectedItem(result.getString(12));
                cityList.setSelectedItem(result.getString(13));
                PhoneNo.setText(result.getString(14));
                Percentage.setText(result.getString(15));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Some error occurred in modifying");
            }
        }
        
        // entering data to be modified ends here
        
        
        setVisible(true);
        setLocation(loc);
        setSize(width, height);
    }
    
    public static void main(String args[]){
//        new AddStudent(new Point(200, 100));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new Main();
            dispose();
        }
        else if(e.getSource() == countryList){
            countryClicked();
        }
        else if(e.getSource() == stateList && alteringStateList == false){
            stateClicked();
        }
        else if(e.getSource() == submit)
            submitButtonPressed();
    }
    
    // function to perform validation before submitting data into database
    private void submitButtonPressed(){
        nameAns = Name.getText();
        String rollNoStringAns = RollNo.getText();
        fatherAns = FatherName.getText();
        motherAns = MotherName.getText();
        dobAns = Dob.getText();
        emailAns = Email.getText();
        if(male.isSelected())
            genderAns = "Male";
        else
            genderAns = "Female";
            
        aadharAns = AadharCard.getText();
        enrollmentAns = Enrollment.getText();
        addressAns = Address.getText();
        countryAns = (String) countryList.getSelectedItem();
        stateAns = (String) stateList.getSelectedItem();
        cityAns = (String) cityList.getSelectedItem();
        phoneAns = PhoneNo.getText();
        String percentAnsString = Percentage.getText();

        if(nameAns.trim().equals("") || rollNoStringAns.trim().equals("") || fatherAns.trim().equals("") || motherAns.trim().equals("") || dobAns.trim().equals("") || emailAns.trim().equals("") || aadharAns.trim().equals("") || enrollmentAns.trim().equals("") || addressAns.trim().equals("") || countryAns.trim().equals("") || stateList.isEnabled() == false || cityList.isEnabled() == false || phoneAns.trim().equals("") || percentAnsString.trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Fill all details");
            return;
        }

        String emailRegEx = "^[a-zA-Z0-9-_.]+@[a-zA-Z0-9-_.]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(emailAns);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(rootPane, "Wrong email address");
            return;
        }

        pattern = Pattern.compile("[\\d]{16}");
        matcher = pattern.matcher(aadharAns);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(rootPane, "Aadhar number should be 16 digits long");
            return;
        }
        
        pattern = Pattern.compile("[A-Z]{2}[\\d]{6}");
        matcher = pattern.matcher(enrollmentAns);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(rootPane, "Wrong format of enrollment number(it shoudl contain two uppercase letters followed by 6 digits with no spece in between)");
            return;
        }
        
        pattern = Pattern.compile("^[\\d]{10}$");
        matcher = pattern.matcher(phoneAns);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(rootPane, "phone number should be 10 digits long");
            return;
        }
        
        pattern = Pattern.compile("^[0-9][0-9]?(\\.)?[0-9]+$|^100[.0]+$");
        matcher = pattern.matcher(percentAnsString);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(rootPane, "Invalid percentage");
            return;
        }
        
        pattern = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");
        matcher = pattern.matcher(dobAns);
        if(!matcher.find() || !checkDate(dobAns)){
            JOptionPane.showMessageDialog(rootPane, "Invalid Date");
            return;
        }
        
        try{
            rollNoAns = Integer.parseInt(rollNoStringAns);
            percentageAns = Float.parseFloat(Percentage.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please add number where numbers are required");
            return;
        }
        
        insertData();
        
//        System.out.println(nameAns + " " + rollNoAns + " " + fatherAns + " " + motherAns + " " + dobAns + " " + emailAns + " " + aadharAns + " " + enrollmentAns + " " + addressAns + " " + countryAns + " " + stateAns + " " + cityAns + " " + phoneAns + " " + percentageAns);
    }
    
    private void insertData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String link = "jdbc:mysql://localhost:3308/StudentDatabase?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "";
            Connection con = (Connection) DriverManager.getConnection(link, username, password);
            
            // first check for existing unique data
            
            Statement stmt = con.createStatement();
            String sql = "select * from student where RollNo = " + rollNoAns;
            ResultSet results = stmt.executeQuery(sql);
            if(results.isBeforeFirst()){
                results.next();
                if(!modifying){
                    JOptionPane.showMessageDialog(rootPane, "Entered roll no. already exists");
                    return;
                }
                
                else if(!results.getString(2).equals(result.getString(2))){
                    JOptionPane.showMessageDialog(rootPane, "Entered roll no. already exists");
                    return;
                }
            }
            
            sql = "select * from student where email = '" + emailAns + "'";
            results = stmt.executeQuery(sql);
            if(results.isBeforeFirst()){
                results.next();
                if(!modifying){
                    JOptionPane.showMessageDialog(rootPane, "Entered email already exists");
                    return;
                }
                
                else if(!results.getString(6).equals(result.getString(6))){
                    JOptionPane.showMessageDialog(rootPane, "Entered email already exists");
                    return;
                }
            }
            
            sql = "select * from student where AadharCard = '" + aadharAns + "'";
            results = stmt.executeQuery(sql);
            if(results.isBeforeFirst()){
                results.next();
                if(!modifying){
                    JOptionPane.showMessageDialog(rootPane, "Entered aadhar card no.s already exists");
                    return;
                }
                
                else if(!results.getString(8).equals(result.getString(8))){
                    JOptionPane.showMessageDialog(rootPane, "Entered aadhar card no. already exists");
                    return;
                }
            }
            
            sql = "select * from student where Enrollment = '" + enrollmentAns + "'";
            results = stmt.executeQuery(sql);
            if(results.isBeforeFirst()){
                results.next();
                if(!modifying){
                    JOptionPane.showMessageDialog(rootPane, "Entered enrollment no.s already exists");
                    return;
                }
                
                else if(!results.getString(9).equals(result.getString(9))){
                    JOptionPane.showMessageDialog(rootPane, "Entered enrollment no. already exists");
                    return;
                }
            }
            
            
            // insertion of data if duplicate data is not present
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse(dobAns);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            String query = "";
            
            if(modifying){
                query = "update student set name = ?, RollNo = ?, FatherName = ?, Mothername = ?, dob = ?, email = ?, gender = ?, AadharCard = ?, Enrollment = ?, Address = ?, country = ?, state = ?, city = ?, PhoneNo = ?, percentage = ? where RollNo = " + result.getString(2);
            }
            else
                query = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);

            
            statement.setString(1, nameAns);
            statement.setInt(2, rollNoAns);
            statement.setString(3, fatherAns);
            statement.setString(4, motherAns);
            statement.setDate(5, sqlDate);
            statement.setString(6, emailAns);
            statement.setString(7, genderAns);
            statement.setString(8, aadharAns);
            statement.setString(9, enrollmentAns);
            statement.setString(10, addressAns);
            statement.setString(11, countryAns);
            statement.setString(12, stateAns);
            statement.setString(13, cityAns);
            statement.setString(14, phoneAns);
            statement.setFloat(15, percentageAns);
            
//            System.out.println(statement.toString());
            int done = statement.executeUpdate();
            con.close();
            if(modifying){
                if(done > 0)
                    JOptionPane.showMessageDialog(rootPane, "Data has been updated");
                else
                    JOptionPane.showMessageDialog(rootPane, "Error while updating data");
            }
                
            else{
                if(done > 0)
                    JOptionPane.showMessageDialog(rootPane, "Data has been submitted");
                else
                    JOptionPane.showMessageDialog(rootPane, "Error while submitting data");
            }
        }
        catch(Exception e){
//            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Some error occurred");
        }
    }
    
    private boolean checkDate(String date){
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        
        if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day == 31)
                return false;
        }
        else if(month == 2){
            if((year % 4 == 0) && (day > 29))
                return false;
            
            else if((year % 4 != 0) && (day > 28))
                return false;
        }
        return true;
    }
    
    
 // function to show city options when a state is selected
    private void stateClicked(){
        stateAns = (String) stateList.getSelectedItem();
        String cities = "";
        if(countryAns.equals("India")){
            switch (stateAns) {
                case "Rajasthan":
                    {
                        cities = "Jaipur, Jodhpur, Jaisalmer, Bharatpur";
                        break;
                    }
                case "Uttar Pradesh":
                    {
                        cities = "Lucknow, Kanpur, Noida, Mathura";
                        break;
                    }
                case "Maharashtra":
                    {
                        cities = "Mumbai, Pune, Nagpur, Nashik";
                        break;
                    }
                case "Karnataka":
                    {
                        cities = "Bangalore, Mangalore, Hubli, Belgaum";
                        break;
                    }
                default:
                    break;
            }
        }
        else{
            switch (stateAns) {
                case "California":
                    {
                        cities = "Los Angeles, San Diego, San Francisco";
                        break;
                    }
                case "Texas":
                    {
                        cities = "Houston, Dallas, Austin, Texas City";
                        break;
                    }
                case "Florida":
                    {
                        cities = "Miami, Orlando, Tampa, Sarasota, Destin";
                        break;
                    }
                case "Michigan":
                    {
                        cities = "Detroit, Lansing, Ann Arbor, Midland, Flint, Muskegon";
                        break;
                    }
                default:
                    break;
            }
        }
        
        addCityItem(cities);
    }
  
// function that adds all cities of selected state to ciytList combobox
    private void addCityItem(String cities){
        cityList.removeAllItems();
        String allCities[] = cities.split(", ");
        for (String allCitie : allCities) {
            cityList.addItem(allCitie);
        }
        cityList.setEnabled(true);
    }
    
// function to select state names when a particular country is selected
    private void countryClicked(){
        countryAns = (String) countryList.getSelectedItem();
        
        String states;
        if(countryAns.equals("India")){
            states = "Rajasthan, Uttar Pradesh, Maharashtra, Karnataka";
        }   
        else{
            states = "California, Texas, Florida, Michigan";
        }   
        
        addStateItems(states);
    }
    
// function that adds states name of selected country to stateList comboBox
    private void addStateItems(String states){
        alteringStateList = true;
        stateList.removeAllItems();
        String allStates[] = states.split(", ");
        for (String state1 : allStates) {
            stateList.addItem(state1);
        }
        stateList.setEnabled(true);
        cityList.setEnabled(false);
        alteringStateList = false;
    }
    
}
