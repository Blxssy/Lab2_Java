import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        boolean fl = true;
        Scanner scanner = new Scanner(System.in);
        while(fl){
            System.out.println(
                    "0 - Выход\n" +
                    "1 - Ввести путь к файлу\n"
            );
//            "./texts/test.txt"
            String input;
            input = scanner.nextLine();
            switch (input){
                case "0":
                    fl = false;
                    break;
                case "1":{
                    System.out.println("Введите путь к файлу:");
                    String inputPath = scanner.nextLine();
                    fileSystem.ReadFile(inputPath);
                    System.out.println("Введите название выходного файла:");
                    String output = scanner.nextLine();
                    fileSystem.WriteFile(output);
                    break;
                }
            }
        }
    }
}
