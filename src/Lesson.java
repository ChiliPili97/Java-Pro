public class Lesson {
    Long id;
    String name;
    Long homework;

    public Lesson() {
    }

    public Lesson(String name, Long homework) {
        this.name = name;
        this.homework = homework;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHomework() {
        return homework;
    }

    public void setHomework(Long homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homework=" + homework +
                '}';
    }
}
