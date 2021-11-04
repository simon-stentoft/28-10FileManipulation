import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class hej {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numre2 = {3,4,5,2,3,4,5,6,3,4};

        int numre[];
        numre = new int[10];

        for (int i = 0; i < 10; i++) {
            int nummer = scanner.nextInt();
            numre[i] = nummer;
        }

        udskriv(numre);
        System.out.println("Gennemsnit: " + gennemsnit(numre, 10));

        System.out.println("");
        læs();
        System.out.println("");
        skriv();

        System.out.println("");
        skrivTilDatFil(numre2,10);
        //plus10TilArray();
        System.out.println("");

        System.out.println("testDataStream metode:");
        testDataStream();
        System.out.println("");


    }
    public static void udskriv(int[] numre) {
        for (int i = 0; i < numre.length; i++) {
            System.out.println("Nummer på plads " + i + ": "+ numre[i]);
        }
        System.out.println(Arrays.toString(numre));
    }
    public static double gennemsnit(int[] numre, int antal) {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numre[i];
        }
        return sum/antal;
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
            System.out.println("Opgave 2: " + Arrays.toString(arrayting));
            double sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += arrayting[i];
            }
            System.out.println("Gennemsnit: " + sum/arrayting.length);
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public static void skrivTilDatFil(int[] a, int antal) {
        try {
            FileOutputStream out = new FileOutputStream("TempArray.dat");
            for (int i = 0; i < antal; i++) {
                out.write(a[i] + 10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testDataStream() {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp2.dat"));
            output.writeUTF("Lokke");
            output.writeDouble(67.34);
            output.writeUTF("Hikke");
            output.writeDouble(25.4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInputStream input = new DataInputStream(new FileInputStream("temp2.dat"));
            String navn;
            Double alder;
            while (input.available()>0) {
                navn = input.readUTF();
                alder = input.readDouble();
                System.out.println(navn);
                System.out.println(alder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void plus10TilArray() {
        try {
            FileOutputStream out = new FileOutputStream("MyFile.txt");
            for (int i = 0; i < 10; i++) {
                out.write(i + 10);
            }
            FileInputStream input = new FileInputStream("MinFil3.dat");
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value + " ");
            }
        } catch (IOException e) {
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
