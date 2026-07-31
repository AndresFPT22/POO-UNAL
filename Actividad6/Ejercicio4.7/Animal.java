package co.unal.edu;

public abstract class Animal {

    protected String sonidos;
    protected String alimentos;
    protected String habitat;
    protected String nombre_cientifico;

    public abstract String getNombreCientifico ();
    public abstract String getSonido ();
    public abstract String getAlimentos ();
    public abstract String getHabitat ();

}
