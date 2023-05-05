import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Abdifatah Ashirow
 *
 */
public final class WordCounter {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private WordCounter() {
    }

    /**
     * Makes a HTML page that pulls from a {@code Map} of words and its number
     * of occurrences
     *
     * @param output
     *            the output text file we are writing to with
     *            {@code SimpleWriter}
     * @param words
     *            the {@code Map} containing all the words and its occurrences
     *            in the input text file
     * @param keyQueue
     *            the {@code Queue} containing the {@code words} 's keys
     * @param input
     *            the input text file read in by {@code SimpleReader}
     * @clears {@code keyQueue}, {@code words}
     * @ensures <pre>
     * {@code HTML code table elements = entries(word)}
     * </pre>
     *
     */
    private static void outputpage(SimpleWriter output, SimpleReader input,
            Map<String, Integer> words, Queue<String> keyQueue) {

        output.println("<html>");
        output.println("<head>");
        output.println("<title>Words Counted in " + input.name() + "</title>");

        output.println("<body>");
        //Header
        output.println("<h2>Words Counted in " + input.name() + "</h2>");
        output.println("<hr />");
        //Start of Table
        output.println("<table border=\"1\">");
        output.println("<tr>");
        output.println("<th>Words</th>");
        output.println("<th>Counts</th>");
        output.println("</tr>");
        //Loops through the Map, writing out the Keys and its respective Values
        while (words.iterator().hasNext()) {
            Map.Pair<String, Integer> tempPair = words
                    .remove(keyQueue.dequeue());
            output.println("<tr>");
            output.println("<td>" + tempPair.key() + "</td>");
            output.println("<td>" + tempPair.value() + "</td>");
            output.println("</tr>");
        }
        output.println("</table>");
        output.println("</body>");
        output.println("</html>");

    }

    /**
     * Processing through the input textFile ({@code SimpleReader}) and assigns
     * the word and its occurrences in a {@code Map}.
     *
     * @param input
     *            the input text file ({@code SimpleReader})
     * @param words
     *            the {@code Map} containing all the words and its occurrences
     * @updates {@code words}
     * @ensures <pre>
     * inFile's words = {@code Map}'s Key(words) and Value(occurrences)
     * </pre>
     */
    private static void readinput(SimpleReader input,
            Map<String, Integer> words) {

        int position = 0;

        /* Separator Characters */
        final String separatorStr = " \t,.'-`~: ";
        Set<Character> separatorSet = new Set1L<Character>();
        generateElements(separatorStr, separatorSet);

        while (!input.atEOS()) {

            String line = input.nextLine();
            position = 0;
            /* Loop through line */
            while (position < line.length()) {
                String key = nextWordOrSeparator(line, position, separatorSet);
                /* if the key is a word */
                if (!separatorSet.contains(key.charAt(0))) {
                    /* Add key to map if not included */
                    if (!words.hasKey(key)) {
                        words.add(key, 1);
                    }
                    /* If included increment the value of the word */
                    else {
                        int wordocc = words.value(key);
                        wordocc++;
                        words.replaceValue(key, wordocc);
                    }
                }
                /* Increase position for next word */
                position += key.length();
            }

        }

    }

    /**
     * Sorts through the {@code Map} using {@code Queue}'s sorting function
     *
     * @param words
     *            the {@code Map} containing all the words and its occurrences
     * @param order
     *            the {@code Comparator} that allows us to compare words
     *            lexicographically ignoring case
     * @param keyQueue
     *            the {@code Queue} that will contain all the words sorted.
     * @ensures <pre>
     * {@code Map} of words is in order based on the {@code Queue} keyQueue.
     * </pre>
     *
     */

    public static void SortWords(Map<String, Integer> words,
            Comparator<String> order, Queue<String> keyQueue) {
        assert words != null : "Violation of : words is not null";
        assert order != null : "Violation of : words is not null";
        assert keyQueue != null : "Violation of : words is not null";

        Map<String, Integer> tempM = words.newInstance();
        Queue<String> tempQ = keyQueue.newInstance();
        keyQueue.clear();

        /* loops through all elements of words */
        while (words.iterator().hasNext()) {
            /* Remove all elements until empty */
            Map.Pair<String, Integer> tempP = words.removeAny();

            /* add tempP into tempM */
            tempM.add(tempP.key(), tempP.value());
            keyQueue.enqueue(tempP.key());
        }

        /* Sort queue */
        keyQueue.sort(order);

        /* Add all emements back into queue in alphabetical order */
        while (keyQueue.iterator().hasNext()) {
            String tempK = keyQueue.dequeue();
            Map.Pair<String, Integer> orderedPair = tempM.remove(tempK);
            words.add(orderedPair.key(), orderedPair.value());
            tempQ.enqueue(tempK);
        }
        keyQueue.transferFrom(tempQ);
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces {@code strSet}
     * @ensures <pre>
     * {@code strSet = elements(str)}
     * </pre>
     */
    private static void generateElements(String str, Set<Character> strSet) {
        assert str != null : "Violation of: str is not null";
        assert strSet != null : "Violation of: strSet is not null";

        strSet.clear();
        for (int i = 0; i < str.length() - 1; i++) {

            strSet.add(str.charAt(i));

        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires <pre>
     * {@code 0 <= position < |text|}
     * </pre>
     * @ensures <pre>
     * {@code nextWordOrSeparator =
     *   text[ position .. position + |nextWordOrSeparator| )  and
     * if elements(text[ position .. position + 1 )) intersection separators = {}
     * then
     *   elements(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    elements(text[ position .. position + |nextWordOrSeparator| + 1 ))
     *      intersection separators /= {})
     * else
     *   elements(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    elements(text[ position .. position + |nextWordOrSeparator| + 1 ))
     *      is not subset of separators)}
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int count = 0;
        char returnedPiece = 'a';
        String returned = "";
        if (separators.contains(text.charAt(position))) {
            while (count < text.substring(position, text.length()).length()) {
                returnedPiece = text.charAt(position + count);
                if (separators.contains(text.charAt(position + count))) {
                    returned = returned + returnedPiece;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
            count = 0;
        } else {
            while (count < text.substring(position, text.length()).length()) {
                returnedPiece = text.charAt(position + count);
                if (!separators.contains(text.charAt(position + count))) {
                    returned = returned + returnedPiece;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
            count = 0;
        }
        return returned;

    }

    /**
     * Compare {@code String}s in lexicographic order. Regardless of case.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.toLowerCase().compareTo(o2.toLowerCase());
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        Map<String, Integer> words = new Map1L<String, Integer>();
        Comparator<String> order = new StringLT();
        Queue<String> keyQueue = new Queue1L<String>();

        out.println("Enter a input file.");
        SimpleReader input = new SimpleReader1L(in.nextLine());

        out.println("Please enter an output file ending in .html");
        SimpleWriter output = new SimpleWriter1L(in.nextLine());

        /* Read input into map */
        readinput(input, words);
        /* Sort map into order in queue */
        SortWords(words, order, keyQueue);
        /* Print output in HTML */
        outputpage(output, input, words, keyQueue);

        in.close();
        out.close();
        input.close();
        output.close();
    }

}
