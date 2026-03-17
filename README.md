# 1) Sistema de Locadora de Veículos

## Enunciado

Desenvolva um sistema em Java para uma locadora de veículos. O programa deve permitir cadastrar veículos, clientes e realizar locações por meio de um **menu interativo no console**.

O sistema deve possuir uma classe base chamada `Veiculo` e classes filhas como `Carro`, `Moto` e `Caminhao`. Cada tipo de veículo deve possuir características próprias e um comportamento polimórfico para cálculo do valor da locação.

## Requisitos

- Criar no mínimo as classes:
    - `Veiculo`
    - `Carro`
    - `Moto`
    - `Caminhao`
    - `Cliente`
    - `Locacao`
    - `Main`
- Utilizar **construtores** para inicializar os objetos.
- Implementar **herança** entre `Veiculo` e suas subclasses.
- Implementar **polimorfismo** em um método como `calcularDiaria()` ou `exibirDetalhes()`.
- Criar um **menu** com opções como:
    1. Cadastrar cliente
    2. Cadastrar veículo
    3. Listar veículos
    4. Realizar locação
    5. Exibir locações
    6. Encerrar
