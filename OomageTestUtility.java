package hw4.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO: Write a utility function that returns true if the given oomages 
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = 0;
        int[] buckets = new int[M];
        for (int i = 0; i < M; i = i + 1) {
            buckets[i] = 0;
        }

        int bucketNum;
        for (Oomage cur : oomages) {
            bucketNum = (cur.hashCode() & 0x7FFFFFFF) % M;
            buckets[bucketNum] = buckets[bucketNum] + 1;
            N = N + 1;
        }

        for (int i = 0; i < M; i = i + 1) {
            if (buckets[i] < (N / 50.0) || buckets[i] > (N / 2.5)) {
                return false;
            }
        }

        return true;
    }
}
