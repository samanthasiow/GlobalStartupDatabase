import java.util.ArrayList;


public class StartupData {
	private String id;
	private String hidden;
	private String communityProfile;
	private String name;
	private String angellistUrl;
	private String quality;
	private String highConcept;
	private String companyUrl;
	private ArrayList<String> markets;
	private ArrayList<String> locations;
	private String companySize;
	private String companyType;
	private String status;

	public StartupData(String id, String hidden, String communityProfile,
			String name, String angellistUrl, String quality,
			String highConcept, String companyUrl, ArrayList<String> markets,
			ArrayList<String> locations, String companySize,
			String companyType, String status) {
		super();
		this.id = id;
		this.hidden = hidden;
		this.communityProfile = communityProfile;
		this.name = name;
		this.angellistUrl = angellistUrl;
		this.quality = quality;
		this.highConcept = highConcept;
		this.companyUrl = companyUrl;
		this.markets = markets;
		this.locations = locations;
		this.companySize = companySize;
		this.companyType = companyType;
		this.status = status;
	}

	@Override
	public String toString() {
		return "StartupData [id=" + id + ", hidden=" + hidden
				+ ", communityProfile=" + communityProfile + ", name=" + name
				+ ", angellistUrl=" + angellistUrl + ", quality=" + quality
				+ ", highConcept=" + highConcept + ", companyUrl=" + companyUrl
				+ ", markets=" + markets.toString() + ", locations=" + locations.toString()
				+ ", companySize=" + companySize + ", companyType="
				+ companyType + ", status=" + status + "]";
	}
	
	
}
