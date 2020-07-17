package StudentDatabase.gitRepo.StudentDatabaseSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
public class AddStudent {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width = 700;
    int height = 600;
    int leftAlingFirstCol = 50, leftAlignSecondCol = 170;
    int labelWidth = 110, textFieldWidth = 150;

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
        
        JLabel title = new JLabel("Add Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        Student.add(title);
        
        // First row
        JLabel name = new JLabel("Name : ");
        name.setBounds(leftAlingFirstCol, 100, labelWidth, 20);
        Student.add(name);
        
        JTextField Name = new JTextField(10);
        Name.setBounds(leftAlignSecondCol, 100, textFieldWidth, 20);
        Student.add(Name);
        
        JLabel rollno = new JLabel("Roll No. : ");
        rollno.setBounds(350, 100, labelWidth, 20);
        Student.add(rollno);
//        
        JTextField RollNo = new JTextField(10);
        RollNo.setBounds(460, 100, textFieldWidth, 20);
        Student.add(RollNo);
        // First row ends
        
        // Second row
        
        JLabel fathername = new JLabel("Father's Name : ");
        fathername.setBounds(leftAlingFirstCol, 150, labelWidth, 20);
        Student.add(fathername);
        
        JTextField FahterName = new JTextField(10);
        FahterName.setBounds(leftAlignSecondCol, 150, textFieldWidth, 20);
        Student.add(FahterName);
        
        JLabel mothername = new JLabel("Mother's Name : ");
        mothername.setBounds(350, 150, labelWidth, 20);
        Student.add(mothername);
        
        JTextField MotherName = new JTextField(10);
        MotherName.setBounds(460, 150, textFieldWidth, 20);
        Student.add(MotherName);
        
        // Second row ends
        
        // Third row
        
        JLabel dob = new JLabel("DOB(mm/dd/yyyy) : ");
        dob.setBounds(leftAlingFirstCol, 200, labelWidth, 20);
        Student.add(dob);
        
        JTextField Dob = new JTextField(10);
        Dob.setBounds(leftAlignSecondCol, 200, textFieldWidth, 20);
        Student.add(Dob);
        
        JLabel email = new JLabel("Email : ");
        email.setBounds(350, 200, labelWidth, 20);
        Student.add(email);
        
        JTextField Email = new JTextField(10);
        Email.setBounds(460, 200, textFieldWidth, 20);
        Student.add(Email);
        
        // Third row ends
        
        // Fourth row
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(leftAlingFirstCol, 250, labelWidth, 20);
        Student.add(gender);
        
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(200, 250, labelWidth, 20);
        Student.add(male);
        
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(350, 250, labelWidth, 20);
        Student.add(female);
        
        ButtonGroup genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        
        // Fourth row ends
        
        // Fifth row
        
        JLabel aadharcard = new JLabel("Aadhar Card : ");
        aadharcard.setBounds(leftAlingFirstCol, 300, labelWidth, 20);
        Student.add(aadharcard);
        
        JTextField AadharCard = new JTextField(10);
        AadharCard.setBounds(leftAlignSecondCol, 300, textFieldWidth, 20);
        Student.add(AadharCard);
        
        JLabel enrollment = new JLabel("Enrollment No. : ");
        enrollment.setBounds(350, 300, labelWidth, 20);
        Student.add(enrollment);
        
        JTextField Enrollment = new JTextField(10);
        Enrollment.setBounds(460, 300, textFieldWidth, 20);
        Student.add(Enrollment);
        
        // Fifth row ends
        
        // Sixth row
        
        JLabel address = new JLabel("Address : ");
        address.setBounds(leftAlingFirstCol, 350, labelWidth, 20);
        Student.add(address);
        
        JTextField Address = new JTextField(150);
        Address.setBounds(leftAlignSecondCol, 350, 400, 20);
        Student.add(Address);
        
        // Sixth row ends
        
        // Seventh row
        
        JLabel country = new JLabel("Country");
        country.setBounds(leftAlingFirstCol, 400, 80, 20);
        Student.add(country);
        
        String countries[] = {"India", "USA", "Britain", "Canada", "Russia"};
        JComboBox countryList = new JComboBox(countries);
        countryList.setBounds(140, 400, 80, 20);
//        countryList.setEnabled(false);
        Student.add(countryList);
        
        JLabel state = new JLabel("Country");
        state.setBounds(230, 400, 80, 20);
        Student.add(state);
        
        JComboBox stateList = new JComboBox();
        stateList.setBounds(320, 400, 80, 20);
        stateList.setEnabled(false);
        Student.add(stateList);
        
        JLabel city = new JLabel("City");
        city.setBounds(410, 400, 80, 20);
        Student.add(city);
        
        JComboBox cityList = new JComboBox();
        cityList.setBounds(500, 400, 80, 20);
        cityList.setEnabled(false);
        Student.add(cityList);
        
        
        
        
        
    }
    
    public static void main(String args[]){
        new AddStudent();
    }
    
}
