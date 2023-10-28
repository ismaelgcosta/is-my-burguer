# is-my-burguer
Projeto para aplicação de conhecimentos da Fase 1 da Pós-Graduação em SOFTWARE ARCHITECTURE da FIAP

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

