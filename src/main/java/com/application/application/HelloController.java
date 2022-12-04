package com.application.application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.application.application.ReadFile.read;


public class HelloController implements Initializable {

    @FXML
    private Button formatButton;


    @FXML
    private Button clearButton;

    @FXML
    private TextArea formatText;

    @FXML
    private ScrollPane formattedLabel;

    Text setTextColorScrollPane(){
        Text text = new Text("Prettier json");
        text.setFill(Color.gray(0.6));
        return text;
    }

    String setTextColorTextArea(){
        String text = "Put json text in one line";
        return text;
    }

    @FXML
    protected void formattedButtonClicked() throws IOException {
        String text = formatText.getText();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(text);
        String prettyJson = gson.toJson(je);
        formattedLabel.setContent(new Text(prettyJson));
        read();
    }

    @FXML
    protected void cleanButtonClicked() {
        formatText.clear();
        formattedLabel.setContent(setTextColorScrollPane());
        clearButton.setVisible(false);
        formatButton.setDisable(true);
    }

    @FXML
    protected void handleKeyReleased(){
        String text = formatText.getText();
        boolean disableButton = text.isEmpty() || text.trim().isEmpty();
        formatButton.setDisable(disableButton);
        clearButton.setVisible(!disableButton);
        formatText.setStyle("-fx-text-fill: black ;");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        formattedLabel.setContent(setTextColorScrollPane());
        formatText.setText(setTextColorTextArea());
        formatText.setStyle("-fx-text-fill: gray ;");
    }

    @FXML
    protected void ReadButtonClicked() throws IOException {
        String text = read();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(text);
        String prettyJson = gson.toJson(je);
        formattedLabel.setContent(new Text(prettyJson));
        clearButton.setVisible(true);
        }
}