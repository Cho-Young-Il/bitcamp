package collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Menu {
	private List<ISand> sandList;
	private Set<ISand> sandSet;
	private Map<String, ISand> sandMap;
	private Properties properties;
	
	public Menu() {
		System.out.println("Menu 기본 생성자");
	}

	public void setSandList(List<ISand> sandList) {
		this.sandList = sandList;
	}

	public void setSandSet(Set<ISand> sandSet) {
		this.sandSet = sandSet;
	}
	
	public void setSandMap(Map<String, ISand> sandMap) {
		this.sandMap = sandMap;
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void printList() {
		for(ISand sand : sandList) {
			sand.info();
		}
	}
	
	public void printSet() {
		for(ISand sand : sandSet) {
			sand.info();
		}
	}
	
	public void printMap() {
		for(String key : sandMap.keySet()) {
			sandMap.get(key).info();
		}
	}
	
	public void printProperties() {
		System.out.println(properties.getProperty("ham"));
		System.out.println(properties.getProperty("cheese"));
		System.out.println(properties.getProperty("hamCheese"));
	}
}