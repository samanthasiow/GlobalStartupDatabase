DELIMITER $$

DROP PROCEDURE IF EXISTS ShowStartupIDByName $$

CREATE PROCEDURE ShowStartupIDByName(IN startupName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.startupName = startupName)
		THEN 
			SELECT id as id
			FROM StartupListing as S
			WHERE S.startupName = startupName;
	ELSE
		SELECT 'No startups found for that ID.' AS  'Error Message';
	END IF;
END
$$