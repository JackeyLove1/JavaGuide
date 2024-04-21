public class Student {
    public String name;
    public int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "Name: " + name + " Score: " + score;
    }

    public int compare(Student p1, Student p2) {
        if (p1.score == p2.score) return 0;
        return p1.score > p2.score ? 1 : -1;
    }
}

