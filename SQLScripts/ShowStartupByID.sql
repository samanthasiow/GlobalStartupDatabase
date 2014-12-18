DELIMITER $$

DROP PROCEDURE IF EXISTS ShowStartupByID $$

CREATE PROCEDURE ShowStartupByID(IN startupID INT)
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.id = startupID)
		THEN 
			SELECT startupName as Name
			FROM StartupListing as S
			WHERE S.id = startupID;
	ELSE
		SELECT 'No people found for that startup.' AS  'Error Message';
	END IF;
END
$$