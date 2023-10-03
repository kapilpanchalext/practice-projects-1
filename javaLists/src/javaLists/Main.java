package javaLists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
					
		Collection<Model> listModel = new ArrayList<>();
		Collection<Model1> listModel1 = new ArrayList<>();
		
		Model model1 = new Model(1L,"Model_Name1");
		Model model2 = new Model(2L, "Model_Name2");
		
		Model1 model1_1 = new Model1(1L,"Model1_Name1");
		Model1 model1_2 = new Model1(2L,"Model_Name2");
		
		listModel.add(model1);
		listModel.add(model2);	
		
		listModel1.add(model1_1);
		listModel1.add(model1_2);
		
		
		listModel.forEach((Model name)->{System.err.println("ForeachMODEL -> " + name.getName());});
		
		
		System.err.println("LIST_ITERATOR_1: " + listModel.iterator().next().getName());
		System.err.println("LIST_ITERATOR_2: " + listModel.iterator().next().getName());
		
		System.err.println(listModel);
		System.err.println(listModel1);

//		Collection<Model> differentModel = new HashSet<>();
//		Collection<Model1> differentModel1 = new HashSet<>();

//		differentModel.addAll(listModel);
//		differentModel1.addAll(listModel1);
//		
//		System.out.println(differentModel);				
		
		Collection<String> stringList1 = new ArrayList<>();
		Collection<String> stringList2 = new ArrayList<>();
		
		stringList1.add(model1.getName());
		stringList1.add(model2.getName());
		
		stringList2.add(model1_1.getName1());
		stringList2.add(model1_2.getName1());
		
		System.err.println(stringList1);
		System.err.println(stringList2);		
		
		stringList1.retainAll(stringList2);
		System.err.println(stringList1);		
		
		stringList2.forEach((String name) -> {
			System.err.println("Foreach -> " + name);			
		});
		
		stringList2.forEach(System.out::println);
		
		for(Iterator<String> i=stringList2.iterator(); i.hasNext();) {
			System.err.println(i.next());
		}		
	}
}


class Model{
	private Long id;
	private String name;
	
	public Model() {
		
	}
	public Model(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Model(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + "]";
	}	
}

class Model1{
	private Long id;
	private String name1;
	
	public Model1() {
		
	}
	public Model1(Long id, String name1) {
		this.id = id;
		this.name1 = name1;
	}
	public Model1(String name1) {
		this.name1 = name1;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}	
	@Override
	public String toString() {
		return "Model1 [id=" + id + ", name1=" + name1 + "]";
	}	
}
