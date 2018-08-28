package mikke.utils;

public class InstanciaUnica {

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static InstanciaUnica getSoyUnico() {
		return soyUnico;
	}

	public static void setSoyUnico(InstanciaUnica soyUnico) {
		InstanciaUnica.soyUnico = soyUnico;
	}

	private String nombre;
    private static InstanciaUnica soyUnico;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private InstanciaUnica(String nombre) {
        this.nombre = nombre;
        System.out.println("Mi nombre es: " + this.nombre);
    }

    public static InstanciaUnica getSingletonInstance(String nombre) {
        if (soyUnico == null){
            soyUnico = new InstanciaUnica(nombre);
        }
        else{
            System.out.println("No se puede crear el objeto "+ nombre + " porque ya existe un objeto de la clase SoyUnico");
        }
        
        return soyUnico;
    }
    
}
