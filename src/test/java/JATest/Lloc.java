package JATest;

import java.util.List;

public class Lloc {

    private Integer idLloc;
    private String nomLloc;

    private Empresa empresa;

    private List<Opinio> opinioList;

    public Lloc() {

    }

    public Integer getIdLloc() {
        return idLloc;
    }

    public void setIdLloc(Integer idLloc) {
        this.idLloc = idLloc;
    }

    public String getNomLloc() {
        return nomLloc;
    }

    public void setNomLloc(String nomLloc) {
        this.nomLloc = nomLloc;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Opinio> getOpinioList() {
        return opinioList;
    }

    public void setOpinioList(List<Opinio> opinioList) {
        this.opinioList = opinioList;
    }


}
