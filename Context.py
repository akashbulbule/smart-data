import nltk
from nltk.tag import pos_tag , map_tag

def contextualization(word):
	category = ['MyChoice','NetNeutrality','ObamaTownHall','TaxDay']
	d = dict( (category[i],{}) for i in range(len(category)))
	d['MyChoice'][1]=['good','nice','massive','better','prime']
	d['MyChoice'][2]=['bad','directionless','blind','empty']
	d['TaxDay'][1]=['free','big','new','more','wonderful','better','best']
	d['TaxDay'][2]=['happy','worst','time-consuming','black','old','middle-class','complicated','hate','late','last']
	d['NetNeutrality'][1]=['free','big','equal','co-exist','important']
	d['NetNeutrality'][2]=['utopian','exclusive-access','long','discriminatory']
	d['ObamaTownHall'][1]=['free','more','deductible','whole','high']
	d['ObamaTownHall'][2]=['expensive','no-brainer','poor','middle-class','low','less']
	for element in d.keys():
		if word in d[element][1]:
			return 1
		if word in d[element][2]:
			return 2
	return -1

def printAdjCounts(inputfileName):
	file_content = open(inputfileName,"r")
	tokens=[]
	for line in file_content.readlines():
		tokens += nltk.word_tokenize(line.lower())
	tokens = filter(lambda a: a!='@' and a!=')' and a!='|',tokens)
	posTagged=nltk.pos_tag(tokens)
	NounTags = [(word, map_tag('en-ptb', 'universal', tag)) for word, tag in posTagged if tag=="JJ" or tag =="JJR" or tag=="JJS"]
	nounCountList=[]
	for noun in NounTags:
		nounCountList += [(tokens.count(noun[0]),noun[0])]
	nounCountList  = sorted(list(set(nounCountList)))[::-1]
	for i in range(5):
		context = contextualization(nounCountList[i][1])
		if context==1 or context==2:
			return "positive" if context==1 else "negative"
