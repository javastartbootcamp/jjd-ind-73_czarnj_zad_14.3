public class Country {
    private String code;
    private String name;
    private int people;

    public Country(String code, String name, int people) {
        this.code = code;
        this.name = name;
        this.people = people;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPeople() {
        return people;
    }
}
