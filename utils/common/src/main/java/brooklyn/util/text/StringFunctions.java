package brooklyn.util.text;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Functions;

public class StringFunctions {

    public static Function<String,String> append(final String suffix) {
        return new Function<String, String>() {
            @Override
            @Nullable
            public String apply(@Nullable String input) {
                if (input==null) return null;
                return input + suffix;
            }
        };
    }

    /** given e.g. "hello %s" returns a function which will insert a string into that pattern */
    public static Function<Object, String> formatter(final String pattern) {
        return new Function<Object, String>() {
            public String apply(@Nullable Object input) {
                return String.format(pattern, input);
            }
        };
    }

    /** given e.g. "hello %s %s" returns a function which will insert an array of two strings into that pattern */
    public static Function<Object[], String> formatterForArray(final String pattern) {
        return new Function<Object[], String>() {
            public String apply(@Nullable Object[] input) {
                return String.format(pattern, input);
            }
        };
    }

    /** joins the given objects in a collection as a toString with the given separator */
    public static Function<Iterable<?>, String> joiner(final String separator) {
        return new Function<Iterable<?>, String>() {
            public String apply(@Nullable Iterable<?> input) {
                return Strings.join(input, separator);
            }
        };
    }

    /** joins the given objects as a toString with the given separator, but expecting an array of objects, not a collection */
    public static Function<Object[], String> joinerForArray(final String separator) {
        return new Function<Object[], String>() {
            public String apply(@Nullable Object[] input) {
                return Strings.join(input, separator);
            }
        };
    }

    /** provided here as a convenience; prefer {@link Functions#toStringFunction()} */
    public static Function<Object,String> toStringFunction() {
        return Functions.toStringFunction();
    }
}
