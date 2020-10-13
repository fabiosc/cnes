# CNES V-0.0.1-SNAPSHOT

### Documentação de referência
* Não foi possível utilizar o arquivo JSON pois o mesmo não estava disponívelpara download, por isso a utilização do arquivo csv.

* A aplicação depende de um arquivo csv contendo os CNES ativos. O caminho do arquivo está descrito no application.properties da aplicação. Para efeito de simplicidade na subida da aplicação, o arquivo está disponibilizado dentro da própria aplicação;

* As dependências de bibliotecas estão descritas no arquivo pom.xml

* Os testes unitários foram realizados e a cobertura ficou por volta de 95%, ver evidência abaixo
![Cobertura de Testes](https://github.com/fabiosc/cnes/blob/master/src/main/resources/imagens/cobertura.PNG)

* A UI Swagger está disponível em tempo de execução na URL http://localhost:8080/swagger-ui.html
![UI Swagger](https://github.com/fabiosc/cnes/blob/master/src/main/resources/imagens/listarCnesUsingGET.PNG)
![UI Swagger](https://github.com/fabiosc/cnes/blob/master/src/main/resources/imagens/listarCnesTipoEstabelecimentoGET.PNG)
![UI Swagger](https://github.com/fabiosc/cnes/blob/master/src/main/resources/imagens/listarCnesPorEstadoUsingGet.PNG)
