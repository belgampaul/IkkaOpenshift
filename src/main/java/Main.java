import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ikka
 * @date: 28.07.2015.
 */
public class Main {
  public static void main(String[] args) {
    File file = new File("D:/tmp/1.txt");
    try {
      ArrayList<String> outStrings = new ArrayList<>();
      List<String> strings = Files.readAllLines(file.toPath());

      for (String string : strings) {
        if (string.contains("<version>")) {
          continue;
        }
        outStrings.add(string);
      }

      Files.write(new File("D:/tmp/11.txt").toPath(), outStrings, StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
