package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListUseCases {
	public static void main(String[] args) {
		List<String> arrayList=new ArrayList<String>();
		List<String> linkedList=new LinkedList<String>();
		arrayList.add("selva");
		arrayList.add("kumar");
		arrayList.add("kishore");
		arrayList.remove(2);
		linkedList.add("selva");
		linkedList.add("kumar");
		linkedList.add("kishore");
		linkedList.remove(2);
		System.out.println("ArrayList: "+arrayList);
		System.out.println("LinkedList: "+linkedList);
		Iterator<String> arrayIterable=arrayList.iterator();
		while(arrayIterable.hasNext()) {
			System.out.println("arrayList: "+arrayIterable.next());
		}
//		Iterator<String> linkedIterable=linkedList.iterator();
//		while(linkedIterable.hasNext()) {
//			System.out.println("linkedList: "+linkedIterable.next());
//		}
		//Listiterator has additional methods that Iterator such as prevoius(),hasPreviuo() etc....
		ListIterator<String> linkedIterable=linkedList.listIterator();
		while(linkedIterable.hasNext()) {
			System.out.println("linkedList: "+linkedIterable.next());
		}
		
	}

}
