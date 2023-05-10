package blog.softwaretester.sandboy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {

    @Test
    void generateReport() {
        new Core().generateReport();
    }
}