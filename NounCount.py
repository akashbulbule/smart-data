import nltk
from nltk.tag import pos_tag, map_tag

def printNounCounts(inputfileName,outputfileName):
	file_content = open(inputfileName,"r")
	tokens=[]
	for line in file_content.readlines():
		tokens += nltk.word_tokenize(line.lower())
	tokens = filter(lambda a: a!='@' and a!=')',tokens)
	posTagged=nltk.pos_tag(tokens)
	NounTags = [(word, map_tag('en-ptb', 'universal', tag)) for word, tag in posTagged if tag=="NN" or tag =="NNP" or tag=="NNS"]
	nounCountList=[]
	outputFile = open(outputfileName,"w")
	for noun in NounTags:
		nounCountList += [(tokens.count(noun[0]),noun[0])]
	nounCountList  = sorted(list(set(nounCountList)))[::-1]
	for nounindex in range(len(nounCountList)):
		outputFile.write(nounCountList[nounindex][1] + " " + str(nounCountList[nounindex][0]) + "\n")


def main():
	#printNounCounts(raw_input("Enter the input file name(absolute path):"),raw_input("Enter the output File name(absolute path):"))
	printNounCounts("input.txt","output.txt")        

main()
