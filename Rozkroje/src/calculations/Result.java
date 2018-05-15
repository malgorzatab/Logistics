package calculations;

import java.util.ArrayList;
import java.util.List;

public class Result {

    //tak dużo jak obiektów CutMethod
    private double[] x;

    //końcowa wartość funkcji celu
    private double goal_function_value;

    //funkcja celu: goal_function[0]*x1+goal_function[1]*x2+...
    private ArrayList<Double> goal_function;

    //warunek dla elementów rodzaju 1, wchodzacych w skład kompletu
    private ArrayList<Double> condition1_function;

    //warunek dla elementów rodzaju 1, wchodzacych w skład kompletu
    private ArrayList<Double> condition2_function;

    //wartość ograniczająca warunek 1
    private int condition1;

    //wartość ograniczająca warunek 2
    private int condition2;

    public Result(){
        this.goal_function_value = 0;
        this.goal_function = new ArrayList<Double>();
        this.condition1_function = new ArrayList<Double>();
        this.condition1 = 0;
        this.condition2 = 0;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double getGoal_function_value() {
        return goal_function_value;
    }

    public void setGoal_function_value(double goal_function_value) {
        this.goal_function_value = goal_function_value;
    }

    public ArrayList<Double> getGoal_function() {
        return goal_function;
    }

    public void setGoal_function(ArrayList<Double> goal_function) {
        this.goal_function = goal_function;
    }
}
