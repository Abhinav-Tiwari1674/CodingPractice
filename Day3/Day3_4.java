package Day3;

import java.util.Arrays;

public class Day3_4 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }

        return childIndex;
    }
}