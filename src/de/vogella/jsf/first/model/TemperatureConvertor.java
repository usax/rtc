package de.vogella.jsf.first.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

public class TemperatureConvertor {
	
	
	public TemperatureConvertor(){
		//keyval = new HashMap(); 
		keyval.put("1", "bcdd");
		
		for(String s :keyval.keySet()){
			
			keys.add(s);
		}
		//keys = new  ArrayList(keyval.keySet());
		
		//
		
		
		//
	}
	private double celsius; 
	private double fahrenheit;
	private boolean initial= false; 
	private Map<String,String> keyval = new HashMap<String,String>();
	private List<String> keys = new ArrayList<String>();
	private HtmlDataTable  dataTable;

	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public double getCelsius() {
		return celsius;
	}
	public Map getKeyval() {
		return keyval;
	}
	public void setKeyval(Map keyval) {
		this.keyval = keyval;
	}
	public void setKeys(List keys) {
		this.keys = keys;
	}
	public List getKeys() {
		return keys;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	public double getFahrenheit() {
		return fahrenheit;
	}
	
	public boolean getInitial(){
		return initial;
	}
	
	public String reset (){
		initial = true;
		fahrenheit =0;
		celsius = 0; 
		return "reset";
	}
	public String celsiusToFahrenheit(){
		initial = false;
		//getValue.put("2", "bwwwcdd");
		fahrenheit = (celsius *9 / 5) +32;
		return "calculated";
	}
	

	public String celsiusTo(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String countrry = params.get("action");
		
		return "hello";
	}
	public void openPopupClicked(ActionEvent event){
	    // View's id in the same form as used in the navigation rules in faces-config.xml
	    // This value could be passed as parameter (using <f:param>)
	    final String viewId = "/Convertors.jsp"; 
	    
	    FacesContext facesContext = FacesContext.getCurrentInstance();

	    // This is the proper way to get the view's url
	    ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
	    String actionUrl = viewHandler.getActionURL(facesContext, viewId);
	    
	    String javaScriptText = "window.open('"+actionUrl+"', 'popupWindow', 'dependent=yes, menubar=no, toolbar=no');";
	    
	    // Add the Javascript to the rendered page's header for immediate execution
	    AddResource addResource = AddResourceFactory.getInstance(facesContext);
	    addResource.addInlineScriptAtPosition(facesContext, AddResource.HEADER_BEGIN, javaScriptText);         
		
	}

	
	
/*	public List getEntrySet() {  2
      return  new ArrayList(keyval.keySet());  
}  
*/
}


	