/**
 *
 * @author eyvind
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p=new Person();
        p.setAddress("Lofotengatan 32");
        p.setName("Johan Hult");
        Main n=new Main();
        n.persist(p);
        p=new Person();
        p.setAddress("Lofotengatan 33");
        p.setName("Greta Nilsson");
        n.persist(p);


    }

    void persist(Object object)
    {
        EntityManagerFactory ef=Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager em=ef.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }


    }

}