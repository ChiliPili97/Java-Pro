import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {
    private static final String DB_PROPS = "db.properties";
    private static final String DB_URL = "db.url";
    private static final String DB_PASSWORD = "db.password";
    public static final String DB_USER = "db.user";

    private static Properties loadProperties () {
        try (InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream(DB_PROPS)) {
            Properties dbProperties = new Properties();
            dbProperties.load(is);
            return dbProperties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataSource intiDataSource () {
        Properties props = loadProperties();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(props.getProperty(DB_URL));
        dataSource.setPassword(props.getProperty(DB_PASSWORD));
        dataSource.setUser(props.getProperty(DB_USER));
        return dataSource;
    }

    public static void main(String[] args) {

        LessonDao lessonDao = new LessonDao(intiDataSource());
        lessonDao.insert( new Lesson("Jdbc", 5L));
        lessonDao.delete(10L);
        List<Lesson> allLessons = lessonDao.getAllLessons();
        for (Lesson lesson: allLessons) {
            System.out.println(lesson);
        }
        System.out.println(lessonDao.getLessonById(6L));
    }
}
