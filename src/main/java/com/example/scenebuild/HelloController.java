package com.example.scenebuild;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HelloController {
    @FXML
    public ComboBox Daysofweek;
    public TextArea text;
    public Button save;
    public ListView list;

    public void initialize() {
        Daysofweek.getItems().add("Sunday");
        Daysofweek.getItems().add("Monday");
        Daysofweek.getItems().add("Tuesday");
        Daysofweek.getItems().add("Wednesday");
        Daysofweek.getItems().add("Thursday");
        Daysofweek.getItems().add("Friday");
        Daysofweek.getItems().add("Saturday");



    }



    public void pickADay() {
        System.out.println("Sam is making progress.");
    }
    public void saveButtonDoSomething() {
        System.out.println("Sam is making MORE progress.");
        // figure out which day to add this task to (for Example: "Friday")
        if (Daysofweek.getSelectionModel().getSelectedItem() != null) {
            String selectedDay = Daysofweek.getSelectionModel().getSelectedItem().toString();
            System.out.println(selectedDay);

            // get the task text (for Example: "Finish this program")
            String typedText = text.getText();
            System.out.println(typedText);


            // put them together (for Example: "Friday : Finish this program);
            String dateAndTask = selectedDay +": " + typedText;

            // Add them to Tasks' listview
            list.getItems().add(dateAndTask);

        }
    }

    public void saveData() throws Exception {
        FileOutputStream fileOut =
                new FileOutputStream("SavedDayList");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<String> Days = new ArrayList<>(list.getItems());
        out.writeObject(Days);
    }

    public void restoreData() throws Exception {

        FileInputStream fileIn = new FileInputStream("SavedDayList");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList templist = (ArrayList)in.readObject();
        ObservableList tempList2 = FXCollections.observableList(templist);
        list.setItems(tempList2);
        in.close();
        fileIn.close();
    }
}


