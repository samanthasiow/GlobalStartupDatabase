DROP TABLE IF EXISTS StartupListing;
	CREATE TABLE StartupListing 
		(id INT NOT NULL PRIMARY KEY,
		startupName VARCHAR(32) NOT NULL,
		quality int NOT NULL,
		highConcept VARCHAR(140) NOT NULL,
		companyUrl VARCHAR(140) NOT NULL,
		companySize VARCHAR(12) NOT NULL);
        
INSERT INTO StartupListing (id, startupName, quality, highConcept, companyUrl, companySize)
VALUES (1, "Test", 1, "Test", "Test", "Test");

SELECT * FROM StartupListing;

DROP TABLE IF EXISTS StartupLocation;
	CREATE TABLE StartupLocation 
		(id INT NOT NULL PRIMARY KEY,
		location VARCHAR(32) NOT NULL);

SELECT * FROM StartupLocation;

DROP TABLE IF EXISTS StartupMarkets;
	CREATE TABLE StartupMarkets 
		(id INT NOT NULL PRIMARY KEY,
		market VARCHAR(32) NOT NULL);

SELECT * FROM StartupMarkets;

DROP TABLE IF EXISTS StartupTypes;
	CREATE TABLE StartupTypes 
		(id INT NOT NULL PRIMARY KEY,
		type VARCHAR(32) NOT NULL);

SELECT * FROM StartupTypes;
        
/*	LOAD DATA INFILE 'AllStartupListings.csv' INTO TABLE StartupListing
	FIELDS TERMINATED BY ',' ENCLOSED BY '$'
	LINES TERMINATED BY '\n'
    (@DATE_STR, `time`, `awayteam_id`, `hometeam_id`);*/