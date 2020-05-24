package Tester;


import org.junit.*;                         // For tags
import static org.junit.Assert.*;           // For assertions

import java.security.acl.LastOwnerException;

import Logica.Logica;
import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Lista_doble_enlazada;
import TDALista.Position;
import TDALista.PositionList;


public class TesterPrimerProyecto {

	private Logica log;
	private static PositionList<Integer> l1, l2, l3;
	private boolean imprimirPorPantalla;

	
	/*
	 * La variable "imprimirPorPantalla" muestra una traza en consola cuando vale TRUE.
	 * En caso de valer FALSE, no muestra nada por consola.
	 */
	@Before public void setUp(){   
		log = new Logica();		
		l1 = getList();
		l2 = getList();
		l3 = getList();
		imprimirPorPantalla = false;
	}
	
	private PositionList<Integer> getList() {
		return new Lista_doble_enlazada<Integer>();
	}
	
	/*
	 * 		A1 x A1'   x   A2 x A2'   x  ...   An  An'
	 * 		Ai = CzCC
	 * 		C pertenece a {a, b}∗
	*/
	
	@Test public void incisoA__cadena_enunciado() {		
		assertTrue("Cadena del enunciado: abbzabbabbxbbabbazbba", log.chequear_cadena("abbzabbabbxbbabbazbba"));
	}	
	@Test public void incisoA__cadena_enunciado_x2() {	
		assertTrue("Cadena: abbzabbabbxbbabbazbbaxabbzabbabbxbbabbazbba", log.chequear_cadena("abbzabbabbxbbabbazbbaxabbzabbabbxbbabbazbba"));
	}

	@Test public void incisoA__cadena_solo_As() {	
		assertTrue("Cadena: azaaxaaza", log.chequear_cadena("azaaxaaza"));
	}
	@Test public void incisoA__cadena_solo_As_x2() {			
		assertTrue("azaaxaazaxazaaxaaza", log.chequear_cadena("azaaxaazaxazaaxaaza"));		
	}
	

	@Test public void incisoA__cadena_solo_Bs() {			
		assertTrue("bzbbxbbzb", log.chequear_cadena("bzbbxbbzb"));			
	}
	@Test public void incisoA__cadena_solo_Bs_x2() {			
		assertTrue("bzbbxbbzbxbzbbxbbzb", log.chequear_cadena("bzbbxbbzbxbzbbxbbzb"));			
	}
	

	@Test public void incisoA__cadena_gigante() {			
		assertTrue("Cadena gigante", log.chequear_cadena("aaabbbababbaaaaaaaababzaaabbbababbaaaaaaaababaaabbbababbaaaaaaaababxbabaaaaaaaabbababbbaaababaaaaaaaabbababbbaaazbabaaaaaaaabbababbbaaa"));			
	}
	

	@Test public void incisoA__con_C_vacio() {			
		assertTrue("zxz", log.chequear_cadena("zxz"));			
	}
	@Test public void incisoA__con_C_vacio_pero_hasta_A3() {			
		assertFalse("zxzxzxzxz", log.chequear_cadena("zxzxzxzxz"));			
	}
	
	@Test public void incisoA__letra_erronea_1() {    
		  assertFalse("abczabcabcxcbacbazcba", log.chequear_cadena("abczabcabcxcbacbazcba"));
	}
	@Test public void incisoA__letra_erronea_2() {    
		  assertFalse("abbzabbabbxbbabbazbbax", log.chequear_cadena("abbzabbabbxbbabbazbbax"));
	}
	@Test public void incisoA__letra_erronea_3() {    
		  assertFalse("abbzabbabbxbbabbazbbaa", log.chequear_cadena("abbzabbabbxbbabbazbbaa"));
	}
	@Test public void incisoA__letra_erronea_4() {    
		  assertFalse("abbazabbabbxbbabbazbba", log.chequear_cadena("abbazabbabbxbbabbazbba"));
	}
	
	@Test public void incisoA__letra_erronea_5() {    
		  assertFalse("abbzaabbabbxbbabbazbba", log.chequear_cadena("abbzaabbabbxbbabbazbba"));
	}
	@Test public void incisoA__letra_erronea_6() {    
		  assertFalse("abbzabbabbbxbbabbazbba", log.chequear_cadena("abbzabbabbbxbbabbazbba"));
	}
	@Test public void incisoA__letra_erronea_7() {    
		  assertFalse("abbzabbabbxbbabbbazbba", log.chequear_cadena("abbzabbabbxbbabbbazbba"));
	}
	@Test public void incisoA__letra_erronea_8() {    
		  assertFalse("abbzabbabbxbbabbaazbba", log.chequear_cadena("abbzabbabbxbbabbaazbba"));
	}
	@Test public void incisoA__letra_erronea_9() {    
		  assertFalse("abbzabbabbxbbabbazbbba", log.chequear_cadena("abbzabbabbxbbabbazbbba"));
	}
	@Test public void incisoA__letra_erronea_10() {			
		assertFalse("zxza", log.chequear_cadena("zxza"));			
	}
	@Test public void incisoA__letra_erronea_11() {			
		assertFalse("zxaz", log.chequear_cadena("zxaz"));			
	}
	@Test public void incisoA__letra_erronea_12() {			
		assertFalse("zaxz", log.chequear_cadena("zaxz"));			
	}
	@Test public void incisoA__letra_erronea_13() {			
		assertFalse("azxz", log.chequear_cadena("azxz"));			
	}
	@Test public void incisoA__letra_erronea_14() {			
		assertFalse("azxza", log.chequear_cadena("azxza"));			
	}
	@Test public void incisoA__letra_erronea_15() {			
		assertFalse("zaxaz", log.chequear_cadena("zaxaz"));			
	}
	@Test public void incisoA__letra_erronea_16() {			
		assertFalse("azxaz", log.chequear_cadena("azxaz"));			
	}
	@Test public void incisoA__letra_erronea_17() {			
		assertFalse("zaxza", log.chequear_cadena("zaxza"));			
	}
	@Test public void incisoA__letra_erronea_18() {			
		assertFalse("zxz", log.chequear_cadena("zxza"));			
	}
	@Test public void incisoA__letra_erronea_19() {			
		assertFalse("zxzx", log.chequear_cadena("zxzx"));			
	}
	@Test public void incisoA__letra_erronea_20() {			
		assertFalse("zxxz", log.chequear_cadena("zxxz"));			
	}
	@Test public void incisoA__letra_erronea_21() {			
		assertFalse("zxxz", log.chequear_cadena("zxxz"));			
	}	
	@Test public void incisoA__letra_erronea_22() {			
		assertFalse("bzbxbzb", log.chequear_cadena("bzbxbzb"));			
	}
	@Test public void incisoA__letra_erronea_23() {			
		assertFalse("bzbbxbbz", log.chequear_cadena("bzbbxbbz"));			
	}
	@Test public void incisoA__letra_erronea_24() {			
		assertFalse("bzbbxbbz", log.chequear_cadena("bzbbxbbz"));			
	}
	@Test public void incisoA__letra_erronea_25() {			
		assertFalse("bazbabaxababzab", log.chequear_cadena("bazabaxababzab"));			
	}
	
	/*
	 * Retorna TRUE si las listas recibidas por parámetro son iguales, FALSE en caso contrario.
	 */
	private <E> boolean listasIguales(PositionList<E> l1, PositionList<E> l2) {
		boolean toReturn = false;
		Position<E> p1, p2;
		
		if(l1.isEmpty() && l2.isEmpty())
			toReturn = true;
		else if(l1.size() == l2.size()) {
				try {					
					p1 = l1.first();
					p2 = l2.first();					
					while(p1!=l1.last() && p2!=l2.last()) {
						if(!p1.element().equals(p2.element())) 
							return false;
						p1 = l1.next(p1);
						p2 = l2.next(p2);
					}
					if(l1.last().element().equals(l2.last().element()))
						toReturn = true;	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		return toReturn;
	}
	
	/*
	 * Recibe por parámetro una lista y la devuelve en formato string
	 */
	private <E> String toString(PositionList<E> l) {
		String toReturn = "{";
		for(E elem : l) {
			toReturn = toReturn + elem.toString() + ", ";
		}		
		toReturn += "}";
		toReturn = toReturn.replaceAll(", }", "}");
		return toReturn;
	}
	
	@Test public void incisoB_listas_vacias() {		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_listas_vacias: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}
		
		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	
	
	@Test public void incisoB_01() {
		l1.addLast(1);
		l3.addLast(1);
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_01: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}		

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}	
	

	@Test public void incisoB_02() {
		l1.addLast(1);
		l2.addLast(2);
		l3.addLast(2);
		l3.addLast(1);		
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_02: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}		

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_03() {
		l1.addLast(1);
		l2.addLast(1);
		l3.addLast(1);
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_03: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_04() {
		
		l1.addLast(1); l1.addLast(3); l1.addLast(5);
		
		l2.addLast(2); l2.addLast(4); l2.addLast(6);
		
		l3.addLast(6); l3.addLast(5); l3.addLast(4);
		l3.addLast(3); l3.addLast(2); l3.addLast(1); 
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_04: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_05() {
		
		l1.addLast(1); l1.addLast(3); l1.addLast(3); l1.addLast(5); 
		
		l2.addLast(2); l2.addLast(2); l2.addLast(4); l2.addLast(6); l2.addLast(6);
		
		l3.addLast(6); l3.addLast(5); l3.addLast(4);
		l3.addLast(3); l3.addLast(2); l3.addLast(1); 

		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_05: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_06() {
		
		l1.addLast(1); l1.addLast(2); l1.addLast(3); l1.addLast(5); 
		
		l2.addLast(1); l2.addLast(2); l2.addLast(4); l2.addLast(6);
		
		l3.addLast(6); l3.addLast(5); l3.addLast(4);
		l3.addLast(3); l3.addLast(2); l3.addLast(1); 		

		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_06: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}
		
		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}

	@Test public void incisoB_07() {
		
		l1.addLast(1); l1.addLast(2); l1.addLast(3); 
		
		l2.addLast(1); l2.addLast(2); l2.addLast(3);
		
		l3.addLast(3); l3.addLast(2); l3.addLast(1);		

		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_07: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}
		
		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_08() {
		
		l1.addLast(1); l1.addLast(2); l1.addLast(2); l1.addLast(3); 
		l1.addLast(5); l1.addLast(5); l1.addLast(5); l1.addLast(5);  
		
		l2.addLast(2); l2.addLast(2); l2.addLast(2); l2.addLast(2); 
		l2.addLast(4); l2.addLast(6); l2.addLast(7);
		
		l3.addLast(7); l3.addLast(6); l3.addLast(5);
		l3.addLast(4); l3.addLast(3); l3.addLast(2); l3.addLast(1); 		

		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_08: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}
		
		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_09() {
		
		l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); 
		
		l3.addLast(1); 
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_09: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}


	@Test public void incisoB_10() {
		
		l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); l1.addLast(1); 
		
		l2.addLast(1); l2.addLast(1); l2.addLast(1); l2.addLast(1); 
		
		l3.addLast(1); 
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_10: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}

		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
	}
	

	@Test public void incisoB_11() {
		
		l2.addLast(5); l2.addLast(5); l2.addLast(5); l2.addLast(5); l2.addLast(5); l2.addLast(5);  
		
		l3.addLast(5); 
		
		
		if(imprimirPorPantalla) {
			System.out.println("Método incisoB_11: ");
			System.out.println("L1 = "+toString(l1));
			System.out.println("L2 = "+toString(l2));
			System.out.println("El resultado deberia ser   = "+toString(l3));
			System.out.println("La respuesta del método es = "+toString(log.intercalar(l1, l2)));
			System.out.println(); System.out.println();
		}
		
		assertTrue(listasIguales(log.intercalar(l1, l2), l3));
		
	}


	@Test public void incisoC_listas_vacias(){
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}

	@Test public void incisoC_01(){
		
		l1.addLast(1);
		
		l2.addLast(1);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
	
	@Test public void incisoC_02(){
		
		l1.addLast(1);
		l1.addLast(1);
		l1.addLast(1);
		
		l2.addLast(1);
		l2.addLast(1);
		l2.addLast(1);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
	
	@Test public void incisoC_03(){
		
		l1.addLast(1);
		l1.addLast(2);
		
		l2.addLast(1);
		l1.addLast(2);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
	
	@Test public void incisoC_04(){
		
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		
		l2.addLast(1);
		l2.addLast(3);
		l2.addLast(2);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
	
	@Test public void incisoC_05(){
		
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);
		
		l2.addLast(1);
		l2.addLast(4);
		l2.addLast(2);
		l2.addLast(3);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
	

	@Test public void incisoC_06(){
		
		l1.addLast(4);
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(0);
		l1.addLast(20);
		l1.addLast(15);
		l1.addLast(30);
		
		l2.addLast(4);
		l2.addLast(30);
		l2.addLast(7);
		l2.addLast(15);
		l2.addLast(1);
		l2.addLast(20);
		l2.addLast(0);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}

	@Test public void incisoC_07(){
		
		l1.addLast(4);
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(0);
		l1.addLast(20);
		l1.addLast(15);
		l1.addLast(30);
		l1.addLast(100);
		
		l2.addLast(4);
		l2.addLast(100);
		l2.addLast(7);
		l2.addLast(30);
		l2.addLast(1);
		l2.addLast(15);
		l2.addLast(0);
		l2.addLast(20);
		
		assertTrue(listasIguales(log.zigzag(l1), l2));
	}
}















