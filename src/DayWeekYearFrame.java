import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.DimensionUIResource;


public class DayWeekYearFrame extends JFrame implements ActionListener  {
    Container WindowPane;
    private JLabel Header_Label, Date_Label, Month_Label, Year_Label, Solution_Label;
    private TextField Date_TextField, Month_TextField, Year_Textfield;
    private JButton Calculate_Button;
    private JPanel Header_Panel, Date_Panel, Month_Panel, Year_Panel, Solution_Panel, Calculate_Panel;

    private int Input_Year [];
    private int lastNumberofValue, day , month , weekday, year;
    private int lastValueIndex_1 , lastValueIndex_2;
    private String Weekdays []= {"Saturday","Sunday", "Monday","Tuesday", "Wendnesday", "Thursday", "Freitag"};


    public DayWeekYearFrame()
    {
        WindowPane = getContentPane();
        WindowPane.setLayout(new FlowLayout());

        /*
        |---Headerlabel-------------------------| --> |---Headerlabel-----------|
        |---Date_Label---Date_TextField---------| --> |---Date_Panel------------|
        |---Month_label--Month_TextField--------| --> |---Month_Panel-----------|
        |---Year_label----Year_TextField--------| --> |---Year_Panel------------|
        |---Calculate_Button--------------------| --> |---Calculate_Panel-------|
        |---Solution_Label----------------------| --> |---Solution_Panel--------|
         */
        Header_Label = new JLabel("Determination of Weekday",SwingConstants.CENTER);
        Header_Label.setOpaque(true);
        Header_Label.setBackground(Color.cyan);
        Header_Label.setFont(new Font("Arial", Font.BOLD, 35));

        Date_Label = new JLabel("Please enter the Date: ", SwingConstants.CENTER);
        Date_Label.setOpaque(true);
        Date_Label.setBackground(Color.white);
        Date_Label.setFont(new Font("Arial", Font.BOLD, 25));

        Month_Label = new JLabel("Please enter the Month: ", SwingConstants.CENTER);
        Month_Label.setOpaque(true);
        Month_Label.setBackground(Color.white);
        Month_Label.setFont(new Font("Arial", Font.BOLD, 25));

        Year_Label = new JLabel("Please enter the Year: ", SwingConstants.CENTER);
        Year_Label.setOpaque(true);
        Year_Label.setBackground(Color.white);
        Year_Label.setFont(new Font("Arial", Font.BOLD, 25));

        Solution_Label = new JLabel("--", SwingConstants.CENTER);
        Solution_Label.setOpaque(true);
        Solution_Label.setBackground(Color.white);
        Solution_Label.setPreferredSize(new DimensionUIResource(500, 25));
        Solution_Label.setFont(new Font("Arial", Font.BOLD, 25));


        Date_TextField = new TextField("",  SwingConstants.CENTER);
        Date_TextField.setPreferredSize (new DimensionUIResource(100, 25));
        Date_TextField.setFont(new Font("Arial", Font.BOLD, 25));

        Month_TextField = new TextField("", SwingConstants.CENTER);
        Month_TextField.setPreferredSize(new DimensionUIResource(100, 25));
        Month_TextField.setFont(new Font("Arial", Font.BOLD, 25));

        Year_Textfield = new TextField("", SwingConstants.CENTER);
        Year_Textfield.setPreferredSize(new DimensionUIResource(100, 25));
        Year_Textfield.setFont(new Font("Arial", Font.BOLD, 25));


        //Creating the Calculate Button
        Calculate_Button= new JButton("Evaluate the Weekday!");
        Calculate_Button.addActionListener(this);
        Calculate_Button.setOpaque(true);
        Calculate_Button.setBackground(Color.ORANGE);
        Calculate_Button.setFont(new Font("Arial", Font.BOLD, 30));

        /*
        Creating Panel as the Explanation in the "picture":

        |---Headerlabel-------------------------| --> |---Headerlabel-----------|
        |---Date_Label---Date_TextField---------| --> |---Date_Panel------------|
        |---Month_label--Month_TextField--------| --> |---Month_Panel-----------|
        |---Year_label----Year_TextField--------| --> |---Year_Panel------------|
        |---Calculate_Button--------------------| --> |---Calculate_Panel-------|
        |---Solution_Label----------------------| --> |---Solution_Panel--------|

         */

        Header_Panel    = new JPanel();
        Date_Panel      = new JPanel();
        Month_Panel     = new JPanel();
        Year_Panel      = new JPanel();
        Calculate_Panel = new JPanel();
        Solution_Panel  = new JPanel();


        /* Adding the JLabel and Textfield to the JPanel */

        Header_Panel.add(Header_Label);

        Date_Panel.add(Date_Label);
        Date_Panel.add(Date_TextField);

        Month_Panel.add(Month_Label);
        Month_Panel.add(Month_TextField);

        Year_Panel.add(Year_Label);
        Year_Panel.add(Year_Textfield);

        Calculate_Panel.add(Calculate_Button);
        Solution_Panel.add(Solution_Label);


        WindowPane.add(Header_Panel);
        WindowPane.add(Date_Panel);
        WindowPane.add(Month_Panel);
        WindowPane.add(Year_Panel);;
        WindowPane.add(Calculate_Panel);
        WindowPane.add(Solution_Panel);

    }

    @Override
    public void actionPerformed(ActionEvent CalculateEvent)
    {


        /*
                                            parseInt
        |----- Date_TextField (String) -----| --> |----- day    (int) ------|
        |----- Month_TextField(String) -----| --> |----- month  (int) ------|
        |----- Year_Textfield (String) -----| --> |----- year   (int) ------|
         */

        day = Integer.parseInt(Date_TextField.getText());
        month = Integer.parseInt(Month_TextField.getText());
        year = Integer.parseInt(Year_Textfield.getText());

//--------------------------------------------------------------------------------------------------
        /*
                                      FormatStringToArray
        |----- Year_Textfield (String) -----| --> |----- Array: Intput_Year[] ------|

        Example:

        String TextField pYear = 2001 --> '2' '0' '0' '1' has a length of 4
                                    Index: 0   1   2   3
                                        |
                                        |
                                        v

        for (int Index = 0; Index < pYear_String.length(); Index++) {
            Input_Year[Index] = pYear_String.charAt(Index) - '0';
        }

        String.charAt(Index) is a method that returns the character at the specified index in a string
        ! Minus '0' means the first Char Index does not count !

                                        |
                                        |
                                        |
                                        v

                                 Input_Year[1] = '0';
                                 Input_Year[2] = '0';
                                 Input_Year[3] = '1';

         !!! BIG ATTENTION: THOSE Input_Year[Index] Values have CHARACTER like '0' THE COMPILER WILL
                            COVERT THIS TO THE NUMBER 48 (ASCII - Converting) !!!

         Solution:
         Use this int[] Input_Year Array and covert all the Character Values into Integer Value
         with " Integer.parseInt "!

        */


        String Year_String = Year_Textfield.getText();
        Input_Year = DayWeekYearCalc.FormatStringToArray(Year_String);



//--------------------------------------------------------------------------------------------------

        lastValueIndex_1 = Input_Year[2];
        lastValueIndex_2 = Input_Year[3];
        
        /*
        Array: Input_Year [] = new Input_Year{ '2', '0' ,'0' ,'1' } ATTENTION: CHARACTER/String --> ASCII INT
        
        Example:        { '2' '0' '0' '1' }
                   Index:  0   1   2   3
                   
        lastValueIndex_1 = Input_Year [2] = '0'
        lastValueIndex_2 = Input_Year [3] = '1'
        */



        lastNumberofValue = Integer.parseInt(String.valueOf(lastValueIndex_1) + String.valueOf(lastValueIndex_2));
        /*                                    String Array [-----------String {'0', '1' }----------------------]
                                                              |                                 |
                                                              |                                 |
                                                              v                                 V
                                    Covert ASCII char/String LastValueIndex_1 to         Covert ASCII char/String LastValueIndex_2 to
                                         int lastNumberofValue                            int lastNumberofValue
                                                              |---------------------------------|
                                                                                |
                                                                                v
                                                                        Integer.parseInt
                                                                  Converting String to an Integer

        */




        lastNumberofValue = DayWeekYearCalc.Evaluation_LastNumberOfValue(day, month, year, lastNumberofValue);



        lastNumberofValue = DayWeekYearCalc.Evaluation_LastNumberOfValue(Input_Year, lastNumberofValue);

        weekday           = DayWeekYearCalc.Weekday_Calculation(lastNumberofValue);

        Get_WeekDay();
    }





    private void Get_WeekDay()
    {
        if (weekday == 0){
            Solution_Label.setText("Der " + day+ "." + month + "." + year + " ist ein " + Weekdays[0] + " !");
        }

        else if(weekday == 1){
            Solution_Label.setText("Der " + day+ "." + month + "." + year  + " ist ein " + Weekdays[1]+ " !");
        }
        else if(weekday == 2){
            Solution_Label.setText("Der " + day+ "." + month + "." + year  + " ist ein "+   Weekdays[2]+ " !");
        }
        else if(weekday == 3){
            Solution_Label.setText("Der " + day+ "." + month + "." + year  + " ist ein " +  Weekdays[3]+ " !");
        }
        else if(weekday == 4){
            Solution_Label.setText("Der " + day+ "." + month + "." + year + " ist ein "+   Weekdays[4]+ " !");
        }
        else if(weekday == 5){
            Solution_Label.setText("Der " + day+ "." + month + "." + year  + " ist ein "  + Weekdays[5]+ " !");
        }
        else if(weekday == 6){
            Solution_Label.setText("Der " + day+ "." + month + "." + year  + " ist ein "  + Weekdays[6]+ " !");
        }

        else
        {
            Solution_Label.setText("Bitte Prüfen Sie ihren Daten, Sie haben einen Tag/Monat/Jahr nicht richtig eingegeben.");
        }

    }
    

    public static void main(String[] args)
    {
       DayWeekYearFrame Window = new DayWeekYearFrame();
        Window.getContentPane(); 
        Window.setTitle("Ermittlung des Wochentages");
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setSize(650, 450);
        Window.setResizable(false);
        Window.setVisible(true);
    }

}
