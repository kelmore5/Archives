package kelmore5.java.hackerrank.java.advanced;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class CovariantReturnTypes {
}

class Flower {
    String name;
    public Flower() {
        this.name = "I have many names and types.";
    }
    public Flower(String name) {
        this.name = name;
    }
    String whatsYourName() {
        return name;
    }
}

class Jasmine extends Flower {
    public Jasmine() {
        super("Jasmine");
    }
}

class Lily extends Flower {
    public Lily() {
        super("Lily");
    }
}

class Lotus extends Flower {
    public Lotus() {
        super("Lotus");
    }
}

class State {
    Flower f;

    public State() {
        f = new Flower();
    }

    public State(Flower f) {
        this.f = f;
    }

    Flower yourNationalFlower() {
        return f;
    }
}

class WestBengal extends State {
    public WestBengal() {
        super(new Jasmine());
    }
}

class AndhraPradesh extends State {
    public AndhraPradesh() {
        super(new Lily());
    }
}

class Karnataka extends State {
    public Karnataka() {
        super(new Lotus());
    }
}