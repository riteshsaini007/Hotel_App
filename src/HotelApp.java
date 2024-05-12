

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class HotelApp {
    private static final String url = "jdbc:mysql://localhost:3306/hotal_app";
    private static final String username = "root";
    private static final String password = "Myadmin@123";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Booking System");
        JLabel NameLB,emailLB,MobileLB,GenderLB,CheckInLB,CheckOutLB,PaymentLB,AddressLB,BookingID;
        JTextField NameTF,emailTF,MobileTF,GenderTF,CheckInTF,CheckOutTF,PaymentTF,AddressTF;
        JButton BookButton, ClearButton,ExitButton;

        NameLB = new JLabel("Name");
        emailLB = new JLabel("email");
        MobileLB = new JLabel("Mobile");
        GenderLB = new JLabel("Gender");
        CheckInLB = new JLabel("CheckIn");
        CheckOutLB = new JLabel("CheckOut");
        PaymentLB = new JLabel("Payment");
        AddressLB = new JLabel("Address");
        BookingID = new JLabel();

        NameTF = new JTextField();
        emailTF = new JTextField();
        MobileTF = new JTextField();
        GenderTF = new JTextField();
        CheckInTF = new JTextField();
        CheckOutTF = new JTextField();
        PaymentTF = new JTextField();
        AddressTF = new JTextField();

        ClearButton = new JButton("Clear");
        BookButton = new JButton("Book now");
        ExitButton = new JButton("Exit");

        //set  Bounds

        NameLB.setBounds(20,30,100,40);
        emailLB.setBounds(20,70,100,40);
        MobileLB.setBounds(20,110,100,40);
        AddressLB.setBounds(20,150,100,40);
        GenderLB.setBounds(280,30,100,40);
        CheckInLB.setBounds(280,70,100,40);
        CheckOutLB.setBounds(280,110,100,40);
        PaymentLB.setBounds(280,150,100,40);
        BookingID.setBounds(50,300,450,40);



        NameTF.setBounds(120,30,150,30);
        emailTF.setBounds(120,70,150,30);
        MobileTF.setBounds(120,110,150,30);
        AddressTF.setBounds(120,150,150,30);
        GenderTF.setBounds(400,30,150,30);
        CheckInTF.setBounds(400,70,150,30);
        CheckOutTF.setBounds(400,110,150,30);
        PaymentTF.setBounds(400,150,150,30);

        ClearButton.setBounds(50,200,150,45);
        BookButton.setBounds(220,200,150,45);
        ExitButton.setBounds(400,200,150,45);

        frame.add(NameLB);
        frame.add(emailLB);
        frame.add(MobileLB);
        frame.add(AddressLB);
        frame.add(GenderLB);
        frame.add(CheckInLB);
        frame.add(CheckOutLB);
        frame.add(PaymentLB);
        frame.add(BookingID);

        frame.add(NameTF);
        frame.add(emailTF);
        frame.add(MobileTF);
        frame.add(AddressTF);
        frame.add(GenderTF);
        frame.add(CheckInTF);
        frame.add(CheckOutTF);
        frame.add(PaymentTF);


        frame.add(ClearButton);
        frame.add(BookButton);
        frame.add(ExitButton);


        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(600,500);
        frame.setVisible(true);

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //to clear the form
                NameTF.setText("");
                emailTF.setText("");
                AddressTF.setText("");
                MobileTF.setText("");
                CheckInTF.setText("");
                CheckOutTF.setText("");
                PaymentTF.setText("");
                GenderTF.setText("");

            }
        });

        BookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // add the validation of form can't be empty


                if(NameTF.getText().toString().isEmpty() ||
                        emailTF.getText().toString().isEmpty() ||
                        MobileTF.getText().toString().isEmpty()||
                        GenderTF.getText().toString().isEmpty() ||
                        CheckInTF.getText().toString().isEmpty() ||
                        CheckOutTF.getText().toString().isEmpty() ||
                        PaymentTF.getText().toString().isEmpty() ||
                        AddressTF.getText().toString().isEmpty()
                ){
                    BookingID.setText("Please Enter full information");
                }
                else{
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        String sql = "insert into hotel (name,email,mobile,address,gender,checkin,checkout,payment,booking_id) "
                                + "values (?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = connection.prepareStatement(sql);
                        pst.setString(1,NameTF.getText().toString());
                        pst.setString(2,emailTF.getText().toString());
                        pst.setString(3,MobileTF.getText().toString());
                        pst.setString(4,AddressTF.getText().toString());
                        pst.setString(5,GenderTF.getText().toString());
                        pst.setString(6,CheckInTF.getText().toString());
                        pst.setString(7,CheckOutTF.getText().toString());
                        pst.setString(8,PaymentTF.getText().toString());
                        pst.setString(9,BookingID.getText().toString());
                        pst.execute();
                       // pst.setString(10,CheckOutTF.getText().toString());


                        System.out.println("DB is connected");
                    } catch (SQLException ex){
                        throw new RuntimeException(ex + "Not connected");
                    }
                    Random random = new Random();
                    int id = random.nextInt(999999);
                    BookingID.setText("Your Booking is Confirmed and Booking ID "+id);
                }

            }
        });

    }
}
