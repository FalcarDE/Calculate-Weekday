# Calculate-Weekday
In this Project I tried to make a GUI, which allowed you to find out a certain Weekday from Day, Month and Year.


The GUI is very simple (maybe poorly) design, but in it works fine. I used Java Swing Libary and the AWT toolkit. 

This is how the GUI look likes:

![Screenshot_20210225_112840](https://user-images.githubusercontent.com/63967790/109140251-b0b0b780-775c-11eb-8800-e8f68ea0e3e9.png)
 
If you insert a correct Day, Month and Year in the Textfield and press the yello button "Evaluate the Weekday!". The programm will print the Weekday in the Textfield under the button.

![Screenshot_20210225_113417](https://user-images.githubusercontent.com/63967790/109140995-7eec2080-775d-11eb-8bd1-f54d66dc1e4a.png)

The JFrame Window 

The first thing i did, was to create 2 classes. The first class in the DayWeekYearFrame which will initialize the Application Window. I used the inheritance of the JFrame class, which is from the Java Swing Libary and the abstract class ActionListener. 

This was my first idea how to create my JFrame - Window Application. 

![Screenshot_20210225_115738](https://user-images.githubusercontent.com/63967790/109143777-af818980-7760-11eb-869f-a6a4f4b047b5.png)

The important part is to connect the JLabel, JTextField and JButton to the JPanel. The JPanel will be added to the Window Pane.

