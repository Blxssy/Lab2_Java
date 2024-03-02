import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private Map<Character, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }

    public void ReadFile(){
        try(FileInputStream fin = new FileInputStream("./texts/test.txt"))
        {
            int ch;
            while((ch = fin.read()) != -1){
                if(ch == 32 || ch == 10 || ch == 13){
                    continue;
                }
                if(map.containsKey((char)ch)){
                    map.put( (char)ch,  (map.get((char)ch) + 1));
                }
                else{
                    map.put( (char)ch,  1);
                }
            }

//            for (int i = 0; i < 256; i++) {
//                if(map.containsKey((char)i)){
//                    System.out.println((char)i + " " + map.get((char)i));
//                }
//            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void WriteFile(){
        boolean isLastEntry = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
