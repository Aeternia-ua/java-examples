import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = ((JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\" + "employees.json"))).toJSONString();
		
		List<EmployeeBean> employees = Arrays.asList(mapper.readValue(json, EmployeeBean[].class));
		
		EmployeeBean[] emplyeesArray = (EmployeeBean[]) employees.toArray();
		Arrays.sort(emplyeesArray, EmployeeBean.EmployeeComparator);
		
		for (EmployeeBean employee : emplyeesArray) {
			System.out.println(employee.getName() + " -> " + employee.getPosition() + " : " + employee.getSalary());
		}
		
	}
	
}
