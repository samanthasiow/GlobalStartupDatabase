DELIMITER $$

DROP PROCEDURE IF EXISTS ShowPersonsByStartup $$

CREATE PROCEDURE ShowPersonsByStartup(IN startupName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.startupName = startupName)
		THEN 
			SELECT name as Name, role as Role, startupName as StartupName
			FROM StartupListing as S, StartupRoles as R
			WHERE R.startupID = S.id and S.startupName = startupName;
	ELSE
		SELECT 'No Startups found in that Market.' AS  'Error Message';
	END IF;
END
$$