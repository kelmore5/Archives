package kelmore5.java.hackerrank.java.data_structures;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaPriorityQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        PriorityQueue<Students> q = new PriorityQueue<>();

        while(totalEvents>0){
            String event = in.next();

            if(event.equals("ENTER")) { q.add(new Students(in.next(), in.nextDouble(), in.nextInt()));}
            else {q.poll();}

            totalEvents--;
        }

        if(q.isEmpty()) {System.out.println("EMPTY");}
        while(!q.isEmpty()) {
            System.out.println(q.poll().getFname());
        }
    }
}

class Students implements Comparable<Students> {
    private int token;
    private String fname;
    private double cgpa;
    public Students(String fname, double cgpa, int id) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Students s) {
        int compare = Double.compare(s.cgpa, this.getCgpa());
        if(compare == 0) { compare = this.fname.compareTo(s.getFname()); }
        if(compare == 0) { compare = Integer.compare(s.token, this.getToken()); }
        return compare;
    }

    public boolean equals(Students s) {
        return fname == s.getFname() && cgpa == s.getCgpa() && token == s.getToken();
    }
}
