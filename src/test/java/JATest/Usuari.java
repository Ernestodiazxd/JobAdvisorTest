package JATest;

import java.util.List;

public class Usuari {
    private Integer idUsuari;
    private String nickname;
    private String email;
    private String password;

    private List<Opinio> opinioList;

    public Usuari() {

    }

    public Integer getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(Integer idUsuari) {
        this.idUsuari = idUsuari;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Opinio> getOpinioList() {
        return opinioList;
    }

    public void setOpinioList(List<Opinio> opinioList) {
        this.opinioList = opinioList;
    }
}
