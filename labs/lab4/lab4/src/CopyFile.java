import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String sourceFilePath = "1.txt";
        String targetFilePath = "2.txt";

        try {
            FileReader reader = new FileReader(sourceFilePath);

            FileWriter writer = new FileWriter(targetFilePath);

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

            reader.close();
            writer.close();

            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
