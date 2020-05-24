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

	@Before public void setUp(){   
		log = new Logica();		
		l1 = getList();
		l2 = getList();
		l3 = getList();
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
	
	public <E> boolean listasIguales(PositionList<E> l1, PositionList<E> l2) {
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
	
	
	@Test public void incisoB_1() {
		//assertEquals(l3, log.intercalar(l1, l2));
		assertTrue("l1= - l2= ",listasIguales(l1,l2));
	}

	@Test public void incisoB_2() {
		l1.addLast(1);
		assertFalse("l1=1 - l2= ",listasIguales(l1,l2));
		l2.addLast(1);
		assertTrue("l1=1 - l2=1 ",listasIguales(l1,l2));
		try {
			System.out.println(l1.first().element().equals(l2.first().element()));
		} catch (EmptyListException e) {
			System.out.println("ERROR incisoB_2");
			e.printStackTrace();
		}
	}
	
	/*
	@Test public void incisoB_4() {
		l1.addLast(2); l1.addLast(3);
		l2.addLast(2); l2.addLast(3);		
		assertTrue("l1=1,2,3 - l2=1,2,3 ",listasIguales(l1,l2));
		
	}

		@Test public void incisoB_5() {
		try {
			l1.remove(l1.first());
			assertFalse("l1=2,3 - l2=1,2,3 ",listasIguales(l1,l2));
			l2.remove(l2.first());
			assertTrue("l1=2,3 - l2=2,3 ",listasIguales(l1,l2));

			l2.remove(l2.first());
			assertFalse("l1=3 - l2=2,3 ",listasIguales(l1,l2));
			l2.remove(l2.first());
			assertFalse("l1= - l2=2,3 ",listasIguales(l1,l2));
			
			assertTrue("l3= - l1= ",listasIguales(l3,l2));
			
			//System.out.println(log.intercalar(l1, l2).toString());
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	*/
}















