package JATest;


public class Empresa {
    private Integer id;

    private String nom;  //*
    private String adreca; //*
    private String poblacio; //*
    private String societat; //(SRL, SA, COOP, SLAB)

    //poner simplemente String sector y en el momento d hacerlo se comprueba si el string existe en la tabla y tal...
    private String sector; //(desplegable) llocs de feina *

    private Integer num_treballadors;


    public Empresa() {
    }

    //Getters i Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public Integer getNum_treballadors() {
        return num_treballadors;
    }

    public void setNum_treballadors(Integer num_treballadors) {
        this.num_treballadors = num_treballadors;
    }

    public String getSocietat() {
        return societat;
    }

    public void setSocietat(String societat) {
        this.societat = societat;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

}
