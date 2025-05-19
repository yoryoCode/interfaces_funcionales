package sample1;

public record UserDTO (int id, String email){	
	
	public UserDTO(int id, String email) {
		this.id = id;
		this.email = email;
		System.out.println("Se invoca constructor con dos parámetros");
	}	

}
