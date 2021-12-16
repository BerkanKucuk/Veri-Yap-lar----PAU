public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        int konum=hash(eleman);
        int i=0;
        while (true){
                HashEntry<T>hucre=dizi[(konum + i*i )%dizi.length];
            if (hucre==null || !hucre.isActive ){
                dizi[(konum + i*i)% dizi.length] = new HashEntry<>(eleman);
                break;
            }
            i++;
        }
            elemanSayisi++;
    }

    public boolean sil(T eleman){
    int konum = hash(eleman);
        int i =0;
            while(true){
                if (dizi[(konum + i * i) % dizi.length].value.equals(eleman) && dizi[(konum + i*i )% dizi.length].isActive){
                    dizi[(konum + i * i) % dizi.length].isActive=false;
                    return true;
                }
                i++;
            }
    }
            }
        
  /*int konum=hash(eleman);
        HashEntry<T> hucre = dizi[konum];
        if (hucre==eleman || hucre.isActive){
            hucre.isActive=false;
            elemanSayisi--;
            return true;
        }
        return false;*/

