import java.util.PriorityQueue;

public class Priority {
    public static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name , int rank)
        {
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2)
        {
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> q1 = new PriorityQueue<>();
        q1.add(new Student("Ram", 15));
        q1.add(new Student("Shyam", 10));
        q1.add(new Student("Sita", 19));
        q1.add(new Student("Geeta", 12));

        while (!q1.isEmpty()) {
            System.out.println(q1.peek().name +" "+q1.peek().rank);
            q1.remove();
        }
    }
}

