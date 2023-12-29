import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message) {
        super(message);
    }

    public static int Numbs(String str) throws CustomNumberFormatException {
        String f = "1234567890";
        for (int i = 0; i < str.length(); i++) {
            if (!f.contains(String.valueOf(str.charAt(i)))) {
                throw new CustomNumberFormatException("Строка" + " '" + str + "' " + "не является числом или не является числом типа int ^_^");
            }
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        try {
            System.out.println(Numbs("1255532fd"));
        } catch (CustomNumberFormatException e) {
            System.err.println(e.getMessage());
            FileWriter writer = new FileWriter("LogException.txt", true);
            writer.write(e.getMessage() + " " + LocalDateTime.now() + "\n");
            writer.close();
        }
    }
}




