# takes command line arguments
# arg 1 = input file; arg 2 = output file

import fileinput
import sys

fout = open(str(sys.argv[1]), "r")
fwrite = open(str(sys.argv[2]), "w")

for i in fout:

    fwrite.write(i.replace("'","\""))

fwrite.close()
fout.close()
    

