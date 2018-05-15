package controller;

import calculations.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PERTController implements Initializable {

    @FXML
    public Label tdLabel;

    @FXML
    private TableView<Activity> tableView;

    @FXML
    private TableView<Dystrybuanta> dystrybuantaTableView;

    @FXML
    private TextField nameField;

    @FXML
    private TextField previousField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField tcField;

    @FXML
    private TextField tmField;

    @FXML
    private TextField toField;

    @FXML
    private TextField tpField;

    @FXML
    private TextField tdField;

    @FXML
    private Label errorLabel;

    private PERTSolver solver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        solver = new PERTSolver();
    }

    //ustawiamy czas dyrektywny, jeden dla zadania
    @FXML
    void setTDAction(ActionEvent event) {
        errorLabel.setText("");
        if(!tdField.getText().trim().isEmpty() || Validator.doubleOrIntMatches(tdField.getText())) {
            solver.setTD(Double.parseDouble(tdField.getText()));
            tdLabel.setText("td = "+tdField.getText());
            tdField.clear();
            tdField.setDisable(true);

        }else{
            if(!tdField.isDisabled())
                errorLabel.setText("Niepoprawny czas dyrektywny.");
        }
    }

    //dodajemy do listy i tabeli obiekt Activity
    @FXML
    void addAction(ActionEvent event) {
        String name = "";
        String previous, description;
        double tc = 0, t0 = 0, tp = 0, tm = 0;
        int id = 0;
        List<Activity> previousActivities = null;

        errorLabel.setText("");

        if (!(tpField.getText().trim().isEmpty()|| tmField.getText().trim().isEmpty() || tcField.getText().trim().isEmpty()|| nameField.getText().trim().isEmpty())) {

            if(!previousField.getText().trim().isEmpty()) {
                previousActivities = new ArrayList<>();
                previous = previousField.getText();
                String[] parts = previous.split(";");
                for (String part : parts) {
                    if(Validator.letterMatches(part)) {
                        Activity a = solver.findPrevious(part);
                        if (a != null)
                            previousActivities.add(a);
                    }else{
                        errorLabel.setText("Niepoprawny format pola: Poprzednicy");
                        return;
                    }
                }
            }

            if(!descriptionField.getText().trim().isEmpty())
                description = descriptionField.getText();
            else
                description = "BRAK";

           if(Validator.letterMatches(nameField.getText()) && Validator.doubleOrIntMatches(tcField.getText())&& Validator.doubleOrIntMatches(tpField.getText()) && Validator.doubleOrIntMatches(tmField.getText())){
                name = nameField.getText();
                id = ((int) name.charAt(0)) - 64;
                tc = Double.parseDouble(tcField.getText());
                tp = Double.parseDouble(tpField.getText());
                tm = Double.parseDouble(tmField.getText());

               if(toField.getText().trim().isEmpty()){
                   t0 = solver.calculateT0(tc, tm, tp);
               }else if(Validator.doubleOrIntMatches(toField.getText())) {
                   t0 = Double.parseDouble(toField.getText());
               }else{
                   errorLabel.setText("Niepoprawny format danych.");
               }

            }else{
               errorLabel.setText("Niepoprawny format danych.");
               return;
           }

            Activity newActivity = new Activity(id, name, previousActivities, t0, tp, tm, tc, description);
            tableView.getItems().add(newActivity);
            solver.addActivity(newActivity);


        }else{
            errorLabel.setText("Prosze uzupelnic wymagane dane oraz czas dyrektywny td. (*)");
        }

        tpField.clear();
        toField.clear();
        tmField.clear();
        tcField.clear();
        nameField.clear();
        previousField.clear();
        descriptionField.clear();

    }

    //obliczamy ścieżkę krytyczną, wariancję i prawdopodobieństwo
    @FXML
    void calculateAction(ActionEvent event) {
        ObservableList<Activity> items = tableView.getItems();

        if(!items.isEmpty() && solver.getResult().getTd() != 0) {
            solver.solvePERT();

            Stage stage = new Stage();
            Parent root = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Results.fxml"));
            try {
                root = loader.load();
                ResultsController resultsController = loader.getController();
                resultsController.setResult(this.solver.getResult());
                stage.setTitle("PERT RESULTS");
                stage.setScene(new Scene(root, 800, 600));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Exception with loading the new stage.");
            }

        }else{
            errorLabel.setText("DODAJ CZYNNOSCI ORAZ CZAS DYREKTYWNY!");
        }

    }

    @FXML
    public void loadAction(ActionEvent event){
        String name1 = "A";
        String name2 = "B";
        String name3 = "C";
        String name4 = "D";
        String name5 = "E";
        String name6 = "F";
        String name7 = "G";
        String name8 = "H";
        String name9 = "I";
        String name10 = "J";
        String name11 = "K";


        //List<Activity> previousActivitiesA = new ArrayList<>();
       // List<Activity> previousActivitiesB = new ArrayList<>();
        //List<Activity> previousActivitiesC = new ArrayList<>();
        List<Activity> previousActivitiesD = new ArrayList<>();
        List<Activity> previousActivitiesE = new ArrayList<>();
        List<Activity> previousActivitiesF = new ArrayList<>();
        List<Activity> previousActivitiesG = new ArrayList<>();
        List<Activity> previousActivitiesH = new ArrayList<>();
        List<Activity> previousActivitiesI = new ArrayList<>();
        List<Activity> previousActivitiesJ = new ArrayList<>();
        List<Activity> previousActivitiesK = new ArrayList<>();


        Activity aA = new Activity(((int) name1.charAt(0)) - 64, name1, null, 14, 15, 14, 13, "");
        Activity aB = new Activity(((int) name2.charAt(0)) - 64, name2, null, 10, 15, 10, 5, "");
        Activity aC= new Activity(((int) name3.charAt(0)) - 64, name3, null, 11, 19, 10, 7, "");
        Activity aD = new Activity(((int) name4.charAt(0)) - 64, name4, previousActivitiesD, 2, 2, 2, 2, "");
        Activity aE = new Activity(((int) name5.charAt(0)) - 64, name5, previousActivitiesE, 10, 10, 10, 10, "");
        Activity aF = new Activity(((int) name6.charAt(0)) - 64, name6, previousActivitiesF, 21, 22, 21, 20, "");
        Activity aG = new Activity(((int) name7.charAt(0)) - 64, name7, previousActivitiesG, 14, 16, 16, 4, "");
        Activity aH = new Activity(((int) name8.charAt(0)) - 64, name8, previousActivitiesH, 18, 23, 20, 5, "");
        Activity aI = new Activity(((int) name9.charAt(0)) - 64, name9, previousActivitiesI, 8, 11, 8, 5, "");
        Activity aJ = new Activity(((int) name10.charAt(0)) - 64, name10, previousActivitiesJ, 12, 12, 12, 12, "");
        Activity aK = new Activity(((int) name11.charAt(0)) - 64, name11, previousActivitiesK, 20, 30, 18, 18, "");

        List<Activity> acts = new ArrayList<>();
        acts.addAll(Arrays.asList(aA,aB,aC,aD,aE,aF,aG,aH,aI,aJ,aK));
        solver.addActivities(acts);

        String[] previous = {"A","A","B;D","B;D","C","E","F","G;H"};

        for(int i = 0; i < 8; i++) {
            String[] parts = previous[i].split(";");
            for (String part : parts) {
                if (Validator.letterMatches(part)) {
                Activity a = solver.findPrevious(part);
                if (a != null)
                switch(i){
                    case 0: {
                        previousActivitiesD.add(a);
                        solver.addPrevious(3,a);
                        break;
                    }
                    case 1: {
                        previousActivitiesE.add(a);
                        solver.addPrevious(4,a);
                        break;
                    }
                    case 2: {
                        previousActivitiesF.add(a);
                        solver.addPrevious(5,a);
                        break;
                    }
                    case 3:{
                        previousActivitiesG.add(a);
                        solver.addPrevious(6,a);
                        break;
                    }
                    case 4:{
                        previousActivitiesH.add(a);
                        solver.addPrevious(7,a);
                        break;
                    }
                    case 5:{
                        previousActivitiesI.add(a);
                        solver.addPrevious(8,a);
                        break;
                    }
                    case 6:{
                        previousActivitiesJ.add(a);
                        solver.addPrevious(9,a);
                        break;
                    }
                    case 7:{
                        previousActivitiesK.add(a);
                        solver.addPrevious(10,a);
                        break;
                    }
                }
                } else {
                    errorLabel.setText("Niepoprawny format pola: Poprzednicy");
                     return;
                }
            }
        }

        tableView.getItems().addAll(aA,aB,aC,aD,aE,aF,aG,aH,aI,aJ,aK);
        solver.getResult().setTd(48);
    }

    @FXML
    public void deleteAction(ActionEvent event){
        tableView.getItems().clear();
        solver = new PERTSolver();
        errorLabel.setText("");
        tdField.setDisable(true);
        tdLabel.setText("");
    }

    @FXML
    public void setDystrybuantaAction(ActionEvent event){
        List<Dystrybuanta> dystrybuantas = Parser.load();
        if(dystrybuantaTableView != null)
            dystrybuantaTableView.getItems().addAll(dystrybuantas);
    }
}
