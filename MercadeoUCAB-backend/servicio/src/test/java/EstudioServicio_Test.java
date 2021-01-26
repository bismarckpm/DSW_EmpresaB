import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudEstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.servicio.EstudioServicio;

import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstudioServicio_Test {

    //Listar todos los estudios
    @Test
    public void pruebaListarEstudios(){

        EstudioServicio servicio = new EstudioServicio();

        try {

        } catch (Exception e) {

        }

    }

    //Consultar un Estudio
    @Test
    public void pruebaConsultarEstudio(){

        EstudioServicio servicio = new EstudioServicio();
        Response estudio_buscar = servicio.consultarEstudio(1);

        try {
            Assertions.assertNotNull(estudio_buscar);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar estudios activos
    @Test
    public void pruebaListarEstudiosActivos(){

        try {
            Assertions.assertNotNull(new EstudioServicio().estudiosActivos());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite insertar un estudio a la BD
    @Test
    public void pruebaInsertarEstudio() throws Exception {

        EstudioServicio servicio = new EstudioServicio();

        try {
            EstudioDto estudioDto = new EstudioDto();

            estudioDto.setNombre("Perros calientes raros parte 2");
            estudioDto.setTipoInstrumento("Encuesta");
            String date1 = "2020-12-01";
            DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = forma.parse(date1);
            estudioDto.setFechaInicio(myDate);
            String date2 = "2021-01-21";
            DateFormat forma2 = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate2 = forma2.parse(date2);
            estudioDto.setFechaFin(myDate2);
            estudioDto.setEstatus("Activo");
            // Revisar los registros de sus base de datos
            SolicitudEstudioDto solicitudEstudioDto = new SolicitudEstudioDto(1);
            estudioDto.setSolicitudEstudioDto(solicitudEstudioDto);
            UsuarioDto usuarioDto = new UsuarioDto(6);
            estudioDto.setUsuarioDto(usuarioDto);
            Response resultado = servicio.addEstudios(estudioDto);
            Assert.assertNotNull(resultado);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }

    }

    // Esta prueba permite modificar un estudio
    @Test
    public void pruebaModificarEstudio() throws ParseException {

        EstudioServicio servicio = new EstudioServicio();

        try {
            EstudioDto estudioDto = new EstudioDto();
            estudioDto.setNombre("Perros calientes raros parte 2");
            estudioDto.setTipoInstrumento("Encuesta");
            String date1 = "2020-12-01";
            DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = forma.parse(date1);
            estudioDto.setFechaInicio(myDate);
            String date2 = "2021-01-21";
            DateFormat forma2 = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate2 = forma2.parse(date2);
            estudioDto.setFechaFin(myDate2);
            estudioDto.setEstatus("Activo");
            // Recuerden que deben ver los id de los registros en la BD
            servicio.modificarEstudio(1, estudioDto);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite eliminar un estudio
    @Test
    public void pruebaEliminarEstudio(){

        EstudioServicio servicio = new EstudioServicio();

        try {
            // Recuerden que deben ver los id de los registros en la BD
            servicio.eliminarEstudio(2);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }

    }
}
