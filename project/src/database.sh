#!/bin/bash

# -----------------------
# Teste do Banco de dados
# -----------------------

#Arquivos do Servidor
javac main/java/ecommerce2/servidor/*.java -d compilados/

# Rodando o TestDatabase
java -cp compilados/ ecommerce2.servidor.TestDatabase
