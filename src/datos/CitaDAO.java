package datos;

import dominio.Cita;
import dominio.Doctor;
import dominio.Paciente;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class CitaDAO {

    private static final String SQL_SELECTALL = "SELECT * FROM citas";
    private static final String SQL_SELECT = "SELECT tipo,fecha,hora FROM citas";
    private static final String SQL_INSERT = "INSERT INTO citas(codigo,fecha,hora,tipo,motivo,doctor_id,paciente_id,consultorio) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM citas WHERE codigo = ?";
    private static final String SQL_UPDATE = "UPDATE citas SET fecha = ?,hora = ?,motivo = ?,doctor_id = ? WHERE codigo = ?";
    private static final String SQL_COUNT = "SELECT COUNT(*) AS total_citas FROM citas";
    
    public List<Cita> listar(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita;
        List<Cita> citas = new ArrayList<>();
        
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECTALL);
            rs = stmt.executeQuery();
            while(rs.next()){
                String codigo = rs.getString("codigo");
                Date fecha = rs.getDate("fecha");
                LocalTime hora = rs.getTime("hora").toLocalTime();
                String tipo = rs.getString("tipo");
                String motivo = rs.getString("motivo");
                String idDoctor = rs.getString("doctor_id");
                String idPaciente = rs.getString("paciente_id");
                cita = new Cita(codigo, fecha, hora, tipo,motivo, new Doctor(idDoctor), new Paciente(idPaciente));
                citas.add(cita);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return citas;
    }
    
    public void agendarCita(Cita cita){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cita.getCodigo());
            stmt.setDate(2, cita.getFecha());
            Time hora = Time.valueOf(cita.getHora());
            stmt.setTime(3, hora);
            stmt.setString(4, cita.getTipo());
            stmt.setString(5, cita.getMotivo());
            stmt.setString(6, cita.getPaciente().getNumeroDocumento());
            stmt.setString(7, cita.getDoctor().getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
    
    public int totalCitas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int totalCitas = 0;
        
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_COUNT);
            rs = stmt.executeQuery();
            rs.next();
            totalCitas = rs.getInt("total_citas");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
            Conexion.close(rs);
        }
        return totalCitas;
    }
}