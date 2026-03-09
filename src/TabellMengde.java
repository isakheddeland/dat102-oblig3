public class TabellMengde<T> implements MengdeADT<T> {

    private T[] tabell;
    private int antall;

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        for(int i = 0; i < antall; i++){
            if(tabell[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for(int i = 0; i < antall; i++) {
            if(!annenMengde.inneholder(tabell[i])) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if(annenMengde.inneholder(tabell[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>();


        for (int i = 0; i < antall; i++) {
            if(annenMengde.inneholder(tabell[i])){
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }

}
