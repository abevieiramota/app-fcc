package com.abevieiramota.fcc;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class TestGuavaView {
	
	@Test
	public void testGuavaView() {
		
		List<String> list = Lists.newArrayList("Abelardo", "Teste", "A", "B");
		
		Collection<String> stringsLenLt3 = Collections2.filter(list, new Predicate<String>() {
			@Override
			public boolean apply(String s) {
				return s.length() < 3;
			}
		});
		
		System.out.println(stringsLenLt3);
		
		list.remove("A");
		
		System.out.println(stringsLenLt3);
	}

}
