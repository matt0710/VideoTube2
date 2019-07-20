public class Video {
    private String durata;
    private String visualizzazioni;
    private String risoluzione;
    private String sottotitoli;

    public Video (){}
    public Video (String durata, String visualizzazioni, String risoluzione, String sottotitoli){
        this.durata = durata;
        this.visualizzazioni = visualizzazioni;
        this.risoluzione = risoluzione;
        this.sottotitoli = sottotitoli;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getVisualizzazioni() {
        return visualizzazioni;
    }

    public void setVisualizzazioni(String visualizzazioni) {
        this.visualizzazioni = visualizzazioni;
    }

    public String getRisoluzione() {
        return risoluzione;
    }

    public void setRisoluzione(String risoluzione) {
        this.risoluzione = risoluzione;
    }

    public String getSottotitoli() {
        return sottotitoli;
    }

    public void setSottotitoli(String sottotitoli) {
        this.sottotitoli = sottotitoli;
    }

    @Override
    public String toString() {
        return "durata: " + this.durata + "\tvisualizzazioni: " + this.visualizzazioni +
                "\trisoluzione: " + this.risoluzione + "\tsottotitoli: " + this.sottotitoli + "\n";
    }
}
