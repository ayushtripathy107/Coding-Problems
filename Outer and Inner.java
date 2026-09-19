class Outer {                                  // Creates the outer class
    int x = 10;                                // Variable of Outer class
    class Inner {                              // Creates Inner class inside Outer
        void display() {                       // Method of Inner class
            System.out.println("x = " + x);   // Accesses x from Outer class
        }
    }
}


public class NestedDemo {                      // Main class
    public static void main(String[] args) {  // Program starts here
        Outer o = new Outer();                 // Creates an object of Outer
        Outer.Inner i = o.new Inner();         // Creates an object of Inner
                                               // using the Outer object
        i.display();                           // Calls Inner's display() method
    }
}
