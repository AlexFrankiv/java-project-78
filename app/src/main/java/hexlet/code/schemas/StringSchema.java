package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        addValidation("required", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int minSize) {
        addValidation("minLength", s -> s == null || s.length() >= minSize);
        return this;
    }

    public StringSchema contains(String subText) {
        addValidation("contains", s -> s == null || s.contains(subText));
        return this;
    }
}
