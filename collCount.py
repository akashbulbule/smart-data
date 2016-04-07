import nltk
from nltk.collocations import *
from nltk.tokenize import RegexpTokenizer
from bs4 import BeautifulSoup

def colCount(inputfileName):
	tokens = []
	stopwords = nltk.corpus.stopwords.words('english')
    path = "C:\Users\Akash\Desktop\
	f = open(path+inputfileName)
	raw = f.read()
	raw = raw.replace(",", "")
	raw = raw.replace(".", "")
	raw = raw.replace("'", "")
	raw = raw.replace("#", "")
	raw = raw.replace("!", "")
	raw = raw.replace(":", "")
	raw = raw.replace("@", "")
	raw = raw.replace("?", "")
	raw = raw.replace("-", "")
	raw = raw.replace("(", "")
	raw = raw.replace(")", "")
	raw = raw.replace("\"", "")


	data_tokens = nltk.wordpunct_tokenize(raw)
	filtered_tokens = [w for w in data_tokens if w.lower() not in stopwords]
	tokens = tokens + filtered_tokens
	
	bigram_measures = nltk.collocations.BigramAssocMeasures()
	finder = BigramCollocationFinder.from_words(tokens)
	finder.apply_freq_filter(2)
	c2 = finder.nbest(bigram_measures.likelihood_ratio, 20)
	outputfile = open(path+colocate.txt,"w")
	outputfile.write(c2)
	print c2

def main():
	colCount(raw_input("Enter the file name:"))