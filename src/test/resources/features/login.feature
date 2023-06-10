#language:pt
@Login
Funcionalidade: Login na pagina - advantageonlineshopping

  Contexto:
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado clique fora da modal
    Então a janela modal deve ser fechada

  @fecharModalIcone
  Cenario: Fechar a modal ao clicar no icone
    Quando for realizado un clique no icone de fechar modal
    Então a janela modal deve ser fechada

  @createNewAccount
  Cenario: Link Create New Account
    Quando for realizado um clique no link Create New Account
    Então a pagina Create New Account deve ser exibida.

  @loginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>

    Quando os campos de login sejam preenchidos da seguinte forma
      | Login    | <login>    |
      | Password | <password> |
      | Remember | <remember> |
    Quando for realizado o clique  no botao Singin
    Então deve ser possível logar no sistema

    Exemplos:
      | identificacao          | login   | password | remember |
      | os campos obrigatorios | chronos | Senha123 | false    |
      | todos os campos        | chronos | Senha123 | true     |

  @loginComDadosInvalidos
  Esquema do Cenario: Realizar login com <identificacao>

    Quando os campos de login sejam preenchidos da seguinte forma
      | Login    | <login>    |
      | Password | <password> |
      | Remember | <remember> |
    Quando for realizado o clique  no botao Singin
    Então o sistema devera exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | Senha123 | false    |
      | senha invalida   | chronos  | invalida | false    |

  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>

    Quando os campos de login sejam preenchidos da seguinte forma
      | Login    | <login>    |
      | Password | <password> |
      | Remember | <remember> |
    Então o botao Singin devera permanecer desabiitado

    Exemplos:
      | identificacao       | login   | password | remember |
      | o usuario em branco |         | Senha123 | false    |
      | a senha em branco   | chronos |          | false    |

