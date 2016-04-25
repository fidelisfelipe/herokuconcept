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

##criar classe Test com servidor embutido ouvindo requisição - embedded container - The Twelve-Factor App by  Adam Wiggins is Heroku Fundator

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

#escalar app
$heroku ps:scale web=2 

#Mais sobre o Heroku
##heroku addon:list //lista de complementos
$heroku apps:errors //erros da aplicação nas ultimas 24hrs
$heroku apps:info //informações
$heroku config //variáveis de ambiente disponíveis para a aplicação
$heroku releases // exibe todas as manutenções feitas na app.
$heroku releases:rollback v3 //reverte para versão 3 da app

#LogsPlex - feature de logs do heroku para apps distribuídas
$heroku logs -t

#Modo Manutenção Heroku
$heroku maintenance:on
$heroku maintenance:off

##Customizando página de manutenção
$heroku config:set MAINTENANCE_PAGE_URL=https://herokuconcept.herokuapp.com/maintenance.html

#Add Plugin Heroku - Eclipse
##http://eclipse-plugin.herokuapp.com


