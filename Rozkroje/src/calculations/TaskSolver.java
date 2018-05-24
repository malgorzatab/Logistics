package calculations;

import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.linear.LinearConstraint;
import org.apache.commons.math3.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optimization.linear.Relationship;
import org.apache.commons.math3.optimization.linear.SimplexSolver;

import java.util.ArrayList;
import java.util.Collection;

public class TaskSolver {

    //zadanie do rozwiązania z danymi
    private Task task;

    private Result result;

    public TaskSolver(double length, int kits_amount, double elem1_length, int elements1_amount,double elem2_length, int elements2_amount, double price_m){
        if(task == null) {
            task = new Task(length, kits_amount, elem1_length, elements1_amount,elem2_length, elements2_amount, price_m);
            this.result = new Result();
        }

    }

    public TaskSolver(double length, int kits_amount,double elem1_length, int elements1_amount,double elem2_length, int elements2_amount){
        if(task == null) {
            task = new Task(length, kits_amount,elem1_length, elements1_amount, elem2_length, elements2_amount);
            this.result = new Result();
        }
    }

    public TaskSolver(){}

    //warunek dla elementu typu 1 - zapisanie do Result
    public Collection<LinearConstraint> calculateConditions(ArrayList<CutMethod> methods){
        Collection<LinearConstraint> constraints = new ArrayList<>();
        //ArrayList<CutMethod> cutMethod = new ArrayList<>(task.getCut_methods());

        ArrayList<CutMethod> cutMethods = new ArrayList<>(methods);
        double constraints1[] = new double[cutMethods.size()];
        double constraints2[] = new double[cutMethods.size()];

        for(int i=0; i<constraints1.length; i++){
            constraints1[i] = cutMethods.get(i).getElement1_length();
            constraints2[i] = cutMethods.get(i).getElement2_length();
        }
        constraints.add(new LinearConstraint(constraints1, Relationship.GEQ,  task.getElements1_amount()));
        constraints.add(new LinearConstraint(constraints2, Relationship.GEQ,  task.getElements2_amount()));

       /*double tmp[] = new double[cutMethods.size()];
        for(int j=0; j<cutMethods.size(); j++){
            for(int k=0; k<cutMethods.size(); k++){
                if(k==j){
                    tmp[k] = 1;
                } else {
                    tmp[k] = 0;
                }
            }
            constraints.add(new LinearConstraint(tmp, Relationship. GEQ,  0));
        }*/

        return constraints;
    }


    //wyliczenie ilości możliwych rozkrojów produktu, dodanie do listy w Task, w Result też (do wyświetlenia)
    public void calculateCutMethods(double length, double elem1Length, double elem2Length){

        double x = 0;
        double waste = 0;
        double part1 = 0;
        double part2 = 0;
        double j = 0.0;
        int i = 0;

        if(elem1Length>elem2Length) {
            part1 = elem1Length;        //longer
            part2 = elem2Length;
        } else {
            part1 = elem2Length;        //longer
            part2 = elem1Length;
        }

        System.out.println(length+ " " + part1+" "+part2);
        while((length - part1*i) >= 0){

            j = Math.floor((length - i*part1)/part2);
            waste =(length - (i*part1 + j*part2));

            if(waste >= part2){
                i++;
                break;
            }
            CutMethod method = new CutMethod(i,(int)j,waste);
            //System.out.println("method: "+i+ "," + j+ "\n");
            i++;
            if(task.getPrice_m() != -1){
                method.calculateWastePrice(task.getPrice_m());
            }

            task.addMethod(method);
        }

    }



    //wyliczenie funkcji celu i zapisanie do Result
    public Result calculateGoalFuntion(){
        ArrayList<CutMethod> cutMethod = new ArrayList<>(task.getCut_methods());
        double tab[] = new double[cutMethod.size()];
        double allWastePrice = 0;
        double allWaste = 0;

        System.out.println(cutMethod.size());
        for(int i=0; i<tab.length; i++){
            tab[i] = cutMethod.get(i).getWaste_price();
            allWastePrice += (cutMethod.get(i).getWaste())*(task.getPrice_m());
            allWaste += cutMethod.get(i).getWaste();
           // System.out.println(tab[i]);
        }


      //  System.out.println(task.getCut_methods());
        LinearObjectiveFunction function = new LinearObjectiveFunction(tab, 0);
        Collection<LinearConstraint> conditions = calculateConditions(cutMethod);
        double epsilon = 0.0004;
        SimplexSolver solver = new SimplexSolver(epsilon,4);
        PointValuePair solution = solver.optimize(function, conditions, GoalType.MINIMIZE, true);
       // RealPointValuePair result = new SimplexSolver().optimize(function, conditions, GoalType.MINIMIZE, true);
        double[] point = solution.getPoint();
        double minimum = solution.getValue();

        this.result.setX(point);
      //  this.result.setGoal_function_value(minimum);
        this.result.setMinimum(minimum);
        this.result.setCut_methods(cutMethod);
        this.result.setWaste_price(allWastePrice);
        this.result.setElem1_amount(this.task.getElements1_amount());
        this.result.setElem2_amount(this.task.getElements2_amount());
        this.result.setWaste(allWaste);
        this.result.setElement1_lenght(this.task.getElem1_length());
        this.result.setElement2_lenght(this.task.getElem2_length());


return this.result;

    }

    public Result getResult() {
        return this.result;
    }

}
