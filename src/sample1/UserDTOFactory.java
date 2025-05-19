package sample1;

@FunctionalInterface
public interface UserDTOFactory {
	public UserDTO getUserDTO(int id, String name);
}
