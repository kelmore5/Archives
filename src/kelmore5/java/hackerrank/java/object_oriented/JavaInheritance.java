package kelmore5.java.hackerrank.java.object_oriented;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaInheritance {
    public static void main(String args[]){

        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();

    }
}

class Animal{
    void walk(){
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void fly(){
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}