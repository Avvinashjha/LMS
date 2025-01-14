package patrons;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String memberId;
    private String email;
    private List<String> borrowingHistory;

    public Patron(String name, String memberId, String email){
        this.name = name;
        this.memberId = memberId;
        this.email = email;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<String> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public void addToBorrowingHistory(String bookISBN) {
        borrowingHistory.add(bookISBN); // Track borrowing by ISBN
    }

    @Override
    public String toString() {
        return String.format("Patron [Name: %s, MemberID: %s, Email: %s, Borrowing History: %s]",
                name, memberId, email, borrowingHistory);
    }
}
