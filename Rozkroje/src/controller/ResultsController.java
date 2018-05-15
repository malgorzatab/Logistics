package controller;

import calculations.Result;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {

    @FXML
    private TextArea condition1Field;

    @FXML
    private TextArea condition2Field;

    @FXML
    private TextArea cutMethods1Field;

    @FXML
    private TextArea cutMethods2Field;

    @FXML
    private TextArea element1Field;

    @FXML
    private TextArea element2Field;

    @FXML
    private TextArea minimumField;

    @FXML
    private TextArea priceField;

    @FXML
    private TextArea wasteField;

    @FXML
    private TextArea xField;

    private Result result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {    }

    public void setResult(Result result){
        this.result = result;
        minimumField.setText(String.valueOf(this.result.getGoal_function_value()));
        xField.setText(String.valueOf(this.result.getX()));
        /*CPResult.setText(String.valueOf(this.result.getCriticalPath()));
        xResult.setText(String.valueOf(this.result.getX()));
        wariancjaResult.setText(String.valueOf(this.result.getWariancja_sqrt()));
        probabilityResult.setText(String.valueOf(this.result.getProbability()));
        timeFrameResult.setText("<"+String.valueOf(result.getCriticalPathCost()-result.getWariancja())+", "+String.valueOf(result.getCriticalPathCost()+result.getWariancja())+">");*/

    }

}
