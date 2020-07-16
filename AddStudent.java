package StudentDatabase.gitRepo.StudentDatabaseSystem;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
public class AddStudent {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Screenwidth = (int) screenSize.getWidth();
    int ScreenHeight = (int) screenSize.getHeight();
    
    int width = 700;
    int height = 600;

    public AddStudent() {
        createFrame();    
    }
    
    private void createFrame(){
        JFrame Student = new JFrame("Add new Student");
        // comment following line before running main program
        Student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Add Student Information", SwingConstants.CENTER);
        title.setBounds(50, 10, width - 100, 80);
        title.setFont(new Font("", Font.PLAIN, 30));
        
        Student.add(title);
        
        JLabel name = new JLabel("Name : ");
        name.setBounds(50, 100, 100, 20);
        
//        JTextField Name = new JTextField(10);
//        Name.setBounds(160, 100, 150, 20);
//        
//        JLabel rollNo = new JLabel("Roll No : ");
//        rollNo.setBounds(380, 100, 100, 20);
//        
//        JTextField RollNo = new JTextField(10);
//        Name.setBounds(480, 100, 150, 20);
        
        Student.add(name);
//        add.add(Name);
//        add.add(rollNo);
//        add.add(RollNo);
        

        Student.setVisible(true);
        Student.setSize(width, height);
        Student.setLayout(null);
        Student.revalidate();
//        add.pack();
    }
    
    public static void main(String args[]){
        new AddStudent();
    }
    
}
