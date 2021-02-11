package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Date;

public class Controller {

    Date data = new Date();


    @FXML
    public TextArea textMain;
    @FXML
    public TextArea textEnter;

    @FXML
    public void clickSend(ActionEvent actionEvent) {
        textMain.setEditable(false);
        textMain.appendText(data.getHours() + ":" + data.getMinutes() + "  " + "Вы: " +  "\n" + textEnter.getText() + "\n");
        textEnter.clear();
        textEnter.requestFocus();


    }

    public void textEnterSendText(KeyEvent keyEvent) {
        if(keyEvent.isShiftDown() && keyEvent.getCode().equals(KeyCode.ENTER)){
            textMain.setEditable(false);
            textMain.appendText(data.getHours() + ":" + data.getMinutes() + "  " + "Вы: " +  "\n" + textEnter.getText() + "\n");
            textEnter.clear();
            textEnter.requestFocus();
        }
    }
}
