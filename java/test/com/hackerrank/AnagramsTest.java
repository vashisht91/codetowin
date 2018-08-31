package com.hackerrank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramsTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
	@Before
	public void before() { 
		System.out.println("Before");
	}
	
	@After
	public void after() {
		System.out.println("After");
	}

	@Test
	public void test() {
//		Anagrams anagram = new Anagrams();
		System.out.println("test");
		assertEquals(true, Anagrams.isAnagram("abc", "cba"));
		assertEquals(true, Anagrams.isAnagram("a	bc", "cab"));
		assertEquals(true, Anagrams.isAnagram("abc", "cba"));
		
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
		assertTrue(Anagrams.isAnagram("abc", "cba"));
	}

}
