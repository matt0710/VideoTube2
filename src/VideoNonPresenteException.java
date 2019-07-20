public class VideoNonPresenteException extends Exception {
    public VideoNonPresenteException (){
        System.err.println("Impossibile rimuovere il video poichè non presente nel canale!");
    }
}
