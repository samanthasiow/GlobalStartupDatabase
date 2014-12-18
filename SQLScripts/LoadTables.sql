DROP TABLE IF EXISTS StartupListing;
	CREATE TABLE StartupListing 
		(id INT NOT NULL PRIMARY KEY,
		startupName VARCHAR(32) NOT NULL,
		quality int NOT NULL,
		highConcept VARCHAR(140),
		companyUrl VARCHAR(140),
		companySize VARCHAR(12),
        thumbUrl VARCHAR(200));
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupListings.csv' INTO TABLE StartupListing
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupListing;

DROP TABLE IF EXISTS StartupLocation;
	CREATE TABLE StartupLocation 
		(id INT NOT NULL PRIMARY KEY,
		location VARCHAR(32) NOT NULL);
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupLocations.csv' INTO TABLE StartupLocation
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupLocation;

DROP TABLE IF EXISTS StartupMarkets;
	CREATE TABLE StartupMarkets 
		(id INT NOT NULL PRIMARY KEY,
		market VARCHAR(32) NOT NULL);

LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupMarkets.csv' INTO TABLE StartupMarkets
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupMarkets;

DROP TABLE IF EXISTS StartupTypes;
	CREATE TABLE StartupTypes 
		(id INT NOT NULL PRIMARY KEY,
		type VARCHAR(32) NOT NULL);
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupTypes.csv' INTO TABLE StartupTypes
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupTypes;