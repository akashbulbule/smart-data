from reduction import *
import sys

def printParaSummary(fileName):
	reduction = Reduction()
	text = open(fileName).read()
	reduction_ratio = float(sys.argv[2])
	reduction_ratio=reduction_ratio/100
	print reduction_ratio
	reduced_text = reduction.reduce(text, reduction_ratio)
	return reduced_text

def main():
	reduced_text = printParaSummary(sys.argv[1])
        print reduced_text

main()
