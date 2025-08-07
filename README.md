# Aula - Avaliação Preguiçosa

Este projeto contém uma coleção abrangente de exemplos práticos que demonstram conceitos fundamentais de **avaliação preguiçosa** (lazy evaluation), **memoização**, **listas preguiçosas**, **estratégias de avaliação de parâmetros** e outros tópicos importantes de programação funcional em Scala.

### Objetivos pedagógicos

Os exemplos foram criados especificamente para ajudar os estudantes a:
- Compreender as diferenças entre avaliação eager (ansiosa) e lazy (preguiçosa)
- Entender as estratégias de avaliação: call-by-value, call-by-name e call-by-need
- Aplicar técnicas de memoização para otimização de performance
- Trabalhar com estruturas de dados preguiçosas (LazyList)
- Implementar operadores lógicos com short-circuit personalizado

### Estrutura dos exemplos

Cada arquivo em `src/main/scala` aborda um conceito específico, com comentários didáticos detalhados (em inglês) explicando o funcionamento e os conceitos envolvidos:

#### Conceitos fundamentais
- **`Bindings.scala`**: Demonstra como bindings (val) funcionam em Scala e a ordem de avaliação
- **`LazyExample.scala`**: Compara avaliação eager vs lazy usando `val` e `lazy val`
- **`HeavyComputation.scala`**: Mostra uso prático de `lazy val` para evitar computações custosas desnecessárias

#### Estratégias de avaliação de parâmetros
- **`CallByValue.scala`**: Demonstra call-by-value (argumentos avaliados antes da chamada da função)
- **`CallByName.scala`**: Demonstra call-by-name com e sem parênteses (argumentos avaliados quando usados)
- **`CallByNeed.scala`**: Compara as três estratégias usando exemplos de divisão, mostrando as diferenças de performance

#### Estruturas de dados preguiçosas
- **`LazyListBasics.scala`**: Introdução ao `LazyList` do Scala, mostrando avaliação sob demanda
- **`MyLazyList.scala`**: Implementação customizada de uma lista preguiçosa com pattern matching

#### Técnicas avançadas
- **`MemoizedFibonacci.scala`**: Implementa memoização manual no cálculo de Fibonacci
- **`ShortCircuit.scala`**: Demonstra short-circuit evaluation e implementação de operadores lógicos customizados
- **`NthPrime.scala`**: Compara busca de números primos usando avaliação estrita vs preguiçosa
- **`Sales.scala`**: Exemplo prático de uso de valores lazy em um contexto de relatórios de vendas

### Como estudar e experimentar

1. **Leia primeiro os comentários**: Cada arquivo começa com uma explicação detalhada do conceito abordado
2. **Execute os exemplos**: Use `sbt run` e escolha o exemplo desejado no menu
3. **Observe as mensagens de debug**: Os exemplos incluem `println` estratégicos para mostrar quando computações são realizadas
4. **Modifique e experimente**: Altere os exemplos para testar diferentes cenários
5. **Use o REPL**: Teste trechos menores com `scala` ou `sbt console`

### Conceitos importantes demonstrados

- **Lazy Evaluation**: Computações são adiadas até serem necessárias
- **Memoization**: Resultados são cached para evitar recomputação
- **Call-by-name vs Call-by-value**: Diferentes momentos de avaliação de argumentos
- **Call-by-need**: Combinação de call-by-name com memoização
- **Short-circuit**: Avaliação condicional em operações lógicas
- **Infinite sequences**: Estruturas infinitas usando avaliação preguiçosa

### Dicas para maximizar o aprendizado

- Execute os exemplos múltiplas vezes para observar os padrões
- Compare os tempos de execução entre versões eager e lazy
- Experimente modificar os valores e observar como isso afeta o comportamento
- Use o debugger do VS Code para acompanhar o fluxo de execução step-by-step

