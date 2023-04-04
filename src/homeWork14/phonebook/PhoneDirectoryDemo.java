package homeWork14.phonebook;

public class PhoneDirectoryDemo {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Record("Andrii", 123456));
        phoneDirectory.add(new Record("Sergii", 123456));
        phoneDirectory.add(new Record("Ivan", 123456));
        phoneDirectory.add(new Record("Andrii", 654321));

        System.out.println(phoneDirectory.find("Andrii"));
        System.out.println(phoneDirectory.findAll("Andrii"));
        System.out.println(phoneDirectory.findAll("Ruslan"));
    }
}
