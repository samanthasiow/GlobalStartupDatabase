DELIMITER $$

DROP PROCEDURE IF EXISTS GetStartupInfoByID $$

CREATE PROCEDURE GetStartupInfoByID(IN startupID INT)
BEGIN
	SELECT id, startupName as StartupName, highConcept as HighConcept, companyUrl as URL, thumbUrl as imgURL
    FROM StartupListing
    WHERE id = startupID;
END
$$