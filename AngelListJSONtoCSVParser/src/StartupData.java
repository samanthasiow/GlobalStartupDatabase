import java.util.ArrayList;


public class StartupData {
	private String id;
	private String hidden;
	private String name;
	private String angellistUrl;
	private String quality;
	private String highConcept;
	private String companyUrl;
	private String companySize;
	private ArrayList<String> companyType;

	public StartupData(String id,
			String name, String angellistUrl, String quality,
			String highConcept, String companyUrl, String companySize) {
		super();
		this.id = id;
		this.name = name;
		this.angellistUrl = angellistUrl;
		this.quality = quality;
		this.highConcept = highConcept;
		this.companyUrl = companyUrl;
		this.companySize = companySize;
		this.companyType = companyType;
	}

	@Override
	public String toString() {
		return  id.replace(",", ";")
				+ "," + name.replace(",", ";")
				+ "," + angellistUrl.replace(",", ";") + "," + quality.replace(",", ";")
				+ "," + highConcept.replace(",", ";") + "," + companyUrl.replace(",", ";")
				+ "," + companySize.replace(",", ";");
	}
	
	
}
