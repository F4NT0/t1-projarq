# t1-projarq

 ------------------------------------------------------------------------------------------------------
  Visão           Público                    Área                                        Modelo da MDS
  --------------- -------------------------- ------------------------------------------- ---------------
  Lógica          Analistas                  Realização dos Casos de Uso                 

  Processo        Integradores               Performance, Escalabilidade, Concorrência   

  Implementação   Programadores              Componentes de Software                     

  Implantação     Gerência de Configuração   Nodos físicos                               

  Caso de Uso     Todos                      Requisitos funcionais                       

  Dados           Especialistas em dados     Persistência de dados                       
                                                                                         
                  
  ------------------------------------------------------------------------------------------------------

Tabela 1 – Visões, Público, Área e Artefatos da MDS

<span id="_Toc417554321" class="anchor"><span id="_Toc452479031" class="anchor"></span></span>REQUISITOS E RESTRIÇÕES ARQUITETURAIS
===================================================================================================================================

Esta seção descrever os requisitos de software e restrições que tem um
impacto significante na arquitetura.

  Requisito                    Solução
  ---------------------------- ----------------------------------------------------------------------------------------------------
  Linguagem                    \[Especificar a(s) linguagem(ns) utilizada(s) no desenvolvimento.\]
  Plataforma                   \[Especificar o servidor de aplicações utilizado.\]
  Segurança                    \[Especificar a necessidade de segurança e as características básicas da segurança.\]
  Persistência                 \[Especificar a necessidade de persistência e qual o mecanismo de persistência que será adotado.\]
  Internacionalização (i18n)   \[Especificar a necessidade de internacionalização/localização na aplicação.\]

<span id="_Toc362861802" class="anchor"><span id="Bookmark3"
class="anchor"></span></span>Tabela 2 – Exemplo de requisitos e
restrições

<span id="_Toc362861804" class="anchor"><span id="_Toc417554322" class="anchor"><span id="_Toc452479032" class="anchor"></span></span></span>VISÃO DE CASOS DE USO
==================================================================================================================================================================

Esta seção lista as especificações centrais e significantes para a
arquitetura do sistema.

Lista de casos de uso do sistema:

-   **Caso de Uso \[00X\]**

-   **Caso de Uso \[00X\]**

Casos de Uso significantes para a arquitetura
---------------------------------------------

\[Exemplo:

<span id="_Toc344453552" class="anchor"><span id="Bookmark7"
class="anchor"><span id="_Toc366050258"
class="anchor"></span></span></span>![](media/image2.png){width="5.905555555555556in"
height="4.763888888888889in"}

Figura 2 – Exemplo de Diagrama com os casos de uso significativos e
atores

<span id="_Toc417554324" class="anchor"><span id="_Toc452479034" class="anchor"></span></span>VISÃO LÓGICA
==========================================================================================================

Descrever uma visão lógica da arquitetura. Descrever as classes mais
importantes, sua organização em pacotes de serviços e subsistemas, e a
organização desses subsistemas em camadas. Também descreve as
realizações dos casos de uso mais importantes, por exemplo, aspectos
dinâmicos da arquitetura. Diagramas de classes e sequência devem ser
incluídos para ilustrar os relacionamentos entre as classes
significativas na arquitetura, subsistemas, pacotes e camadas.

Visão Geral – pacotes e camadas
-------------------------------

\[Exemplo:

![](media/image3.emf){width="5.905555555555556in"
height="3.047222222222222in"}

Figura 2 – Exemplo de Diagrama de Camadas da Aplicação

![](media/image4.png){width="5.905555555555556in" height="5.9625in"}

Figura 3 – Exemplo de Diagrama de Pacotes da Aplicação

<span id="_Toc362861810" class="anchor"><span id="_Toc417554326" class="anchor"><span id="_Toc452479036" class="anchor"></span></span></span>VISÃO DE IMPLEMENTAÇÃO
===================================================================================================================================================================

Caso de Uso \[00X\]
-------------------

### Diagrama de Classes

\[Exemplo:

![](media/image5.png){width="5.905555555555556in"
height="4.0569444444444445in"}

Figura 20 – Exemplo de Diagrama de Classes

### Diagrama de Sequência

![](media/image6.png){width="5.896527777777778in"
height="3.122916666666667in"}

Figura 20 – Exemplo de Diagrama de Sequência

<span id="_Toc417554327" class="anchor"><span id="_Toc452479040" class="anchor"></span></span>VISÃO DE IMPLANTAÇÃO
==================================================================================================================

<span id="_Toc362861812" class="anchor"></span>Descrever os nodos
físicos, as configurações e os artefatos que serão implantados.

\[Exemplo:

![](media/image7.png){width="5.896527777777778in"
height="3.3965277777777776in"}

Figura 20 – Exemplo de Diagrama de Implantação Java

<span id="_Toc417554328" class="anchor"><span id="_Toc452479041" class="anchor"></span></span>DIMENSIONAMENTO E PERFORMANCE
===========================================================================================================================

Volume
------

Enumerar os itens relativos ao volume de acesso aos recursos da
aplicação:

-   Número de estimado usuários: \[000\]

-   Número estimado de acessos diários: \[000\]

-   Número estimado de acessos por período: \[000\]

-   Tempo de sessão de um usuário: \[000\]

Performance
-----------

Enumerar os itens referentes à resposta esperada do sistema:

-   Tempo máximo para a execução de determinada transação: \[000\]

<span id="_Toc417554329" class="anchor"><span id="_Toc452479044" class="anchor"></span></span>QUALIDADE
=======================================================================================================

Enumerar os itens de qualidade de software \[QOS\] significativos para a
aplicação:

  Item                              Descrição             Solução
  --------------------------------- --------------------- --------------------------------
  Escalabilidade                    \[Breve Descrição\]   \[Breve descrição da Solução\]
  Confiabilidade, Disponibilidade   \[Breve Descrição\]   \[Breve descrição da Solução\]
  Portabilidade                     \[Breve Descrição\]   \[Breve descrição da Solução\]
  Segurança                         \[Breve Descrição\]   \[Breve descrição da Solução\]
