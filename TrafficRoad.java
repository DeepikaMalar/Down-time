import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TrafficRoad{
	static int crossedPath = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nmbrOfPeople = scanner.nextInt();
		int nmbrOfPath = scanner.nextInt();
		Set<Integer>[] crossingSet = new Set[nmbrOfPeople];
		List<Integer> occurenceList = new ArrayList<Integer>();
		int[] lengths = new int[occurenceList.size()];
		int largerGroup = 1;
		
			if (nmbrOfPeople <= 800 && nmbrOfPath <= 10000) {
				for (int i = 0; i < nmbrOfPeople; i++) {
					crossingSet[i] = new TreeSet<Integer>();
				}
				for (int i = 0; i < nmbrOfPath; i++) {
					int pathOfA = scanner.nextInt();
					int pathOfB = scanner.nextInt();
					crossingSet[pathOfA-1].add(pathOfB-1);
				}

				for (int i = 0; i < nmbrOfPeople; i++) {
					Set<Integer> duplicateList = new HashSet<Integer>();
					for (int j = 0; j < i; j++) {
						if (crossingSet[j].contains(i)) {
							duplicateList.add(j);
						}
					}
					if (!duplicateList.isEmpty()) {

						int maxLimit = 10000;
						for (Integer val : duplicateList) {
							int indexVal = occurenceList.indexOf(val);
							if (indexVal < maxLimit) {
								maxLimit = indexVal;
							}
						}
						occurenceList.add(maxLimit, i);
					} else {
						occurenceList.add(i);
					}
				}
				int[] findLargeGroup = new int[occurenceList.size()];
				findLargeGroup[0] = 1;
				for (int i = 1; i < findLargeGroup.length; i++) {
					int counter = 0;
					for (int j = 0; j < i; j++) {
						if (occurenceList.get(j) > occurenceList.get(i) && findLargeGroup[j] > counter) {
							counter = findLargeGroup[j];
						}
					}
					findLargeGroup[i] = counter + 1;
					if (findLargeGroup[i] > largerGroup) {
						largerGroup = findLargeGroup[i];
					}
				}
				System.out.println(largerGroup);

			}

		
	}

}
