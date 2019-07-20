public class VideoPlayer {
    private int volume;
    private boolean sottotitoli;
    private Video videoProva;

    public VideoPlayer (){}
    public VideoPlayer (int volume, boolean sottotitoli, Video videoProva){
        this.volume = volume;
        this.sottotitoli = sottotitoli;
        this.videoProva = videoProva;
    }

    public void attivaSottotitoli () throws  NoSottotitoliException{
        if (this.videoProva.getSottotitoli().equals("si"))
            this.sottotitoli = true;
        else
            throw new NoSottotitoliException();
    }

    public void disattivaSottotitoli (){
        this.sottotitoli = false;
    }

    public void play (){
        System.out.println("play");
    }
    public void stop (){
        System.out.println("stop");
    }
    public void pausa (){
        System.out.println("pausa");
    }

    public void aumentaVolume (int incremento){
        this.volume += incremento;
    }

    public void decrementaVolume (int decremento){
        this.volume -= decremento;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean getSottotitoli() {
        return sottotitoli;
    }

    public void setSottotitoli(boolean sottotitoli) {
        this.sottotitoli = sottotitoli;
    }

    public Video getVideoProva() {
        return videoProva;
    }

    public void setVideoProva(Video videoProva) {
        this.videoProva = videoProva;
    }

    @Override
    public String toString() {
        return "volume: " + this.volume + "\tsottotitoli: " + this.sottotitoli + "\tvideo: " + this.videoProva + "\n";
    }
}
