import org.junit.Test;
import ucab.dsw.dtos.RolDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.LoginServicio;

public class LoginServicio_Test {
    
    @Test
    public void loginTest(){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setCorreo( "greggspinetti@gmail.com" );
        usuarioDto.setContrasena( "otraclave" );
        usuarioDto.setEstatus("Activo");
        RolDto rol = new RolDto();
        rol.setNombre("Administrador");
        LoginServicio login = new LoginServicio();
        login.login(usuarioDto);
    }
}
