package blog.softwaretester.sandboy.filesystem;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

public class FileIO {
    public String readContentFromFile(final String filePath) throws Exception {
        try {
            byte[] bytes = readAllBytes(Paths.get(filePath));
            return new String(bytes).trim();
        } catch (IOException e) {
            throw new Exception("File " + filePath + " does not exist!");
        }
    }
}
