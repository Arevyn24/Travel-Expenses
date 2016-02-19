/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelexpenses; 

//items needed to import to make this program do what it needs to do
import java.awt.*; 
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Zachary Murphy
 */
public class TravelExpenses extends JFrame{
    

    //info for labels
    private JLabel daysOnTrip; //label 
    private JLabel carRental; //label
    private JLabel airfair; //label
    private JLabel parkingFees; //label
    private JLabel taxiFees; //label
    private JLabel milesDriven; //label
    private JLabel conReg; //label
    private JLabel lodgingNightCharges; //label

    //reference panel obs
    private JPanel travelInfo;
    private JPanel buttonP;

    //info from fields of texts set as private variables 
    private JTextField daysOnTripText; //textfield 
    private JTextField carRentalText; //text field
    private JTextField airfairText; //text field
    private JTextField parkingFeesText; //text field
    private JTextField taxiFeesText; // text field
    private JTextField milesDrivenText; //text field
    private JTextField conRegText; //text field
    private JTextField lodgingNightChargesText; //test field

    //buttons that will be used to function 
    private JButton calculate; //will be used to calculate informaiton that the user enters when clicked
    private JButton reset; // will be used to reset the fields as needed when clicked

    //constants as specified  
    private double mealsCost = 37.00; //per day for meals
    private double parkingFeesAmount = 10.00; // up to 10 per day
    private double taxiFeesAmount = 20.00; // up to 20 per day
    private double lodgingChargesAmount = 95.00; // up to 95 a day
    private double mileAmount = 0.27; //per mile driven

    /**
     * Constructor  for TravelExpenses
     * @param args
     */

    public TravelExpenses(){
        //JFrame title called
        super("Travel Expenses");

        //center of desktop placement
        setLocationRelativeTo(null);

        //Close button will do this..
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //border layout mgr cp
        setLayout(new BorderLayout());

        //TravelInfo&Buttons
        buildTravelInfoPanel();
        buildButton();

        // get panels to frame content
        add(travelInfo, BorderLayout.CENTER);
        add(buttonP, BorderLayout.SOUTH);

        //window content display
        pack();
        setVisible(true);
    }
    /*
    This will build the travel info panel what the user sees next to the text box (label)
    */
    private void buildTravelInfoPanel(){
        //field labels made APPLIES TO BELLOW
        daysOnTrip = new JLabel("Number of days for trip.");
        airfair = new JLabel("Airfair Amount: ");
        carRental = new JLabel ("Car Rental Cost Amount: ");
        milesDriven = new JLabel ("Mile Driven: ");
        parkingFees = new JLabel ("Parking Fees: ");
        taxiFees = new JLabel ("Taxi Fees: ");
        conReg = new JLabel ("Conference Registration Cost: ");
        lodgingNightCharges =  new JLabel ("Lodging Charges per Night: ");

        //text boxes for input from user APPLIES TO BELLOW
        daysOnTripText = new JTextField(3);
        carRentalText = new JTextField(8);
        airfairText = new JTextField(8);
        parkingFeesText = new JTextField(6);
        taxiFeesText = new JTextField(6);
        milesDrivenText = new JTextField(4);
        conRegText = new JTextField(8);
        lodgingNightChargesText = new JTextField(6);

        //panel for labels/text
        travelInfo = new JPanel();


        //Grid for 10 r and 2 c
        travelInfo.setLayout(new GridLayout(10,2));



        //labels and text for panel made for their according variable as it functions in this program APPLIES TO BELLOW
        travelInfo.add(daysOnTrip);
        travelInfo.add(daysOnTripText);
        travelInfo.add(airfair);
        travelInfo.add(airfairText);
        travelInfo.add(carRental);
        travelInfo.add(carRentalText);
        travelInfo.add(milesDriven);
        travelInfo.add(milesDrivenText);
        travelInfo.add(parkingFees);
        travelInfo.add(parkingFeesText);
        travelInfo.add(taxiFees);
        travelInfo.add(taxiFeesText);
        travelInfo.add(conReg);
        travelInfo.add(conRegText);
        travelInfo.add(lodgingNightCharges);
        travelInfo.add(lodgingNightChargesText);


    }

    /**
     * buildButton is method that adds reset and calc buttons to main panel
     * @param args
     */

    /*
    builds both calculate and reset
    */
    private void buildButton(){
        //caclulation button

        calculate = new JButton("Calculate");

        //event listiner for calculation
        calculate.addActionListener(new CalculateListener());

        //reste button

        reset = new JButton("Reset");

        //event listiner for reset
        reset.addActionListener(new ResetListener());

        //button panels new panel
        buttonP = new JPanel();

        //buttons 
        buttonP.add(reset, BorderLayout.WEST); //declaring location of reset button
        buttonP.add(calculate, BorderLayout.CENTER); //declaring location of calculate button





    }

    /**
     * CalculateListener will  do event for calculate button
     *
     * @param args
     */

    private class CalculateListener implements ActionListener{
        //vars for everything that gets calculated
        String input;
        int days;
        double air;
        double miles;
        double carRental;
        double conReg;
        double lodging;
        double parking;
        double meals;
        double taxi;

        /*
        this works with the implements ActionListener above
        */
        public void actionPerformed(ActionEvent e){
            //vars
            //total expenses
            double actualExpenses;
            //milage
            double milesExpenses;
            //allowable totoal
            double allowed;
            
            //extra airfair
            double exAirfair;
            //extra carRental 
            double exCarRen;
            //extra car parking
            double exParking;
            //extra taxi fees
            double exTaxi;
            //extra lodging fees
            double exLodge;
            //over total of ex's
            double overTotal;
            //savings
            double savings;
            //what company pays you 
            double reimb;

            //dec format implement
            DecimalFormat money = new DecimalFormat("$#,###.00");
        }
        //get info from text fields
        private void getInfo(){
            //gets each variable as indicated from the text variable calling the getText method
            days = Integer.parseInt(daysOnTripText.getText());
            air = Double.parseDouble(airfairText.getText());
            carRental = Double.parseDouble(carRentalText.getText());
            miles = Double.parseDouble(milesDrivenText.getText());
            parking = Double.parseDouble(parkingFeesText.getText());
            taxi = Double.parseDouble(parkingFeesText.getText());
            conReg = Double.parseDouble(conRegText.getText());
            lodging = Double.parseDouble(lodgingNightChargesText.getText());

        }
        //figure out expenses
        private void calcActualExpenses(double actualExpenses, double milesExpenses){
            //calculates actual expenses
            actualExpenses = air + carRental + parking + taxi + conReg + lodging;
            //calculates miles driven
            milesExpenses = miles * mileAmount;
            //new actual expenses with miles driven
            actualExpenses = actualExpenses + milesExpenses;



            //display total
            //THIS IS WHAT ISN'T WORKING WHEN YOU CLICK CALCULATE
          JOptionPane.showMessageDialog(null, "Total expenses: " + actualExpenses + 
                  "Allowables expenses: "  +
                   "Amount to be paid back: ");
            

        }


    }

    //this handles reset button
    private class ResetListener implements ActionListener{
        /*
        applies to actionListener
        */
        public void actionPerformed(ActionEvent e){
            
            //upon reset each of these will reset accodring variable 
            daysOnTripText.setText("");
            airfairText.setText("");
            carRentalText.setText("");
            milesDrivenText.setText("");
            parkingFeesText.setText("");
            taxiFeesText.setText("");
            conRegText.setText("");
            lodgingNightChargesText.setText("");
        }
    }

/*
    main program
    */
    public static void main(String[] args) {
       //creating new travel expense to open gui app
        new TravelExpenses();
    }

}