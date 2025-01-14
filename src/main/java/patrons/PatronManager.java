package patrons;

import java.util.HashMap;
import java.util.Map;

public class PatronManager {
    private Map<String, Patron> patrons; // userid : user

    public PatronManager(){
        patrons = new HashMap<>();
    }

    public void addPatron(Patron patron){
        patrons.put(patron.getMemberId(), patron);
    }

    public Patron getPatron(String memberId) {
        return patrons.get(memberId);
    }

    public void updatePatronInfo(String memberId, String newEmail) {
        Patron patron = patrons.get(memberId);
        if (patron != null) {
            patron.setEmail(newEmail);
        }
    }

    public void listAllPatrons() {
        patrons.values().forEach(System.out::println);
    }
}
