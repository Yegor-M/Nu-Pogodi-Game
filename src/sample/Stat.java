package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Stat {
    public Stat() {

    }

    public void save(ObservableList<String> records) {
        try {
            FileWriter myWriter = new FileWriter("records.txt");
            for (String record : records) {
                myWriter.write(record + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> get() {
        ObservableList<String> new_records = FXCollections.observableArrayList();
        try {
            File myObj = new File("records.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                new_records.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ListView<String> records = new ListView<String>(new_records);
        records.setLayoutX(150);
        records.setLayoutY(100);
        records.setMinSize(400,300);
        return new_records;
    }

    public ListView<String> records(ObservableList<String> new_records) {
        ListView<String> records = new ListView<String>(new_records);
        records.setLayoutX(150);
        records.setLayoutY(100);
        records.setMinSize(400,300);
        return records;
    }

}
