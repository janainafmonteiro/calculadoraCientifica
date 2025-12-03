# A3- Calculadora de Expressões Complexas (Java)

Guilherme Silva Vieira Souza- 1272420344

Janaína Ferreira Monteiro- 12724214793

Luis Henrique Silva- 12724213663

Maria Luiza Amorim- 12724215829

Este projeto consiste em uma aplicação de linha de comando desenvolvida em Java, que funciona como uma calculadora especializada para manipulação e resolução de **Números Complexos**. O programa permite ao usuário resolver expressões que incluem variáveis e operações complexas, fornecendo o resultado numérico e uma representação da expressão em formato **Lisp**.

---

## Funcionalidades

O menu principal oferece as seguintes opções de interação:

1.  **Comparar expressão:** Para verificar a igualdade entre os resultados no formato LISP
2.  **Resolver expressão:** Para calcular o valor de uma expressão complexa, substituindo variáveis.
3.  **Sair:** Digite um número diferente de 1 ou 2 para finalizar a aplicação.

## Operadores e Sintaxe Suportados

A calculadora reconhece as seguintes notações para operações complexas:

| Símbolo | Operação | Descrição | Exemplo |
| :---: | :--- | :--- | :--- |
| `~` | Conjugado | Inverte o sinal da parte imaginária. | `~(2+3i)` |
| `#` | Raiz Quadrada | Calcula a raiz quadrada do número complexo. | `#a` |
| `^` | Potência | Eleva um número complexo a uma potência. | `2^a` |

---

## Como Executar

A execução é feita via linha de comando.

### 1. Comparar Expressões

Esta funcionalidade compara a estrutura simbólica das expressões (árvore) mesmo que o valor final seja o mesmo.

| Passo | Entrada | Saída | Observação |
| :---: | :---: | :--- | :--- |
| **Menu** | `1` | `---Comparar expressões--- Digite a expressão 1:` | Seleção da opção Comparar. |
| **Exp 1** | `2+2` | `Digite a expressão 2:` | Expressão $2+2$. |
| **Exp 2** | `3+1` | `As expressões são diferentes` | Expressão $3+1$. O valor é 4 para ambas, mas a **estrutura** é diferente. |

### 2. Resolver expressão
Resolve a expressão e mostra em formato LISP

| Passo | Entrada | Saída | Observação |
| :---: | :---: | :--- | :--- |
| **Menu** | `2` | `---Resolver expressão--- Digite a expressão:` | Seleção da opção Resolver. |
| **Exp** | `2+3i+a` | `Qual sera o valor da variável: a?` | Solicita o valor da variável |
| **a** | `5` | `Valor: 7.0 + 3.0i Lisp: (+ (+ (complexo 2,00 0,00) (complexo 0,00 3,00)) (complexo 5,00 0,00))` | Mostra o resultado |



