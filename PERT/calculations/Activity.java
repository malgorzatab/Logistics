package calculations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity implements Serializable {

    // id czynności (A = 1, B =2 ...)
    private int id;

    // nazwa czynności (A, B, C...)
    private String name;

    // czynność poprzednia
    private List<Activity> previous;

    // czynność następna
    private List<Activity> next;

    // zdarzenie początkowe i końcowe
    private int[] events;

    //czas oczekiwana trwania czynności, od zdarzenia events[0] do events[1]
    private double t0;

    // czas pesymistyczny
    private double tp;

    //czas najbardziej prawdopodobny
    private double tm;

    //czas optymistyczny
    private double tc;

    //czas postępu aż do aktualnej czynności
    private double criticalCost;

    private String description;

    Activity(){}


    public Activity(int id, String name, List<Activity> previous, double t0, double tp, double tm, double tc, String description) {
        if(previous != null)
            this.previous = new ArrayList<>(previous);
        this.next = new ArrayList<>();
        this.events = new int[2];
        this.id = id;
        this.name = name;
        this.t0 = t0;
        this.tp = tp;
        this.tm = tm;
        this.tc = tc;
        this.description = description;
        this.criticalCost = 0;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getPrevious() {
        return previous;
    }

    void setPrevious(List<Activity> previous) {
        this.previous = previous;
    }

    void addPrevious(Activity a){
        this.previous.add(a);
    }

    List<Activity> getNext() {
        return next;
    }

    void setNext(List<Activity> next) {
        this.next = next;
    }

    void addNext(Activity activity){
        this.next.add(activity);
    }

    int[] getEvents() {
        return events;
    }

    int getEvent(int index){
        return events[index];
    }

    void setEvents(int[] events) {
        this.events = events;
    }

    void setEvents(int start, int end){
        events[0] = start;
        events[1] = end;
    }

    public double getT0() {
        return t0;
    }

    public void setT0(double t0) {
        this.t0 = t0;
    }

    public double getTp() {
        return tp;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    public double getTm() {
        return tm;
    }

    public void setTm(double tm) {
        this.tm = tm;
    }

    public double getTc() {
        return tc;
    }

    public void setTc(double tc) {
        this.tc = tc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCriticalCost() {
        return criticalCost;
    }

    public void setCriticalCost(double criticalCost) {
        this.criticalCost = criticalCost;
    }

    @Override
    public String toString() {
        return this.name+" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != activity.id) return false;
        if (Double.compare(activity.t0, t0) != 0) return false;
        if (Double.compare(activity.tp, tp) != 0) return false;
        if (Double.compare(activity.tm, tm) != 0) return false;
        if (Double.compare(activity.tc, tc) != 0) return false;
        if (Double.compare(activity.criticalCost, criticalCost) != 0) return false;
        if (!name.equals(activity.name)) return false;
        if (previous != null ? !previous.equals(activity.previous) : activity.previous != null) return false;
        if (next != null ? !next.equals(activity.next) : activity.next != null) return false;
        if (!Arrays.equals(events, activity.events)) return false;
        return description != null ? description.equals(activity.description) : activity.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (previous != null ? previous.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(events);
        temp = Double.doubleToLongBits(t0);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tc);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(criticalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
