package kelmore5.java.morrison.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
@SuppressWarnings("unused")
public class QS {
    private static void swap(int[] x, int k, int l)
    {
        if(k < 0 || l < 0 || k >= x.length || l >= x.length)
            throw new IndexOutOfBoundsException();
        if(k != l)
        {
            int temp = x[k];
            x[k] = x[l];
            x[l] = temp;
        }
    }

    public static void pivot(int[] x)
    {
        int left = 0; //things to the left of this are <= the pivot entry
        int right = x.length - 1;//things to the right of this are bigger than the pivot entry
        //push them to the middle maintaining the loop invariant
        int pivoter = x[0];
        while(left != right)
        {
            if(x[left] < pivoter)
            {
                swap(x, left, right);
            }
            else
            {
                swap(x, right, left);
            }
            left++;
            System.out.println(Arrays.toString(x));
        }

    }

    public static void chaquitopivot(int[] x)
    {
        int left = 0;
        int right = x.length - 1;
        int pivoter = x[left];
        int switcher = 0;

        while (right-switcher > left)
        {
            if(x[left] > pivoter)
            {
                swap(x, left, right);
                right--;
                switcher = 0;
            }
            else if(x[left] < pivoter)
            {
                left++;
                switcher = 0;
            }
            else
            {
                swap(x, left, right-switcher);
                switcher++;
            }
        }
    }

    public static void chaquitopivot(int[] x, int a, int b)
    {
        int left = a;
        int right = b;
        int pivoter = x[left];
        int switcher = 0;

        while (right-switcher > left)
        {
            if(x[left] > pivoter)
            {
                swap(x, left, right);
                right--;
                switcher = 0;
            }
            else if(x[left] < pivoter)
            {
                left++;
                switcher = 0;
            }
            else
            {
                swap(x, left, right-switcher);
                switcher++;
            }
        }
    }

    private static int freep(int[] x, int a, int b)
    {
        int left = a;
        int right = b;
        while(right > left)
        {
            if(x[left] > x[left + 1])
            {
                swap(x, left, left + 1);
                left++;
            }
            else
            {
                swap(x, left + 1, right);
                right--;
            }
        }
        return left;
    }

    private static void sort(int[] x)
    {
        fergiPivotSub(x, 0, x.length-1);
    }

    private static void fergiPivotSub(int[] x, int a, int b)
    {
        int locationOf = a;
        for(int i = a+1; i <= b; i++)
        {
            if(x[i] <= x[locationOf])
            {
                swap(x, locationOf, locationOf + 1);
                if(locationOf + 1 != i)
                    swap(x, locationOf, i);
                locationOf++;
            }
        }
        if((locationOf-a) > 1)
            fergiPivotSub(x, a, locationOf-1);
        if((b - locationOf) > 1)
            fergiPivotSub(x, locationOf + 1, b);
    }

    private static void sortHelper(int[] x, int a, int b)
    {
        if(b - a <= 1)
            return;
        int pivotLocation = freep(x, a, b);
        freep(x, a, pivotLocation);
        freep(x, pivotLocation, b);
    }

    public static void fergipivot(int[] x)
    {
        int locationOf = 0;
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] < x[locationOf])
            {
                swap(x, locationOf, locationOf+1);
                if(locationOf+1 != i)
                    swap(x, locationOf, i);
                locationOf++;
            }
        }
    }

    public static void tohleipivot(int[] x)
    {
        int left = 0; //things to the left of this are <= the pivot entry
        int right = x.length - 1;//things to the right of this are bigger than the pivot entry
        //push them to the middle maintaining the loop invariant
        int pivoter = x[0];
        for(int i = 0; i <= (x.length - 1); ++i)
        {
            if(pivoter >= x[i])
            {
                swap(x, i, right);
                --right;
            }
            else
            {
                swap(x, i, left);
                ++left;
            }
        }

    }

    public static void main(String[] args)
    {
		/*int[] x = {21, 12, 38, 45, 63, 3, 19, 2, 21, 21, 21};
		System.out.println(Arrays.toString(x));
		sort(x);
		System.out.println(Arrays.toString(x));*/
        Random r = new Random();
        int[] x = new int[100];
        for(int k = 0; k < x.length; k++)
        {
            x[k] = r.nextInt();
        }
        sort(x);
        //pivotSub(x, 0, x.length);
        //System.out.println(Arrays.toString(x));
    }

}