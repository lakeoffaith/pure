package com.ijoy.common.comutil;

import java.util.Collections;
import java.util.List;

public class ListUtil {
	//两个list出重,且排序，
	public static List dereplication(List father,List son){
		father.removeAll(son);
		father.addAll(son);
		Collections.sort(father);
		return father;
		
	}
}
