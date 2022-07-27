package Empapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException  {
	
	private static final long serialVersionUID= 1L;
	private String resourceName;
	private String resourceField;
	private Object resourceValue;
	
	
	public ResourceNotFound() {
		super();
	}
	public ResourceNotFound(String resourceName, String resourceField, Object resourceValue) {
		super(String.format("This %s not present in resources %s : '%s' ",resourceField,resourceName,resourceValue));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.resourceValue = resourceValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	
	public String getResourceField() {
		return resourceField;
	}
	
	public Object getResourceValue() {
		return resourceValue;
	}
	

}
