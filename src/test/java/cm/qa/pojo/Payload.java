package cm.qa.pojo;

public class Payload {

String summary;
String description;

Issuetype issuetype;
Project project;

public Payload()
{
	
}

public Payload(String summary, String description, Issuetype issuetype,Project project)
{
	this.summary=summary;
	this.description=description;
	this.issuetype=issuetype;
	this.project=project;
	
}

public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Issuetype getIssuetype() {
	return issuetype;
}
public void setIssuetype(Issuetype issuetype) {
	this.issuetype = issuetype;
}
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}






}
