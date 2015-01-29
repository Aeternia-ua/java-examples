import java.util.Comparator;

import org.apache.commons.lang.builder.CompareToBuilder;

public class EmployeeBean implements Comparable<EmployeeBean> {
	
	private long id;
	private String name;
	private String position;
	private Double salary;
	
	public EmployeeBean() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public int compareTo(EmployeeBean o) {
		return this.salary < o.getSalary() ? -1 :
			this.salary > o.getSalary() ? 1 : 0;
	}
	
	public static Comparator<EmployeeBean> EmployeeComparator = new Comparator<EmployeeBean>() {
		
		@Override
		public int compare(EmployeeBean empl, EmployeeBean empl2) {
			
			return new CompareToBuilder()
				.append(empl.getPosition(), empl2.getPosition())
				.append(empl.getSalary(), empl2.getSalary())
				.toComparison();
		}
		
	};
}
