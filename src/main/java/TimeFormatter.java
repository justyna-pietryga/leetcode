/**
 19-Jan-2022
 https://www.codewars.com/kata/52742f58faf5485cae000b9a
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";
        AtomicInteger remainingSeconds = new AtomicInteger(seconds);

        return Arrays.stream(TimeUnit.values())
                .map(unit -> getTimeData(remainingSeconds, unit))
                .filter(timeData -> timeData.getTimeValueInThisUnit() > 0)
                .map(TimeData::toString)
                .collect(Collectors.collectingAndThen(Collectors.toList(), joiningWithDifferentLastDelimiter(", ", " and ")));
    }

    private static TimeData getTimeData(AtomicInteger remainingSeconds, TimeUnit unit) {
        int measureInSeconds = unit.getInSeconds();
        int howManyInThisUnit = remainingSeconds.get() / measureInSeconds;

        if (howManyInThisUnit >= 1) {
            remainingSeconds.set(remainingSeconds.get() % measureInSeconds);
            return new TimeData(unit, howManyInThisUnit);
        } else {
            return new TimeData(unit, 0);
        }
    }

    private static Function<List<String>, String> joiningWithDifferentLastDelimiter(String delimiter, String lastDelimiter) {
        return list -> {
            int last = list.size() - 1;
            if (last < 1) return String.join(delimiter, list);
            return String.join(lastDelimiter,
                    String.join(delimiter, list.subList(0, last)),
                    list.get(last));
        };
    }


    protected enum TimeUnit {
        YEARS(365 * 24 * 60 * 60, "years", "year"),
        DAYS(24 * 60 * 60, "days", "day"),
        HOURS(60 * 60, "hours", "hour"),
        MINUTES(60, "minutes", "minute"),
        SECONDS(1, "seconds", "second");

        private final int inSeconds;
        private final String pluralUnitName;
        private final String nonPluralUnitName;

        TimeUnit(int inSeconds, String pluralUnitName, String nonPluralUnitName) {
            this.inSeconds = inSeconds;
            this.pluralUnitName = pluralUnitName;
            this.nonPluralUnitName = nonPluralUnitName;
        }

        public int getInSeconds() {
            return this.inSeconds;
        }

        public String getProperUnitForm(int number) {
            return number > 1 ? this.pluralUnitName : this.nonPluralUnitName;
        }
    }

    protected static class TimeData {
        private final TimeUnit timeUnit;
        private final int timeValueInThisUnit;

        public TimeData(TimeUnit timeUnit, int value) {
            this.timeUnit = timeUnit;
            this.timeValueInThisUnit = value;
        }

        public int getTimeValueInThisUnit() {
            return timeValueInThisUnit;
        }

        @Override
        public String toString() {
            return this.timeValueInThisUnit + " " + this.timeUnit.getProperUnitForm(this.timeValueInThisUnit);
        }
    }
}