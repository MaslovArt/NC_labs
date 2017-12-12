package NC_lab1.entity;

public class Car {

    private String model;
    private String mark;
    private int year;
    private int run;

    public Car(String mark, String model, int year, int run) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.run = run;
    }

    public String getModel() {
        return model;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public int getRun() {
        return run;
    }

    @Override
    public String toString() {
        return "Model " + model + " mark " + mark + " year " + year + "  run " + run;
    }
}
