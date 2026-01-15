package trees;

import java.util.Iterator;
import java.util.TreeSet;

public class Test01LibraryTreeSet {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("============ Tree Set  =============");
        System.out.println();

        TreeSet<String> set = new TreeSet<>();
        System.out.println(set);
        set.add("Tim");
        System.out.println(set);
        set.add("Jim");
        System.out.println(set);
        set.add("Kim");
        System.out.println(set);
        set.add("Tom");
        System.out.println(set);
        set.add("Bob");
        System.out.println(set);
        System.out.println();
        System.out.println();

        Iterator<String> itr = set.iterator();
        System.out.println(set);

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println(set);

        itr.remove();
        System.out.println(set);
        System.out.println(set.size());
    }
}
