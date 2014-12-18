DELIMITER $$

DROP PROCEDURE IF EXISTS ShowPersonsByStartup $$

CREATE PROCEDURE ShowPersonsByStartup(IN startupID VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.id = startupID)
		THEN 
			SELECT name as Name, role as Role, startupName as StartupName
			FROM StartupListing as S, StartupRoles as R
			WHERE R.startupID = S.id and S.id = startupID;
	ELSE
		SELECT 'No people found for that startup.' AS  'Error Message';
	END IF;
END
$$