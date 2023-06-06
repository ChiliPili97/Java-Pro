import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LessonDao {

    private DataSource dataSource;

    public LessonDao(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Lesson insert(Lesson entity) {
        Objects.requireNonNull(entity);
        if (entity.getId() != null) {
            throw new JdbcOperationException("Id must not be provided during the insert operation!");
        }
        final var SQL = """
                INSERT INTO schedule.lesson(name, homework_id) VALUES (?, ?)
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            int idx = 1;
            ps.setString(idx++, entity.getName());
            ps.setLong(idx, entity.getHomework().getId());
            int rowInserted = ps.executeUpdate();
            if (rowInserted < 1) {
                throw new JdbcOperationException("No rows were inserted, input entity = %s".formatted(entity));
            }
            ResultSet generatedKey = ps.getGeneratedKeys();
            if (generatedKey.next()) {
                Long id = generatedKey.getLong(1);
                entity.setId(id);
            }
            return entity;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to insert a product = %s".formatted(entity), e);
        }
    }

    public boolean delete(Long id) {
        Objects.requireNonNull(id);
        final var SQL = """
                DELETE FROM schedule.lesson WHERE id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
            int idx = 1;
            ps.setLong(idx, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted < 1) {
                throw new JdbcOperationException("No rows were deleted!");
            }
            return true;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to delete a product by id = %d".formatted(id), e);
        }
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> allLessons = new ArrayList<>();
        final var SQL = """
                SELECT id, name, homework_id FROM schedule.lesson
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("id"));
                lesson.setHomework(getHomeworkById(rs.getLong("homework_id")));
                lesson.setName(rs.getString("name"));
                allLessons.add(lesson);
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to select all lessons", e);
        }
        return allLessons;
    }

    public Lesson getLessonById(Long id) {
        Objects.requireNonNull(id);
        Lesson lesson = new Lesson();
        final var SQL = """
                SELECT id, name, homework_id FROM schedule.lesson WHERE id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
            int idx = 1;
            ps.setLong(idx, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lesson.setId(rs.getLong("id"));
                lesson.setHomework(getHomeworkById(rs.getLong("homework_id")));
                lesson.setName(rs.getString("name"));
                return lesson;
            } else {
                throw new JdbcOperationException("Product with id = %d not found!".formatted(id));
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to find a product by id = %d".formatted(id), e);
        }
    }

    public Homework getHomeworkById(Long id) {
        Objects.requireNonNull(id);
        Homework homework = new Homework();
        final var SQL = """
                SELECT id, name, description FROM schedule.homework WHERE id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
            int idx = 1;
            ps.setLong(idx, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                homework.setId(rs.getLong("id"));
                homework.setName(rs.getString("name"));
                homework.setDescription(rs.getString("description"));
                return homework;
            } else {
                throw new JdbcOperationException("Homework with id = %d not found!".formatted(id));
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to find a homework by id = %d".formatted(id), e);
        }
    }
}
