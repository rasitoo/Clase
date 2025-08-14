package ApliCanvas;
// Un objeto que sea Dibujable es un objeto al que
// le puedo pedir que se pinte en un lienzo que yo le doy.
// El objeto, desde este método, lanzará al Lienzo las
// llamadas que sean necesarias para pintarse. Como el objeto
// sabe en qué posición está y sabe cuál es su aspecto,
// el objeto sabrá qué píxeles tendrá que marcar o qué textos
// deberá escribir.

public interface Dibujable {
	public void setLienzo(Lienzo lienzo);
	public void dibujar();
}