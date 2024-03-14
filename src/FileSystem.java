import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private boolean readSuccess = false;
    private Map<Character, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }

    public void ReadFile(String path) {
        try (FileInputStream fin = new FileInputStream(path)) {
            int ch;
            while ((ch = fin.read()) != -1) {
                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                    char character = (char) ch;
                    map.put(character, map.getOrDefault(character, 0) + 1);
                }
            }
            readSuccess = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + path);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void WriteFile(String name) {
        if (!readSuccess) {
            throw new IllegalStateException("Не удалось прочитать файл для записи");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
        }
    }

    public boolean isReadSuccess() {
        return readSuccess;
    }
}
