import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("out.txt");
        if(!file.exists()){
            FileOutputStream fos = new FileOutputStream("out.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            InvertedIndex obj = new InvertedIndex();
            obj.indexCollection("collection_html");
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }
        FileInputStream fis = new FileInputStream("out.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        InvertedIndex obj_main = (InvertedIndex) oin.readObject();
        System.out.println(obj_main.executeQuery("Brutus AND and"));

        }
    }