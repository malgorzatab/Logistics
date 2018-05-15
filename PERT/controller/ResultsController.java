package controller;

import calculations.Result;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {

    public TextArea tdResult;
    public TextArea timeResult;
    public TextArea CPResult;
    public TextArea xResult;
    public TextArea wariancjaResult;
    public TextArea probabilityResult;
    public TextArea timeFrameResult;
    private Result result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {    }

    public void setResult(Result result){
        this.result = result;
        tdResult.setText(String.valueOf(this.result.getTd()));
        timeResult.setText(String.valueOf(this.result.getCriticalPathCost()));
        CPResult.setText(String.valueOf(this.result.getCriticalPath()));
        xResult.setText(String.valueOf(this.result.getX()));
        wariancjaResult.setText(String.valueOf(this.result.getWariancja_sqrt()));
        probabilityResult.setText(String.valueOf(this.result.getProbability()));
        timeFrameResult.setText("<"+String.valueOf(result.getCriticalPathCost()-result.getWariancja())+", "+String.valueOf(result.getCriticalPathCost()+result.getWariancja())+">");

    }

}
