# Estruturas de Dados em Java

## Descrição

Este projeto implementa várias estruturas de dados fundamentais em Java, incluindo Lista Encadeada, Pilha, Fila, Árvore e Árvore Binária de Busca. Cada estrutura é projetada para oferecer funcionalidades básicas de manipulação de dados, incluindo inserção, remoção e pesquisa.

## Estruturas de Dados Implementadas

### 1. [Lista Encadeada (LinkedList)](src/main/java/com/neto/dataStructure/LinkedList.java)

Uma lista encadeada que permite inserção, remoção e acesso a elementos em uma lista linearmente conectada.

#### Funcionalidades

- `prepend(T data)`: Adiciona um elemento no início da lista.
- `append(T data)`: Adiciona um elemento no final da lista.
- `insert(int index, T data)`: Insere um elemento em uma posição específica.
- `removeFirst()`: Remove o primeiro elemento da lista.
- `removeLast()`: Remove o último elemento da lista.
- `delete(int index)`: Remove um elemento em uma posição específica.
- `get(int index)`: Obtém o valor do elemento na posição especificada.
- `set(int index, T data)`: Define um valor específico em uma posição.
- `print()`: Imprime todos os elementos da lista.

### 2. [Pilha (Stack)](src/main/java/com/neto/dataStructure/Stack.java)

Uma pilha (LIFO - Last In, First Out) que permite empilhar e desempilhar elementos.

#### Funcionalidades

- `push(T value)`: Adiciona um elemento no topo da pilha.
- `pop()`: Remove e retorna o elemento do topo da pilha.
- `getTop()`: Exibe o elemento do topo da pilha.
- `print()`: Imprime todos os elementos da pilha.

### 3. [Fila (Queue)](src/main/java/com/neto/dataStructure/Queue.java)

Uma fila (FIFO - First In, First Out) que permite enfileirar e desenfileirar elementos.

#### Funcionalidades

- `enqueue(T value)`: Adiciona um elemento ao final da fila.
- `dequeue()`: Remove e retorna o elemento no início da fila.
- `getFirst()`: Retorna o elemento no início da fila.
- `getLast()`: Retorna o elemento no final da fila.
- `print()`: Imprime todos os elementos da fila.

### 4. [Árvore (Tree)](src/main/java/com/neto/dataStructure/Tree.java)

Uma estrutura de árvore genérica com métodos de travessia.

#### Funcionalidades

- `insert(T value)`: Insere um novo valor na árvore.
- `preOrder()`: Travessia em pré-ordem (Root, Left, Right).
- `inOrder()`: Travessia em ordem (Left, Root, Right).
- `postOrder()`: Travessia em pós-ordem (Left, Right, Root).
- `bfs()`: Travessia em largura usando BFS (Breadth-First Search).

### 5. [Árvore Binária de Busca (BinarySearchTree)](src/main/java/com/neto/dataStructure/BinarySearchTree.java)

Uma árvore binária de busca que permite inserção, pesquisa e remoção de elementos de forma ordenada.

#### Funcionalidades

- `insert(T value)`: Insere um novo valor na árvore binária de busca.
- `contains(T value)`: Verifica se a árvore contém um valor específico.
- `minValue(Node<T> node)`: Retorna o menor valor na árvore.
- `deleteNode(T value)`: Remove um nó com um valor específico da árvore.
- `inOrder()`: Travessia em ordem (Left, Root, Right).

## Como Usar

### Importando o Projeto

Para utilizar essas estruturas de dados, clone o repositório e importe o projeto em sua IDE Java.

```bash
git clone <URL do repositório>
```

### Exemplo de Uso

Aqui está um exemplo de como você pode usar a lista encadeada:

```java
import com.neto.dataStructure.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.print(); // Exibe 1, 2, 3

        list.prepend(0);
        list.print(); // Exibe 0, 1, 2, 3

        list.insert(2, 9);
        list.print(); // Exibe 0, 1, 9, 2, 3

        list.delete(2);
        list.print(); // Exibe 0, 1, 2, 3
    }
}
```