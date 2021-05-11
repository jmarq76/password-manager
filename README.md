# Digital Innovation: API para Gerenciamento de Senhas e Logins



Foi desenvolvida uma API para gerenciamento de Senhas e Logins com a implementação de um gerador aletório de senhas, baseado no projeto: Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot , da [Digital Innovation One] (https://digitalinnovation.one/).

Foram implementados os métodos http GET, POST, PUT e DELETE.



Para gerar a aleatóriamente uma senha é necessário ir no caminho /api/v1/login/generate-password e informar os seguintes paramêtros através de JSON:

specialChar - Boolean - Para obter caracteres especiais na composição da senha; 

numChar - Boolean - Para obter números na composição da senha;

alphabeticChar - Boolean - Para obter caracteres alfabéticos na composição da senha;

passLength - int - Qual o tamanho da senha pretendida.



Neste projeto foram usadas as seguintes dependêcias Spring:

* Spring Data JPA

* Spring Web

* Lombok

* Validation

* H2 DataBase



Outras dependências usadas:

* [MapStruct](https://mapstruct.org/)

