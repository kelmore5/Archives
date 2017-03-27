package kelmore5.java.hackerrank.java.advanced;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaReflection {
    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m: methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student s) {
        if(this.cgpa > s.cgpa) {
            return -1;
        } else if(this.cgpa == s.cgpa) {
            int compare = this.fname.compareTo(s.fname);
            if(compare == 0) {
                return Integer.compare(this.id, s.id);
            }
            return compare;
        } else {
            return 1;
        }
    }
}
