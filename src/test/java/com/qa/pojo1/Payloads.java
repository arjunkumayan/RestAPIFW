package com.qa.pojo1;

public class Payloads {
	
	String description;
	String summary;
	Project project;
    Parent parent;
    Issuetype issuetype;
    
    
	public Payloads( Project project,Parent parent, String summary,  String description,Issuetype issuetype) {
		this.project = project;
		this.parent = parent;
		this.summary = summary;
		this.description = description;
		this.issuetype = issuetype;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Issuetype getIssuetype() {
		return issuetype;
	}


	public void setIssuetype(Issuetype issuetype) {
		this.issuetype = issuetype;
	}
    
    
}
