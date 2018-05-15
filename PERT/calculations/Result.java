package calculations;

import java.util.ArrayList;
import java.util.List;

public class Result {

    //czas dyrektywny
    private double td;

    // suma kwadratów wariancji dla scieżki krytycznej
    private double wariancja;

    //pierwiastek z sumy kwadratów wariancji
    private double wariancja_sqrt;

    //w %
    private double probability;

    //czas przeskalowany do N(0,1)
    private double x;

    private List<Activity> critical_path;

    private double criticalPathCost;

    public Result() {
        this.critical_path = new ArrayList<>();
        this.criticalPathCost = 0;
        this.td = 0;
    }

    public double getTd() {
        return td;
    }

    public void setTd(double td) {
        this.td = td;
    }

    public double getWariancja() {
        return wariancja;
    }

    public void setWariancja(double wariancja) {
        this.wariancja = wariancja;
    }

    public double getWariancja_sqrt() {
        return wariancja_sqrt;
    }

    public void setWariancja_sqrt(double wariancja_sqrt) {
        this.wariancja_sqrt = wariancja_sqrt;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public List<Activity> getCriticalPath() {
        return critical_path;
    }

    public void setCriticalPath(List<Activity> critical_path) {
        this.critical_path = critical_path;
    }

    public double getCriticalPathCost() {
        return criticalPathCost;
    }

    public void setCriticalPathCost(double criticalPathCost) {
        this.criticalPathCost = criticalPathCost;
    }
}
