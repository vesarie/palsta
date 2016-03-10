package palsta.pojo;

import java.sql.*;

public class Viesti {

    private Integer tunnus;
    private Integer keskustelu; // keskustelun PK 
    private String lahettaja;
    private Timestamp pvm;
    private String sisalto;

    public Viesti(Integer tunnus, Integer keskustelu, String lahettaja, Timestamp pvm, String sisalto) {
        this.tunnus = tunnus;
        this.keskustelu = keskustelu;
        this.lahettaja = lahettaja;
        this.pvm = pvm;
        this.sisalto = sisalto;
    }

    public Integer getTunnus() {
        return this.tunnus;
    }

    public Integer getKeskustelu() {
        return this.keskustelu;
    }

    public String getLahettaja() {
        return this.lahettaja;
    }

    public Timestamp getPvm() {
        return this.pvm;
    }

    public String getSisalto() {
        return this.sisalto;
    }
}
