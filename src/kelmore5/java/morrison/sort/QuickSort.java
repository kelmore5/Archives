package kelmore5.java.morrison.sort;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
@SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
public class QuickSort {
    private static void sort(int[] list) {
        endSort(list, 0, list.length-1);
    }

    public static int countSort(int[] list) {
        return countBeginSort(list, 0, list.length-1);
    }

    public static void mergeSort(int[] a) {
        int[] b = new int[a.length];
        mergeSort(a,b,0,a.length-1);
    }

    private static void mergeSort(int[] a, int[] b, int low, int high) {
        if(low < high){
            int middle = (low+high) / 2;
            mergeSort(a,b,low,middle);
            mergeSort(a,b,middle+1,high);
            int s_high = middle+1;
            int s_low = low;
            for(int i = low; i <= high; i++){
                if((s_low <= middle) && ((s_high > high) || (a[s_low] < a[s_high])))
                    b[i] = a[s_low++];
                else
                    b[i] = a[s_high++];
            }
            System.arraycopy(b, low, a, low, high + 1 - low);
        }
    }

    private static void sort(int[] list, int begin, int end) {
        int first = begin;
        int last = end;
        int pivot = list[begin + (end-begin)/2];

        while (first <= last) {

            while (list[first] < pivot) {
                first++;
            }

            while (list[last] > pivot) {
                last--;
            }

            if (first <= last) {
                swap(list, first, last);
                first++;
                last--;
            }
        }
        if (begin < last)
            sort(list, begin, last);
        if (first < end)
            sort(list, first, end);
    }

    private static void endSort(int[] list, int begin, int end) {
        int first = begin;
        int last = end-1;
        int pivot = end;

        while(first <= last) {
            while(list[first] < list[pivot]) {
                first++;
            }

            while(list[last] > list[pivot] && last > 0) {
                last--;
            }

            if(first <= last) {
                swap(list, first, last);
                first++;
                last--;
            }
        }

		/*if(last == -1) {
			last++;
		}
		if(list[pivot] > list[first]) {
			swap(list, first, pivot);
		}
		else if(list[pivot] > list[last]) {
			swap(list, last, pivot);
		}*/

        if(begin < last)
            endSort(list, begin, last);
        if(first < end)
            endSort(list, first, end);

    }

    private static void beginSort(int[] list, int begin, int end) {
        int first = begin+1;
        int last = end;
        int pivot = begin;

        while(first <= last) {
            while(list[first] < list[pivot] && first < end) {
                first++;
            }

            while(list[last] > list[pivot]) {
                last--;
            }

            if(first <= last) {
                swap(list, first, last);
                first++;
                last--;
            }
        }

        if(first == list.length) {
            first--;
        }
        if(list[pivot] > list[first]) {
            swap(list, first, pivot);
        }
        else if(list[pivot] > list[last]) {
            swap(list, last, pivot);
        }

        if(begin < last)
            beginSort(list, begin, last);
        if(first < end)
            beginSort(list, first, end);


    }

    private static int countBeginSort(int[] list, int begin, int end) {
        int counter = 0;
        int first = begin+1;
        int last = end;
        int pivot = begin;

        while(first <= last) {
            counter++;
            while(list[first] < list[pivot] && first < end) {
                counter++;
                first++;
            }

            while(list[last] > list[pivot]) {
                counter++;
                last--;
            }

            if(first <= last) {
                counter++;
                swap(list, first, last);
                first++;
                last--;
            }
        }

        if(first == list.length) {
            counter++;
            first--;
        }
        if(list[pivot] > list[first]) {
            counter++;
            swap(list, first, pivot);
            counter += 3;
        }
        else if(list[pivot] > list[last]) {
            counter++;
            swap(list, last, pivot);
            counter += 3;
        }

        if(begin < last) {
            counter++;
            counter += countBeginSort(list, begin, last);
        }
        if(first < end) {
            counter++;
            counter += countBeginSort(list, first, end);
        }

        return counter;

    }

    private static int countSort(int[] list, int begin, int end) {
        int counter = 0;
        int first = begin;
        int last = end;
        int pivot = list[begin + (end-begin)/2];

        while (first <= last) {
            counter++;

            while (list[first] < pivot) {
                counter++;
                first++;
            }

            while (list[last] > pivot) {
                counter++;
                last--;
            }

            if (first <= last) {
                counter++;
                swap(list, first, last);
                counter+= 3;
                first++;
                last--;
            }
        }
        if (begin < last) {
            counter++;
            counter += countSort(list, begin, last);
        }
        if (first < end) {
            counter++;
            counter += countSort(list, first, end);
        }

        return counter;
    }

    public static int countEndSort(int[] list, int begin, int end) {
        int counter = 0;
        int first = begin;
        int last = end-1;
        int pivot = end;

        while(first <= last) {
            counter++;
            while(list[first] < list[pivot]) {
                counter++;
                first++;
            }

            while(list[last] > list[pivot]) {
                counter++;
                last--;
            }

            if(first <= last) {
                counter++;
                swap(list, first, last);
                counter += 3;
                first++;
                last--;
            }
        }

        swap(list, pivot, first);
        counter += 3;

        if(begin < last) {
            counter++;
            counter += countBeginSort(list, begin, last+1);

            endSort(list, 0, list.length-1);
        }
        if(first < end) {
            counter++;
            counter += countBeginSort(list, first+1, end);

            endSort(list, 0, list.length-1);

            endSort(list, 0, list.length-1);
        }

        return counter;
    }

    private static int countMergeSort(int[] a, int[] b, int low, int high) {
        int counter = 0;
        if(low < high){
            counter++;
            int middle = (low+high) / 2;
            counter += countMergeSort(a,b,low,middle);
            counter += countMergeSort(a,b,middle+1,high);
            int s_high = middle+1;
            int s_low = low;
            for(int i = low; i <= high; i++){
                counter++;
                if((s_low <= middle) && ((s_high > high) || (a[s_low] < a[s_high]))) {
                    counter++;
                    b[i] = a[s_low++];
                }
                else {
                    counter++;
                    b[i] = a[s_high++];
                }
            }
            for(int i = low; i <= high; i++) {
                counter++;
                a[i] = b[i];
            }
        }

        return counter;
    }

    public static int countMergeSort(int[] a) {
        int[] b = new int[a.length];
        return countMergeSort(a,b,0,a.length-1);
    }

    private static void swap(int[] list, int first, int last) {
        int temp = list[last];
        list[last] = list[first];
        list[first] = temp;
    }

	/*public static void randomSort(int[] list, int begin, int end) {
		int first = begin;
		int last = end;
		int pivot = (int)(Math.random()*list.length-1);
		System.out.println("Pivot: " + pivot);

		while(first <= last) {
			while(list[first] < list[pivot]) {
				first++;
			}

			while(list[last] > list[pivot]) {
				last--;
			}

			if(first <= last) {
				swap(list, first, last);
				first++;
				last--;
			}
		}

	}*/

    public static String toString(int[] list) {
        String string = "[";
        for(int i: list) {
            string += i;
            string += ", ";
        }

        string = string.substring(0, string.lastIndexOf(","));
        string += "]";
        return string;
    }

    public static void main(String[] args) {
		/*int[] test = new int[10000000];
		for(int i = 0; i < test.length; i++) {
			test[i] = test.length - i;
		}
		//sort(test);
		System.out.println("" + countSort(test));*/
        int[] test = new int[] {5,2, 1, 7,9,0,6, 8, 3};
        System.out.println(toString(test));
        sort(test);
        System.out.println(toString(test));

		/*int[] test2 = new int[100];
		for(int i = 0; i < test2.length; i++) {
			test2[i] = (int) (Math.random()*100);
		}
		System.out.println(toString(test2));
		sort(test2);
		System.out.println(toString(test2));
		System.out.println("done");*/
    }
}