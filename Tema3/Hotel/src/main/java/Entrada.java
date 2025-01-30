import dao.ClienteDAO;
import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import database.HibernateUtil;
import model.Cliente;
import model.Direccion;
import model.Habitacion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    // FORMAS SIN DAO

        // insercion .persist()
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Introduce los datos del trabajador - nombre, apellido, direccion, telefono");
        session.persist(
                new Trabajador(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt())
        );

        session.getTransaction().commit();

        session.close();
        */

        // obtencion .get()
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();

        Trabajador t = session.get(Trabajador.class, 1); // filtro por ID

        session.getTransaction().commit();

        System.out.println(t); // toString del 1

        session.close();
         */

        // actualizacion -> primero obtener un objeto con el get y luego actualizar con setter y luego un merge
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();

        Trabajador trabajador = session.get(Trabajador.class,1);
        trabajador.setDireccion("Madrid");
        session.merge(trabajador);

        session.getTransaction().commit();

        session.close();
         */


        // borrado
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();

        // opcion 1
        Trabajador trabajador = new Trabajador(1); // necesitamos un constructor con solo el ID
        session.delete(trabajador);

        // opcion 2
        Trabajador trabajador2 = session.get(Trabajador.class, 1);
        session.delete(trabajador2);

        session.getTransaction().commit();

        session.close();
        */


        // get de todos
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();

        // t nomenglatura para un trabajador --> select * from empleados;
        Query<Trabajador> query = session.createQuery("SELECT t FROM Trabajador t", Trabajador.class);
        List<Trabajador> listaTrabajadores = query.list();

        for(Trabajador trabajadores : listaTrabajadores){
            System.out.println(trabajadores);
        }

        session.getTransaction().commit();

        session.close();*/




    // FORMAS CON DAO
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        /*try {
            trabajadorDAO.insertarTrabajador(new Trabajador("Paco2", "Martin2",
                    new Direccion("Madrid", "Madrid"),
                    new Direccion("Barcelona", "Barcelona"), 123));
        } catch (ConstraintViolationException e){
            System.out.println("El telefono esta duplicado, ¿quieres indicarme otro?");
        }*/



        //trabajadorDAO.seleccionarTodosByProvincia("Jaen");

        //trabajadorDAO.actualizarNombre("Actualizaman");


        // crear varias habitaciones
        /*for (int i = 10; i < 21 ; i++){
            habitacionDAO.crearHabitacion(new Habitacion(1, i, 4));
        }*/

        /*trabajadorDAO.insertarTrabajador(new Trabajador("Pepito", "Gonzalez",
                new Direccion("Asturias", "Oviedo"),
                new Direccion("Galicia", "Galicia"), 453), 11);
         */

        /*trabajadorDAO.insertarTrabajador(new Trabajador("Pepito", "Gonzalez",
                new Direccion("Asturias", "Oviedo"),
                new Direccion("Galicia", "Galicia"), 4543), new Habitacion(3, 300, 3));
         */

        //trabajadorDAO.seleccionHabitacionTrabajador(9);

        //habitacionDAO.getTrabajadorHabitacion(11);

        //clienteDAO.crearCliente(new Cliente("Casper"), 15);

        //habitacionDAO.getAllClientes(15);

        // Ejemplo de manytomany sin DAO
        /*Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        System.out.println("Sacando los trabajadores que se relacionaron con el cliente 1");
        Cliente cliente = session.get(Cliente.class, 1); // Cliente con ID 1
        for(Trabajador trabajador : cliente.getListaTrabajadores()){
            System.out.println(trabajador.getNombre());
        }

        System.out.println("Sacando los clientes a los que atendió el trabajador 5");
        Trabajador trabajador = session.get(Trabajador.class, 5);
        for(Cliente cliente2: trabajador.getListaClientes()){
            System.out.println(cliente2.getNombre());
        }

        session.getTransaction().commit();
        session.close();*/


        // vamos a relacionar el cliente 1 con el trabajador 4
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Cliente cliente = session.get(Cliente.class, 1);
        Trabajador trabajador = session.get(Trabajador.class, 4);

        cliente.getListaTrabajadores().add(trabajador);
        trabajador.getListaClientes().add(cliente);

        session.persist(cliente);
        session.persist(trabajador);

        session.getTransaction().commit();
        session.close();
    }
}
