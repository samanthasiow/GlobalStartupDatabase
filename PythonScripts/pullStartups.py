import os,sys
import urllib
import json
from angellist import AngelList

def main(argv):

	if len(sys.argv) != 3 or not argv[1].isdigit() or not argv[2].isdigit():
		print "Usage is python read.py <start ID> <end ID>"
		exit()

	if ( int(argv[1]) > int(argv[2]) ):
		print "Invalid range"
		exit()

	filename = "Startups_" + argv[1] + "-" + argv[2]
	
	if not os.path.isfile(filename):

		angel = AngelList("6093fd1f428b52cd5e5f039e63b4870ce3b3c5884ff35e32")

	#	angelapi.search({'method':'GET', 'query':'search-string'})

		f = open(filename, 'w')

		# Enter range of IDs here
		for x in range( int(argv[1]), int(argv[2]) ):
			try:
			 	f.write(json.dumps( angel.startups({'method':'GET', 'id':str(x)}) ) )
				f.write('\n')
			except Exception:
				pass	

if __name__ == "__main__":
	main(sys.argv)
