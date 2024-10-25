
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;





public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation, tfeducation ; 
    JLabel lblempId;
    JButton update, back;
    String empId;
    
    
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel ("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("San Serif", Font.BOLD, 25));
        add(heading);
        
        JLabel lablename = new JLabel ("Name :");
        lablename.setBounds(50, 150, 150 , 30);
        lablename.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablename);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel lablefname = new JLabel ("Fathers Name :");
        lablefname.setBounds(400, 150, 150 , 30);
        lablefname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablefname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        
        JLabel labledob = new JLabel ("Date Of Birth :");
        labledob.setBounds(50, 200, 150 , 30);
        labledob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labledob);
        
        JLabel lbldob =new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel lablesalary = new JLabel ("Salary :");
        lablesalary.setBounds(400, 200, 150 , 30);
        lablesalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablesalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel lableaddress = new JLabel ("Address :");
        lableaddress.setBounds(50, 250, 150 , 30);
        lableaddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lableaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lablephone = new JLabel ("Phone :");
        lablephone.setBounds(400, 250, 150 , 30);
        lablephone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablephone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lableemail = new JLabel ("Email :");
        lableemail.setBounds(50, 300, 150 , 30);
        lableemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lableemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labledeucation = new JLabel ("Higest Education :");
        labledeucation.setBounds(400, 300, 150 , 30);
        labledeucation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labledeucation);
        
        
        
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labledesignation = new JLabel ("Designation :");
        labledesignation.setBounds(50, 350, 150 , 30);
        labledesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labledesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel lableaadhar = new JLabel ("Aadhar Number :");
        lableaadhar.setBounds(400, 350, 150 , 30);
        lableaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(lableaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        JLabel lablemployeeId = new JLabel ("Employee Id :");
        lablemployeeId.setBounds(50, 400, 150 , 30);
        lablemployeeId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablemployeeId);
        
        lblempId = new JLabel ();
        lblempId.setBounds(200, 400, 150 , 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try{
            Conn c = new  Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
        }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        
        add(update);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        

        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== update) {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary ='"+salary+"',address = '"+address+"',phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Home();
            }catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
    
}
