import java.io.*;

public class nogotogo {
    public static void main(String[] args) {
        skrivTilFil();
        skrivDatFil();
        læsDatFil();
    }

    public static void skrivTilFil() {
        try {
            int x = 1;
            float y = (float) 10.5;
            String s= "Pernille";
            PrintWriter fil = new PrintWriter("Opgavenogo1.txt");
            fil.format("%d %s %f\n",x,s,y);
            fil.format("%d %s %f\n",x,s,y);
            fil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void skrivDatFil() {
        try {
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("Opgavenogo1datfil.dat"));
            int x = 1;
            float y = (float) 10.5;
            String s= "Pernille";
            outputStream.writeInt(x);
            outputStream.writeUTF(s);
            outputStream.writeFloat(y);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void læsDatFil() {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream("Opgavenogo1datfil.dat"));
            int x;
            float y;
            String s;

            x = inputStream.readInt();
            s = inputStream.readUTF();
            y = inputStream.readFloat();
            System.out.format("%d %s %f",x,s,y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
