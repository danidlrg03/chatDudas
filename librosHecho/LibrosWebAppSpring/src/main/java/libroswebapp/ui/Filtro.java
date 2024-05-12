package libroswebapp.ui;

public class Filtro {

    protected String titulo;
    protected String anyo;

    public Filtro() {
        this.titulo = "";
        this.anyo = "";
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getShortAnyo () {
        if (anyo.isEmpty()) {
            return 0;
        } else {
            return Short.parseShort(anyo);
        }
    }

    public boolean estaVacio () {
        return titulo.isEmpty() && this.anyo.isEmpty();

    }

}
