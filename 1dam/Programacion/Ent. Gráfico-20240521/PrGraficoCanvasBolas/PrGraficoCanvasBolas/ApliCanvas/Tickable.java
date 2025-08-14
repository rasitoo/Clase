package ApliCanvas;
// Un objeto que sea "Tickable" es un objeto que está interesado
// en saber cómo van pasando unidades de tiempo.
// Por CADA UNA de estas unidades de tiempo, yo tengo la
// obligación de llamar a su método tick().
// El objeto, a su vez, actualizará su estado interno en el método
// (ubicación//movimiento, puntuaciones, etc.).

public interface Tickable {
	public void tick();
}