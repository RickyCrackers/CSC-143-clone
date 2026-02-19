import utils.ArrayList;

public class TmpArrayListProbe {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add(null);
        try {
            System.out.println("indexOf(null)=" + a.indexOf(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> b = new ArrayList<>();
        b.add(null);
        try {
            System.out.println("equals with null element=" + a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(1);
        c.add(1);

        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        c.removeAll(d);
        System.out.println("after removeAll [1] from [1,1,1]: " + c + " size=" + c.size());
    }
}
