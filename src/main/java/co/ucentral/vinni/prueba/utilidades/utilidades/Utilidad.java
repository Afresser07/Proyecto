package co.ucentral.vinni.prueba.utilidades.utilidades;
    import java.text.SimpleDateFormat;
    import java.util.Date;

public class Utilidad {
    public static void main(String[] args) {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cadenaFecha = formato.format(fecha);

        System.out.println(cadenaFecha);
    }
}
