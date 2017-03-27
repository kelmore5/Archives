package kelmore5.java.hackerrank.java.data_structures;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class TwoDArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int y=0; y < 6; y++){
            for(int x=0; x < 6; x++){
                arr[y][x] = in.nextInt();
            }
        }

        int max = getHourglassSum(arr, 0, 0);

        for(int y = 0; y < 4; y++) {
            for(int x = 0; x < 4; x++) {
                int hourglass = getHourglassSum(arr, y, x);
                if(hourglass > max) {
                    max = hourglass;
                }
            }
        }

        System.out.println(max);
    }

    public static int getHourglassSum(int[][] arr, int y, int x) {
        int sum = arr[y+1][x+1];
        for(int k = x; k < x+3; k++) {
            sum += arr[y][k] + arr[y+2][k];
        }
        return sum;
    }
}
