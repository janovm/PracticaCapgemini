package modelo;

public class Rectangulo extends Poligono {

	private double longitud;
	private double altura;

	public Rectangulo(double longitud, double altura) {
		super();
		this.longitud = longitud;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		double area = longitud * altura;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		double perimetro = 2 * (longitud + altura);
		return perimetro;
	}

}
