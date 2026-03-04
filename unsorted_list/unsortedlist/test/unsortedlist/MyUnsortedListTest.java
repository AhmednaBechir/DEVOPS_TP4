package unsortedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

import static org.junit.Assert.*;

import org.junit.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

public class MyUnsortedListTest {
	
	@Test
	public void isEmptyTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list", list.isEmpty());
		list.append(4);
		assertFalse("after append", list.isEmpty());
		list.pop();
		assertTrue("after append+pop", list.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals("size after init", 0, list.size());
		list.append(3);
		assertEquals("size after append", 1, list.size());
		list.prepend(1);
		assertEquals("size after prepend", 2, list.size());
		list.insert(2, 1);
		assertEquals("size after insert", 3, list.size());
		list.remove(1);
		assertEquals("size after remove", 2, list.size());
		list.popLast();
		assertEquals("size after popLast", 1, list.size());
		list.pop();
		assertEquals("size after popLast", 0, list.size());
	}
	
	@Test
	public void prependTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(4);
		list.prepend(-13);
		list.prepend(8);
		assertEquals("prependTest: Check list size after prepend should be 3", 3, list.size());
		assertEquals("get first prepend element", 8, (int) list.pop());
		assertEquals("get second prepend element", -13, (int) list.pop());
		assertEquals("get third prepend element", 4, (int) list.pop());
		assertTrue("prependTest: Should be empty after 3 pops",list.isEmpty());
	}

	@Test
	public void appendTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.append(4);
		list.append(-13);
		list.append(8);
		assertEquals("appendTest: Check list size after append should be 3", 3, list.size());
		assertEquals("get first append element", 4, (int) list.pop());
		assertEquals("get second append element", -13, (int) list.pop());
		assertEquals("get third append element", 8, (int) list.pop());
		assertTrue("appendTest: Should be empty after 3 pops",list.isEmpty());
	}
	
	@Test
	public void insertTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(2, 4);
		
		list.insert(1, 0);
		list.insert(3, 2);
		list.insert(5, 4);
		assertEquals("insertTest: Check list size after insert should be 5", 5, list.size());
		assertEquals("first element insert", 1, (int) list.pop());
		assertEquals("second element insert", 2, (int) list.pop());
		assertEquals("third element insert", 3, (int) list.pop());
		assertEquals("fourth element insert", 4, (int) list.pop());
		assertEquals("fifth element insert", 5, (int) list.pop());
		assertTrue("insertTest: Should be empty after 5 pops",list.isEmpty());
	}
	
	@Test
	public void popTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		assertEquals("first pop", 1, (int) list.pop());
		assertEquals("second pop", 2, (int) list.pop());
		assertEquals("third pop", 3, (int) list.pop());
		assertEquals("fourth pop", 4, (int) list.pop());
		assertEquals("fifth pop", 5, (int) list.pop());
		assertTrue("popTest: Should be empty after 5 pops",list.isEmpty());
	}
	
	@Test(expected = EmptyListException.class)
	public void popEmptyTest1() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test(expected = EmptyListException.class)
	public void popEmptyTest2() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.pop();
		list.pop();
		list.pop();
		list.pop();
	}
	
	@Test
	public void popLastTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		assertEquals("first popLast", 5, (int) list.popLast());
		assertEquals("second popLast", 4, (int) list.popLast());
		assertEquals("third popLast", 3, (int) list.popLast());
		assertEquals("fourth popLast", 2, (int) list.popLast());
		assertEquals("fifth popLast", 1, (int) list.popLast());
		assertTrue("popLastTest: Should be empty after 5 popslast",list.isEmpty());
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastEmptyExceptionTest1() {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastEmptyExceptionTest2() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		list.pop();
		list.pop();
		list.pop();
		list.popLast();
	}
	
	@Test
	public void removeTest() {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		
		assertEquals("first remove", 1, (int) list.remove(0));
		assertEquals("second remove", 3, (int) list.remove(1));
		assertEquals("third remove", 5, (int) list.remove(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertBadIndexTest1() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(2, 1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertBadIndexTest2() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		
		list.insert(list.remove(1), 5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertBadIndexTest3() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		list.insert(6, -3);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertBadIndexTest4() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		list.insert(6, 6);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeBadIndexTest1() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeBadIndexTest2() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		list.remove(5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeBadIndexTest3() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		list.pop();
		list.remove(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeBadIndexTest4() throws Exception {
		MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
		list.pop();
		list.remove(-3);
	}
	
	@Test
	public void equalsTest1() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3);
		
		assertTrue("equals test 1", list1.equals(list2));
	}
	
	@Test
	public void equalsTest2() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of();
		
		assertFalse("equals test 2", list1.equals(list2));
	}
	
	@Test
	public void equalsTest3() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(3, 2, 1);
		
		assertFalse("equals test 3", list1.equals(list2));
	}
	
	@Test
	public void equalsTest4() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3, 4);
		
		assertFalse("equals test 4", list1.equals(list2));
	}
	
	@Test
	public void equalsTest5() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3, 4);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3);
		
		assertFalse("equals test 5", list1.equals(list2));
	}
	
	@Test
	public void equalsTest6() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		int list2 = 1;
		
		assertFalse("equals test 6", list1.equals(list2));
	}
	
	@Test
	public void equalsTest7() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Character> list2 = MyUnsortedList.of((char) 1, (char) 2, (char) 3);
		
		assertFalse("equals test 7", list1.equals(list2));
	}

	@Test
	public void equalsTest8() {
		MyUnsortedList<Integer> mylist = MyUnsortedList.of(1,2,3,4,5);
		MyUnsortedList<String> mylist2 = MyUnsortedList.of("1","2","3","4","5");
		
		assertTrue("equals test 8: The 2 lists should be equals after toString conversion",mylist.toString().equals(mylist2.toString()));
	}

	@Test
	public void equalsTest9() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 8);

		assertFalse("equals test 9", list1.equals(list2));
	}

	@Test
	public void equalsTest10() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of(1);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(1);

		assertTrue("equals test 10", list1.equals(list2));
	}

	@Test
	public void equalsTest11() {
		MyUnsortedList<Integer> list1 = MyUnsortedList.of();
		MyUnsortedList<Integer> list2 = MyUnsortedList.of();

		assertTrue("equals test 11", list1.equals(list2));
	}

    @Test
	public void MultiplePopRemovePopLastTest() {
		MyUnsortedList<Integer> mylist = MyUnsortedList.of(1,2,3,4,5);
		
		assertEquals( "MultiplePopRemovePopLastTest: 1 popLast should be 5", 5, (int) mylist.popLast());
		assertEquals( "MultiplePopRemovePopLastTest: 1 Pop should be 1", 1, (int)mylist.pop());
		assertEquals( "MultiplePopRemovePopLastTest: remove(1) should be 3", 3, (int)mylist.remove(1));
		assertEquals( "MultiplePopRemovePopLastTest: 1 popLast should be 4", 4, (int) mylist.popLast());
		assertEquals( "MultiplePopRemovePopLastTest: 1 Pop should be 2", 2,(int) mylist.pop());
		assertTrue("MultiplePopRemovePopLastTest: List should be empty", mylist.isEmpty());
	} 
	

}
