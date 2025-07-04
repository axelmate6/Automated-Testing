import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> directory;

    public PhoneBook(Map<String, List<String>> directory) {
        this.directory = directory;
    }

    public PhoneBook() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.get(lastName);
    }
}
