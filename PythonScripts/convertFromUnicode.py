import fileinput

def main():

	fout = open("filename")

	for i in fout:

		print  i.replace("u\"","\"").replace("u\'","\'")
	
if __name__ == "__main__":
	main()


