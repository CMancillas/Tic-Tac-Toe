# Variables
SRC_DIR=src
BIN_DIR=bin
SRC_FILES=$(wildcard $(SRC_DIR)/*.java)
MAIN_CLASS=PruebaJuego

# Compilar todos los .java en bin/
all: $(BIN_DIR)/$(MAIN_CLASS).class

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SRC_FILES)

# Ejecutar el programa principal
run: all
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Limpiar archivos compilados
clean:
	rm -rf $(BIN_DIR)/*.class