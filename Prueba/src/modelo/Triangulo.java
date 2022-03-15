package modelo;

public class Triangulo extends Poligono {
	private double longitudBase;
	private double altura;

	public Triangulo(double longitudBase, double altura) {
		super();
		this.longitudBase = longitudBase;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		double area = (longitudBase * altura) / 2;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		double perimetro = 3 * longitudBase;
		return perimetro;
	}

}
