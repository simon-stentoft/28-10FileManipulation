import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class læsfil {
    public static void main(String[] args) {
        læs();
        skriv();
    }
    public static void læs() {
        try {
            File file = new File("MyFile.txt");
            Scanner scanner = new Scanner(file);
            int arrayting[];
            arrayting = new int[10];


            while (scanner.hasNext()) {
                for (int i = 0; i < arrayting.length; i++) {
                    int nr = scanner.nextInt();
                    arrayting[i] = nr;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
    public static void skriv() {
        try {
            int x = 5;
            float y = (float) 4.45;
            String s="Hello";
            PrintWriter fil = new PrintWriter("test.txt");
            fil.format("%d %s %f\n",x,s,y);
            fil.format("%d %s %f\n",x,s,y);
            fil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
