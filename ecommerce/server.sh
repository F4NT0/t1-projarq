#!/bin/bash

# ----------------------
# Compile and Run Server
# ----------------------

javac source/servidores/Server.java -d out/production/t1-projarq/
java -cp out/production/t1-projarq/ source.servidores.Server

