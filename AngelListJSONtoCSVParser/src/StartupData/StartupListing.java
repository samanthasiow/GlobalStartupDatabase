package StartupData;


public class StartupListing {
	private String id;
	private String name;
	private String quality;
	private String highConcept;
	private String companyUrl;
	private String companySize;
	private String thumbUrl;

	public StartupListing(String id,String name, String quality,
			String highConcept, String companyUrl, String companySize, String thumbUrl) {
		super();
		this.id = id;
		this.name = name;
		this.quality = quality;
		this.highConcept = highConcept;
		this.companyUrl = companyUrl;
		this.companySize = companySize;
		this.thumbUrl = thumbUrl;
	}

	@Override
	public String toString() {
		return  id.replace(",", ";")
				+ "," + name.replace(",", ";")
				+ "," + quality.replace(",", ";")
				+ "," + highConcept.replace(",", ";") + "," + companyUrl.replace(",", ";")
				+ "," + companySize.replace(",", ";") + "," + thumbUrl;
	}
	
	
}
