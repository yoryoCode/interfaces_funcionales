package sample1;

public class BuildUsersSample {
	
	public static void main(String[] args) {
		UserDTOFactory factory = UserDTO::new;
		System.out.println("Se crea instancia del factory");
		// Crear una nueva instancia
		UserDTO instancia = factory.getUserDTO(1, "jorge.ga@bba.com");
        System.out.println("Instancia creada: " + instancia);
	}

}
