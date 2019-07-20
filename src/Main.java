import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

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
