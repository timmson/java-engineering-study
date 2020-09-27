package ru.timmson.load;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class Converter {

    private final static Map<Integer, String> N2R = new HashMap<>(ofEntries(
            entry(0, ""),
            entry(1, "I"),
            entry(5, "V"),
            entry(10, "X"),
            entry(50, "L"),
            entry(100, "C")
    ));

    final static Range RANGE = new Range(N2R.keySet());


/*    private final static Map<String, Integer> R2N = RANGE.toSteam()
            .map(Converter::toEntry)
            .collect(toMap(Entry::getKey, Entry::getValue));

    protected static Entry<String, Integer> toEntry(Integer number) {
        return entry(convert(number), number);
    }*/

/*    public static void checkIfValidRoman(String number) {
        if (!R2N.containsKey(number)) {
            throw new IndexOutOfBoundsException(number + " could not convert to range " + RANGE);
        }
    }*/

    public static void checkIfValidNumber(int number) {
        if (!RANGE.contains(number)) {
            throw new IndexOutOfBoundsException(number + " does not belongs to range " + RANGE);
        }
    }

/*    public static int convert(String number) {
        if (number == null) {
            return 0;
        }
        checkIfValidRoman(number);
        return R2N.get(number);
    }*/

    public static String convert(int number) {
        checkIfValidNumber(number);

        final var sNumber = String.valueOf(number);
        if (sNumber.indexOf("4") == 0) {

            return N2R.get(sNumber.length()) + N2R.get(5 * sNumber.length()) + (sNumber.length() > 1 ? convert(Integer.parseInt(sNumber.substring(1, sNumber.length() - 1))) : "");
        } else if (sNumber.indexOf("9") == 0) {

            return N2R.get(sNumber.length()) + N2R.get(10 * sNumber.length()) + (sNumber.length() > 1 ? convert(Integer.parseInt(sNumber.substring(1, sNumber.length() - 1))) : "");

        } else {

            final var keysIt = N2R.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).listIterator();

            var c = keysIt.next();
            while (keysIt.hasNext() && c > number) {
                c = keysIt.next();
            }

            return N2R.get(c) + (number > 0 ? convert(number - c) : "");
        }
    }

    private static class Range {

        private int min;
        private int max;

        public Range(Collection<Integer> c) {
            this.min = c.stream().min(Integer::compareTo).orElse(0);
            this.max = c.stream().max(Integer::compareTo).orElse(0);
        }

        public Stream<Integer> toSteam() {
            return IntStream.rangeClosed(min, max).boxed();
        }

        public boolean contains(int i) {
            return min <= i && i <= max;
        }

        @Override
        public String toString() {
            return "[" + min + ":" + max + "]";
        }

    }
}
