from nltk.corpus import wordnet as wn
import sys

def synlist(inputfileName,outputfileName):
	file_content = open(inputfileName,"r")
	tokens=[]
	stopwords = nltk.corpus.stopwords.words('english')

	raw = file_content.read()
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
	outputfile = open(outputfileName,"w")
	for string in tokens:
		syn_sets = wn.synsets(string)
		if syn_sets==[]:
			continue
		outputfile.write("********Synonyms for word:"+string+"**********\n\n")
		
		for syn_set in syn_sets:
			outputfile.write(str(syn_set) +" "+str(syn_set.lemma_names())+"\n")

def main():
	synlist(raw_input("Enter the file name:"),raw_input("Enter the output file name:"))
	

main()