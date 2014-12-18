import sys, os
import json
import urllib2
from angellist import AngelList

def main(argv):


	if len(sys.argv) != 3 or not argv[1].isdigit() or not argv[2].isdigit():
		print "Usage is python pullStartupRoles.py <start ID> <end ID>"
		exit()

	startID = int(argv[1])
	endID = int(argv[2])

	if ( startID >= endID ):
		print "Invalid Range"

	try:
		roles = open( "roles", 'r')

	except IOError:
		"File does not exist"

	filename = "Roles_" + argv[1] + "-" + argv[2]
	
	if not os.path.isfile(filename):

		angel = AngelList("6093fd1f428b52cd5e5f039e63b4870ce3b3c5884ff35e32")
		ANGELLIST_ROLES_URL = "https://api.angel.co/1/startup_roles?startup_id="
		
		f = open(filename, 'w')

		# Enter range of IDs here

		for startupID in roles:
			try:
				if ( int(startupID) >= startID and int(startupID) <= endID ):
					result = json.dumps(json.loads(urllib2.urlopen(ANGELLIST_ROLES_URL + startupID).read())) 
					f.write( '{"startupID":' + startupID.rstrip('\n') + ', ' + result[1:])
					f.write('\n')
			except Exception:
				pass	


if __name__ == "__main__":
	main(sys.argv)
