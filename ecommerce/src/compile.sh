#!/bin/bash

# ----------------------
# COMPILE ALL JAVA FILES
# ----------------------

# Servidor
javac main/java/projarq/servidor/*.java -d classes/

# Cliente
javac main/java/projarq/cliente/*.java -d classes/
