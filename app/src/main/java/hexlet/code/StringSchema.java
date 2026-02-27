package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate<String>> listPredicates = new ArrayList<>();

    public StringSchema required() {
        listPredicates.add(s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minSize) {
        listPredicates.add(s -> s == null || s.length() >= minSize);
        return this;
    }

    public StringSchema contains(String subText) {
        listPredicates.add(s -> s == null || s.contains(subText));
        return this;
    }

    public boolean isValid(String value) {
        for (var pred : listPredicates) {
            if (!pred.test(value)) {
                return false;
            }
        }
        return true;
    }

}
