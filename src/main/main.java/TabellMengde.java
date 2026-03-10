package main.java.uke10.oblig;

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

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>();

        for(int i = 0; i < antall; i++) {
            resultat.leggTil(tabell[i]);
        }
        T[] andre = annenMengde.tilTabell();
        for (int i = 0; i <andre.length; i++) {
            resultat.leggTil(andre[i]);
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>();

        for (int i = 0; i < antall; i++) {
            if(!annenMengde.inneholder(tabell[i])){
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if(!inneholder(element)){
            tabell[antall] = element;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] andre = annenMengde.tilTabell();
        for (int i = 0; i < andre.length; i++) {
            leggTil(andre[i]);
        }
    }

    @Override
    public T fjern(T element) {

        if(!inneholder(element)){
            return null;
        }
        int indeks = -1;

        for (int i = 0; i < antall; i++) {
            if(tabell[i].equals(element)){
                indeks = i;
                break;
            }
        }
        T fjernet = tabell[indeks];

        for (int i = 0; i < antall - 1; i++) {
            tabell[i] = tabell[i -1];
        }

        tabell[antall - 1] = null;
        antall--;

        return fjernet;
    }

    @Override
    public T[] tilTabell() {
        T[] ny = (T[]) new Object[antall];

        for (int i = 0; i < antall; i++) {
            ny[i] = tabell[i];
        }
        return ny;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

}
