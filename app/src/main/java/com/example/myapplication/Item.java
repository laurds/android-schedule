package com.example.myapplication;

import java.io.Serializable;


public class Item implements Serializable {

    public String title;
    public String nota;
    public String hora;
    public String data;


    @Override
    public String toString() {
        return  title + System.getProperty("line.separator") +
                nota + System.getProperty("line.separator") +
                hora + System.getProperty("line.separator") +
                data + System.getProperty("line.separator");
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public Item(String title, String nota, String hora, String data) {
        this.title = title;
        this.nota = nota;
        this.hora = hora;
        this.data = data;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
