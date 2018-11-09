package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IO {

    private final static Path C_PATH = Paths.get(Constants.C_ZH_LOCATION);

    public static void AppendLine(String line) {
        try {
            List<String> lines = Files.readAllLines(C_PATH);
            lines.add(line);
            Files.write(C_PATH, lines);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ReplaceLine(String oldLine, String newLine) {
        //boolean succes = false;

        try (Stream<String> stream = Files.lines(C_PATH)) {
            
            List<String> replacedLines = stream.map(line -> line.contains(oldLine) ? newLine : line).collect(Collectors.toList());
            
            Files.write(C_PATH, replacedLines);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }

        //return succes;
    }
}
