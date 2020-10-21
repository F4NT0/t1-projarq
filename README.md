
# Gerenciador de E-commerce Cliente-Servidor

---

### Estrutura do Projeto

```text
ecommerce/
    | ⮕ src/
    |     | ⮕ main/
    |            | ⮕ java/
    |                   | ⮕ projarq/
    |                           | ⮕ cliente/
    |                           |       | ⮕ Client.java
    |                           |       | ⮕ Cliente.java
    |                           |       | ⮕ Main.java
    |                           |
    |                           | ⮕ servidor/
    |                           |       | ⮕ Database.java
    |                           |       | ⮕ database.json
    |                           |       | ⮕ Ecommerce.java
    |                           |       | ⮕ Pedido.java
    |                           |       | ⮕ Produto.java
    |                           |       | ⮕ Server.java
    |                           |
    |                           | ⮕ compile.sh
    |
    | ⮕ target/   
    | ⮕ client.sh
    | ⮕ pom.xml
    | ⮕ server.sh
```

**Arquivos Importantes**

* Unicode arrow: `2b95`
* Unicode check: `2705`
* Unicode x: `274C`

Nome do Arquivo|Para que serve|Linguagem|Status|Atualizado
|---|---|---|---|---|
**server.sh**|Serve para iniciar o Servidor(Linux)|Shell Script|✅|21/10
**pom.xml**|Arquivo de informações do Maven|XML|✅|21/10
**client.sh**|Serve para iniciar um Cliente(Linux)|Shell Script|✅|21/10
**src/compile.sh**|Arquivo para compilar todos os Arquivos .java|Shell Script|✅|21/10
**servidor/Produto.java**|Classe dos Objetos Produto|Java|✅|21/10
**servidor/Pedido.java**|Classe dos Objetos Pedido|Java|✅|21/10
**servidor/Ecommerce.java**|Classe dos Objetos Ecommerce|Java|✅|21/10
**servidor/Database.java**|Classe de Acesso ao JSON dos E-commerces cadastrados|Java|❌|21/10
**servidor/database.json**|Banco de Dados simples com informações dos E-commerces cadastrados|JSON|✅|21/10
**servidor/Server.java**|Servidor do Gerenciador de E-commerces|Java|✅|21/10
**cliente/Cliente.java**|Classe dos Objetos Cliente|Java|✅|21/10
**cliente/Client.java**|Criador de Clientes para acessarem o Servidor|Java|✅|21/10
**cliente/Main.java**|Iniciador dos Processos definidos(_DISABLED_)|Java|❌|21/10

