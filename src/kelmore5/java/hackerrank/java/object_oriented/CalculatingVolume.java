package kelmore5.java.hackerrank.java.object_oriented;

import java.io.IOException;
import java.security.Permission;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class CalculatingVolume {
    public static void main(String[] args) {
        DoNotTerminate.forbidExit();
        try {
            Calculate cal = new Calculate();
            int T = cal.get_int_val();
            while (T--> 0) {
                double volume = 0.0;
                int ch = cal.get_int_val();
                if (ch == 1) {
                    int a = cal.get_int_val();
                    volume = Calculate.do_calc().get_volume(a);
                } else if (ch == 2) {
                    int l = cal.get_int_val();
                    int b = cal.get_int_val();
                    int h = cal.get_int_val();
                    volume = Calculate.do_calc().get_volume(l, b, h);

                } else if (ch == 3) {
                    double r = cal.get_double_val();
                    volume = Calculate.do_calc().get_volume(r);

                } else if (ch == 4) {
                    double r = cal.get_double_val();
                    double h = cal.get_double_val();
                    volume = Calculate.do_calc().get_volume(r, h);

                }
                cal.output.display(volume);
            }

        } catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }


    } //end of main
}

class Calculate {
    Scanner scan;
    static Calculator output;
    public Calculate() throws IOException {
        scan = new Scanner(System.in);
        if(scan == null) {
            throw new IOException();
        }
        output = new Calculator();
    }

    static Calculator do_calc() {
        output = output == null ? new Calculator() : output;
        return output;
    }

    int get_int_val() {
        return scan.nextInt();
    }

    double get_double_val() {
        return scan.nextDouble();
    }



    public static class Calculator {
        static void checkDigits(double... i) throws NumberFormatException {
            for(double ii: i) {
                if(ii <= 0) {
                    throw new NumberFormatException("All the values must be positive");
                }
            }
        }
        static double get_volume(int a) throws NumberFormatException {
            checkDigits((double) a);
            return (double) a*a*a;
        }

        static double get_volume(int l, int b, int h) throws NumberFormatException {
            checkDigits((double) l, (double) b, (double) h);
            return (double) l*b*h;
        }

        static double get_volume(double r) throws NumberFormatException {
            checkDigits(r);
            return (2* Math.PI * r*r*r)/3;
        }

        static double get_volume(double r, double h) throws NumberFormatException {
            checkDigits(r, h);
            return Math.PI * r*r * h;
        }

        static void display(double num) {
            DecimalFormat dec = new DecimalFormat("#.000");
            System.out.println(dec.format(num));
        }

    }
}

/**
 *This class prevents the user form using System.exit(0)
 * from terminating the program abnormally.
 *
 */
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {}

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
} //end of Do_Not_Terminate
