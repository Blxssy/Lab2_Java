import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileSystem fileSystem = new FileSystem();

        System.out.println("Введите путь к файлу для чтения:");
        String inputPath = scanner.nextLine();
        try {
            fileSystem.ReadFile(inputPath);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        if (fileSystem.isReadSuccess()) {
            System.out.println("Введите название файла для записи:");
            String outputPath = scanner.nextLine();
            try {
                fileSystem.WriteFile(outputPath);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
