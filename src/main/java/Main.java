import java.io.UncheckedIOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "countries.csv";
    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        CountryReader reader = new CountryReader();
        try {
            Map<String, Country> countries = reader.readCountries(FILE_NAME);
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String code = scanner.nextLine();
            Country country = countries.get(code.toUpperCase());
            if (country == null) {
                System.out.printf("Kod kraju %s nie został znaleziony.%n", code);
            } else {
                System.out.printf("%s (%s) ma %d ludności.%n", country.getName(), country.getCode(),
                        country.getPeople());
            }
        } catch (UncheckedIOException ex) {
            System.out.println("Brak pliku " + FILE_NAME + ".");
        }
    }

}
