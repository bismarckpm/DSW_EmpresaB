package ucab.dsw.accesodatos;

import ucab.dsw.entidades.PreguntaEncuesta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DaoPreguntaEncuesta extends Dao<PreguntaEncuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPreguntaEncuesta(){
        super (_handler);
    }

    public List<Object[]> listarPreguntasEstudio(long id){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mercadeoUcabPU");
        EntityManager entitymanager = factory.createEntityManager();

        String SQL = null;

        SQL = "SELECT DISTINCT pe._id as idPregunta, pe._descripcion as descripcion, pe._tipoPregunta as tipoPregunta, pe._estatus as estatus FROM PreguntaEncuesta as pe" +
                " WHERE pe._subcategoria._id in " +
                "(SELECT sc._id FROM Subcategoria as sc, Producto as p, SolicitudEstudio as so, Estudio as e WHERE sc._id = p._subcategoria._id and p._id = so._producto._id and so._id = e._solicitudEstudio._id and e._id = :id and pe._id not in " +
                "(SELECT pes._preguntaEncuesta._id FROM PreguntaEstudio as pes, Estudio as e WHERE pes._estudio._id = e._id and e._id = :id))";

        Query query = entitymanager.createQuery(SQL);
        query.setParameter("id", id);

        List<Object[]> listaPreguntas = query.getResultList();

        return listaPreguntas;

    }

}
