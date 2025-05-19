package sample2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachSample {

  public static void main(String[] args) {

    List<Long> firstTen = Stream.iterate(1L, n -> n + 1).limit(10).collect(Collectors.toList());

    //1 Primera forma de imprimir los numeros: a la antiguita creando clase anonima
    Consumer<Long> c = new Consumer<Long>() {
		
		@Override
		public void accept(Long o) {
			System.out.println(o);
		}
	
    };
		
    firstTen.forEach(c);
	
    //2 Segunda forma de imprimir los numeros: usando una funcion lambda
    Consumer<Long> cLambda = n -> System.out.println(n);
		
    firstTen.forEach(cLambda);

    //3 Tercera forma de imprimir los numeros: usando referencia a método
		firstTen.forEach(System.out::println);		
		
    Function<String, Integer> convertNumber = n -> Integer.parseInt(n);

    // Aplicar la función
    Integer num = convertNumber .apply("123");
    System.out.println(num);  // Imprime: 123
  }
}
