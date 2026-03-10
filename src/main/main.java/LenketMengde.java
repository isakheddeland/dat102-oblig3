package main.java.uke10.oblig;

public class LenketMengde<T> implements MengdeADT<T> {

    private Node forste;
    private int antall;

    private class Node {
        T data;
        Node neste;

        Node(T data) {
            this.data = data;
            this.neste = neste;
        }
    }

    @Override
    public boolean erTom() {
        antall == 0;
    }

    public boolean inneholder(T element) {
        Node current = forste;

        while(current != null) {
            if(current.data.equals(element)) {
                return true;
            }
            current = current.neste;
        }
        return false;
    }
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde){
        Node current = forste;

        while(current != null){
            if(!annenMengde.inneholder(current.data)){
                return false;
            }
            current = current.neste;
        }
        return true;
    }


    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }


    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node current = forste;

        while(current != null){
            if(annenMengde.inneholder(current.data)){
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();

        Node current = forste;
        while(current != null){
            if(annenMengde.inneholder(current.data)){
                resultat.leggTil(current.data);
            }
            current = current.neste;
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();

        Node current = forste;
        while(current != null) {
            resultat.leggTil(current.data);
            current = current.neste;
        }
        T[] andre =  annenMengde.tilTabell();
        for (int i = 0; i < antall; i++) {
            resultat.leggTil(andre[i]);
        }
        return resultat;

    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();

        Node current = forste;
        while(current != null) {
            if(!annenMengde.inneholder(current.data)) {
                resultat.leggTil(current.data);
            }
            current = current.neste;
        }
        return resultat;
    }


    @Override
    public void leggTil(T element) {
        if(!inneholder(element)){
            Node ny = new Node(element);
            ny.neste = forste;
            forste = ny;
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
        if(forste == null){
            return null;
        }

        if(forste.data.equals(element)) {
            T fjern = forste.data;
            forste = forste.neste;
            antall--;
            return fjern;
        }

        Node current = forste;
        while(current.neste != null) {
            if(current.data.equals(element)) {
                T fjern = current.neste.data;
                current.neste = current.neste.neste;
                antall--;
                return fjern;
            }
            current = current.neste;
        }
        return null;
    }


    @Override
    public T[] tilTabell() {
        T[] ny = (T[]) new Object[antall];
        Node current = forste;
        int index = 0;

        while(current != null){
            ny[index] = current.data;
            index++;
            current = current.neste;
        }
        return ny;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

}
