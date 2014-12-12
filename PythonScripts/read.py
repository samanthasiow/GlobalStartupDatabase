import os,sys
import urllib
from angellist import AngelList

def main():
	angel = AngelList("6093fd1f428b52cd5e5f039e63b4870ce3b3c5884ff35e32")

#	angel = AngelList("6093fd1f428b52cd5e5f039e63b4870ce3b3c5884ff35e49")
#	angelapi.search({'method':'GET', 'query':'search-string'})

	# Enter range of IDs here
	for x in range(1001, 2000):
		try:
		 	print angel.startups({'method':'GET', 'id':str(x)})
		except Exception:
			pass
	


if __name__ == "__main__":
	main()
