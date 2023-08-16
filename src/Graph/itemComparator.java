package Graph;

import java.util.Comparator;

public class itemComparator implements Comparator<item> {
    @Override
    public int compare(item a, item b) {
        double r1 = (double) (a.value / b.value);
        double r2 = (double) (a.weight / b.weight);
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}
