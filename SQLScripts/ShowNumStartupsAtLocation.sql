/* Display the number of startups per location */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowNumStartupsAtLocation $$

CREATE PROCEDURE ShowNumStartupsAtLocation(IN locationName VARCHAR(255))
BEGIN
	SELECT L.location, count(L.location) as NumStartups
	FROM StartupLocation as L, StartupListing as S
	WHERE L.id = S.id and L.location = locationName;
END;
$$