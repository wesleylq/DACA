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


### Instalação
1. Faça o download do zip ou clone o repositório Git.
2. Descompacte o arquivo zip (se você tiver baixado um)
3. Abra o terminal e vá até o projeto, e entre na pasta onde está o pom.xml.
4. Execulte o seguinte comando:
   ``` mvn spring-boot:run```