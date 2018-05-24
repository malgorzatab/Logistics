package calculations;

import java.util.ArrayList;

public class Task {

    //długość produktów
    private double length;

    //ilość zamówionych kompletów
    private int kits_amount;

    //ilość rodzajów elementów w komplecie
    private double elements_type_amount = 2;

    //ilość elementów pierwszego typu w komplecie
    private int elements1_amount;

    //ilość elementów pierwszego typu w komplecie
    private int elements2_amount;

    //cena za 1m odpadu
    private double price_m;
    private double elem1_length;
    private double elem2_length;

    private ArrayList<CutMethod> cut_methods;

    public Task(double length, int kits_amount, double elem1_length, int elements1_amount, double elem2_length, int elements2_amount, double price_m){
        this.length = length;
        this.kits_amount = kits_amount;
        this.elem1_length = elem1_length;
        this.elements1_amount = elements1_amount;
        this.elem2_length = elem2_length;
        this.elements2_amount = elements2_amount;
        this.price_m = price_m;
        this.cut_methods = new ArrayList<>();
    }

    public Task(double length, int kits_amount,double elem1_length, int elements1_amount,double elem2_length, int elements2_amount){
        this.length = length;
        this.kits_amount = kits_amount;
        this.elem1_length = elem1_length;
        this.elem2_length = elem2_length;
        this.elements1_amount = elements1_amount;
        this.elements2_amount = elements2_amount;
        this.price_m = -1;
        this.cut_methods = new ArrayList<>();
    }

    public void addMethod(CutMethod method){
        this.cut_methods.add(method);
    }

    public double getLength() {
        return length;
    }

    public double getElem1_length() {
        return elem1_length;
    }

    public void setElem1_length(double elem1_length) {
        this.elem1_length = elem1_length;
    }

    public double getElem2_length() {
        return elem2_length;
    }

    public void setElem2_length(double elem2_length) {
        this.elem2_length = elem2_length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getKits_amount() {
        return kits_amount;
    }

    public void setKits_amount(int kits_amount) {
        this.kits_amount = kits_amount;
    }

    public double getElements_type_amount() {
        return elements_type_amount;
    }

    public void setElements_type_amount(double elements_type_amount) {
        this.elements_type_amount = elements_type_amount;
    }

    public int getElements1_amount() {
        return elements1_amount;
    }

    public void setElements1_amount(int elements1_amount) {
        this.elements1_amount = elements1_amount;
    }

    public int getElements2_amount() {
        return elements2_amount;
    }

    public void setElements2_amount(int elements2_amount) {
        this.elements2_amount = elements2_amount;
    }

    public double getPrice_m() {
        return price_m;
    }

    public void setPrice_m(double price_m) {
        this.price_m = price_m;
    }

    public ArrayList<CutMethod> getCut_methods() {
        return cut_methods;
    }

    public void setCut_methods(ArrayList<CutMethod> cut_methods) {
        this.cut_methods = cut_methods;
    }
}
