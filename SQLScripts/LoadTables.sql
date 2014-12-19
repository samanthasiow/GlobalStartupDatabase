DROP TABLE IF EXISTS StartupListing;			# Startup data
	CREATE TABLE StartupListing 
		(id INT NOT NULL PRIMARY KEY,			# id = 123
		startupName VARCHAR(32) NOT NULL,		# startupName = 'AngelList'
		quality int NOT NULL,					# quality = 10, based on AngelList rankings
		highConcept VARCHAR(140),				# highConcept = 'A platform for startups'
		companyUrl VARCHAR(140),				# companyUrl = 'http://angel.co'
		companySize VARCHAR(12),				# companySize = '1-10'
        thumbUrl VARCHAR(200));					# thumbUrl = 'http://....jpg' thumbnail image
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupListings.csv' INTO TABLE StartupListing
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupListing;

DROP TABLE IF EXISTS StartupLocation;			# Location data for each startup
	CREATE TABLE StartupLocation 
		(id INT NOT NULL,						# id for the startup, e.g. 123
		location VARCHAR(32) NOT NULL,			# location of an office of the startup, e.g. San Francisco
        FOREIGN KEY (id) REFERENCES StartupListing(id));
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupLocations.csv' INTO TABLE StartupLocation
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupLocation;

DROP TABLE IF EXISTS StartupMarkets;			# Markets for the startup's products
	CREATE TABLE StartupMarkets 
		(id INT NOT NULL,						# id for the startup, e.g. 123
		market VARCHAR(32) NOT NULL,			# market for the startup's product, e.g. mobile
        FOREIGN KEY (id) REFERENCES StartupListing(id)); 	# links to the startup listing

LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupMarkets.csv' INTO TABLE StartupMarkets
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupMarkets;

DROP TABLE IF EXISTS StartupTypes; 					# Type of startup = vc, incubator, closed, acquired
	CREATE TABLE StartupTypes 
		(id INT NOT NULL PRIMARY KEY,				# id = 123
		type VARCHAR(32) NOT NULL,					# type = acquired
        FOREIGN KEY (id) REFERENCES StartupListing(id));
        
LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllStartupTypes.csv' INTO TABLE StartupTypes
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupTypes;

DROP TABLE IF EXISTS StartupRoles;					# People and their roles in startups
	CREATE TABLE StartupRoles 
		(id INT NOT NULL PRIMARY KEY,				# id of the user, e.g. 345
		name VARCHAR(32) NOT NULL,					# name of the person, e.g. John Smith
		roleID INT NOT NULL,						# the id of their role
        role VARCHAR(32) NOT NULL,					# their role in the startup, e.g. founder, past_investor
        startupID INT NOT NULL,						# id of the startup that they are related to, e.g. 123
        FOREIGN KEY (id) REFERENCES StartupListing(id));

LOAD DATA LOCAL INFILE '/Users/samanthasiow/Documents/Fall 2014/Databases/FinalProject/SQLScripts/AllUserRoles.csv' INTO TABLE StartupRoles
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n';

SELECT * FROM StartupRoles;