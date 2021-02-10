package ucab.dsw.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

    private long id;
    private String nombre;
    private String token;
    private String correo;
    private String estatus;

    public UsuarioResponse(){
        super();
    }

    public UsuarioResponse(long id, String nombre, String codigoRecuperacion, String correo, String estatus) {
        this.id = id;
        this.nombre = nombre;
        this.token = codigoRecuperacion;
        this.correo = correo;
        this.estatus = estatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
