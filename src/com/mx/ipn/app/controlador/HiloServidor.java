package com.mx.ipn.app.controlador;

import com.mx.ipn.app.modelo.daoimpl.AlumnoDAOImpl;
import com.mx.ipn.app.modelo.daoimpl.CategoriaDAOImpl;
import com.mx.ipn.app.modelo.daoimpl.Conexion;
import com.mx.ipn.app.modelo.daoimpl.EscuelaDAOImpl;
import com.mx.ipn.app.modelo.entidades.Peticion;
import com.mx.ipn.app.modelo.squirrel.Alumno;
import com.mx.ipn.app.modelo.squirrel.AlumnoKey;
import com.mx.ipn.app.modelo.squirrel.Categoria;
import com.mx.ipn.app.modelo.squirrel.CategoriaKey;
import com.mx.ipn.app.modelo.squirrel.Escuela;
import com.mx.ipn.app.modelo.squirrel.EscuelaKey;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextArea;

public class HiloServidor extends Thread {

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private final Integer puerto;
    private final JTextArea area;
    private boolean bandera;
    private Peticion peticion;
    private final Conexion conexion;
    private final EscuelaDAOImpl escuelaDAOimpl;
    private final AlumnoDAOImpl alumnoDAOImpl;
    private final CategoriaDAOImpl categoriaDAOImpl;

    public HiloServidor(Integer puerto, JTextArea area) {
        this.puerto = puerto;
        this.area = area;
        bandera = true;
        conexion = new Conexion();
        conexion.hacerConexion();
        categoriaDAOImpl = new CategoriaDAOImpl();
        alumnoDAOImpl = new AlumnoDAOImpl();
        escuelaDAOimpl = new EscuelaDAOImpl();
    }

    @Override
    public void run() {
        try {
            //Iniciar el servidor
            serverSocket = new ServerSocket(puerto);
            area.append("Servidor iniciado \n");
        } catch (IOException ex) {
            area.append("Error en el servidor " + ex + "\n");
        }
        while (bandera) {
            //Recibir peticiones
            peticion();
        }
    }

    public void peticion() {
        try {
            //Esperar cliente
            area.append("Esperando cliente \n");
            socket = serverSocket.accept();
            area.append("Cliente aceptado \n");
            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());
            peticion = (Peticion) entrada.readObject();
            clasificar();
            liberar();
        } catch (IOException ex) {
            System.err.println("Error al aceptar " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada en el servidor " + ex);
        }
    }

    private void clasificar() {
        switch (peticion.getTipo()) {
            case "escuela":
                tipoEscuela();
                break;
            case "categoria":
                tipoCategoria();
                break;
            case "alumno":
                tipoAlumno();
                break;
            case "competidor":
                tipoCompetidor();
                break;
            default:
                break;
        }
    }

    private void cerrarServidor() {
        bandera = false;
    }

    private void tipoEscuela() {
        try {
            switch (peticion.getConsulta()) {
                case "crear": {
                    escuelaDAOimpl.create((Escuela) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "leer": {
                    EscuelaKey ek = new EscuelaKey();
                    ek.setIdescuela(((Escuela) peticion.getObjecto()).getIdescuela());
                    Escuela escuela = escuelaDAOimpl.load(ek, conexion.obtenerConexion());
                    salida.writeObject(escuela);
                    break;
                }
                case "actualizar": {
                    escuelaDAOimpl.update((Escuela) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "borrar": {
                    EscuelaKey ek = new EscuelaKey();
                    ek.setIdescuela(((Escuela) peticion.getObjecto()).getIdescuela());
                    escuelaDAOimpl.delete(ek, conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "todo":
                    List<Escuela> escuelas = escuelaDAOimpl.getResults(conexion.obtenerResultSet("select * from Escuela"));
                    salida.writeObject(escuelas);
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            System.err.println("Error al escribir alguna respuesta " + ex);
        } catch (SQLException ex) {
            System.err.println("Error en la consulta SQL " + ex);
        }
    }

    private void tipoCategoria() {
        try {
            switch (peticion.getConsulta()) {
                case "crear": {
                    categoriaDAOImpl.create((Categoria) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "leer": {
                    CategoriaKey ck = new CategoriaKey();
                    ck.setIdcategoria(((Categoria) peticion.getObjecto()).getIdcategoria());
                    Categoria categoria = categoriaDAOImpl.load(ck, conexion.obtenerConexion());
                    salida.writeObject(categoria);
                    break;
                }
                case "actualizar": {
                    categoriaDAOImpl.update((Categoria) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "borrar": {
                    CategoriaKey ck = new CategoriaKey();
                    ck.setIdcategoria(((Categoria) peticion.getObjecto()).getIdcategoria());
                    categoriaDAOImpl.delete(ck, conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "todo":
                    List<Categoria> categorias = categoriaDAOImpl.getResults(conexion.obtenerResultSet("select * from Categoria"));
                    salida.writeObject(categorias);
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            System.err.println("Error al escribir alguna respuesta " + ex);
        } catch (SQLException ex) {
            System.err.println("Error en la consulta SQL " + ex);
        }
    }

    private void tipoAlumno() {
        try {
            switch (peticion.getConsulta()) {
                case "crear": {
                    alumnoDAOImpl.create((Alumno) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "leer": {
                    AlumnoKey ak = new AlumnoKey();
                    ak.setIdalumno(((Alumno) peticion.getObjecto()).getIdalumno());
                    Alumno alumno = alumnoDAOImpl.load(ak, conexion.obtenerConexion());
                    salida.writeObject(alumno);
                    break;
                }
                case "actualizar": {
                    alumnoDAOImpl.update((Alumno) peticion.getObjecto(), conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "borrar": {
                    AlumnoKey ak = new AlumnoKey();
                    ak.setIdalumno(((Alumno) peticion.getObjecto()).getIdalumno());
                    alumnoDAOImpl.delete(ak, conexion.obtenerConexion());
                    salida.writeBoolean(true);
                    break;
                }
                case "todo":
                    List<Alumno> alumnos = alumnoDAOImpl.getResults(conexion.obtenerResultSet("select * from Alumno"));
                    salida.writeObject(alumnos);
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            System.err.println("Error al escribir alguna respuesta " + ex);
        } catch (SQLException ex) {
            System.err.println("Error en la consulta SQL " + ex);
        }
    }

    private void tipoCompetidor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void liberar() {
        try {
            if (entrada != null) {
                System.out.println("Cerrando entrada ");
                entrada.close();
                System.out.println("Cerrado entrada ");
            }
            if (salida != null) {
                System.out.println("Cerrando salida");
                salida.close();
                System.out.println("Cerrado salida");
            }
            if (socket != null) {
                System.out.println("Cerrando socket");
                socket.close();
                System.out.println("Socket cerrado ");
            }
        } catch (IOException ex) {
            System.err.println("Error al liberar los recursos " + ex);
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket s = new Socket("localhost", 3030);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Escuela e = new Escuela();
        e.setIdescuela(1);
        //e.setNombre("Mas que Box");
        oos.writeObject( new Peticion("escuela", "leer", e));
        //Escuela eo = (Escuela) ois.readObject();
        Escuela escuela = (Escuela) ois.readObject();
        System.out.println(escuela.toString());
    }

}
