package StudentDatabase.gitRepo.StudentDatabaseSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddStudent implements ActionListener{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width = 700;
    int height = 600;
    int leftAlingFirstCol = 50, leftAlignSecondCol = 170;
    int labelWidth = 110, textFieldWidth = 150;
    
    JLabel title,name, rollno, fathername, mothername, dob, email, gender, aadharcard, enrollment, address;
    JLabel country, state, city, phoneno, percentage;
    JTextField Name, RollNo, FatherName, MotherName, Dob, Email, Gender, AadharCard, Enrollment, Address;
    JTextField PhoneNo, Percentage;
    JRadioButton male, female;
    ButtonGroup genders;
    JComboBox countryList, stateList, cityList;
    JButton submit;
    
    int rollNoAns, enrollmentAns, phoneAns, percentageAns;
    String nameAns, fatherAns, motherAns, dobAns, emailAns, genderAns, aadharAns;
    String countryAns, stateAns, cityAns, addressAns;

    public AddStudent() {
        createFrame();    
    }
    
    private void createFrame(){
        JFrame Student = new JFrame("Add new Student");
        Student.setVisible(true);
        Student.setSize(width, height);
        Student.setLayout(null);
        
        // comment following line before running main program
        Student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JLabel("Add Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        Student.add(title);
        
        // First row
        name = new JLabel("Name : ");
        name.setBounds(leftAlingFirstCol, 100, labelWidth, 20);
        Student.add(name);
        
        Name = new JTextField(10);
        Name.setBounds(leftAlignSecondCol, 100, textFieldWidth, 20);
        Student.add(Name);
        
        rollno = new JLabel("Roll No. : ");
        rollno.setBounds(350, 100, labelWidth, 20);
        Student.add(rollno);
//        
        RollNo = new JTextField(10);
        RollNo.setBounds(460, 100, textFieldWidth, 20);
        Student.add(RollNo);
        // First row ends
        
        // Second row
        
        fathername = new JLabel("Father's Name : ");
        fathername.setBounds(leftAlingFirstCol, 150, labelWidth, 20);
        Student.add(fathername);
        
        FatherName = new JTextField(10);
        FatherName.setBounds(leftAlignSecondCol, 150, textFieldWidth, 20);
        Student.add(FatherName);
        
        mothername = new JLabel("Mother's Name : ");
        mothername.setBounds(350, 150, labelWidth, 20);
        Student.add(mothername);
        
        MotherName = new JTextField(10);
        MotherName.setBounds(460, 150, textFieldWidth, 20);
        Student.add(MotherName);
        
        // Second row ends
        
        // Third row
        
        dob = new JLabel("DOB(mm/dd/yyyy) : ");
        dob.setBounds(leftAlingFirstCol, 200, labelWidth, 20);
        Student.add(dob);
        
        Dob = new JTextField(10);
        Dob.setBounds(leftAlignSecondCol, 200, textFieldWidth, 20);
        Student.add(Dob);
        
        email = new JLabel("Email : ");
        email.setBounds(350, 200, labelWidth, 20);
        Student.add(email);
        
        Email = new JTextField(10);
        Email.setBounds(460, 200, textFieldWidth, 20);
        Student.add(Email);
        
        // Third row ends
        
        // Fourth row
        
        gender = new JLabel("Gender");
        gender.setBounds(leftAlingFirstCol, 250, labelWidth, 20);
        Student.add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 250, labelWidth, 20);
        Student.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(350, 250, labelWidth, 20);
        Student.add(female);
        
        genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        
        // Fourth row ends
        
        // Fifth row
        
        aadharcard = new JLabel("Aadhar Card : ");
        aadharcard.setBounds(leftAlingFirstCol, 300, labelWidth, 20);
        Student.add(aadharcard);
        
        AadharCard = new JTextField(10);
        AadharCard.setBounds(leftAlignSecondCol, 300, textFieldWidth, 20);
        Student.add(AadharCard);
        
        enrollment = new JLabel("Enrollment No. : ");
        enrollment.setBounds(350, 300, labelWidth, 20);
        Student.add(enrollment);
        
        Enrollment = new JTextField(10);
        Enrollment.setBounds(460, 300, textFieldWidth, 20);
        Student.add(Enrollment);
        
        // Fifth row ends
        
        // Sixth row
        
        address = new JLabel("Address : ");
        address.setBounds(leftAlingFirstCol, 350, labelWidth, 20);
        Student.add(address);
        
        Address = new JTextField(150);
        Address.setBounds(leftAlignSecondCol, 350, 400, 20);
        Student.add(Address);
        
        // Sixth row ends
        
        // Seventh row
        
        country = new JLabel("Country");
        country.setBounds(leftAlingFirstCol, 400, 80, 20);
        Student.add(country);
        
        String countries[] = {"India", "USA"};
        countryList = new JComboBox(countries);
        countryList.setBounds(140, 400, 80, 20);
        Student.add(countryList);
        countryList.addActionListener(this);
        
        state = new JLabel("State");
        state.setBounds(260, 400, 50, 20);
        Student.add(state);
        
        stateList = new JComboBox();
        stateList.setBounds(320, 400, 80, 20);
        stateList.setEnabled(false);
        Student.add(stateList);
        stateList.addActionListener(this);
        
        city = new JLabel("City");
        city.setBounds(440, 400, 50, 20);
        Student.add(city);
        
        cityList = new JComboBox();
        cityList.setBounds(500, 400, 80, 20);
        cityList.setEnabled(false);
        Student.add(cityList);
        
        // Seventh row ends
        
        // eighth row 
        
        phoneno = new JLabel("Phone No. : ");
        phoneno.setBounds(leftAlingFirstCol, 450, labelWidth, 20);
        Student.add(phoneno);
        
        PhoneNo = new JTextField(10);
        PhoneNo.setBounds(leftAlignSecondCol, 450, textFieldWidth, 20);
        Student.add(PhoneNo);
        
        percentage = new JLabel("Percentage : ");
        percentage.setBounds(350, 450, labelWidth, 20);
        Student.add(percentage);
        
        Percentage = new JTextField(10);
        Percentage.setBounds(460, 450, textFieldWidth, 20);
        Student.add(Percentage);
        
        //eighth row ends
        
        submit = new JButton("Submit");
        submit.setBounds(300, 500, 100, 30);
        Student.add(submit);
        submit.addActionListener(this);
    }
    
    public static void main(String args[]){
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == countryList)
            countryClicked();
        else if(e.getSource() == stateList)
            stateClicked();
        else if(e.getSource() == submit)
            submitButtonPressed();
    }
    
    private void submitButtonPressed(){
        nameAns = name.getText();
        rollNoAns = Integer.parseInt(rollno.getText());
        fatherAns = FatherName.getText();
        motherAns = MotherName.getText();
        dobAns = Dob.getText();
        emailAns = Email.getText();
        if(male.isSelected())
            genderAns = "Male";
        else
            genderAns = "Female";
        aadharAns = AadharCard.getText();
        enrollmentAns = Integer.parseInt(Enrollment.getText());
        addressAns = Address.getText();
        countryAns = (String) countryList.getSelectedItem();
        stateAns = (String) stateList.getSelectedItem();
        cityAns = (String) stateList.getSelectedItem();
        phoneAns = Integer.parseInt(PhoneNo.getText());
        percentageAns = Integer.parseInt(Percentage.getText());
    }
    
    private void stateClicked(){
        stateAns = (String) stateList.getSelectedItem();
        if(countryAns == "India"){
            if(stateAns == "Rajasthan"){
                String cities[] = {"Jaipur", "Jodhput", "Jaisalmer", "Bharatput"};
                addCityItem(cities);                
            }
            
            else if(stateAns == "Uttar Pradesh"){
                String cities[] = {"Lucknow", "Kanpur", "Noida", "Mathura"};
                addCityItem(cities);
            }
            
            else if(stateAns == "Maharashtra"){
                String cities[] = {"Mumbai", "Pune", "Nagpur", "Nashik", "Aurangabad"};
                addCityItem(cities);
            }
            
            else if(stateAns == "Karnataka"){
                String cities[] = {"Bangalore", "Mangalore", "Hubli", "Belgaum"};
                addCityItem(cities);
            }
        }
        else{
            if(stateAns == "California"){
                String cities[] = {"Los Angeles", "San Diego", "San Francisco"};
                addCityItem(cities);
            }
            else if(stateAns == "Texas"){
                String cities[] = {"Houston", "Dallas", "Austin", "Texas City"};
                addCityItem(cities);
            }
            else if(stateAns == "Florida"){
                String cities[] = {"Miami", "Orlando", "Tampa", "Sarasota", "Destin"};
                addCityItem(cities);
            }
            else if(stateAns == "Michigan"){
                String cities[] = {"Detroit", "Lansing", "Ann Arbor", "Midland", "Flint", "Muskegon"};
                addCityItem(cities);
            }
        }
    }
  
    private void addCityItem(String cities[]){
        cityList.removeAllItems();
        for(int i = 0; i<cities.length; i++){
            cityList.addItem(cities[i]);
        }
        cityList.setEnabled(true);
    }
    
    private void countryClicked(){
        countryAns = (String) countryList.getSelectedItem();
        
        if(countryAns == "India"){
            String states[] = {"Rajasthan", "Uttar Pradesh", "Maharashtra", "Karnataka"};
            addStateItems(states);
        }   
        else{
            String states[] = {"California", "Texas", "Florida", "Michigan"};
            addStateItems(states);
        }   
    }
    
    private void addStateItems(String states[]){
        stateList.removeAllItems();
        for(int i = 0; i<states.length; i++){
            stateList.addItem(states[i]);
        }
        stateList.setEnabled(true);
        cityList.setEnabled(false);
    }
    
}
