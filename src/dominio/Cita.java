package dominio;

import java.sql.Date;
import java.time.LocalTime;

public class Cita {

    private String codigo;
    private Date fecha;
    private LocalTime hora;
    private String tipo;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;
    private String consultorio;

    public Cita() {
    }

    public Cita(String codigo) {
        this.codigo = codigo;
    }

    public Cita(String codigo, Date fecha, LocalTime hora, String tipo, Doctor doctor, Paciente paciente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public Cita(String codigo, Date fecha, LocalTime hora, String tipo, String motivo, Doctor doctor, Paciente paciente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cita{" + "codigo=" + codigo + ", \nfecha=" + fecha + ", \nhora=" + hora + ", \ntipo=" + tipo + ", \nmotivo=" + motivo + ", \ndoctor=" + doctor + ", \npaciente=" + paciente + '}';
    }
}
