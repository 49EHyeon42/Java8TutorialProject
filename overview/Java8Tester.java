package overview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Tester {

    public static void main(String[] args) {

        List<String> names1 = createList();
        List<String> names2 = createList();
        List<String> names3 = createList();
        List<String> names4 = createList();

        sortUsingJava7(names1);
        System.out.println("Sort using Java 7 syntax: ");
        System.out.println(names1);

        sortUsingJava8(names2);
        System.out.println("Sort using Java 8 syntax: ");
        System.out.println(names2);

        sortList1(names3);
        System.out.println("simplification java 8 1 syntax: ");
        System.out.println(names3);

        sortList2(names4);
        System.out.println("simplification java 8 2 syntax: ");
        System.out.println(names4);
    }

    private static List<String> createList() {
        List<String> names = new ArrayList<>();

        names.add("Mahesh ");
        names.add("Suresh ");
        names.add("Ramesh ");
        names.add("Naresh ");
        names.add("Kalpesh ");

        return names;
    }

    //sort using java 7
    private static void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    //sort using java 8
    private static void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

    // simplification java 8 1
    private static void sortList1(List<String> names) {
        names.sort(Comparator.naturalOrder());
    }

    // simplification java 8 2
    private static void sortList2(List<String> names) {
        names.sort(String::compareTo);
    }
}
