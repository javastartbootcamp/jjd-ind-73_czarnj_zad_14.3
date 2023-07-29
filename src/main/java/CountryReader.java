import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;

public class CountryReader {

    public Map<String, Country> readCountries(String fileName) {
        Map<String, Country> countries = new HashMap<>();
        try (var br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                Country country = parseToCountry(nextLine);
                countries.put(country.getCode(), country);
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return countries;
    }

    private Country parseToCountry(String line) {
        String[] splittedLine = line.split(";");
        String code = splittedLine[0];
        String name = splittedLine[1];
        int people = Integer.parseInt(splittedLine[2]);
        return new Country(code, name, people);
    }
}
