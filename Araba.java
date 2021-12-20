package com.company;

public class Araba implements Comparable<Araba> {
    public int modelYili;
    public String plaka;
    public String marka;
    double motorHacmi;


    public Araba(String plaka,String marka,int modelYili,double motorHacmi){
        this.marka=marka;
        this.modelYili=modelYili;
        this.plaka=plaka;
        this.motorHacmi=motorHacmi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getModelYili() {
        return modelYili;
    }

    public void setModelYili(int modelYili) {
        this.modelYili = modelYili;
    }

    public double getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(double motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    @Override
    public int compareTo(Araba o) {

        if (this.modelYili > o.getModelYili())
            return 1;
        else if (this.modelYili < o.getModelYili()) {
            return -1;
        } else if (this.modelYili == o.getModelYili())
            return 0;
        return 0;
    }
}


