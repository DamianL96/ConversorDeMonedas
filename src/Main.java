import com.conversor.connection.Conexion;

public class Main {
  public static void main(String[] args) {


    Conexion coneccion = new Conexion("ARS");
    String json = coneccion.conectar();
    System.out.println(json);
  }
}