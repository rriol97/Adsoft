package eps.uam.ads.p2.autoescuela.alumnos;

public class Alumno {
	// Atributos
	private int dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;
	
	// Metodos
	public Alumno(int dni, String nombre, String apellidos, String direccion, int telefono, int dia, int mes, int anyo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		fechaMatricula = new Fecha(dia, mes, anyo);
	}
	
	public String getNombreYApellidos(){
		return nombre+" "+apellidos;
	}
	
	public Fecha getFechaMatricula() {
		return fechaMatricula;
	}

	public Fecha getFechaSupTeorico() {
		return fechaSupTeorico;
	}

	public Fecha getFechaSupPractico() {
		return fechaSupPractico;
	}

	public void setFechaSupTeorico(int dia, int mes, int anyo) {
		this.fechaSupTeorico = new Fecha(dia, mes, anyo);
	}

	public void setFechaSupPractico(int dia, int mes, int anyo) {
		this.fechaSupPractico = new Fecha(dia, mes, anyo);
	}

	@Override
	public String toString() {
		return "<dni: " + dni + ">\n\tNombre y apellidos: " + nombre + " " + apellidos + "\n\tDirección: " + direccion
				+ "\n\tTeléfono: " + telefono + "\n\tFecha de matriculación: " + fechaMatricula.getFecha();
	}
	
	public boolean isFechaValida(Fecha f){
		return f.isFechaValida();
	}

}