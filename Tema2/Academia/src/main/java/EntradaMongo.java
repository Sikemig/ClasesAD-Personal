import dao.UsuariosDAO;
import model.Usuario;

public class EntradaMongo {
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.insertarUsuario(new Usuario("SikemDAO" , "IglesiasDAO", 28, "sikemDAO@correo.com"));
    }
}