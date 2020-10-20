#!/bin/bash

# -------------------------
# Testando Projeto no Linux
# -------------------------


# ============================
# Compilando todos os Arquivos
# ============================

# Servidor

javac source/servidores/Ecommerce.java -d out/production/t1-projarq/
javac source/servidores/Produto.java -d out/production/t1-projarq/
javac source/servidores/Pedido.java -d out/production/t1-projarq/


# Cliente

javac source/cliente/Cliente.java -d out/production/t1-projarq/
javac source/cliente/Main.java -d out/production/t1-projarq/

# =========================
# Rodando todos os Arquivos
# =========================

# Servidor

# java -cp out/production/t1-projarq/ source.servidores.Ecommerce
# java -cp out/production/t1-projarq/ source.servidores.Produto
# java -cp out/production/t1-projarq/ source.servidores.Ecommerce

# # Cliente

# java -cp out/production/t1-projarq/ source.cliente.Cliente
java -cp out/production/t1-projarq/ source.cliente.Main