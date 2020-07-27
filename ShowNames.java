package StudentDatabase.gitRepo.StudentDatabaseSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
public class ShowNames extends JFrame implements ActionListener {
    int width, height;
    Point loc;
    ResultSet result;
    Vector<JButton> names = new Vector();
    Vector<JLabel> rollNumbers = new Vector();
    int size  = 0;
    boolean resultExists = false;

    public ShowNames(Point loc, int width, int height, ResultSet results){
        this.width = width;
        this.height = height;
        this.loc = loc;
        result = results;
        CreateFrame();
    }
    
    public void CreateFrame(){
        try {
            setLayout(null);
//        getContentPane().setLayout(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);

            final JScrollPane scrollPanel = new JScrollPane(
                    mainPanel,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
            );
            scrollPanel.setBounds(0, 0, 480, 250);
            getContentPane().add(scrollPanel);
            
            JLabel sn = new JLabel("S.No.");
            sn.setBounds(20, 20, 100, 30);
            mainPanel.add(sn);
            
            JLabel Nameheading = new JLabel("Name");
            Nameheading.setBounds(130, 20, 100, 30);
            mainPanel.add(Nameheading);
            
            JLabel rollNoHeading = new JLabel("Roll No");
            rollNoHeading.setBounds(260, 20, 100, 30);
            mainPanel.add(rollNoHeading);
            
            
            int initialHeight = 80;
            while(result.next()){
                size++;
                String name = result.getString(1);
                names.add(new JButton(name));
                String rollno = result.getString(2);
                rollNumbers.add(new JLabel(rollno));
                
                sn = new JLabel("" + size);
                sn.setBounds(20, initialHeight + 5, 60, initialHeight + 10);
                sn.setSize(60, 20);
//                System.out.println(sn.getBounds());
//                Border border = BorderFactory.createLineBorder(Color.blue, 2);
//                sn.setBorder(border);
                mainPanel.add(sn);
                
                names.get(size - 1).setBounds(100, initialHeight, 150, initialHeight + 30);
                names.get(size - 1).setSize(100, 30);
                names.get(size - 1).setBackground(Color.WHITE);
                names.get(size - 1).addActionListener((ActionListener) this);
//                System.out.println(names.get(size - 1).getBounds());
                mainPanel.add(names.get(size - 1));
                
                rollNumbers.get(size - 1).setBounds(270, initialHeight + 5, 150, initialHeight + 30);
                rollNumbers.get(size-1).setSize(100, 20);
                mainPanel.add(rollNumbers.get(size - 1));
//                System.out.println(rollNumbers.get(size - 1).getBounds());
                
                initialHeight += 40;
            }

            int height = ((initialHeight > 250) ? initialHeight : 250);
            mainPanel.setPreferredSize(new Dimension(450, height));

            setSize(500, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(loc);
            setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Some error occurred");
        }
        
        
    }
    
    public static void main(String args[]){
//        new ShowNames();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rollNumber;
        int i;
        for(i = 0; i<size; i++){
            if(e.getSource() == names.get(i)){
                break;
            }
        }
        
        rollNumber = rollNumbers.get(i).getText();
        getData(rollNumber);
        if(resultExists)
        try {
            new ShowFetchedData(loc, result, width, height);
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Some error occured");
        }
        
    }
    
    private void getData(String data){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String link = "jdbc:mysql://localhost:3308/StudentDatabase?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(link, username, password);
            String sql = "";
            sql = "select * from student where RollNo = " + data;
                
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(sql);
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(rootPane, "No student from Provided roll no.");
                return;
            }
            else{
                resultExists = true;
            }
        }
        catch(Exception e){
//            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Some error occurred while connecting to database");
        }
    }
    
}
