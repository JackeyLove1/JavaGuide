public class Person {
    private int age;
    private String name;
    public long id;
    public long grade;
    protected float score;
    protected int rank;


    public Person() {
        this.age = 1;
        this.name = "name";
        this.id = 1;
        this.grade = 1;
        this.score = 1;
        this.rank = 1;
    }

    public Person(int age, String name, long id, long grade, float score, int rank) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.score = score;
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", grade=").append(grade);
        sb.append(", score=").append(score);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }

}

abstract class Man {
    public abstract void run();
}
