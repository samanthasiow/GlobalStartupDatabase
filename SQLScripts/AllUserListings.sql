DELIMITER $$

DROP PROCEDURE IF EXISTS AllUserListings $$

CREATE PROCEDURE AllUserListings()
BEGIN
	SELECT name as Name, role as Role, startupName as StartupName
    FROM StartupListing as S, StartupRoles as R
    WHERE R.startupID = S.id;
END
$$