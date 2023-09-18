all: JOING.jar

JOING.jar: JOING.java
	javac $<
	jar cvfe $@ JOING JOING.class comptext.txt
	rm -f JOING.class

clean:
	rm -f JOING.jar
