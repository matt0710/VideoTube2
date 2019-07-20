public class Canale {
    public String nome;
    public String autore;
    public String dataDiCreazione;

    public Canale (){}
    public Canale (String nome, String autore, String dataDiCreazione){
        this.nome = nome;
        this.autore = autore;
        this.dataDiCreazione = dataDiCreazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getDataDiCreazione() {
        return dataDiCreazione;
    }

    public void setDataDiCreazione(String dataDiCreazione) {
        this.dataDiCreazione = dataDiCreazione;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\tautore: " + this.autore + "\tdata: " + this.dataDiCreazione + "\n";
    }
}
