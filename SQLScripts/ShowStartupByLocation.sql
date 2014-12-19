/* Display all startups at a given location */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowStartupByLocation $$

CREATE PROCEDURE ShowStartupByLocation(IN locationName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT location FROM StartupLocation WHERE location = locationName)
		THEN 
			SELECT S.id, startupName as StartupName, highConcept as HighConcept, companyUrl as URL, thumbUrl as imgURL
			FROM StartupListing as S, StartupLocation as L
            WHERE S.id = L.id and L.location = locationName;
	ELSE
		SELECT 'No Startups Located.' AS  'Error Message';
	END IF;
END
$$