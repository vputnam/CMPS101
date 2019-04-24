# Makefile for CMPS 101 BestSuffEver
#------------------------------------------------------------------------------

JAVAC      = javac
MAINCLASS  = TestDrivers
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile INPUT Ouput.txt GROUP
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS)


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)



