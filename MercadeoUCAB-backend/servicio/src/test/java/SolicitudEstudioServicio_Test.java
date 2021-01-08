import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.SolicitudEstudio;
import ucab.dsw.servicio.SolicitudEstudioServicio;

public class SolicitudEstudioServicio_Test {

    //Listar todas las solicitudes
    @Test
    public void pruebaListarSolicitudes(){

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();

        try {
            Assertions.assertTrue(servicio.listarSolicitudes().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una solicitud
    @Test
    public void pruebaConsultarSolicitud(){

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();
        SolicitudEstudio solicitudEstudio_buscar = servicio.consultarSolicitud(1);

        try {
            Assertions.assertEquals(1, solicitudEstudio_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar solicitudes activas
    @Test
    public void pruebaListarSolicitudesActivas(){

        try {
            Assertions.assertNotNull(new SolicitudEstudioServicio().mostrarSolicitudesActivas());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    //Esta prueba nos permite insertar una solicitud
    @Test
    public void pruebaInsertarSolicitud() throws Exception {

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();

        try {
            SolicitudEstudioDto solicitudEstudioDto = new SolicitudEstudioDto();

            solicitudEstudioDto.setDescripcion("Investigacion acerca de los perros calientes de arandanos");
            solicitudEstudioDto.setGenero("");
            solicitudEstudioDto.setEdadMaxima(35);
            solicitudEstudioDto.setEdadMinima(20);
            solicitudEstudioDto.setEstadoCivil("");
            solicitudEstudioDto.setDisponibilidadEnLinea("");
            solicitudEstudioDto.setCantidadPersonas(0);
            solicitudEstudioDto.setCantidadHijos(0);
            solicitudEstudioDto.setGeneroHijos("");
            solicitudEstudioDto.setEdadMinimaHijos(0);
            solicitudEstudioDto.setEdadMaximaHijos(0);
            solicitudEstudioDto.setEstatus("Activo");

            // Recuerden que deben ver los id de los registros en la BD
            NivelAcademicoDto nivelAcademicoDto = new NivelAcademicoDto(1);
            solicitudEstudioDto.setNivelAcademicoDto(nivelAcademicoDto);

            // Recuerden que deben ver los id de los registros en la BD
            UsuarioDto usuarioDto = new UsuarioDto(1);
            solicitudEstudioDto.setUsuarioDto(usuarioDto);
            ;

            // Recuerden que deben ver los id de los registros en la BD
            ProductoDto productoDto = new ProductoDto(1);
            solicitudEstudioDto.setProductoDto(productoDto);

            // Recuerden que deben ver los id de los registros en la BD
            OcupacionDto ocupacionDto = new OcupacionDto(3);
            solicitudEstudioDto.setOcupacionDto(ocupacionDto);

            // Recuerden que deben ver los id de los registros en la BD
            NivelEconomicoDto nivelEconomicoDto = new NivelEconomicoDto(1);
            solicitudEstudioDto.setNivelEconomicoDto(nivelEconomicoDto);

            SolicitudEstudioDto resultado = servicio.addSolicitudEstudio(solicitudEstudioDto);
            Assert.assertNotEquals(resultado.getId(), 0);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    //Prueba actualizar estatus de una solicitud
    @Test
    public void pruebaModificarEstatusSolicitud(){

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();

        try {
            SolicitudEstudioDto solicitudEstudioDto = new SolicitudEstudioDto();

            solicitudEstudioDto.setEstatus("Inactivo");
            // Recuerden que deben ver los id de los registros en la BD
            servicio.modificarEstatusSolicitudEstudio(2, solicitudEstudioDto);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    //Prueba actualizar una solicitud
    @Test
    public void pruebaModificarSolicitud(){

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();

        try {
            SolicitudEstudioDto solicitudEstudioDto = new SolicitudEstudioDto();

            solicitudEstudioDto.setDescripcion("Investigacion acerca de los perros calientes de arandanos");
            solicitudEstudioDto.setGenero("");
            solicitudEstudioDto.setEdadMaxima(35);
            solicitudEstudioDto.setEdadMinima(20);
            solicitudEstudioDto.setEstadoCivil("");
            solicitudEstudioDto.setDisponibilidadEnLinea("");
            solicitudEstudioDto.setCantidadPersonas(0);
            solicitudEstudioDto.setCantidadHijos(0);
            solicitudEstudioDto.setGeneroHijos("");
            solicitudEstudioDto.setEdadMinimaHijos(0);
            solicitudEstudioDto.setEdadMaximaHijos(0);
            solicitudEstudioDto.setEstatus("Activo");
            // Recuerden que deben ver los id de los registros en la BD
            servicio.modificarSolicitudEstudio(2, solicitudEstudioDto);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }

    }

    @Test
    public void pruebaEliminarSolicitud(){

        SolicitudEstudioServicio servicio = new SolicitudEstudioServicio();

        try {
            // Recuerden que deben ver los id de los registros en la BD
            servicio.eliminarSolicitudEstudio(2);

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }

    }


}