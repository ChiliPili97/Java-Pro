package homeWork14.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneDirectory {

    private List<Record> contacts = new ArrayList<>();

    public void add(Record contact) {
        Objects.requireNonNull(contact);
        this.contacts.add(contact);
    }

    public Record find(String name) {
        Objects.requireNonNull(name);
        for (Record contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        Objects.requireNonNull(name);
        List<Record> result = new ArrayList<>();

        for (Record contact : contacts) {
            if (contact.getName().equals(name)) {
                result.add(contact);
            }
        }
        return result.size() == 0 ? null : result;
    }
}
