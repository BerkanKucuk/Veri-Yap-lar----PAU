package com.company;
import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        //ekle metodunu yazınız
        /*LinkedList<Integer> A = new LinkedList<>();
        A=dizi[hash(deger)];
        A.add(deger);*/
        if (dizi[hash(deger)]!=null){
                dizi[hash(deger)].add(deger);
        }
        else{
            dizi[hash(deger)]=new LinkedList<>();
            dizi[hash(deger)].add(deger);
        }
    }
    public boolean sil(int deger) {
        //sil metodunu yazınız
        int konum = hash(deger);
        if (dizi[konum] != null) {
            int konum2 = dizi[konum].indexOf(deger);
             dizi[konum].remove(konum2);
            return true;
        }
        return false;
    }
    public void yenidenOzetle() {

        int ikikati=2* dizi.length;
        int sayac = 0;
        int yeniboyut;
        int i=ikikati;
        while (true) {
            i++;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    sayac++;
            }
            if (sayac == 0) {
                yeniboyut=i;
                break;
            }

        }
        LinkedList<Integer>[] dizi2=dizi;
        dizi=new LinkedList[yeniboyut];
        for (LinkedList<Integer> liste : dizi2 ) {
            if (liste!=null)
            for ( int deger : liste){
                ekle(deger);
            }
        }
    }
}




