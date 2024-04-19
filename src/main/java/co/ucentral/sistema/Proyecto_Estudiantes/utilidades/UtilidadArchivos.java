package co.ucentral.sistema.Proyecto_Estudiantes.utilidades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UtilidadArchivos {
    public static boolean guardar(String archivo, Object objeto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto);
        } catch (IOException e) {
            return false;
        }
        return true;

    }
    public static Object obtener(String archivo){
        Object objetoCOnsultado;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            objetoCOnsultado = ois.readObject();
            return objetoCOnsultado;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
