import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<Video> getVideoFromFile (String path) throws IOException{

        File file = new File(path);

        if (file.exists() && file.isFile()){
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String str = reader.readLine();
            String [] s;// = str.split(" ");
            LinkedList<Video> lista = new LinkedList<>();
            Video video;

            for (int i=0; i<5; i++){
                s = str.split(" ");
                video = new Video(s[0], s[1], s[2], s[3]);
                lista.add(video);
                str = reader.readLine();
                //s = str.split(" ");
            }
            reader.close();
            return lista;
        }else if (file.exists() && file.isDirectory()){
            BufferedWriter writer = null;
            File fileDaScrivere = new File(path + "out.txt");
            writer = new BufferedWriter(new FileWriter(fileDaScrivere));
            String[] str = file.list();

            for (String s : str){
                writer.write(s + "\n");
            }
            writer.close();
            return null;
        }else
            throw new FileNotFoundException("fnf");

    }

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        String pathVideo;
        String pathCanale;

        GetDataFromFile<Canale> getCanale;
        GetDataFromFile<Video> getVideo;

        LinkedList<Canale> listaCanale;
        LinkedList<Video> listaVideo;

        HashMap<Canale, LinkedList<Video>> mappa;

        VideoPlayer videoPlayer1;
        VideoPlayer videoPlayer2;
        VideoTube youtube;

        Video nuovoVideo1;
        Video nuovoVideo2;

        System.out.println("inserisci la path del video: ");
        pathVideo = sc.nextLine();

        System.out.println("Inserisci la path del canale: ");
        pathCanale = sc.nextLine();


        getVideo = new GetDataFromFile<>(pathVideo, 5, " ");
        getCanale = new GetDataFromFile<>(pathCanale, 3, " ");
        try{
            /*System.out.println(getVideo.getData());
            System.out.println("_________________________________");
            System.out.println(getCanale.getData());*/

            listaVideo = getVideo.getData();
            listaCanale = getCanale.getData();

            mappa = new HashMap<>();
            videoPlayer1 = new VideoPlayer(100, false, listaVideo.get(0));
            videoPlayer2 = new VideoPlayer(1000, false, listaVideo.get(1));

            mappa.put(listaCanale.get(0), listaVideo);
            youtube = new VideoTube(mappa, videoPlayer1);

            youtube.aggiungiCanale(listaCanale.get(1));

            nuovoVideo1 = new Video("12min", "100", "1920*1080", "si");
            youtube.aggiungiVideo(listaCanale.get(1), nuovoVideo1);

            nuovoVideo2 = new Video("19min", "800", "1920*1080", "no");
            youtube.aggiungiVideo(listaCanale.get(1), nuovoVideo2);

            System.out.println(youtube);

            youtube.rimuoviVideo(listaCanale.get(1), nuovoVideo1);

            System.out.println("__________________________________________");
            System.out.println(youtube);

            videoPlayer1.attivaSottotitoli();

            System.out.println("_______________________");
            System.out.println(videoPlayer1);



        }catch (IOException io){
            System.err.println("fnf");
        }catch (CanaleNonPresenteException cnp){ }
        catch (VideoNonPresenteException vnp){}
        catch (NoSottotitoliException ns){}


    }
}
