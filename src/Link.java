
public class Link {
	
	private final String original;
	private final String subject;
	private String site;
	private final String semester;
	
	public Link(String s){
		semester = "&cdyd_kod=15%2F16L";//winter to default
		//cdyd_kod=15%2F16L summer semester
		original = s;
		subject = change(s);
	}
	
	public final String change(String s){
		int ind1 = s.indexOf("prz_kod=");
		return "&"+s.substring(ind1);
	}
	
	
	
	public String getSubject(){
		return subject;
	}
	
	public String getSemester(){
		return semester;
	}
	
	public String getOriginalLink(){
		return original;
	}
	
	public String getHTMLLink(){
		site = "https://www.usosweb.uj.edu.pl/kontroler.php?_action=katalog2/przedmioty/pokazPlanZajecPrzedmiotu"
				+ getSubject()+ getSemester()+"&division=semester&plan_format=html"
				+"&plan_showSettings=1&plan_showStartTime=1&plan_showEndTime=1&plan_showTypeShort=0&plan_showTypeFull=1&plan_showGroupNumber=1&plan_showCourseName=1&plan_showCourseCode=0&plan_showRoom=1&plan_showBuildingCode=1&plan_showLecturers=1&plan_overridePrintWidth=1&plan_colorScheme=default";
		return site;
	}
}
