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

        double[] points = this.result.getX();
       // minimumField.setText(String.valueOf(this.result.getGoal_function_value()));
        for(int i=0; i<points.length; i++){
            xField.appendText(String.valueOf("x"+(i+1)+"= "+points[i]+" ,"));
        }
        wasteField.setText(String.valueOf(this.result.getWaste()));
        priceField.setText(String.valueOf(this.result.getWaste_price()));
        minimumField.setText(String.valueOf(this.result.getMinimum()));
        element1Field.setText(String.valueOf(this.result.getElement1_lenght()));
        cutMethods1Field.setText(String.valueOf(this.result.getCut_methods()));
        element2Field.setText(String.valueOf(this.result.getElement2_lenght()));
        //cutMethods2Field.setText(String.valueOf(this.result.getCut_methods()));
        condition1Field.setText(String.valueOf(this.result.getElem1_amount()));
        condition2Field.setText(String.valueOf(this.result.getElem2_amount()));


    }

}
