# EduSinal

Aplicacao de terminal em Java para registrar dados de uma turma e apontar estudantes que precisam de atencao com base em desempenho escolar e frequencia.

> Este projeto usa apenas dados digitados durante a execucao. Nao inclua dados reais de estudantes em repositorios publicos.

## Funcionalidades

- Cadastro de turma e estudantes pelo terminal;
- Registro de notas e presencas;
- Validacao de dados informados pelo usuario;
- Calculo de media das avaliacoes;
- Calculo do percentual de frequencia;
- Relatorio com estudantes em atencao.

## Regras de indicadores

Um estudante entra em atencao quando possuir ao menos uma das condicoes abaixo:

| Indicador | Regra |
| --- | --- |
| Desempenho | Media inferior a 5,0 |
| Frequencia | Percentual inferior a 75% |

## Estrutura

```text
src/
├── Main.java                # ponto de entrada
├── SistemaEduSinal.java     # fluxo da aplicacao e relatorio
├── EntradaDados.java        # interacao e validacao pelo terminal
├── Turma.java               # entidade turma
├── Estudante.java           # entidade estudante
└── MotorIndicadores.java    # regras de negocio
```

## Como executar

Requisitos: Java 17 ou superior.

```bash
javac -d out src/*.java
java -cp out Main
```

## Exemplo de uso

```text
Digite o ID da turma: 1
Digite o nome da turma: 3o Ano A
Digite a quantidade de estudantes: 1

----- Estudante 1 -----
Nome: Joana
Quantas avaliacoes deseja cadastrar? 2
Digite a nota da avaliacao 1: 4
Digite a nota da avaliacao 2: 5
Quantas aulas deseja registrar? 4
O estudante esteve presente na aula 1? (S/N): S
O estudante esteve presente na aula 2? (S/N): S
O estudante esteve presente na aula 3? (S/N): N
O estudante esteve presente na aula 4? (S/N): N

Estudante: Joana
Situacao: EM ATENCAO
- Baixo desempenho escolar.
- Frequencia abaixo de 75%.
```

## Tecnologias e conceitos

- Java
- Programacao orientada a objetos
- Encapsulamento
- Separacao de responsabilidades
- Collections (`List`)

## Proximos passos

- Adicionar testes automatizados;
- Migrar para Spring Boot;
- Criar uma API REST;
- Persistir dados em PostgreSQL;
- Desenvolver interface web.
