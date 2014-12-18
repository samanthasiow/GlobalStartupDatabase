DELIMITER $$

DROP PROCEDURE IF EXISTS AllStartupListings $$

CREATE PROCEDURE AllStartupListings()
BEGIN
	SELECT startupName as StartupName, highConcept as HighConcept, companyUrl as URL
    FROM StartupListing;
END
$$