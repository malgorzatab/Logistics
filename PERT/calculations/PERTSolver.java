package calculations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PERTSolver {

    private List<Activity> allActivities;

    private Result result;

    public PERTSolver() {
        allActivities = new ArrayList<>();
        result = new Result();
    }

    public Result getResult() {
        return result;
    }

    public void setTD(double td) {
        this.result.setTd(td);
    }

    public void addPrevious(int index, Activity a){
        Activity current = allActivities.get(index);
        current.addPrevious(a);
    }

    public Activity findPrevious(String name) {
        Activity previousAct = null;

        for (Activity activity : allActivities) {
            if (activity.getName().equals(name)) {
                previousAct = activity;
            }
        }
        return previousAct;
    }

    private Activity findActivity(int id) {
        Activity act = null;

        for (Activity activity : allActivities) {
            if (activity.getId() == id) {
                act = activity;
            }
        }
        return act;
    }

    public void addActivity(Activity activity) {
        allActivities.add(activity);
    }

    public void addActivities(List<Activity> activity) {
        allActivities.addAll(activity);
    }

    public void setEvents() {
       /* List<Activity> previous = null;
        int maximum = 0;
        int e = 0;

        for (Activity a : allActivities) {
            previous = a.getPrevious();
            if (previous == null && a.getId() == 1) {
                a.setEvents(1, 2);
                maximum = 2;
            } else if (previous == null) {
                e = findActivity(a.getId() - 1).getEvent(1);
                a.setEvents(e, e + 1);
                maximum = e + 1;
            } else {
                for (Activity p : previous) {
                    e = p.getEvent(1);
                    a.setEvents(e, maximum + 1);
                }
            }
        }

        for (Activity a : allActivities) {
            System.out.println(a.getName() + " events: (" + a.getEvent(0) + ", " + a.getEvent(1) + ")");
        }*/
    }

    private void setNext() {
        Activity currentAct = null;

        for (int i = (allActivities.size() - 1); i > -1; i--) {
            currentAct = allActivities.get(i);

            if (currentAct.getPrevious() != null) {
                for (Activity prev : currentAct.getPrevious()) {
                    prev.addNext(currentAct);
                }
            }
        }

        for(Activity a:allActivities){
            if(a.getNext().size() == 0){
                a.setNext(null);
            }
        }
    }

    public double calculateT0(double tc, double tm, double tp){
        return (tc+4*tm+tp)/6;
    }

    private void calculateCP() {
        List<Activity> remaining = new ArrayList<>(allActivities);
        List<Activity> completed = new ArrayList<>();

        while (!remaining.isEmpty()) {
            for (Iterator<Activity> it = remaining.iterator(); it.hasNext(); ) {
                Activity activity = it.next();

                if (activity.getPrevious() == null) {
                    activity.setCriticalCost(activity.getT0());
                    completed.add(activity);
                    it.remove();
                } else if (completed.containsAll(activity.getPrevious())) {
                    double critical = 0;
                    for (Activity prev : activity.getPrevious()) {
                        if (prev.getCriticalCost() > critical) {
                            critical = prev.getCriticalCost();
                        }
                    }

                    activity.setCriticalCost(critical + activity.getT0());
                    completed.add(activity);
                    it.remove();
                }
            }
        }

        result.setCriticalPath(findCP(completed));
    }

    private List<Activity> findCP(List<Activity> activities){
        List<Activity> critical_path = new ArrayList<>();
        Activity last = new Activity();
        double critical = 0;

        for(Activity a : activities){
            if((a.getNext() == null) && (a.getCriticalCost() > critical)){
                critical = a.getCriticalCost();
                last = a;
            }
        }

        critical_path.add(last);
        activities.remove(last);
        result.setCriticalPathCost(last.getCriticalCost());

        while(last.getPrevious() != null){
            critical = 0;
            List<Activity> tmp = last.getPrevious();
            for (Activity prev : tmp) {
                if (prev.getCriticalCost() > critical) {

                    critical = prev.getCriticalCost();
                    last = prev;
                }
            }
            critical_path.add(last);
        }

        Collections.reverse(critical_path);

        return critical_path;
    }

    private void calculateWariancja(){
        double wariancja = 0;

        for(Activity a : result.getCriticalPath()){
            wariancja += Math.pow((a.getTp()-a.getTc())/6, 2);
        }

        result.setWariancja(wariancja);
        result.setWariancja_sqrt(Math.sqrt(wariancja));

    }

    private void calculateX(){
        result.setX((result.getTd()-result.getCriticalPathCost())/result.getWariancja_sqrt());
    }

    private void calculateProbability(){
        double dystrybuanta = 0;
        try {
            dystrybuanta = Parser.parse(Math.abs(result.getX()));

            if(result.getX() < 0){
                result.setProbability((1-dystrybuanta)*100);
            }else{
                result.setProbability(dystrybuanta*100);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Exception.");
        }

    }

    public void  solvePERT() {
        setEvents();
        setNext();
        calculateCP();
        calculateWariancja();
        calculateX();
        calculateProbability();
    }
}



