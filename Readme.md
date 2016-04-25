#Init Project

##criar repositório do projeto
criado repositório no github com nome: herokuconcept

##vincule-se ao repositório
clone este repositório para seu ambiente local

##crie a app no heroku
$heroku apps:create herokuconcept

##veja a aplicação
$heroku open

##configure triger de commits no github
Heroku>DashBoard>Deploy>GitHub>Search you repo>connect
Enable Automatc Deploys

#adicionar natureza java/mvn

##criar diretório parão maven
$mkdir -p src/main/java/

##criar classe Test com servidor embutido ouvindo requisição

##criar pom.xml na raiz do projeto

##buil com mvn

##set variavel de ambiente para executar a aplicação em alguma porta
$SET PORT=8000
confirme o valor configurado com:
$echo %PORT%

##execute a aplicação

java -cp target\classes;"target\dependency\*" HelloWorld

#crie arquivo Procfile na raiz do projetocom seguinte conteúdo
web: java -cp target/classes:target/dependency/* HelloWorld

