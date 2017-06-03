all:
	make dev
	make clean

dev:
	javac JOING.java
	jar cvfe JOING.jar JOING *

clean:
	rm JOING.class || continue

clean-all:
	make clean
	rm JOING.jar || continue
