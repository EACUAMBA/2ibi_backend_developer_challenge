# Projecto Backend Developer Challenge - January 2022

## Como executar?
### Instale o PostgreSQL
Para este projecto usei o SGBD PostgreSQL por isso deves instalar o postgres na tua máquina, para fazer isso podes [clicar aqui e ir ao site de downloads do postgreSQL e baixar a última versão disponível](https://www.postgresql.org/download/).
Após fazer o download, podes instalar durante a instalação deves colocar  a porta como `5432` e o password como `postgres`.

### Execute o script para criar o banco
Com o postgres instalado abra a plataforma pgAdmin para executar alguns comandos de criação do banco.
Execute esta query para criar o banco de dados: `create database backend_developer_challenge_january_2022 with owner postgres;`

### Abra o projecto na sua IDEA
Após fazer os procedimentos acima abra o projecto na sua IDEA de preferência e faço um maven install ou mvn install para baixar as dependencias, _a sua IDEA deve ter suporte para o maven_, após isso é só executar como executa qualquer aplicação spring BOOT.

### EndPoints
Nesta aplicação temos duas collections de APIs, uma sem segurança e outra usando JWT.
Deixo aqui a lista das APIs:

- APIs sem JWT:
- - GET `http://localhost:8080/pais?dir=asc&sortBy=regiao.nome` - lista todos os paises registrados e permite a orgenação e páginacao usando parametros `page=Integer, pageSize=Integer, sortBy=propriedadeUsadaParaOrdenacao, dir=direcaoDaOrdenacao`;
 
- - GET `http://localhost:8080/pais/2` - retorna o país com o id passado na url.
    
- - PUT `http://localhost:8080/pais/2` -actualiza um registro de pais com os dados novos passados, nota que no payload não precisa incluir o ID vistro que ao chamar o recurso pais/2 já dissemos quem queremos editar, o payload:
    <pre>
    {
    "capital": "Capital 4",
    "regiaoNome": "Regiao Teste 4",
    "subRegiaoNome": "Subregiao Teste 4",
    "area": 500000.0
    }
    </pre>


- - POST `http://localhost:8080/pais` - cria um registro de pais, nota que o payload deve estar assim:
    <pre>
    {
    "capital": "Capital 4",
    "regiaoNome": "Regiao Teste 4",
    "subRegiaoNome": "Subregiao Teste 4",
    "area": 500000.0
    }
    </pre>
    
    
- APIs com JWT:
  
- - Para usar estas APIs primeiro deve se autenticar e gerar um token, para autenticação temos eestes usuarios:
    <pre>
        {
            "username":"eacuamba",
            "password": "12345"
        }
    ou
        {
            "username":"luis",
            "password": "12345"
        }
    ou
        {
            "username":"carlos",
            "password": "12345"
        }
    
    todos tem a ROLE_ADMIN
    </pre>
    
    Para se autenticar use envie uma requisição para `http://localhost:8080/login` e no payload coloque o JSON do utilizador que preferir.
    
    Ao se autenticar o servidor vai gerar umm token que estará no HEADER da resposta é so copiar o valor dessa chave `Authorization`, algo como `Bearer eyJhbGciOiJIUzM4NCJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiQURNSU46VVBEQVRFIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn0seyJhdXRob3JpdHkiOiJBRE1JTjpXUklURSJ9LHsiYXV0aG9yaXR5IjoiQURNSU46UkVBRCJ9LHsiYXV0aG9yaXR5IjoiQURNSU46REVMRVRFIn1dLCJpYXQiOjE2NDMyMDE5MDEsImV4cCI6MTY0NDQ0NDAwMH0.R5OIa3uQXuEenNfgBdHMTjZZ0-ydPYrQQ0x3bfhypiC4r_2vdbvFw43Pyxe_Htm2` e colocar nas suas posteriores requisiçõesdo mesmo jeito, no HEADER.
    
    

- - GET `http://localhost:8080/jwt/pais?dir=asc&sortBy=regiao.nome` - lista todos os paises registrados e permite a orgenação e páginacao usando parametros `page=Integer, pageSize=Integer, sortBy=propriedadeUsadaParaOrdenacao, dir=direcaoDaOrdenacao`;

- - GET `http://localhost:8080/jwt/pais/2` - retorna o país com o id passado na url.

- - PUT `http://localhost:8080/jwt/pais/2` -actualiza um registro de pais com os dados novos passados, nota que no payload não precisa incluir o ID vistro que ao chamar o recurso pais/2 já dissemos quem queremos editar, o payload:
    <pre>
    {
    "capital": "Capital 4",
    "regiaoNome": "Regiao Teste 4",
    "subRegiaoNome": "Subregiao Teste 4",
    "area": 500000.0
    }
    </pre>


- - POST `http://localhost:8080/jwt/pais` - cria um registro de pais, nota que o payload deve estar assim:
    <pre>
    {
    "capital": "Capital 4",
    "regiaoNome": "Regiao Teste 4",
    "subRegiaoNome": "Subregiao Teste 4",
    "area": 500000.0
    }
    </pre>