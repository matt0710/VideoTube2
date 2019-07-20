import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class VideoTube {

    private HashMap<Canale, LinkedList<Video>> mappa = new HashMap<>();
    private VideoPlayer videoPlayer;

    public VideoTube (){}
    public VideoTube (HashMap<Canale, LinkedList<Video>> mappa, VideoPlayer videoPlayer){
        this.mappa = mappa;
        this.videoPlayer = videoPlayer;
    }

    public void aggiungiCanale (Canale canale){
        if (this.mappa.containsKey(canale)) {
            System.out.println("Il canale " + canale.getNome() +" è già presente");
            return;
        }
        LinkedList<Video> zeroItemList = new LinkedList<>();
        this.mappa.put(canale, zeroItemList);
    }

    public void rimuoviCanale (Canale canale) throws CanaleNonPresenteException{
        if (this.mappa.containsKey(canale)){
            this.mappa.remove(canale);
            return;
        }
        throw new CanaleNonPresenteException();
    }

    public void aggiungiVideo (Canale canale, Video video) throws CanaleNonPresenteException{
        if (this.mappa.containsKey(canale)){
            this.mappa.get(canale).add(video);
            return;
        }
        throw new CanaleNonPresenteException();
    }

    public void rimuoviVideo (Canale canale, Video video) throws CanaleNonPresenteException, VideoNonPresenteException{
        boolean videoTrovato = false;
        if (this.mappa.containsKey(canale)){
            for (int i=0; i<this.mappa.get(canale).size(); i++){
                if (this.mappa.get(canale).get(i) == video){
                    videoTrovato = true;
                }
            }
            if (videoTrovato) {
                this.mappa.get(canale).remove(video);
                return;
            }
            throw new VideoNonPresenteException();

        }
        else
            throw new CanaleNonPresenteException();
    }

    public void playVideo (){
        this.videoPlayer.play();
    }

    @Override
    public String toString() {
        Set<Canale> set1 = this.mappa.keySet();
        Iterator<Canale> iter = set1.iterator();
        String s = "";

        while (iter.hasNext()){
            Canale c = iter.next();
            s += "\n" + c + "\n";
            for (Video v : this.mappa.get(c))
                s += v;
        }
        return s;
    }
}
