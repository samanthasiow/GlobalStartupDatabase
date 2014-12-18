DELIMITER $$

DROP PROCEDURE IF EXISTS AllStartupListings $$

CREATE PROCEDURE AllStartupListings()
BEGIN
	SELECT id, startupName as StartupName, highConcept as HighConcept, companyUrl as URL, thumbUrl as imgURL
    FROM StartupListing;
END
$$