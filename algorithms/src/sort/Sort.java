package sort;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Sort {

    public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
	Random randGen = new Random();
	for (int i=0; i<10; i++) {
            list.add(randGen.nextInt(100));
	}
	System.out.println(list);
	//int numberOfSteps = bubbleSort(list,new IntegerComparator());
        int numberOfSteps = selectionSort(list,new IntegerComparator());
	System.out.println("Number of steps: "+numberOfSteps);
	System.out.println(list);

    }
	
    public static <T> int bubbleSort(List<T> list, Comparator<T> comp) {
	int numberOfSteps = 0;
	for (int i=0; i<list.size()-1; i++) {
            for (int j=0; j<list.size()-i-1; j++) {
		if (comp.compare(list.get(j), list.get(j+1)) > 0) {
                    T tmp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, tmp);
		}
                numberOfSteps++;
            }
	}
	return numberOfSteps;
    }
	
    public static <T> int selectionSort(List<T> list, Comparator<T> comp) {
	int numberOfSteps = 0;
        for (int i=0; i<list.size()-1; i++) {
            int minInd = i;
            T minVal = list.get(i);
            for (int j=i+1; j<list.size(); j++) {
                if (comp.compare(minVal, list.get(j)) > 0) {
                    minInd = j;
                    minVal = list.get(j);
                }
                numberOfSteps++;
            }
            T tmp = list.get(i);
            list.set(i, list.get(minInd));
            list.set(minInd, tmp);
        }
	return numberOfSteps;
    }

}
