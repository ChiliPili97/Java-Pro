package homeWork14.phonebook;

public class Record {
    String name;
    int phoneNumber;

    public Record(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
