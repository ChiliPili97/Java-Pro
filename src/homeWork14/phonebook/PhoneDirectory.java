package homeWork14.phonebook;

import java.util.ArrayList;

public class PhoneDirectory {

    private ArrayList<Record> contacts = new ArrayList<>();

    public void add(Record contact) {
        this.contacts.add(contact);
    }

    public Record find(String name) {
        for (Record contact : contacts) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Record> findAll(String name) {
        ArrayList<Record> result = new ArrayList<>();
        for (Record contact : contacts) {
            if (contact.name.equals(name)) {
                result.add(contact);
            }
        }
        return result.size() == 0 ? null : result;
    }
}
