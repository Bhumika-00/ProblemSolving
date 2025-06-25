import java.util.HashSet;

public class IntersectionOfTwoSets {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        System.out.println("Intersection:");
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                System.out.println(arr2[i]);
                hs.remove(arr2[i]);  // remove to avoid duplicates
            }
        }
    }
}
