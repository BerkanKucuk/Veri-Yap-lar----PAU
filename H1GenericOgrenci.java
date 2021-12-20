package com.company;


public class H1GenericOgrenci {
    /**
     * Parametre olarak gönderilen dizi değişkenini sıralayınız. Kabarcık ya da seçmeli sıralama kullanılabilir.
     * @param dizi Gönderilen dizi
     * @param <T> Karşılaştırılabilir tür
     */
    public static<T extends Comparable> void sirala(T[] dizi) {
        T geçici;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 1; j < dizi.length; j++) {
                if(dizi[j-1].compareTo(dizi[j])>0){
                    geçici = dizi[j-1];
                    dizi[j-1]=dizi[j];
                    dizi[j]=geçici;
                }
            }
        }
    }

    /**
     * Parametre olarak gönderilen 3 generic değerden en büyüğünü hesaplayıp döndüren fonksiyonu yazınız.
     * @param deger1 Değer 1
     * @param deger2 Değer 2
     * @param deger3 Değer 3
     * @param <T> Generic tür
     * @return En büyük değer
     */
    public static<T extends Comparable> T enbuyuk(T deger1, T deger2, T deger3){
        T max=deger1;
        if (deger2.compareTo(max)>0)
            max=deger2;
        if (deger3.compareTo(max)>0)
            max = deger3;
        return max;
    }
}
