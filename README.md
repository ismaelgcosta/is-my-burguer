# Is My Burguer

Projeto para aplicação de conhecimentos da Fase 1 da Pós-Graduação em SOFTWARE ARCHITECTURE da FIAP

# Arquitetura do Projeto


Para modelagem da arquitetura do sistema foi utilizado o padrão de Ports and Adapters ou mais conhecido como Arquitetura Hexagonal. 

Isso garante a manutenabilidade e testabilidade do sistema.


Abaixo temos o desenho conceitual dessa arquitetura:


![Hexagonal.jpg](docs%2Fimages%2FHexagonal.jpg)


# Organização dos Módulos:


Para forçar que as camadas fossem respeitadas pelos desenvolvedores foram criados módulos para separação do código. 

Essa separação será feita utilizando o framework de build de código [Maven](https://maven.apache.org/).


Cada módulo representará um ou parte de um dos Contextos Delimitados encontrados na modelagem do domínio.


A separação dos módulos ficou da seguinte forma:


![Modulos.png](docs%2Fimages%2FModulos.png)


(o sistema possui vários módulos, aqui estamos demonstrando apenas o contexto de cadastro de cliente)


Conforme comentado na imagem acima as portas oferecem apenas as interfaces tanto pra entrada quanto para saída dos dados. 

Isso garante que todas as partes conheçam apenas o próprio domínio ou os domínios de outros módulos mas sem conseguirem chamar as implementações diretamente.


# Requisitos necessários para compilar o projeto


Ter o docker instalado na sua máquina:


* [Windows](https://docs.docker.com/windows/started)

* [OS X](https://docs.docker.com/mac/started/)

* [Linux](https://docs.docker.com/linux/started/)


# Como fazer o build do projeto e da imagem


Na pasta raiz do projeto rodar o comando abaixo:


```

./mvnw install -U "&" docker compose up --build

```


Existem duas formas de acessar a documentação das APIs da aplicação:


# Swagger

http://localhost:8080/swagger-ui/index.html


# ReDoc

http://localhost:8080


