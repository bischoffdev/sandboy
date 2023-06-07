package blog.softwaretester.sandboy.filesystem;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.logger.SandboyLogger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllBytes;

@Singleton
public class FileIO {
    private final SandboyLogger logger;

    @Inject
    public FileIO(final SandboyLogger logger) {
        this.logger = logger;
    }

    public String readContentFromFile(final String filePath) throws SandboyException {
        try {
            byte[] bytes = readAllBytes(Paths.get(filePath));
            return new String(bytes).trim();
        } catch (IOException e) {
            throw new SandboyException("File " + filePath + " does not exist!");
        }
    }

    public void createDirectory(final String dirName) throws SandboyException {
        File directory = new File(dirName);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new SandboyException("Could not create directory " + dirName + ".");
        }
    }

    public void copyResourceFromJar(final String resourceName, final String destination) throws SandboyException {
        final int BYTE_BLOCK = 4096;
        try (InputStream inputStream = this.getClass().getResourceAsStream(resourceName)) {
            System.out.println(inputStream);

            int readBytes;
            byte[] buffer = new byte[BYTE_BLOCK];
            try (OutputStream outputStream = new FileOutputStream(destination)) {
                while ((readBytes = Objects.requireNonNull(inputStream).read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readBytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new SandboyException("Cannot write resource '" + resourceName + "': " + e.getMessage());
            }
        } catch (Exception e) {
            throw new SandboyException("Cannot process resource '" + resourceName + "': " + e.getMessage());
        }
    }

    public void copyResource(final String source, final String destination) throws SandboyException {
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new SandboyException("Cannot copy resource '" + source + "': " + e.getMessage());
        }
    }

    public List<Path> getXmlFilePaths(final String sourcePath) throws SandboyException {
        List<Path> xmlPaths;
        try (Stream<Path> walk = Files.walk(Paths.get(sourcePath))) {
            xmlPaths =
                    walk
                            .filter(Files::isRegularFile)
                            .filter(p -> p.toString().toLowerCase().endsWith(".xml"))
                            .collect(Collectors.toList());

        } catch (IOException e) {
            throw new SandboyException("Unable to find XML files in " + sourcePath + "!");
        }
        return xmlPaths;
    }
}
