public class RównanieKwadratowe {
    private double a;
    private double b;
    private double c;

    public RównanieKwadratowe(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String result(){
        double delta;
        String solution="";
        delta = (b*b)-(4*a*c);
        if (delta > 0.0){
            delta = Math.sqrt(delta);
            double x1 = (-b-delta)/(2*a);
            double x2 = (-b+delta)/(2*a);
            solution = "Quadratic equation solutions x1: " + x1 + " and " + x2;
        }
        if (delta==0.0){
            delta = Math.sqrt(delta);
            double x1 = -b/(2*a);
            solution = "Quadratic equation solution is x1: " + x1;
        }

        if (delta<0.0){
            solution = "There is no solution";
        }

        return solution;
    }

    public void setA(double a) { this.a = a; }
    public void setB(double b) { this.b = b;}
    public void setC(double c) { this.c = c; }

}