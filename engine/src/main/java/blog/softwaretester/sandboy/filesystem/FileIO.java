package blog.softwaretester.sandboy.filesystem;

import blog.softwaretester.sandboy.exceptions.SandboyException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

@Singleton
public class FileIO {
    @Inject
    public FileIO() {
    }

    public String readContentFromFile(final String filePath) throws SandboyException {
        try {
            byte[] bytes = readAllBytes(Paths.get(filePath));
            return new String(bytes).trim();
        } catch (IOException e) {
            throw new SandboyException("File " + filePath + " does not exist!");
        }
    }
}
