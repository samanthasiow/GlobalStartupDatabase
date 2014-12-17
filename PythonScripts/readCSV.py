import os, sys

def main(argv):

	if ( len(argv) != 0 ):
		print "Need to include a path to csv file"

	filename = argv[1]
    
	try:
		import csv 
		with open(filename, 'rb') as csvfile:
			reader = csv.reader(csvfile, delimiter = ',', quotechar = '|')
	
			for row in reader:
				print row[0].replace("$", "")

	except IOError:
		print "File does not exist"
		
	exit()

if __name__ == "__main__":
	main(sys.argv)
