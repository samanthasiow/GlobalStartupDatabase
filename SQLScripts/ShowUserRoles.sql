DELIMITER $$

DROP PROCEDURE IF EXISTS ShowPersonRoles $$

CREATE PROCEDURE ShowPersonRoles(IN personName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupRoles WHERE personName = name)
		THEN 
			SELECT name as Name, role as Role, startupName as StartupName
			FROM StartupListing as S, StartupRoles as R
			WHERE R.startupID = S.id and R.name = personName;
	ELSE
		SELECT 'No Startups found in that Market.' AS  'Error Message';
	END IF;
END
$$