package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addPredicate(s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minSize) {
        addPredicate(s -> s == null || s.length() >= minSize);
        return this;
    }

    public StringSchema contains(String subText) {
        addPredicate(s -> s == null || s.contains(subText));
        return this;
    }

}
