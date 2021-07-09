package application;

public class Dog {

    private int instancias;

    Dog() {
        instancias++;
    }

    public int getInstancias() {
        return instancias;
    }

    public static void main(String[] args) {
        Dog bob = new Dog();
        bob.instancias++;
        Dog rex = new Dog();
       
        
        
        System.out.println("Imprime:" + (rex.getInstancias() + bob.getInstancias()));
    }
}