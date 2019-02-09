public abstract class shape {
    double a,b,c,l,radius;
    public void calculateArea(){
    System.out.println("I don't know how to calculate Area");
}
    public void calculatePerimeter(){
    System.out.println("I don't know how to calculate perimeter");
}

    public static void main (String args[])
    {
        //shape sh = new shape(); // Abstraction: Shape class cannot be instantiated as it is declared as abstract
        triangle tri = new triangle(); //overridding
        tri.a = 2;
        tri.b = 4;
        tri.c = 5;
        tri.calculateArea();
        tri.calculatePerimeter();

        System.out.println("polymorphism implementation");
        shape myrec = new rectangle();
        myrec.l = 2;
        myrec.b = 4;
        myrec.calculatePerimeter();
        myrec.calculateArea();

        System.out.println(square.name); // static field in the square class
        square.whoami();    // static method in the square class
    }

}

class triangle extends shape{
    // double a,b,c;

    @Override
    public void calculateArea(){

        double s, area;
        s = (a+b+c)/2;
        area = java.lang.Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("Area of the triangle is: " + area);

    }
    @Override
    public void calculatePerimeter(){
        double p = a+b+c;
        System.out.println("Perimeter of triangle is: "+ p);
    }


}
class rectangle extends shape{

    // double l,b;

    public void calculateArea(){
        double area;
        area = l*b;
//        System.out.println(l + " " + b);
        System.out.println("Area of rectangle is: " + area);

    }
        public void calculatePerimeter(){
        double p = 2 * (l+b);
        System.out.println("Perimeter of rectangle is: " +p);
        }

}

class circle extends shape{
    // double radius;

    @Override
    public void calculateArea() {

        double area = Math.PI* (radius * radius);
        System.out.println("Area of circle is: "+ area);
    }

    @Override
    public void calculatePerimeter() {
        double p = 2 * Math.PI * radius;
        System.out.println("Perimeter of circle is: "+ p);
    }
}
class square extends shape{
    // double a;
    static String name = "square";

    public void calculateArea() {
        double area = a*a;
        System.out.println("Area of Square is: " + area);

    }

    public void calculatePerimeter(){
        double perimeter = 4 * a;
        System.out.println("perimeter of a square is: "+ perimeter);
    }

    static void whoami(){
        System.out.println("I am a square");
    }

}