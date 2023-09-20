#!/bin/bash

# Caminho para o arquivo .jar do seu aplicativo
JAR_FILE="/usr/share/OZimbresCalculadoras.jar"

# Verifica se o arquivo .jar existe
if [ -f "$JAR_FILE" ]; then
    java -jar "$JAR_FILE"
else
    echo "Arquivo .jar não encontrado: $JAR_FILE"
    exit 1
fi
