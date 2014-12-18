DELIMITER $$

DROP PROCEDURE IF EXISTS ShowStartupByID $$

CREATE PROCEDURE ShowStartupByID(IN startupName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.id = startupID)
		THEN 
			SELECT startupName as Name
			FROM StartupListing as S
			WHERE S.name = startupName;
	ELSE
		SELECT 'No startups found for that ID.' AS  'Error Message';
	END IF;
END
$$