package mikke.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arreglos {

	public Arreglos() {
		// TODO Auto-generated constructor stub
	}
	
	//Determina la cantidad de caracteres duplicados dentro de un String
	public void buscarDuplicados (String cad)
	{
		String cadena = cad;

		Map<Character, Integer> mapa = new HashMap<>((int) Math.ceil(cadena.length() / .75));

		for (char caracter : cadena.toCharArray()) {
			mapa.put(caracter, mapa.containsKey(caracter) ? mapa.get(caracter) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
			System.out.println("letra: " + entry.getKey() + " repeticiones:" + entry.getValue());
		}

		List<Integer> values = new ArrayList<>(mapa.values());
		Collections.sort(values);
		System.out.println("Ordenadas: " + values );
		
		System.out.print("Las letras duplicadas son:");
		
		for (Map.Entry<Character, Integer> test : mapa.entrySet()) {
			if (test.getValue() > 1)
			{
				System.out.println(test.getKey());
			}
			
		}

	}

	//Ordena de mayor a meno un arreglo de enteros
	public void ordenarArray ()
	{
		List <Integer> numeros = new ArrayList<>();

		numeros.add(1);
		numeros.add(12);
		numeros.add(100);
		numeros.add(6);
		numeros.add(112);
		numeros.add(3);
		numeros.add(200);
		numeros.add(56);
		numeros.add(37);
		numeros.add(15);

		numeros.stream().sorted((x,y)-> y.compareTo(x)).forEach(System.out::println);
	}

	//revierte el orden de los caracteres de una cadena usando programación basica
	public String reverse(String str) {
		if (str.length() == 1)
			return str;
		else
			return reverse(str.substring(1)) + str.charAt(0);
	}

	//revierte el orden de los caracteres de una cadena usando API de Java
	public StringBuilder reverseJava (String str)
	{
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse();  // reverse it
	}

	public void test ()
	{
		for (int x=0;x<10;x++){
			System.out.println(x);
		}

		System.out.println(2+6<<1); //= 16

		int x=1;

		switch (x) {
			case 1:
				System.out.println("Uno");
			case 2:
				System.out.println("Dos");
			case 3:
				System.out.println("Tres");
			default:
				System.out.println("Otro número");
		}

		int x1=2;
		int y=2;
		int z;

		z = x++ + y;
		System.out.println("z: " + z);
	}
}

