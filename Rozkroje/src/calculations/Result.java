package calculations;

import java.util.ArrayList;

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

    private double element1_lenght;
    private double element2_lenght;
    private double waste;
    private double waste_price;
    private double minimum;
    private int elem1_amount;
    private int elem2_amount;
    private ArrayList<CutMethod> cut_methods;

    public ArrayList<CutMethod> getCut_methods() {
        return cut_methods;
    }

    public void setCut_methods(ArrayList<CutMethod> cut_methods) {
        this.cut_methods = cut_methods;
    }

    public ArrayList<Double> getCondition1_function() {
        return condition1_function;
    }

    public void setCondition1_function(ArrayList<Double> condition1_function) {
        this.condition1_function = condition1_function;
    }

    public ArrayList<Double> getCondition2_function() {
        return condition2_function;
    }

    public void setCondition2_function(ArrayList<Double> condition2_function) {
        this.condition2_function = condition2_function;
    }

    public int getCondition1() {
        return condition1;
    }

    public void setCondition1(int condition1) {
        this.condition1 = condition1;
    }

    public int getCondition2() {
        return condition2;
    }

    public void setCondition2(int condition2) {
        this.condition2 = condition2;
    }

    public double getElement1_lenght() {
        return element1_lenght;
    }

    public void setElement1_lenght(double element1_lenght) {
        this.element1_lenght = element1_lenght;
    }

    public double getElement2_lenght() {
        return element2_lenght;
    }

    public void setElement2_lenght(double element2_lenght) {
        this.element2_lenght = element2_lenght;
    }

    public double getWaste() {
        return waste;
    }

    public void setWaste(double waste) {
        this.waste = waste;
    }

    public double getWaste_price() {
        return waste_price;
    }

    public void setWaste_price(double waste_price) {
        this.waste_price = waste_price;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public int getElem1_amount() {
        return elem1_amount;
    }

    public void setElem1_amount(int elem1_amount) {
        this.elem1_amount = elem1_amount;
    }

    public int getElem2_amount() {
        return elem2_amount;
    }

    public void setElem2_amount(int elem2_amountl) {
        this.elem2_amount = elem2_amountl;
    }

    public Result(){
        this.goal_function_value = 0;
        this.goal_function = new ArrayList<Double>();
        this.condition1_function = new ArrayList<Double>();
        this.condition2_function = new ArrayList<Double>();
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
