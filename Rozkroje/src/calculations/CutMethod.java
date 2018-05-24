package calculations;

public class CutMethod {

    //ilość części pierwszego typu, które można wytworzyć z całości produktu
    private int element1_amount;

    //długość elementów 1 typu
    private int element1_length;

    //ilość części drugiego typu, które można wytworzyć z całości produktu
    private int element2_amount;

    //ilość elementów 2 typu
    private int element2_length;

    //długość odpadu
    private double waste;

    //cena odpadu
    private double waste_price;

    public CutMethod(double total_length, int element1_amount, int element2_amount, int element1_length, int element2_length) {
        this.element1_amount = element1_amount;
        this.element2_amount = element2_amount;
        this.element1_length = element1_length;
        this.element2_length = element2_length;
        this.waste = -1;
        this.waste_price = -1;
    }

    public CutMethod(int element1_length, int element2_length, double waste) {
        this.element1_length = element1_length;
        this.element2_length = element2_length;
        this.waste = waste;
    }

    public void calculateWaste(double total_length){
        this.waste = total_length - (element1_amount*element1_length + element2_amount*element2_length);
    }

    public void calculateWastePrice(double price_m){
        if(this.waste != -1)
            this.waste_price = price_m * this.waste;
    }


    public int getElement1_amount() {
        return element1_amount;
    }

    public void setElement1_amount(int element1_amount) {
        this.element1_amount = element1_amount;
    }

    public int getElement2_amount() {
        return element2_amount;
    }

    public void setElement2_amount(int element2_amount) {
        this.element2_amount = element2_amount;
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

    public int getElement1_length() {
        return element1_length;
    }

    public void setElement1_length(int element1_length) {
        this.element1_length = element1_length;
    }

    public int getElement2_length() {
        return element2_length;
    }

    public void setElement2_length(int element2_length) {
        this.element2_length = element2_length;
    }

    @Override
    public String toString() {
        return
                "{ element1_length=" + element1_length +
                ", element2_length=" + element2_length + ", waste = " + waste + ", waste_price = " + waste_price +
                "}\n";
    }
}
