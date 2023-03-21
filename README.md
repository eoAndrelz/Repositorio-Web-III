### Fatec ZL - Centro Paula Souza 
##### Disciplina - Programação Web III 
Grupo X 
- André Luiz Da Silva Santos
- Guilherme 
- Gustavo 
- Pedro Pessina
- Vicenzzo Toth
##### Processo de Desenvolvimento de Software - PDS
> O PDS segue uma abordagem interativa incremental adaptada do Scrum. Cada interação tem uma definição de pronto estabelecida com objetivo de controlar a qualidade. 
##### Estudo de Caso – Sistema de Gerenciamento de Adoção. 
>Durante a evolução de uma organização, o aumento na dificuldade de manter um bom controle das informações necessárias para o funcionamento da empresa cresce exponencialmente, levando a maiores probabilidades de erros, desorganização em diversas áreas e possíveis percas de documentos físicos importantes.
Com o objetivo de diminuir estes problemas e obter maior eficiência energética, produtividade e diminuição de erros durante as tarefas diárias de gerenciamento e controle de dados, o projeto consiste em oferecer funcionalidades que irão permitir um fácil acesso aos dados gerais, desde questões internas - como controle de funcionários - a atividades que envolvem os clientes externos - como relatórios de adoções (já que a plataforma prestará suporte a organização de adoções e ajuda a animais).
##### Product Backlog 
- RU01 - Adoção - Registra e acompanha os processos adotivos na organização, prevê a entrega programada de pedidos de adoção 
- RU02 - Relatorio - Registra, controla e informa sobre a entrada de doações e integra as informações dos dados da nota fiscal de entrada com o estoque 
##### Sprint Backlog 
> Cada requisito tem um identificador único de maneira que seja possível rastrear a necessidade do cliente com a implementação do software. 

| Identificador | Descrição | Prioridade |
| ------------ | ------------------------------------------------------------------------ | ------|
| REQ01 – Gerenciar acesso | Como – funcionário, Eu quero – controlar meu acesso ao sistema, De maneira que – seja possível cadastrar-se, alterar a senha e entrar no sistema| Alta |
| REQ02 – Gerenciar cargos | Como – funcionário administrativo, Eu quero – controlar os dados dos cargos, De maneira que – possa atializar os cargos existentes e adiconar novos, além de atribuir uma opção a cada funcionário | Média |
| REQ03 – Gerenciar departamentos | Como – funcionário administrativo, Eu quero – controlar os dados dos departamentos, De maneira que – possa atualizar os departamentos existentes e adicionar novos, além de atribuir uma opção a cada funcionário | Média |
| REQ04 – Gerenciar funcionários | Como – funcionárop administrativo, Eu quero – controlar os dados dos funcionários, De maneira que – possa obter um controle atualizado de cada membro da empresa, podendo inserir novos, atualizar as informações dos existentes ou deletar| Alta |
| REQ05 – Gerenciar clientes | Como – atendente, Eu quero –controlar os dados dos clientes, De maneira que – possa obter um controle atualizado de cada cliente que realizou alguma adoção, cadastrando, atualizando ou deletando as informações | Alta 
| REQ06 – Gerenciar adoções | Como – atendente, Eu quero – administrar os relatórios de adoções, De maneira que – resulte na organização dos relatórios de cada animal adotado, sendo possível gerar novos registros ou editar os existentes | Alta |
| REQ07 – Gerenciar animais | Como – funcionário da área de controle, Eu quero – administrar os dados dos animais, De maneira que – possa obter um controle atualizado de cada animal que a empresa recebeu, cadastrando, atualizando ou deletando as informações | Alta |
| REQ08 – Gerenciar relatórios de animais | Como – veterinário, Eu quero – administrar os relatórios de animais, De maneira que – resulte na organização dos relatórios de cada animal examinado, sendo possível gerar novos registros, editar ou excluir os existentes | Média | 
| REQ09 – Categorizar animais | Como – funcionário da área de controle, Eu quero –documentar as raças e portes de animais, De maneira que – possa ajudar a incluir detalhes nos registros dos animais que a empresa possui, cadastrando, atualizando ou deletando as diferentes categorias | Baixa 
| REQ010 – Gerenciar medicamentos | Como – funcionário da área de recursos, Eu quero – organizar os dados dos medicamentos, De maneira que – facilite direcionar os registros e controlar o estoque, atraves da inserção, atualização e exclusão dos medicamentos no sistema | Média |
| REQ11 – Gerenciar fornecedores | Como – funcionário administrativo, Eu quero – organizar os dados dos fornecedores, De maneira que – possa obter um controle atualizado de cada fornecedor que a empresa requisitou, cadastrando, atualizando ou deletando as informações| Média |
##### Definição de pronto 
> O sprint será considerado concluido quando: 
> 1) Os casos de teste de aceitação forem executados e obtiverem 100% de satisfatorios. Os casos de teste (CT) são rastreáveis para os requisiitos (REQ). O elo de rastreabilidade 
é estabelecido pelo identificador do caso de teste.
> 2) Depois de executado os casos de teste com 100% de satisfatorios o código deve ser armazenado no github (commit). 
##### Casos de teste 
| Identificador | Cenário de uso | 
| ------------ | ------------------------------------------------------------------------ | 
| REQ01CT01 | Dado (setup) que o CPF do cliente não está cadastrado; Quando (ação) o usuário confirma o cadastro; Então (resultado esperado) o sistema envia uma mensagem de cadastro realizado com sucesso | 
| REQ01CT02 | Dado (setup) que o CPF do cliente está cadastrado; Quando (ação) o usuário confirma o cadastro; Então (resultado esperado) o sistema rejeita e envia uma mensagem de dados inválidos | 
> 
O modelo de dominio (Larman, 2006 - classes conceituais ou classes de negócio) foi definido considerando as seguintes classes: 
![modelo de dominio](https://user-images.githubusercontent.com/68782201/160412338-54c2c974-d6d2-4ab6-bea5-e1137a6f7e6c.jpg) 
A arquitetura segue uma abordagem orientada a serviços. Os serviços foram classificados em três tipos (ERL, 2007): 
- **1. Serviços utilitários**. Implementam funcionalidades comuns a vários tipos de aplicações, como, por exemplo: log, notificação, transformação de informações. Um exemplo de serviço utilitário é um serviço de conversão de moeda que 
poderá ser acessado para calcular a conversão de uma moeda (por exemplo, dólares) para outra (por exemplo, euros). 
- **2. Serviços de entidade (serviços de negócios)**. Derivado de uma ou mais entidades de negócio (domínio), possuindo um alto grau de reutilização. Geralmente são serviços que fazem operações CRUD (Create, Read, Update e Delete). 
- **3. Serviços de tarefa (coordenação de processos-workflow)**. Tipo de serviço mais específico que possui baixo grau de reuso. Consome outros serviços para atender seus consumidores. São serviços que suportam um processo de negócios 
amplo que geralmente envolve atividades e atores diferentes. Um exemplo de serviço de coordenação em uma empresa é um serviço de pedidos em que os pedidos são feitos, os produtos são aceitos e os pagamentos são efetuados. 
A visão lógica da arquitetura para API de Cliente é apresentada na figura abaixo. A visã lógica descreve como o código está organizado, as classes os pacotes e os relacionamentos entre eles. 
![f3_visao_logica](https://user-images.githubusercontent.com/68782201/162488505-5ec27561-eb83-42dc-a05f-27760e5bb7f3.jpg) 
>A entidade Cliente foi identificada como um serviço (ERL, 2007 - serviço do tipo entidade) o contrado das operações de sistema (LARMAN, 2006, pag.140) foram definidas no diagrama abaixo. 
```mermaid 
classDiagram 
 class ClienteServicoI 
 <<interface>> ClienteServicoI 
 
 ClienteServicoI : +List<Cliente> consultaTodos() 
 ClienteServicoI : +Optional<<Cliente>> consultaPorCpf(String cpf) 
 ClienteServicoI : +Optional<<Cliente>> consultaPorId(Long id) 
 ClienteServicoI : +Optional<<Cliente>> save(Cliente c) 
 ClienteServicoI : +void delete (Long id) 
 ClienteServicoI : +Optional<<Cliente>> altera (Cliente c) 
``` 
>O diagrama de sequência descreve como os varios componentes arquiteturais colaboram para manipular uma operação de sistema (exemplo para operação consultaTodos()) 
```mermaid 
sequenceDiagram 
Usuario ->> APIClienteController: GET /api/v1/clientes 
APIClienteController ->> ClienteServiceI: consultaTodos ( ) 
ClienteServiceI ->> ClienteRepository: findAll ( ) 
ClienteRepository -->> ClienteServiceI: List[] 
ClienteServiceI-->> APIClienteController: List[] 
APIClienteController -->> Usuario: JSon[] 
``` 
>Referencias 
- [1] KRUCHTEN, Philippe. Reference: Title: Architectural blueprints—the “4+ 1” view model of software architecture. IEEE software, v. 12, n. 6, 1995. 
- [2] RICHARDSON, Chris. Microservices patterns: with examples in Java. Simon and Schuster, 2018. 
- [3] ERL, Thomas. SOA principles of service design (the Prentice Hall service-oriented computing series from Thomas Erl). Prentice Hall PTR, 2007. 
- [4] LARMAN, Craig. Utilizando UML e padrões. 2aed., Porto Alegre: Bookman Editora, 2006 (pag. 147)
