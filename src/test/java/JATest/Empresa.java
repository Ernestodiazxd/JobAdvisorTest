package JATest;


import java.util.List;

public class Empresa {
    private Integer idEmpresa;

    private String nomEmpresa;
    private String adreca;
    private String poblacio;
    private String societat;
    private String sector;
    private Long Ntreballadors;


    private List<Lloc> llocList;

    public Empresa() {

    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
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

    public Long getNtreballadors() {
        return Ntreballadors;
    }

    public void setNtreballadors(Long ntreballadors) {
        Ntreballadors = ntreballadors;
    }

    public List<Lloc> getLlocList() {
        return llocList;
    }

    public void setLlocList(List<Lloc> llocList) {
        this.llocList = llocList;
    }

}
