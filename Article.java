package entity;

public class Article {

    protected int Artikelnummer;
    protected String Mandant;
    protected String Bezeichnung1;
    protected String Bezeichnung2;
    protected String Matchcode;
    protected int Artikelgruppe;
    protected int Hauptartikelgruppe;
    protected int Vaterartikelgruppe;
    protected String Verkaufsmengeneinheit;
    protected String Basismengeneinheit;
    protected String Lagermengeneinheit;
    protected String Lagerfuehrung;
    protected String Lagerplatzzuordnung;
    protected String IstVerkaufsartikel;
    protected String Warennummer;
    protected boolean Aktiv;
    protected String Ursprungsland;

    public int getArtikelnummer() {
        return Artikelnummer;
    }

    public void setArtikelnummer(int artikelnummer) {
        Artikelnummer = artikelnummer;
    }

    public String getMandant() {
        return Mandant;
    }

    public void setMandant(String mandant) {
        Mandant = mandant;
    }

    public String getBezeichnung1() {
        return Bezeichnung1;
    }

    public void setBezeichnung1(String bezeichnung1) {
        Bezeichnung1 = bezeichnung1;
    }

    public String getBezeichnung2() {
        return Bezeichnung2;
    }

    public void setBezeichnung2(String bezeichnung2) {
        Bezeichnung2 = bezeichnung2;
    }

    public String getMatchcode() {
        return Matchcode;
    }

    public void setMatchcode(String matchcode) {
        Matchcode = matchcode;
    }

    public int getArtikelgruppe() {
        return Artikelgruppe;
    }

    public void setArtikelgruppe(int artikelgruppe) {
        Artikelgruppe = artikelgruppe;
    }

    public int getHauptartikelgruppe() {
        return Hauptartikelgruppe;
    }

    public void setHauptartikelgruppe(int hauptartikelgruppe) {
        Hauptartikelgruppe = hauptartikelgruppe;
    }

    public int getVaterartikelgruppe() {
        return Vaterartikelgruppe;
    }

    public void setVaterartikelgruppe(int vaterartikelgruppe) {
        Vaterartikelgruppe = vaterartikelgruppe;
    }

    public String getVerkaufsmengeneinheit() {
        return Verkaufsmengeneinheit;
    }

    public void setVerkaufsmengeneinheit(String verkaufsmengeneinheit) {
        Verkaufsmengeneinheit = verkaufsmengeneinheit;
    }

    public String getBasismengeneinheit() {
        return Basismengeneinheit;
    }

    public void setBasismengeneinheit(String basismengeneinheit) {
        Basismengeneinheit = basismengeneinheit;
    }

    public String getLagermengeneinheit() {
        return Lagermengeneinheit;
    }

    public void setLagermengeneinheit(String lagermengeneinheit) {
        Lagermengeneinheit = lagermengeneinheit;
    }

    public String getLagerfuehrung() {
        return Lagerfuehrung;
    }

    public void setLagerfuehrung(String lagerfuehrung) {
        Lagerfuehrung = lagerfuehrung;
    }

    public String getLagerplatzzuordnung() {
        return Lagerplatzzuordnung;
    }

    public void setLagerplatzzuordnung(String lagerplatzzuordnung) {
        Lagerplatzzuordnung = lagerplatzzuordnung;
    }

    public String getIstVerkaufsartikel() {
        return IstVerkaufsartikel;
    }

    public void setIstVerkaufsartikel(String istVerkaufsartikel) {
        IstVerkaufsartikel = istVerkaufsartikel;
    }

    public String getWarennummer() {
        return Warennummer;
    }

    public void setWarennummer(String warennummer) {
        Warennummer = warennummer;
    }

    public boolean isAktiv() {
        return Aktiv;
    }

    public void setAktiv(boolean aktiv) {
        Aktiv = aktiv;
    }

    public String getUrsprungsland() {
        return Ursprungsland;
    }

    public void setUrsprungsland(String ursprungsland) {
        Ursprungsland = ursprungsland;
    }
}
