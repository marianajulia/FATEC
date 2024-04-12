# Classe Componentes:
class Componente:
    def __init__(self, nome):
        self.nome = nome

    def adicionar(self):
        pass

    def remover(self):
        pass

    def obterNome(self):
        return self.nome

# Classe Folha:
class Folha(Componente):
    def __init__(self, nome, preco):
        super().__init__(nome)
        self.preco = preco

    def obterPreco(self):
        return self.preco
    
    def obterConteudo(self):
        return f"{self.nome} - R${self.preco:.2f}"
    
# Classe Container:
class Container(Componente):
    def __init__(self, nome):
        super().__init__(nome)
        self.arrayComponente = []

    def adicionar(self, componente):
        self.arrayComponente.append(componente)
    
    def remover(self, componente):
        self.arrayComponente.remove(componente)

    def obterPreco(self):
        preco = 0
        for componente in self.arrayComponente:
            preco += componente.obterPreco()
        return preco
    
    def obterConteudo(self):
        conteudo = f'{self.nome}:\n'
        for componente in self.arrayComponente:
            conteudo += f"\t{componente.obterConteudo()}\n"
        return conteudo
    
####################################################################################
maca = Folha('Maçã\t', 8.99)
laranja = Folha('Laranja\t', 3.69)
uva = Folha('Uva\t', 9.98)
banana = Folha('Banana\t', 6.99)
abacate = Folha('Abacate\t', 4.91)

produto = Container('Carrinho de Compra')
produto.adicionar(maca)
produto.adicionar(laranja)
produto.adicionar(uva)
produto.adicionar(banana)
produto.adicionar(abacate)

pedido = Container('Pedido Fechado')
pedido.adicionar(produto)
pedido.adicionar(Folha('Embalagem', 1.90))

pedidoEntrega = Container('Pedido Completo')
pedidoEntrega.adicionar(pedido)
pedidoEntrega.adicionar(Folha('Frete SP', 35.00))

print(produto.obterConteudo())
print(pedido.obterConteudo())
print(pedidoEntrega.obterConteudo())
print(f"Preço Total R${pedidoEntrega.obterPreco()}")