all:
	make dev
	make clean

dev:
	javac JOING.java
	jar cvfe JOING.jar JOING *

nojar:
	javac JOING.java

clean:
	rm JOING.class || continue

clean-all:
	make clean
	rm JOING.jar || continue
