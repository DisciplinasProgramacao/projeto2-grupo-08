[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10572417)
# Projeto 2
Grupo 08 do laboratório da disciplina LPM 1/2023 PUC Minas - Praça da Liberdade

## Correção e comentários

### Nota: 11,5

Grafo de teste

![Grafo de teste](docs/grafoTeste.png)

---

- BFS retorna void? E não tem vértice de início?
- BFS causa exceção no meio
- Contou arestas dobrado no tamanho (lema do aperto de mãos)
- Não carrega grafo: tem um método no app para isso, que não funciona, pois...
- Fazendo == em String no main: não executa porque não reconhece nem D nem N. Não dá opção de executar se não carregar um grafo. 
- BFS entra em loop infinito no main

---

- Aderência às classes do diagrama: 2/2 pontos
- Requisitos de grafos corretamente implementados: 8,5/12 pontos
  - Carregar/salvar		1/2 pontos
  - Grafo completo e subgrafo 3/3 pontos
  - Grafo ponderado/não ponderado 2/2 pontos
  - Busca em largura ~~ou profundidade~~ 1,5/3 pontos
  - App para uso 1/2 pontos
- Documentação de código: 0/4 pontos
  - Não há praticamente nada documentado que não seja do arquivo original. Instrução de uso não está no readme, está em comentário dentro do main.
- Testes (quantidade e qualidade): 1/2 pontos
  - Como mostram os erros, faltaram muitos testes até para métodos básicos, como "tamanho" e "carregar" no main

## Alunos integrantes da equipe

* Bernardo Cavanellas Biondini
* João Vitor Bessa Lacerda
* Nathan Gonçalves de Oliveira

## Professores responsáveis

* João Caram Santos de Oliveira

