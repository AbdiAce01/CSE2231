import components.sequence.Sequence;

/**
 * Implements method to smooth a {@code Sequence<Integer>}.
 *
 * @author Abdifatah Ashirow
 *
 */
public final class SequenceSmooth {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SequenceSmooth() {
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @param s2
     *            the resulting sequence
     * @replaces s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static void smooth(Sequence<Integer> s1, Sequence<Integer> s2) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s2 != null : "Violation of: s2 is not null";
        assert s1 != s2 : "Violation of: s1 is not s2";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        s2.clear();
        int count = 0;
        int avg;

        if (s1.length() > 1) {
            while (count < s1.length() - 1) {
                int i = s1.entry(count);
                int j = s1.entry(count + 1);

                if ((i > 0 && j > 0) || (i < 0 && j < 0)) {
                    avg = (i / 2) + (j / 2) + (i % 2 + j % 2) / 2;
                } else {
                    avg = (i + j) / 2;
                }

                s2.add(count, avg);
                count++;
            }
        }
    }

    public static void smooth1(Sequence<Integer> s1, Sequence<Integer> s2) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s2 != null : "Violation of: s2 is not null";
        assert s1 != s2 : "Violation of: s1 is not s2";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        s2.clear();

        if (s1.length() > 1) {
            int i = s1.entry(0);
            int j = s1.entry(0 + 1);

            int ii = i % 2;
            int jj = j % 2;

            int rem = ii + jj;

            if ((ii < 0 && jj > 0) || (ii > 0 && jj < 0)) {
                rem = rem * 2;
            }

            int avg = i / 2 + j / 2 + rem / 2;

            s2.add(0, avg);
            int temp = s1.remove(0);
            smooth1(s1, s2);

        }
        if (s1.length() <= 1) {
            s1.add(0, temp);

        }

    }

}
