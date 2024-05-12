package libroswebapp.ui;


import java.util.ArrayList;
import java.util.List;

public class Libro {

    private Integer libroid;
    private String libroname;
    private short yearreleased;
    private List<Integer> idescritores;
    private List<Integer> idgeneros;
    private Integer ideditorial;

    public Libro() {
    }

    public Integer getLibroid() {
        return libroid;
    }

    public void setLibroid(Integer libroid) {
        this.libroid = libroid;
    }

    public String getLibroname() {
        return libroname;
    }

    public void setLibroname(String libroname) {
        this.libroname = libroname;
    }

    public short getYearreleased() {
        return yearreleased;
    }

    public void setYearreleased(short yearreleased) {
        this.yearreleased = yearreleased;
    }

    public List<Integer> getIdescritores() {
        return idescritores;
    }

    public void setIdescritores(List<Integer> idescritores) {
        this.idescritores = idescritores;
    }

    public Integer getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(Integer ideditorial) {
        this.ideditorial = ideditorial;
    }

    public List<Integer> getIdgeneros() {
        return idgeneros;
    }

    public void setIdgeneros(List<Integer> idgeneros) {
        this.idgeneros = idgeneros;
    }
}
