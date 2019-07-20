import java.io.*;
import java.util.LinkedList;

public class GetDataFromFile<E> {
    private String path;
    private int fileLength;
    private String regex;

    public GetDataFromFile (){}
    public GetDataFromFile (String path, int fileLength, String regex){
        this.path = path;
        this.fileLength = fileLength;
        this.regex = regex;
    }

    public LinkedList<E> getData () throws IOException{

        File file = new File(this.path);

        if (file.exists()){
            if (file.isFile()){
                BufferedReader reader = new BufferedReader(new FileReader(this.path));
                String s = reader.readLine();
                String[] str;
                Video v;
                Canale c;
                E e;
                LinkedList<E> list = new LinkedList<>();

                for (int i=0; i<this.fileLength; i++){
                    str = s.split(this.regex);
                    if (str.length == 4){
                        v = new Video(str[0], str[1], str[2], str[3]);
                        e = (E)v;
                        list.add(e);
                    }
                    else if (str.length == 3){
                        c = new Canale(str[0], str[1], str[2]);
                        e = (E)c;
                        list.add(e);
                    }

                    s = reader.readLine();
                }
                reader.close();
                return list;
            }
            else if (file.isDirectory()){
                BufferedWriter writer;
                File fileDaScrivere = new File(this.path + "out.txt");
                String[] directory = file.list();
                writer = new BufferedWriter( new FileWriter(fileDaScrivere));

                for (String s : directory){
                    writer.write(s + "\n");
                }
                writer.close();
                return null;
            }
            else throw new IOException("The path isn't file or directory");
        }else
            throw new IOException("the file doesn't exist!");

    }
}
