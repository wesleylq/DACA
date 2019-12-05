# DACA
Projeto DACA 2019.2

*Aluno: Wesley lucena Queiroz - 117110918*

## Projeto para a disciplina de Desenvolvimento de Aplicações para Corporações Avançadas.
## Sistema WEB + APP usando o Flutter (futuro...!), com Backend em Spring Boot. 

### Resumo do Projeto
Projeto consiste num sistema de controle para uma loja de aluguel de roupas e acessórios, além de um e-commerce no aplicativo e web. No entanto, a parte inicial deste projeto foca na criação de um backend.

### Arquitetura e design do projeto
 
Há três entidades simples: Cliente, Vestido e Aluguel(empréstimo), sendo aluguel composta pelas outras.

![Image](https://i.ibb.co/p0Xp58S/Loz-Diagram.png)

A arquitetura no backend, utiliza-se de uma API RESTFul com SpringBoot, composta por três camadas lógicas: Controller, Service e Repository.

### Segurança
#### Autenticação
A autenticação do usuário é  default inicialemente feita pela rota: POST "/login". 
Deve-se enviar um Json no formato:  
{ "username": "seuUsername",  
  "password": "suaSenha" }


#### Autorizaçâo
Existem no sitema dois tipos de usuarios, ADMIN e USER. Para prósitos da disciplina apenas a rotasde criacao e remoção de usuários POST e DELETE "/clients/{id}" que tem o privilégio do ADMIN. GET "/clients" ambos tipos de usuários tem acesso.

### Desempenho
Para avaliação de desempenho do sistema, foi utilizado o JMeter. O JMeter é uma ferramenta que testa requisições HTTP forcando uma carga de interações e de usuários. Ela retorna uma avaliação completa e resultado mostrando como o aplicação lidou com o estresse imposto pelos testes.

Para efeitos de comparação, foi testado a aplicaçao com e sem Cache na rota GET "/clients".
Foram configuradas 1000 threads com infinitas interaçôes por tempo determinado.  
  
Como será visto a seguir é notória que a diferença do tempo de respota é menor utilizando-se de Cache.  

##### Sem Cache

Nº de Requisiçôes HTTP: 74418  
Tempo Médio de resposta : 400ms  
Vazão: 2434.747/ms  

![Image](https://i.ibb.co/qs2LnPx/lines.png)  
![Image](https://i.ibb.co/25BCZTF/graph.png) 

##### Com Cache

Nº de Requisiçôes HTTP: 138107  
Tempo Médio de resposta : 214ms  
Vazão: 4548.080/s  


![Image](https://i.ibb.co/QP3ZS9c/cached-Lines.png)  
![Image](https://i.ibb.co/ZBMKTP4/cachedgraph.png)
 



### Instalação
1. Faça o download do zip ou clone o repositório Git.
2. Descompacte o arquivo zip (se você tiver baixado um)
3. Abra o terminal e vá até o projeto, e entre na pasta onde está o pom.xml.
4. Execulte o seguinte comando:
   ``` mvn spring-boot:run```
