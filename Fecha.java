package eps.uam.ads.p2.autoescuela.alumnos;

public class Fecha {
	// Atributos
	private int dia;
	private int mes;
	private int anyo;
	
	// Metodos
	public Fecha(int dia, int mes, int anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public boolean isFechaValida(){
		if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getFecha(){
		return dia + "/" + mes + "/" + anyo;
	}
}




