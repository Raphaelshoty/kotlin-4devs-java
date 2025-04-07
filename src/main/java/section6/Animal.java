package section6;

public class Animal {

    private final String name;
    private final String kind;
    private Integer weight;

    public Animal(String name, String kind, Integer weight) {
        this.name = name;
        this.kind = kind;
        this.weight = weight;
    }

    public Animal(String name, String kind) {
        this.name = name;
        this.kind = kind;
    }

    public String show(){
        return name + " is a " + kind + " weighing " + weight + " kg.";
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
